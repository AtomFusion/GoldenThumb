package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.Overworld
import dokutoku.golden_thumb.lib.Rarity.ExtremelyCommon
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random

class CoalCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = Overworld
  val rarity = ExtremelyCommon
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
    if(rand.nextFloat() <= 0.3f) world.spawnParticle("smoke", x + rand.nextFloat(), y + 0.1f, z + rand.nextFloat(),
											                0.0f, 0.03f, 0.0f)
    
  }
}