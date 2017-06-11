package ru.grandmine.steamstell.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import ru.grandmine.steamstell.utils.Utils;
import ru.grandmine.steamstell.blocks.fluid_tank.GrandFluidTank;
import ru.grandmine.steamstell.tileentity.TileGlassFluidTank;

public class RenderGlassTank implements ISimpleBlockRenderingHandler{
		
	public static int renderID;
	public static int renderPass = 0;
	public RenderGlassTank(int renderingID) {
		renderID = renderingID;
}
		
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		if (modelId == renderID) {
			TileGlassFluidTank tank = (TileGlassFluidTank) world.getTileEntity(x, y, z);
			if (renderPass == 0) {
				if (tank.tank.getFluid() != null) {
					Fluid fluid = tank.tank.getFluid().getFluid();
					Utils.renderBlockByCompleteness(GrandFluidTank.renderblocks,fluid, world.getBlockMetadata(x, y, z), renderer, (double) tank.tank.getFluidAmount() / (double) tank.tank.getCapacity(), x, y, z);
				}
			}
			else if (renderPass == 1) {
				renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderFromInside(true);
				renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderFromInside(false);
			}
		}
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}
	@Override
	public int getRenderId() {
		return renderID;
	}
}