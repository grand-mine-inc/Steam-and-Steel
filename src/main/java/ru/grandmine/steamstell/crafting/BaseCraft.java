package ru.grandmine.steamstell.crafting;

import net.minecraft.item.ItemStack;
import ru.grandmine.steamstell.blocks.GrandBlocks;
import ru.grandmine.steamstell.item.GrandItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class BaseCraft {
	
	public static void init() {	
		addSmelting();
		addRecipe();
	}
	
	public static void addRecipe() {
		
		GameRegistry.addRecipe( new ItemStack(GrandBlocks.aluminiumblock), new Object[] { "###", "###", "###", '#', GrandItem.aluminiumingot});
		GameRegistry.addRecipe( new ItemStack(GrandItem.aluminiumingot, 9), new Object[] { "#", '#', GrandBlocks.aluminiumblock});
		GameRegistry.addRecipe( new ItemStack(GrandBlocks.copperblock), new Object[] { "###", "###", "###", '#', GrandItem.copperingot});
		GameRegistry.addRecipe( new ItemStack(GrandItem.copperingot, 9), new Object[] { "#", '#', GrandBlocks.copperblock});
		GameRegistry.addRecipe( new ItemStack(GrandBlocks.leadblock), new Object[] { "###", "###", "###", '#', GrandItem.leadingot});
		GameRegistry.addRecipe( new ItemStack(GrandItem.leadingot, 9), new Object[] { "#", '#', GrandBlocks.leadblock});
		GameRegistry.addRecipe( new ItemStack(GrandBlocks.nickelblock), new Object[] { "###", "###", "###", '#', GrandItem.nickelingot});
		GameRegistry.addRecipe( new ItemStack(GrandItem.nickelingot, 9), new Object[] { "#", '#', GrandBlocks.nickelblock});
		GameRegistry.addRecipe( new ItemStack(GrandBlocks.rubyblock), new Object[] { "###", "###", "###", '#', GrandItem.ruby});
		GameRegistry.addRecipe( new ItemStack(GrandItem.ruby, 9), new Object[] { "#", '#', GrandBlocks.rubyblock});
		GameRegistry.addRecipe( new ItemStack(GrandBlocks.tinblock), new Object[] { "###", "###", "###", '#', GrandItem.tiningot});
		GameRegistry.addRecipe( new ItemStack(GrandItem.tiningot, 9), new Object[] { "#", '#', GrandBlocks.tinblock});
		GameRegistry.addRecipe( new ItemStack(GrandBlocks.uraniumblock), new Object[] { "###", "###", "###", '#', GrandItem.uraniumingot});
		GameRegistry.addRecipe( new ItemStack(GrandItem.uraniumingot, 9), new Object[] { "#", '#', GrandBlocks.uraniumblock});
		
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