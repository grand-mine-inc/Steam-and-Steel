package ru.grandmine.steamstell.blocks.fluid_tank;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;

public class GrandFluidTank {

	public static BlockContainer fluidtank;
	
	public static final void init() {
		
		fluidtank = new FluidTank();
		
		GameRegistry.registerBlock(fluidtank, "fluid_tank");
		
	}
	
}
