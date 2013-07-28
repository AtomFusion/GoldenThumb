package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.Overworld
import dokutoku.golden_thumb.lib.Rarity.Uncommon
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random

class NickelCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = Overworld
  val rarity = Uncommon
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
    val randu = rand.nextInt(2)
    
    if(randu == 1) metalFXEffect(world, x, y, z, rand, 2.55F, 2.55F, 2.22F);
	else           metalFXEffect(world, x, y, z, rand, 1.28F, 1.24F, 0.98F);
  }
}