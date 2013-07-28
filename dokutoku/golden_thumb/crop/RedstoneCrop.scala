package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.Overworld
import dokutoku.golden_thumb.lib.Rarity.Common
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random
import net.minecraft.world.IBlockAccess

class RedstoneCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = Overworld
  val rarity = Common
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
    if(rand.nextFloat() <= 0.3f) world.spawnParticle("reddust", x + rand.nextFloat(), y + 0.1f, z + rand.nextFloat(),
           	 		   			 0.0f, 0.00f, 0.0f)
           	 		   
  }
  
  override def canProvidePower() = true
  
  override def isProvidingWeakPower(metadata: IBlockAccess, x: Int, y: Int, z: Int, side: Int) : Int = {
    
    val max = 16
    
    metadata.getBlockMetadata(x, y, z) match {
      
      case 15 => max
      case 14 => max
      case 13 => max
      case 12 => max
      case 11 => max
      case 10 => max
      case  9 => max
      case  8 => max
      case  7 => max
      case  6 => max-2
      case  5 => max-4
      case  4 => max-6
      case  3 => max-8
      case  2 => max-10
      case  1 => max-12
      case  0 => max-14
      
    }
    
  }
  
}