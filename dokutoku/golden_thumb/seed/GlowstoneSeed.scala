package dokutoku.golden_thumb.seed

import dokutoku.golden_thumb.seed.traits.GoldenSeed
import net.minecraft.util.Icon
import net.minecraft.item.ItemStack
import net.minecraft.item.Item

class GlowstoneSeed(id: Int, crop: Int) extends GoldenSeed(id, crop) {

  val product = new ItemStack(Item.lightStoneDust, 3)
  
}