package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.Nether
import dokutoku.golden_thumb.lib.Rarity.Uncommon
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random

class NetherrackCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = Nether
  val rarity = Uncommon
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
    val randu = rand.nextFloat()
    
    if(randu <= 0.3f) world.spawnParticle("flame", x + rand.nextFloat(), y + 0.1f, z + rand.nextFloat(),
                	 0.0f, 0.03f, 0.0f)
					 world.spawnParticle("portal", x + rand.nextFloat(), y + 0.1f, z + rand.nextFloat(),
					 0.0f, 0.00f, 0.0f)
  }
}