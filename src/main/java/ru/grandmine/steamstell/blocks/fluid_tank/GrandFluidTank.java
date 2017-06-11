package ru.grandmine.steamstell.blocks.fluid_tank;

import ru.grandmine.steamstell.render.blocks.GrandRenderBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;

public class GrandFluidTank {

	public static Block glassfluidtank;
	public static Block renderblocks;
	
	public static final void init() {
		
		glassfluidtank = new GlassFluidTank();
		renderblocks = new GrandRenderBlocks();
		
		GameRegistry.registerBlock(glassfluidtank, "glass_fluid_tank");
		GameRegistry.registerBlock(renderblocks, "grand_render_blocks");
		
	}
	
}
