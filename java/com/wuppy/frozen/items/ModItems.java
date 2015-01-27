package com.wuppy.frozen.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import com.wuppy.frozen.FrozenCraft;

public class ModItems
{
	//standard item objects
	public static Item frozenHeart;
	public static Item iceSaw;
	public static Item elsaGlove;
	public static Item hansSword;
	public static Item kristoffPickaxe;
	
	//armor item objects
	public static Item elsaTiara;
	public static Item elsaBodice;
	public static Item elsaSkirt;
	public static Item elsaHeels;
	
	public static Item annaCap;
	public static Item annaBodice;
	public static Item annaSkirt;
	public static Item annaBoots;
	
	public static Item kristoffCap;
	public static Item kristoffJacket;
	public static Item kristoffPants;
	public static Item kristoffBoots;
	
	public static Item hansHair;
	public static Item hansTop;
	public static Item hansPants;
	public static Item hansBoots;
	
	public static void loadItems()
	{
		//standard item init
		frozenHeart = new ItemFrozenHeart();
		iceSaw = new ItemIceSaw();
		elsaGlove = new ItemElsaGlove();
		hansSword = new ItemHansSword();
		kristoffPickaxe = new ItemKristoffPickaxe();
		
		//armor item init
		elsaTiara = new ItemElsaArmor(ModMaterials.elsa, 0, "elsaTiara");
		elsaBodice = new ItemElsaArmor(ModMaterials.elsa, 1, "elsaBodice");
		elsaSkirt = new ItemElsaArmor(ModMaterials.elsa, 2, "elsaSkirt");
		elsaHeels = new ItemElsaArmor(ModMaterials.elsa, 3, "elsaHeels");
		
		annaCap = new ItemAnnaArmor(ModMaterials.anna, 0, "annaCap");
		annaBodice = new ItemAnnaArmor(ModMaterials.anna, 1, "annaBodice");
		annaSkirt = new ItemAnnaArmor(ModMaterials.anna, 2, "annaSkirt");
		annaBoots = new ItemAnnaArmor(ModMaterials.anna, 3, "annaBoots");
		
		kristoffCap = new ItemKristoffArmor(ModMaterials.kristoff, 0, "kristoffCap");
		kristoffJacket = new ItemKristoffArmor(ModMaterials.kristoff, 1, "kristoffJacket");
		kristoffPants = new ItemKristoffArmor(ModMaterials.kristoff, 2, "kristoffPants");
		kristoffBoots = new ItemKristoffArmor(ModMaterials.kristoff, 3, "kristoffBoots");
		
		hansHair = new ItemHansArmor(ModMaterials.hans, 0, "hansHair");
		hansTop = new ItemHansArmor(ModMaterials.hans, 1, "hansTop");
		hansPants = new ItemHansArmor(ModMaterials.hans, 2, "hansPants");
		hansBoots = new ItemHansArmor(ModMaterials.hans, 3, "hansBoots");
	}
	
	public static void regsisterItemRenders(FMLPostInitializationEvent event)
	{
		if(event.getSide() == Side.CLIENT)
		{
		    RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		    
		    renderItem.getItemModelMesher().register(frozenHeart, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemFrozenHeart) frozenHeart).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(iceSaw, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemIceSaw) iceSaw).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(elsaGlove, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemElsaGlove) elsaGlove).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(hansSword, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemHansSword) hansSword).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(kristoffPickaxe, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemKristoffPickaxe) kristoffPickaxe).getName(), "inventory"));
		    
		    renderItem.getItemModelMesher().register(elsaTiara, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemElsaArmor) elsaTiara).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(elsaBodice, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemElsaArmor) elsaBodice).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(elsaSkirt, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemElsaArmor) elsaSkirt).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(elsaHeels, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemElsaArmor) elsaHeels).getName(), "inventory"));
		
		    renderItem.getItemModelMesher().register(annaCap, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemAnnaArmor) annaCap).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(annaBodice, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemAnnaArmor) annaBodice).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(annaSkirt, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemAnnaArmor) annaSkirt).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(annaBoots, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemAnnaArmor) annaBoots).getName(), "inventory"));
		    
		    renderItem.getItemModelMesher().register(kristoffCap, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemKristoffArmor) kristoffCap).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(kristoffJacket, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemKristoffArmor) kristoffJacket).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(kristoffPants, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemKristoffArmor) kristoffPants).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(kristoffBoots, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemKristoffArmor) kristoffBoots).getName(), "inventory"));
		    
		    renderItem.getItemModelMesher().register(hansHair, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemHansArmor) hansHair).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(hansTop, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemHansArmor) hansTop).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(hansPants, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemHansArmor) hansPants).getName(), "inventory"));
		    renderItem.getItemModelMesher().register(hansBoots, 0, new ModelResourceLocation(FrozenCraft.modid + ":" + ((ItemHansArmor) hansBoots).getName(), "inventory"));
		}
	}
}