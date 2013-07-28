package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.Overworld
import dokutoku.golden_thumb.lib.Rarity.Rare
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random

class LapisCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = Overworld
  val rarity = Rare
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
    val randu = rand.nextInt(2)
    
    if(randu == 1) metalFXEffect(world, x, y, z, rand, 0.10F, 0.43F, 1.22F)
	else           metalFXEffect(world, x, y, z, rand, 0.90F, 1.30F, 2.26F)
  }
}