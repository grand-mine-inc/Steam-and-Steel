package ru.grandmine.steamstell.render.blocks;

import org.lwjgl.opengl.GL11;
import ru.grandmine.steamstell.utils.Utils;
import ru.grandmine.steamstell.blocks.fluid_tank.GrandFluidTank;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fluids.FluidStack;

public class RenderItemBlockGlassTank implements IItemRenderer {
		
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
	return type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY || type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.EQUIPPED;
	
	}
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		
		return true;
		
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		RenderBlocks renderblocks = (RenderBlocks) data[0];
		Block block = Block.getBlockFromItem(item.getItem());
		if (item.hasTagCompound()) {
			NBTTagCompound tag = item.stackTagCompound;
			if (tag.hasKey("Fluid")) {
				FluidStack liquid = FluidStack.loadFluidStackFromNBT(item.getTagCompound().getCompoundTag("Fluid"));
				if (liquid != null) {
					GL11.glEnable(GL11.GL_BLEND);
					float height = ((float) liquid.amount / (float) 20000 * (float) 0.99);
					renderblocks.setRenderBounds(0.01, 0.01, 0.01, 0.99, height, 0.99);
					Utils.renderInventoryBlock(renderblocks, GrandFluidTank.renderblocks, liquid.getFluid());
					GL11.glDisable(GL11.GL_BLEND);
				}
			}

			GL11.glEnable(GL11.GL_ALPHA_TEST);
			renderblocks.setRenderBounds(0, 0, 0, 1, 1, 1);
			Utils.renderInventoryBlock(renderblocks, block, GrandFluidTank.glassfluidtank.getIcon(0, 0));
			GL11.glDisable(GL11.GL_ALPHA_TEST);

		}
	}
	}