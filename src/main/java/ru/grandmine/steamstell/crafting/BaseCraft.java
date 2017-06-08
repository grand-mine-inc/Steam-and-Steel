package ru.grandmine.steamstell.crafting;

import net.minecraft.item.ItemStack;
import ru.grandmine.steamstell.blocks.GrandBlocks;
import ru.grandmine.steamstell.item.GrandItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class BaseCraft {
	
	public static void init() {	
		addSmelting();	
	}
	
	public static void addSmelting() {
		
		GameRegistry.addSmelting(GrandBlocks.blockcopperore, new ItemStack(GrandItem.copperingot), 0.7F);
		GameRegistry.addSmelting(GrandBlocks.blockaluminiumore, new ItemStack(GrandItem.aluminiumingot), 0.7F);
		GameRegistry.addSmelting(GrandBlocks.blockleadore, new ItemStack(GrandItem.leadingot), 0.7F);
		GameRegistry.addSmelting(GrandBlocks.blocknickelore, new ItemStack(GrandItem.nickelingot), 0.7F);
		GameRegistry.addSmelting(GrandBlocks.blockrubyore, new ItemStack(GrandItem.ruby), 1F);
		GameRegistry.addSmelting(GrandBlocks.blocktinore, new ItemStack(GrandItem.tiningot), 0.7F);
		GameRegistry.addSmelting(GrandBlocks.blockuraniumore, new ItemStack(GrandItem.uraniumingot), 1F);
		
	}
}