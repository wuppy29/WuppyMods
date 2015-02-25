package com.wuppy.frozen.items;

import com.wuppy.frozen.FrozenCraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemAnnaArmor extends ItemArmor {
	private String name;

	public ItemAnnaArmor(ArmorMaterial material, int armorType, String name) {
		super(material, 0, armorType);
		this.name = name;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		setCreativeTab(FrozenCraft.fcArmor);
	}

	public String getName() {
		return name;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ModItems.annaCap) {
			return FrozenCraft.modid + ":models/armor/annaArmorCap.png";
		} else if (stack.getItem() == ModItems.annaBodice) {
			return FrozenCraft.modid + ":models/armor/annaArmorBodice.png";
		} else if (stack.getItem() == ModItems.annaSkirt) {
			return FrozenCraft.modid + ":models/armor/annaArmorSkirt.png";
		} else if (stack.getItem() == ModItems.annaBoots) {
			return FrozenCraft.modid + ":models/armor/annaArmorBoots.png";
		} else {
			System.out.println("Invalid Item ItemAnnaArmor");
			return null;
		}
	}
}