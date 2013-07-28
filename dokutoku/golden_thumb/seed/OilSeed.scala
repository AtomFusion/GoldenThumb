package dokutoku.golden_thumb.seed

import dokutoku.golden_thumb.seed.traits.GoldenSeed
import net.minecraft.util.Icon
import net.minecraft.item.ItemStack
import net.minecraft.item.Item
import cpw.mods.fml.common.registry.GameRegistry
import dokutoku.golden_thumb.lib.Reference
import forestry.api.recipes.RecipeManagers
import dokutoku.golden_thumb.mod.Integration
import net.minecraftforge.liquids.LiquidDictionary
import dokutoku.golden_thumb.util.Logger

class OilSeed(id: Int, crop: Int) extends GoldenSeed(id, crop) {

  val product = null
  
  
  override def addRecipe() = {
    
    val oil  = Option(LiquidDictionary.getLiquid("Oil", 500))
    
    oil match {
      case Some(value) => Integration.SqueezerRegistry += Tuple2(this, value)
      case None		   => Logger.debug("Oil not found")
    }
    
    this
  }
  
}