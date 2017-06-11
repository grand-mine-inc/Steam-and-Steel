package ru.grandmine.steamstell.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.grandmine.steamstell.blocks.fluid_tank.GlassFluidTank;
import ru.grandmine.steamstell.blocks.fluid_tank.GrandFluidTank;
import ru.grandmine.steamstell.render.blocks.RenderGlassTank;
import ru.grandmine.steamstell.render.blocks.RenderItemBlockGlassTank;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	

	@Override
	public void registerRenders() {
		int tank_id = RenderingRegistry.getNextAvailableRenderId();
		GlassFluidTank.renderID = tank_id;
		RenderingRegistry.registerBlockHandler(tank_id, new RenderGlassTank(tank_id));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(GrandFluidTank.renderblocks), new RenderItemBlockGlassTank());


}

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

}
