package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.MainSteamStell;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAluminiumOre extends Block {
	
	public BlockAluminiumOre() {
		
		super(Material.rock);
		setHardness(3F);
		setResistance(15F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setBlockName("BlockAluminiumOre");
		setBlockTextureName("steamstell:aluminium_ore");
		
	}

}
