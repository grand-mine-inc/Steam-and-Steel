package ru.grandmine.steamstell.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class GrandItem {

	public static final CreativeTabs tabGrandItem = new CreativeTabs("GrandItem") {
		@Override public Item getTabIconItem() {
	        return GrandItem.leadingot;
	}
	};
	
	public static Item copperingot;
	public static Item aluminiumingot;
	public static Item leadingot;
	public static Item nickelingot;
	public static Item tiningot;
	public static Item uraniumingot;
	public static Item ruby;
	public static Item sulfurdust;
	public static Item glassbottomtank;
	
	public static final void init() {
		
		copperingot = new CopperIngot();
		aluminiumingot = new AluminiumIngot();
		leadingot = new LeadIngot();
		nickelingot = new NickelIngot();
		tiningot = new TinIngot();
		uraniumingot = new UraniumIngot();
		ruby = new Ruby();
		sulfurdust = new SulfurDust();
		glassbottomtank = new GlassBottomTank();
		
		GameRegistry.registerItem(copperingot, "copper_ingot");
		GameRegistry.registerItem(aluminiumingot, "aluminium_ingot");
		GameRegistry.registerItem(leadingot, "lead_ingot");
		GameRegistry.registerItem(nickelingot, "nickel_ingot");
		GameRegistry.registerItem(tiningot, "tin_ingot");
		GameRegistry.registerItem(uraniumingot, "uranium_ingot");
		GameRegistry.registerItem(ruby, "ruby");
		GameRegistry.registerItem(sulfurdust, "sulfur_dust");
		GameRegistry.registerItem(glassbottomtank, "glass_bottom_tank");
		
    }
	
}

