package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.MainSteamStell;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockLeadOre extends Block {

	public BlockLeadOre() {
		super(Material.rock);
		setHardness(3F);
		setResistance(15F);
		setBlockName("BlockLeadOre");
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setBlockTextureName("steamstell:lead_ore");
		setHarvestLevel("pickaxe", 2);
	}
	
}
