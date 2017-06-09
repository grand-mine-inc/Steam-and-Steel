package ru.grandmine.steamstell.blocks.fluid_tank;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.grandmine.steamstell.blocks.GrandBlocks;
import ru.grandmine.steamstell.tileentity.TileGlassFluidTank;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;

public class GlassFluidTank extends BlockContainer {
	
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
    public int getRenderBlockPass()
        {
        return 1;
        }
    
    @Override
    public boolean isOpaqueCube()
        {
        return false;
        }
    
    @Override
    public boolean renderAsNormalBlock()
        {
        return false;
        }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {

		return new TileGlassFluidTank();
		
	}

}
