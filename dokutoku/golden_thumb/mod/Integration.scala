package dokutoku.golden_thumb.mod

import scala.collection.mutable.ListBuffer
import dokutoku.golden_thumb.seed.traits.GoldenSeed
import forestry.api.recipes.RecipeManagers
import net.minecraft.item.ItemStack
import net.minecraftforge.liquids.LiquidStack
import thermalexpansion.api.crafting.CraftingManagers
import dokutoku.golden_thumb.crop.GoldenCrop
import powercrystals.minefactoryreloaded.api.FarmingRegistry
import dokutoku.golden_thumb.mod.java.HarvestablePlant
import dokutoku.golden_thumb.mod.java.PlantableSeed
import net.minecraft.block.BlockCrops
import dokutoku.golden_thumb.mod.java.FertilizablePlant

object Integration {

  var SqueezerRegistry = new ListBuffer[Tuple2[GoldenSeed, LiquidStack]]
  var CrucibleRegistry = new ListBuffer[Tuple2[GoldenSeed, LiquidStack]]
  
  var MFRCropRegistry  = new ListBuffer[Tuple2[GoldenCrop, GoldenSeed]]
  
  var LiquidSeeds	   = new ListBuffer[GoldenSeed]
  
  def doForestryIntegration(): Unit = {
    for(seed <- SqueezerRegistry) {
      val seedStack = new ItemStack(seed._1)
      val temp = Array[ItemStack](seedStack)
      RecipeManagers.squeezerManager.addRecipe(10, temp, seed._2)
    }
  }
  
  def doThermalExpansionIntegration(): Unit = {
    
    for(seed <- CrucibleRegistry) {
      val seedStack = new ItemStack(seed._1)
      CraftingManagers.crucibleManager.addRecipe(1000, seedStack, seed._2)
    }
    
  }
  
  def doMineFactoryIntegration(): Unit = {
    
    for((crop, seed) <- MFRCropRegistry) {
      FarmingRegistry.registerHarvestable(new HarvestablePlant(crop.blockID, seed.itemID))
      FarmingRegistry.registerFertilizable(new FertilizablePlant(crop.blockID))
      FarmingRegistry.registerPlantable(new PlantableSeed(seed.itemID, seed.getPlantID(null, 0, 0, 0)))
    }
    
  }
  
}