package ru.grandmine.steamstell.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AluminiumBlock extends Block {

	public AluminiumBlock() {
		
		super(Material.iron);
		setHardness(4F);
		setResistance(25);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setStepSound(soundTypeMetal);
		setBlockName("AluminiumBlock");
		setBlockTextureName("steamstell:aluminium_block");
		
	}
	
}
