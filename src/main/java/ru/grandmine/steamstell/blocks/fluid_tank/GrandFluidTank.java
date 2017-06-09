package ru.grandmine.steamstell.blocks.fluid_tank;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;

public class GrandFluidTank {

	public static Block glassfluidtank;
	
	public static final void init() {
		
		glassfluidtank = new GlassFluidTank();
		
		GameRegistry.registerBlock(glassfluidtank, "glass_fluid_tank");
		
	}
	
}
