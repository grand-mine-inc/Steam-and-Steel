package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.MainSteamStell;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSulfurOre extends Block {
	
	public BlockSulfurOre() {
		
		super(Material.rock);
		setHardness(2);
		setResistance(10);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setBlockName("BlockSulfurOre");
		setBlockTextureName("steamstell:sulfur_ore");
		
	}

}
