package ru.grandmine.steamstell.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UraniumBlock extends Block {
	
	public UraniumBlock() {
		
		super(Material.iron);
		setHardness(5F);
		setResistance(30F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setStepSound(soundTypeMetal);
		setBlockName("UraniumBlock");
		setBlockTextureName("steamstell:uranium_block");
		
	}
	
}
