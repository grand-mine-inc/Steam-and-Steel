package ru.grandmine.steamstell.utils;

import org.lwjgl.opengl.GL11;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import ru.grandmine.steamstell.blocks.fluid_tank.GrandFluidTank;
import ru.grandmine.steamstell.tileentity.TileGlassFluidTank;;
public class Utils {
	public static void renderBlockByCompleteness(Block block, Fluid fluid, int meta, RenderBlocks renderer, double complete, int x, int y, int z) {

		renderer.setRenderBounds(0.01, 0.01, 0.01, 0.99, complete * 0.99, 0.99);
		renderer.setOverrideBlockTexture(fluid.getIcon());
		renderer.renderStandardBlock(block, x, y, z);
		renderer.clearOverrideBlockTexture();
	}
	public static ItemStack useItemSafely(ItemStack stack) {
		
		if (stack.stackSize == 1) {
			if (stack.getItem().hasContainerItem(stack))
				return stack.getItem().getContainerItem(stack);
			else
				return null;
		}
		else {
			stack.splitStack(1);
			return stack;
		}
		
	}
	public static void dropStackInWorld(World world, int x, int y, int z, ItemStack stack) {
		
		if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
			float f = 0.7F;
			double d0 = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
			double d1 = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
			double d2 = (double) (world.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
			EntityItem entityitem = new EntityItem(world, (double) x + d0, (double) y + d1, (double) z + d2, stack);
			entityitem.delayBeforeCanPickup = 10;
			world.spawnEntityInWorld(entityitem);
			
		}
		
	}
	
	public static ItemStack getTankStackFromTile(TileGlassFluidTank tank, boolean keepFluid) {
		
		ItemStack stack = new ItemStack(GrandFluidTank.glassfluidtank);
		stack.setTagCompound(new NBTTagCompound());
		FluidStack fluid = tank.tank.getFluid();
		if (fluid != null && keepFluid) {
			NBTTagCompound tagFluid = new NBTTagCompound();
			fluid.writeToNBT(tagFluid);
			stack.getTagCompound().setTag("Fluid", tagFluid);
			
		}

		return stack;
	}
	
	public static void renderInventoryBlock(RenderBlocks renderblocks, Block block, IIcon icon) {
		
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, getValidIIcon(icon));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, getValidIIcon(icon));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, getValidIIcon(icon));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, getValidIIcon(icon));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, getValidIIcon(icon));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, getValidIIcon(icon));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		
	}

	public static void renderInventoryBlock(RenderBlocks renderblocks, Block block, Fluid fluid) {
		
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, getValidIIcon(fluid.getIcon()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, getValidIIcon(fluid.getIcon()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, getValidIIcon(fluid.getIcon()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, getValidIIcon(fluid.getIcon()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, getValidIIcon(fluid.getIcon()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, getValidIIcon(fluid.getIcon()));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
	
	private static IIcon getValidIIcon(IIcon icon) {
		
		if (icon != null)
			return icon;
		return Blocks.fire.getIcon(0, 0);
		
	}
	
	public static ItemStack getTankStackFromData() {
		
		ItemStack stack = new ItemStack(Item.getItemFromBlock(GrandFluidTank.glassfluidtank));
		NBTTagCompound tag = new NBTTagCompound();
		stack.setTagCompound(tag);
		return stack;
		
	}	
	
	public static ItemStack getItemBlockForCreativeTab(Block block) {
		
		ItemStack stack = new ItemStack(Item.getItemFromBlock(block));
		return stack;
		
	}



	}
