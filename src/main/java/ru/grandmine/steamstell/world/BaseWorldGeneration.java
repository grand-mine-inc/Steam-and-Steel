package ru.grandmine.steamstell.world;

import java.util.Random;

import ru.grandmine.steamstell.blocks.GrandBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class BaseWorldGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			this.lowOre(this.generation_copper, world, random, chunkX, chunkZ, 30, 0, 256);
			this.lowOre(this.generation_tin, world, random, chunkX, chunkZ, 30, 0, 256);
			this.mediumOre(this.generation_lead, world, random, chunkX, chunkZ, 30, 0, 256);
			this.mediumOre(this.generation_aluminium, world, random, chunkX, chunkZ, 30, 0, 256);
			this.mediumOre(this.generation_nickel, world, random, chunkX, chunkZ, 30, 0, 256);
			this.hardOre(this.generation_ruby, world, random, chunkX, chunkZ, 30, 0, 256);
			this.hardOre(this.generation_uranium, world, random, chunkX, chunkZ, 30, 0, 256);
			break;
		case -1:
			this.netherOre(this.generation_sulfur, world, random, chunkX, chunkZ, 40, 0, 256);
			break;
		case 1:
			
			break;
		}	
	}
	private WorldGenerator generation_copper;
	private WorldGenerator generation_tin;
	private WorldGenerator generation_lead;
	private WorldGenerator generation_aluminium;
	private WorldGenerator generation_nickel;
	private WorldGenerator generation_ruby;
	private WorldGenerator generation_uranium;
	private WorldGenerator generation_sulfur;
	
	public BaseWorldGeneration() {
		this.generation_copper = new WorldGenMinable(GrandBlocks.blockcopperore, 7);
		this.generation_tin = new WorldGenMinable(GrandBlocks.blocktinore, 7);
		this.generation_aluminium = new WorldGenMinable(GrandBlocks.blockaluminiumore, 5);
		this.generation_lead = new WorldGenMinable(GrandBlocks.blockleadore, 5);
		this.generation_nickel = new WorldGenMinable(GrandBlocks.blocknickelore, 4);
		this.generation_ruby = new WorldGenMinable(GrandBlocks.blockrubyore, 3);
		this.generation_uranium = new WorldGenMinable(GrandBlocks.blockuraniumore, 3);
		this.generation_sulfur = new WorldGenMinable(GrandBlocks.blocksulfurore, 32, Blocks.netherrack);
	}
	
	private void lowOre(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		
			if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
	
			int heightDiff = 60;
			for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, x, y, z);
			}
		}
	
	private void mediumOre(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
		throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = 40;
		for (int i = 0; i < chancesToSpawn; i ++) {
		int x = chunk_X * 16 + rand.nextInt(16);
		int y = minHeight + rand.nextInt(heightDiff);
		int z = chunk_Z * 16 + rand.nextInt(16);
		generator.generate(world, rand, x, y, z);
		}
	}
	
	private void hardOre(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
		throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = 20;
		for (int i = 0; i < chancesToSpawn; i ++) {
		int x = chunk_X * 16 + rand.nextInt(16);
		int y = minHeight + rand.nextInt(heightDiff);
		int z = chunk_Z * 16 + rand.nextInt(16);
		generator.generate(world, rand, x, y, z);
		}
	}
	
private void netherOre(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
		throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = 40;
		for (int i = 0; i < chancesToSpawn; i ++) {
		int x = chunk_X * 16 + rand.nextInt(16);
		int y = minHeight + rand.nextInt(heightDiff);
		int z = chunk_Z * 16 + rand.nextInt(16);
		generator.generate(world, rand, x, y, z);
		}
	}
	
}