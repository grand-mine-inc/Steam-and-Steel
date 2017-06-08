package ru.grandmine.steamstell.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CopperBlock extends Block {

	public CopperBlock() {
		
		super(Material.iron);
		setHardness(4F);
		setResistance(25F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setStepSound(soundTypeMetal);
		setBlockName("CopperBlock");
		setBlockTextureName("steamstell:copper_block");
		
	}
	
}
