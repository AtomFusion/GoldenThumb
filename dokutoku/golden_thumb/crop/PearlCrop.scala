package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.End
import dokutoku.golden_thumb.lib.Rarity.ExtremelyRare
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random

class PearlCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = End
  val rarity = ExtremelyRare
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
    world.spawnParticle("townaura", x + rand.nextFloat(), y + 0.5f, z + rand.nextFloat(),
 	 		   		0.0f, 0.00f, 0.0f)
 	 		   		
  }
}