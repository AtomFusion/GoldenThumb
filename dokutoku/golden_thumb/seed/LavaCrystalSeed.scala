package dokutoku.golden_thumb.seed

import dokutoku.golden_thumb.seed.traits.GoldenSeed
import net.minecraft.util.Icon
import net.minecraft.item.ItemStack
import net.minecraft.item.Item
import cpw.mods.fml.common.registry.GameRegistry
import dokutoku.golden_thumb.lib.Reference
import net.minecraftforge.liquids.LiquidDictionary
import dokutoku.golden_thumb.mod.Integration
import dokutoku.golden_thumb.util.Logger

class LavaCrystalSeed(id: Int, crop: Int) extends GoldenSeed(id, crop) {

  val product = new ItemStack(Item.bucketLava, 1)
  
  
  override def addRecipe() = {
		  
			val oil  = Option(LiquidDictionary.getLiquid("Lava", 500))
			
			oil match {
			  case Some(value) => Integration.CrucibleRegistry += Tuple2(this, value)
			  case None		   => Logger.debug("Lava not found... (Huh?)")
			}
		  
		  this
  }
  
}