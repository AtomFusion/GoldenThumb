package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.Overworld
import dokutoku.golden_thumb.lib.Rarity.Uncommon
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random

class LeadCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = Overworld
  val rarity = Uncommon
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
    val randu = rand.nextInt(2)
    
    if(randu == 1) metalFXEffect(world, x, y, z, rand, 0.73F, 0.84F, 1.16F)
	else           metalFXEffect(world, x, y, z, rand, 0.45F, 0.52F, 0.73F)
  }
}