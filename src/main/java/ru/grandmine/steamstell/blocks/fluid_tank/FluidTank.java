package ru.grandmine.steamstell.blocks.fluid_tank;

import ru.grandmine.steamstell.blocks.GrandBlocks;
import ru.grandmine.steamstell.tileentity.FluidTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class FluidTank extends BlockContainer {
	
	public FluidTank() {
		
		super(Material.glass);
		setBlockName("FluidTank");
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {

		return new FluidTileEntity();
		
	}

}
