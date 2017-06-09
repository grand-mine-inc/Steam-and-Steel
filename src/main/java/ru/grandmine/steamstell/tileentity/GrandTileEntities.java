package ru.grandmine.steamstell.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public final class GrandTileEntities {

    public static void init() {
        GameRegistry.registerTileEntity(TileGlassFluidTank.class, "tile_glass_fluid_tank");
    }

}
