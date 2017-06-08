package ru.grandmine.steamstell.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public final class GrandTileEntities {

    public static void init() {
        GameRegistry.registerTileEntity(FluidTileEntity.class, "grand_tile_entity");
    }

}
