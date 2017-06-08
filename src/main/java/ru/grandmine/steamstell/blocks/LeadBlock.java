package ru.grandmine.steamstell.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LeadBlock extends Block{
	
	public LeadBlock() {
		
		super(Material.iron);
		setHardness(5F);
		setResistance(30F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setStepSound(soundTypeMetal);
		setBlockName("LeadBlock");
		setBlockTextureName("steamstell:lead_block");
		
	}
	
}
