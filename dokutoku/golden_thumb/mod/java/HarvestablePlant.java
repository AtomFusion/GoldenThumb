package dokutoku.golden_thumb.mod.java;

import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import powercrystals.minefactoryreloaded.api.FertilizerType;
import powercrystals.minefactoryreloaded.api.HarvestType;
import powercrystals.minefactoryreloaded.api.IFactoryFertilizable;
import powercrystals.minefactoryreloaded.api.IFactoryHarvestable;

public class HarvestablePlant implements IFactoryHarvestable {
	
	private int sourceBlockId;
	private int seedId;
	
	public HarvestablePlant(int sourceBlockId, int seedId) {
		this.sourceBlockId = sourceBlockId;
		this.seedId = seedId;
	}

	@Override
	public int getPlantId() {
		return sourceBlockId;
	}

	@Override
	public HarvestType getHarvestType() {
		return HarvestType.Normal;
	}

	@Override
	public boolean breakBlock() {
		return true;
	}

	@Override
	public boolean canBeHarvested(World world,
			Map<String, Boolean> harvesterSettings, int x, int y, int z) {
		System.out.println("I'm returning: " + (world.getBlockMetadata(x, y, z) >= 7));
		return world.getBlockMetadata(x, y, z) >= 7;
	}

	@Override
	public List<ItemStack> getDrops(World world, Random rand,
			Map<String, Boolean> harvesterSettings, int x, int y, int z) {
		BlockCrops crop = ((BlockCrops)Block.blocksList[world.getBlockId(x, y, z)]);
		return crop.getBlockDropped(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
	}

	@Override
	public void preHarvest(World world, int x, int y, int z) {

	}

	@Override
	public void postHarvest(World world, int x, int y, int z) {

	}

}
