package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.MainSteamStell;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTinOre extends Block {
	
	public BlockTinOre(){
		super(Material.rock);
		setHardness(2F);
		setResistance(12F);
		setBlockName("BlockTinOre");
		setBlockTextureName("steamstell:tin_ore");
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
	}

}
