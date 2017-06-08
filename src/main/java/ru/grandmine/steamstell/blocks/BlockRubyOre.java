package ru.grandmine.steamstell.blocks;

import java.util.Random;

import ru.grandmine.steamstell.MainSteamStell;
import ru.grandmine.steamstell.item.GrandItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockRubyOre extends Block {
	
	private Random rand;

	public BlockRubyOre() {
		
		super(Material.rock);
		setHardness(5F);
		setResistance(20F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setBlockName("BlockRubyOre");
		setBlockTextureName("steamstell:ruby_ore");
		
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		
		return GrandItem.ruby;
		
	}
	
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
    {
		return 3;
		
    }
	
}
