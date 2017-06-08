package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.MainSteamStell;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCopperOre extends Block{

	public BlockCopperOre() {
		super(Material.rock);
		setBlockName("BlockCopperOre");
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setResistance(12F);
		setHardness(2F);
		setHarvestLevel("pickaxe", 1);
		setBlockTextureName("steamstell:copper_ore");
	}
	
}
