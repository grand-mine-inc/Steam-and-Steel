package ru.grandmine.steamstell.blocks;

import java.util.Random;

import ru.grandmine.steamstell.MainSteamStell;
import ru.grandmine.steamstell.item.GrandItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public class BlockSulfurOre extends Block {
	
	public BlockSulfurOre() {
		
		super(Material.rock);
		setHardness(2);
		setResistance(10);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setBlockName("BlockSulfurOre");
		setBlockTextureName("steamstell:sulfur_ore");
		
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		
		return GrandItem.sulfurdust;
		
	}
	
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
    {
		return 1;
		
    }

}
