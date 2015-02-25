package com.wuppy.frozen.items;

import com.wuppy.frozen.FrozenCraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHansArmor extends ItemArmor {
	private String name;

	public ItemHansArmor(ArmorMaterial material, int armorType, String name) {
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
		if (stack.getItem() == ModItems.hansHair) {
			return FrozenCraft.modid + ":models/armor/hansArmorHair.png";
		} else if (stack.getItem() == ModItems.hansTop) {
			return FrozenCraft.modid + ":models/armor/hansArmorTop.png";
		} else if (stack.getItem() == ModItems.hansPants) {
			return FrozenCraft.modid + ":models/armor/hansArmorPants.png";
		} else if (stack.getItem() == ModItems.hansBoots) {
			return FrozenCraft.modid + ":models/armor/hansArmorBoots.png";
		} else {
			System.out.println("Invalid Item ItemHansArmor");
			return null;
		}
	}
}