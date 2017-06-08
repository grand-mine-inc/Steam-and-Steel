package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.MainSteamStell;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNickelOre extends Block {
	
	public BlockNickelOre() {
		super(Material.rock);
		setHardness(3F);
		setResistance(15F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setBlockName("BlockNickelOre");
		setBlockTextureName("steamstell:nickel_ore");
	}

}
