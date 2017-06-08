package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.MainSteamStell;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockUraniumOre extends Block {
	
	public BlockUraniumOre() {
		
		super(Material.rock);
		setHardness(4F);
		setResistance(17F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setBlockName("BlockUraniumOre");
		setBlockTextureName("steamstell:uranium_ore");
		setLightLevel(0.5F);
		
	}

}
