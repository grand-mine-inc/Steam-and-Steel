package ru.grandmine.steamstell.item.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.grandmine.steamstell.blocks.fluid_tank.GlassFluidTank;
import ru.grandmine.steamstell.blocks.fluid_tank.GrandFluidTank;
import ru.grandmine.steamstell.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

	public class ItemBlockGlassTank extends ItemBlock{
		
		public static int renderID;
		@SideOnly(Side.CLIENT)
	    private IIcon bottomIcon;
	    @SideOnly(Side.CLIENT)
	    private IIcon topIcon;
	    @SideOnly(Side.CLIENT)
	    private IIcon sideIcon;
		
		public ItemBlockGlassTank(Block p_i45328_1_) {
			super(p_i45328_1_);
			this.setMaxStackSize(1);
			this.setFull3D();
		}
		
		@SideOnly(Side.CLIENT)
		@Override
		public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean isAdvanced) {

			if (stack.hasTagCompound()) {
				NBTTagCompound tag = stack.stackTagCompound;
				FluidStack fluid = null;
				if (tag.hasKey("Fluid")) {
					fluid = FluidStack.loadFluidStackFromNBT((NBTTagCompound) tag.getTag("Fluid"));
					tooltip.add("Fluid " + ": " + fluid.getLocalizedName());
				}
				int amount = (fluid != null) ? fluid.amount : 0;
				tooltip.add("Amount" + ": " + amount + " / " + 8000 + " mB");

			}
			else
				tooltip.add("Item Error");
		}


		@SideOnly(Side.CLIENT)
		public void getSubItems(Item item, CreativeTabs tab, List itemList) {

			itemList.add(Utils.getTankStackFromData());

		}


	}

