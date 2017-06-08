package ru.grandmine.steamstell.blocks;

import java.util.Random;

import ru.grandmine.steamstell.item.GrandItem;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class RubyBlock extends Block {

	public RubyBlock() {
		
		super(Material.iron);
		setHardness(5F);
		setResistance(30F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setStepSound(soundTypeMetal);
		setBlockName("RubyBlock");
		setBlockTextureName("steamstell:ruby_block");
		
	}
    
}
