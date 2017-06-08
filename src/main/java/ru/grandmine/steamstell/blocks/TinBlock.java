package ru.grandmine.steamstell.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TinBlock extends Block {
	
	public TinBlock() {
		
		super(Material.iron);
		setHardness(4F);
		setResistance(25F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setStepSound(soundTypeMetal);
		setBlockName("TinBlock");
		setBlockTextureName("steamstell:tin_block");
		
	}

}
