package harderpeaceful;

import static org.objectweb.asm.Opcodes.FCONST_0;
import static org.objectweb.asm.Opcodes.FCONST_1;
import static org.objectweb.asm.Opcodes.IFLE;
import static org.objectweb.asm.Opcodes.IFLT;

import java.util.Iterator;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class HPClassTransformer implements IClassTransformer
{
	@Override
	public byte[] transform(String name, String arg1, byte[] bytes) 
	{
		if(name.equals("uw"))
		{
			bytes = patchFoodStats(name, bytes, true);
		}
		else if(name.equals("net.minecraft.util.FoodStats"))
		{
			bytes = patchFoodStats(name, bytes, false);
		}
		else if(name.equals("ue"))
		{
			bytes = patchEntityPlayer(name, bytes, true);
		}
		else if(name.equals("net.minecraft.entity.player.EntityPlayer"))
		{
			bytes = patchEntityPlayer(name, bytes, false);
		}
		return bytes;
	}
	
	private byte[] patchFoodStats(String name, byte[] bytes, boolean obfuscated) 
	{
		int iflecount = 0;
		
		//Our target method
		String targetMethodName = "";
		
		if(obfuscated == true)
			targetMethodName ="a";
		else
			targetMethodName ="onUpdate";
		
		//set up ASM class manipulation stuff. Consult the ASM docs for details
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		
		Iterator<MethodNode> methods = classNode.methods.iterator();
		while(methods.hasNext())
		{
			MethodNode m = methods.next();
			
			if(m.name.equals(targetMethodName))
			{
				AbstractInsnNode currentNode = null;
				
				Iterator<AbstractInsnNode> iter = m.instructions.iterator();
				
				InsnList nodeList = new InsnList();
				
				while(iter.hasNext())
				{
					currentNode = iter.next();
					
					if (currentNode.getOpcode() == IFLE)
					{
						iflecount++;
						if(iflecount == 3)
						{
							nodeList.add(new JumpInsnNode(IFLT, ((JumpInsnNode) currentNode).label));
						}
						else
							nodeList.add(currentNode);
					}
					else
						nodeList.add(currentNode);
				}
				
				m.instructions = nodeList;
			}
		}
		
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(writer);
        return writer.toByteArray();
	}

	private byte[] patchEntityPlayer(String name, byte[] bytes, boolean obfuscated) 
	{
		boolean first = true;
		
		//Our target method
		String targetMethodName = "";
		
		if(obfuscated == true)
			targetMethodName ="c";
		else
			targetMethodName ="onLivingUpdate";
		
		//set up ASM class manipulation stuff. Consult the ASM docs for details
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		
		Iterator<MethodNode> methods = classNode.methods.iterator();
		while(methods.hasNext())
		{
			MethodNode m = methods.next();
			
			if(m.name.equals(targetMethodName))
			{
				AbstractInsnNode currentNode = null;
				
				Iterator<AbstractInsnNode> iter = m.instructions.iterator();
				
				InsnList nodeList = new InsnList();
				
				while(iter.hasNext())
				{
					currentNode = iter.next();
					
					if(currentNode.getOpcode() == FCONST_1 && first)
					{
						nodeList.add(new InsnNode(FCONST_0));
					}
					else
						nodeList.add(currentNode);
				}
				m.instructions = nodeList;
			}
		}
		
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(writer);
        return writer.toByteArray();
	}
}