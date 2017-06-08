package ru.grandmine.steamstell.proxy;

import ru.grandmine.steamstell.blocks.GrandBlocks;
import ru.grandmine.steamstell.crafting.BaseCraft;
import ru.grandmine.steamstell.item.GrandItem;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {


    public void preInit(FMLPreInitializationEvent e) {
    	 GrandItem.init();
    	 GrandBlocks.init();
    	 BaseCraft.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
	 
}
