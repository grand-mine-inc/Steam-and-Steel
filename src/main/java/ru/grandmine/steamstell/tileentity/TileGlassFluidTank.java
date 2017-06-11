package ru.grandmine.steamstell.tileentity;

import com.sun.xml.internal.stream.Entity;

import ru.grandmine.steamstell.blocks.fluid_tank.GlassFluidTank;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileGlassFluidTank extends TileEntity implements IFluidHandler {

	public FluidTank tank = new FluidTank(GlassFluidTank.MAXFLUID);
	private boolean needsUpdate = false;
	private int updateTimer = 0;
	
	

	public TileGlassFluidTank() {

		
	}
	public TileGlassFluidTank(int x, int y, int z) {
	worldObj.getTileEntity(x, y, z);
	
	}
	
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		needsUpdate = true;
		return this.tank.fill(resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		return this.tank.drain(resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		needsUpdate = true;
		return this.tank.drain(maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] {this.tank.getInfo()};
	}
	
	public float getAdjustedVolume()
	{
		float amount = tank.getFluidAmount();
		float capacity = tank.getCapacity();
		float volume = (amount/capacity)*0.8F;
		return volume;
	}
	

	public void updateEntity()
	{
		needsUpdate = true;
	if (needsUpdate)
	{
		if (updateTimer == 0)
		{
			updateTimer = 16;
		}
		else
		{
			--updateTimer;
			if (updateTimer == 0)
	{
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = false;
	}
		}
	}
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		tank.readFromNBT(tag);

	}
	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		tank.writeToNBT(tag);
		writeCustomNBT(tag);
	}

	private void writeCustomNBT(NBTTagCompound tag) {
		NBTTagCompound comp = new NBTTagCompound();
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, tag);
	}
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.func_148857_g();
		readFromNBT(tag);
	}	
	}