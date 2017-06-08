package ru.grandmine.steamstell.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class NickelBlock extends Block {
	
	public NickelBlock() {
		
		super(Material.iron);
		setHardness(5F);
		setResistance(15F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setStepSound(soundTypeMetal);
		setBlockName("NickelBlock");
		setBlockTextureName("steamstell:nickel_block");
		
	}

}
