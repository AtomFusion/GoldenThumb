package dokutoku.golden_thumb.seed

import dokutoku.golden_thumb.seed.traits.GoldenSeed
import net.minecraft.util.Icon
import net.minecraft.item.ItemStack
import net.minecraft.item.Item
import cpw.mods.fml.common.registry.GameRegistry
import dokutoku.golden_thumb.lib.Reference
import net.minecraftforge.oredict.ShapelessOreRecipe
import net.minecraftforge.oredict.OreDictionary

class TinSeed(id: Int, crop: Int) extends GoldenSeed(id, crop) {

  val product = new ItemStack(Item.ingotIron, 1)
  
  override def addRecipe() : GoldenSeed = {
    
    val ore = "oreTin"
    val wantOre = OreDictionary.getOres(ore)
    var delivered : ItemStack = null
    
    if(wantOre.size() > 0)
      delivered = wantOre.get(0)
    else
      delivered = product
    
    GameRegistry.addRecipe(
    	new ShapelessOreRecipe(delivered,
    						   new ItemStack(this))
    )
    
    GameRegistry.addRecipe(
    	new ShapelessOreRecipe(new ItemStack(this), Reference.stem, ore)
    )
    
    this
    
  }
  
}