package ru.grandmine.steamstell.blocks;

import ru.grandmine.steamstell.item.GrandItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GrandBlocks {

	public static final CreativeTabs tabGrandBlocks = new CreativeTabs("GrandBlocks") {
		@Override public Item getTabIconItem() {
	        return GrandItem.ruby;
	}
	};
	
	public static Block blockcopperore;
	public static Block blocktinore;
	public static Block blockleadore;
	public static Block blockuraniumore;
	public static Block blockaluminiumore;
	public static Block blocknickelore;
	public static Block blockrubyore;
	public static Block blocksulfurore;
	public static Block aluminiumblock;
	public static Block copperblock;
	public static Block leadblock;
	public static Block nickelblock;
	public static Block rubyblock;
	public static Block tinblock;
	public static Block uraniumblock;
	
	public static final void init() {

		blockcopperore = new BlockCopperOre();
		blocktinore = new BlockTinOre();
		blockleadore = new BlockLeadOre();
		blockuraniumore = new BlockUraniumOre();
		blockaluminiumore = new BlockAluminiumOre();
		blocknickelore = new BlockNickelOre();
		blockrubyore = new BlockRubyOre();
		blocksulfurore = new BlockSulfurOre();
		aluminiumblock = new AluminiumBlock();
		copperblock = new CopperBlock();
		nickelblock = new NickelBlock();
		rubyblock = new RubyBlock();
		leadblock = new LeadBlock();
		tinblock = new TinBlock();
		uraniumblock = new UraniumBlock();
		
		GameRegistry.registerBlock(blockcopperore, "block_copper_ore");
		GameRegistry.registerBlock(blocktinore, "block_tin_ore");
		GameRegistry.registerBlock(blockleadore, "block_lead_ore");
		GameRegistry.registerBlock(blockuraniumore, "block_uranium_ore");
		GameRegistry.registerBlock(blockaluminiumore, "block_aluminium_ore");
		GameRegistry.registerBlock(blocknickelore, "block_nickel_ore");
		GameRegistry.registerBlock(blockrubyore, "block_ruby_ore");
		GameRegistry.registerBlock(blocksulfurore, "block_sulfur_ore");
		GameRegistry.registerBlock(aluminiumblock, "aluminium_block");
		GameRegistry.registerBlock(copperblock, "copper_block");
		GameRegistry.registerBlock(leadblock, "lead_block");
		GameRegistry.registerBlock(nickelblock, "nickel_block");
		GameRegistry.registerBlock(rubyblock, "ruby_block");
		GameRegistry.registerBlock(tinblock, "tin_block");
		GameRegistry.registerBlock(uraniumblock, "uranium_block");
		
    }
	
}
