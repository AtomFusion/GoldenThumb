package dokutoku.golden_thumb.mod.java;

import java.util.Random;

import net.minecraft.world.World;
import powercrystals.minefactoryreloaded.api.FertilizerType;
import powercrystals.minefactoryreloaded.api.IFactoryFertilizable;

public class FertilizablePlant implements IFactoryFertilizable {

	private int sourceBlockId;
	
	public FertilizablePlant(int sourceBlockId) {
		this.sourceBlockId = sourceBlockId;
	}

	@Override
	public int getFertilizableBlockId() {
		return sourceBlockId;
	}

	@Override
	public boolean canFertilizeBlock(World world, int x, int y, int z,
			FertilizerType fertilizerType) {
		return fertilizerType == FertilizerType.GrowPlant && world.getBlockMetadata(x, y, z) != 7;
	}

	@Override
	public boolean fertilize(World world, Random rand, int x, int y, int z, FertilizerType fertilizerType) {
		
		int m = world.getBlockMetadata(x, y, z);
		if(m < 7)
		{
			world.setBlockMetadataWithNotify(x, y, z, m+1, 3);
			return true;
		}
		return false;
		
	}

}
