package dokutoku.golden_thumb.mod.java;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import powercrystals.minefactoryreloaded.api.IFactoryPlantable;

public class PlantableSeed implements IFactoryPlantable {
	
	private int cropId;
	private int seedId;
	
	public PlantableSeed(int seedId, int cropId) {
		this.cropId = cropId;
		this.seedId = seedId;
	}

	@Override
	public int getSeedId() {
		return seedId;
	}

	@Override
	public int getPlantedBlockId(World world, int x, int y, int z,
			ItemStack stack) {
		if(stack.itemID != seedId)
		{
			return -1;
		}
		return cropId;
	}

	@Override
	public int getPlantedBlockMetadata(World world, int x, int y, int z,
			ItemStack stack) {
		return stack.getItemDamage();
	}

	@Override
	public boolean canBePlantedHere(World world, int x, int y, int z,
			ItemStack stack) {
		int groundId = world.getBlockId(x, y - 1, z);
		if(!world.isAirBlock(x, y, z))
		{
			return false;
		}
		return 
				(Block.blocksList[cropId].canPlaceBlockAt(world, x, y, z) && Block.blocksList[cropId].canBlockStay(world, x, y, z)) ||
				(Block.blocksList[cropId] instanceof IPlantable && Block.blocksList[groundId] != null &&
				((BlockCrops)Block.blocksList[cropId]).canThisPlantGrowOnThisBlockID(world.getBlockId(x, y, z)) &&
				Block.blocksList[groundId].canSustainPlant(world, x, y, z, ForgeDirection.UP, ((IPlantable)Block.blocksList[cropId])));
	}

	@Override
	public void prePlant(World world, int x, int y, int z, ItemStack stack) {
		
		int groundId = world.getBlockId(x, y - 1, z);
        if (groundId == Block.dirt.blockID || groundId == Block.grass.blockID)
        {
            world.setBlock(x, y - 1, z, Block.tilledField.blockID);
        }
		
	}

	@Override
	public void postPlant(World world, int x, int y, int z, ItemStack stack) {

	}

}
