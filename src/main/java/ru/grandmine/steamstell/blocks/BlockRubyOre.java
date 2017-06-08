package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.MainSteamStell;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRubyOre extends Block {
	
	public BlockRubyOre() {
		
		super(Material.rock);
		setHardness(5F);
		setResistance(20F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setBlockName("BlockRubyOre");
		setBlockTextureName("steamstell:ruby_ore");
		
	}

}
