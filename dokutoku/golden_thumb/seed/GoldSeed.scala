package dokutoku.golden_thumb.seed

import dokutoku.golden_thumb.seed.traits.GoldenSeed
import net.minecraft.item.ItemStack
import net.minecraft.item.Item
import net.minecraft.block.Block

class GoldSeed(id: Int, crop: Int) extends GoldenSeed(id, crop) {

    val product = new ItemStack(Block.oreGold, 1)
  
}