package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.Lava
import dokutoku.golden_thumb.lib.Rarity.Rare
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random

class LavaCrystalCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = Lava
  val rarity = Rare
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
    val randu = rand.nextFloat()
    
    if(randu <= 0.3f) world.spawnParticle("flame", x + rand.nextFloat(), y + 0.1f, z + rand.nextFloat(),
           	 	   	  0.0f, 0.03f, 0.0f)
    if(randu <= 0.05f) world.spawnParticle("lava", x, y, z, 0.0f, 0.0f, 0.0f)
  }
}