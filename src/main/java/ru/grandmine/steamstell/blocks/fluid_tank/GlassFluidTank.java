package ru.grandmine.steamstell.blocks.fluid_tank;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.grandmine.steamstell.blocks.GrandBlocks;
import ru.grandmine.steamstell.render.blocks.RenderGlassTank;
import ru.grandmine.steamstell.tileentity.TileGlassFluidTank;
import ru.grandmine.steamstell.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class GlassFluidTank extends Block implements ITileEntityProvider {
	
	public static int renderID;
	@SideOnly(Side.CLIENT)
    private IIcon bottomIcon;
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;
    public static final int MAXFLUID = 8000;
	
	public GlassFluidTank() {
		
		super(Material.glass);
		setBlockName("GlassFluidTank");
		setBlockTextureName("steamstell:glass_fluid_tank");
		setCreativeTab(GrandBlocks.tabGrandBlocks);
		setLightOpacity(0);
		setStepSound(soundTypeGlass);
		setTickRandomly(isBlockContainer);
	}
	

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world,
			
			int x, int y, int z) {
		return Utils.getTankStackFromTile((TileGlassFluidTank) world.getTileEntity(x, y, z), true);
		
	}
	
	@Override
	public boolean hasComparatorInputOverride() {
		
		return true;
		
		}
	
	public TileEntity createNewTileEntity(World world, int meta) {
		
		return new TileGlassFluidTank();
		
	}
	
	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		
		return side == ForgeDirection.DOWN;
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		
		return side == 0 ? bottomIcon : side == 1 ? blockIcon : sideIcon;
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		
		blockIcon = reg.registerIcon(getTextureName() + "_top");
		sideIcon = reg.registerIcon(getTextureName() + "_side");
		bottomIcon = reg.registerIcon(getTextureName() + "_bottom");
		
	}
	
	@Override
    public int getRenderBlockPass(){ 
		
        return 1;
        
    }
    
    @Override
    public boolean isOpaqueCube(){
    	
        return false;
        
    }
    
    @Override
    public int getRenderType() {

    	return renderID;
    
    }
    
    @Override
    public boolean renderAsNormalBlock()
        {
        return false;
        }
    
    @Override
    public boolean canRenderInPass(int pass) {
    	
    	RenderGlassTank.renderPass = pass;
    	return true;
    
    }
    
    @Override
    public int quantityDropped(Random rnd) {
    	
    	return 0;
    	
    }
    
    @Override
    public int getComparatorInputOverride(World world, int x, int y, int z, int opSide) {
    	
    	return 0;
    
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
    	
    	ItemStack stack = player.inventory.getCurrentItem();
    	if (stack != null) {
    		FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(stack);
    		TileGlassFluidTank tank = (TileGlassFluidTank) world.getTileEntity(x, y, z);
    		if (liquid != null) {
    			int amount = tank.fill(ForgeDirection.UNKNOWN, liquid, false);
    			if (amount == liquid.amount) {
    				tank.fill(ForgeDirection.UNKNOWN, liquid, true);
    				if (!player.capabilities.isCreativeMode)
    					player.inventory.setInventorySlotContents(player.inventory.currentItem, Utils.useItemSafely(stack));

    				if(tank.tank.getFluid().getFluid().getBlock() != null){
    }
    				return true;
    			}
    			else
    				return true;
    		}
    		else if (FluidContainerRegistry.isBucket(stack)) {
    			FluidTankInfo[] tanks = tank.getTankInfo(ForgeDirection.UNKNOWN);
    			if (tanks[0] != null) {
    				FluidStack fillFluid = tanks[0].fluid;
    				ItemStack fillStack = FluidContainerRegistry.fillFluidContainer(fillFluid, stack);
    				if (fillStack != null) {
    					tank.drain(ForgeDirection.UNKNOWN, FluidContainerRegistry.getFluidForFilledItem(fillStack).amount, true);
    					if (!player.capabilities.isCreativeMode) {
    						if (stack.stackSize == 1)
    							player.inventory.setInventorySlotContents(player.inventory.currentItem, fillStack);
    						else {
    							player.inventory.setInventorySlotContents(player.inventory.currentItem, Utils.useItemSafely(stack));
    							if (!player.inventory.addItemStackToInventory(fillStack))
    								player.dropPlayerItemWithRandomChoice(fillStack, false);
    						}
    					}
    					return true;
    				}
    				else
    					return true;
    			}

    		}
    	}
    	return false;
    	}
    
    @Override
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest) {
    	
    	if (!player.capabilities.isCreativeMode) {
    		TileGlassFluidTank tank = (TileGlassFluidTank) world.getTileEntity(x, y, z);

    		Utils.dropStackInWorld(world, x, y, z, Utils.getTankStackFromTile(tank, true));

    	}
    	return world.setBlockToAir(x, y, z);
    	}
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
    	
    	if (stack.hasTagCompound()) {
    		TileGlassFluidTank tank = (TileGlassFluidTank) world.getTileEntity(x, y, z);
    		if (tank != null) {
    			NBTTagCompound tagFluid = stack.getTagCompound().getCompoundTag("Fluid");
    			if (tagFluid != null) {
    				FluidStack liquid = FluidStack.loadFluidStackFromNBT(tagFluid);
    				tank.tank.setFluid(liquid);
    			}

    		}
    	}
    	}
    
    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
    	
    	Utils.dropStackInWorld(world, x, y, z, Utils.getTankStackFromTile((TileGlassFluidTank) world.getTileEntity(x, y, z), true));
    	world.setBlockToAir(x, y, z);
    	onBlockDestroyedByExplosion(world, x, y, z, explosion);
    	
    }
}
