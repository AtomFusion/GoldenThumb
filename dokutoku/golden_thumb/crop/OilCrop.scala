package dokutoku.golden_thumb.crop

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.WorldType.Desert
import dokutoku.golden_thumb.lib.Rarity.Rare
import dokutoku.golden_thumb.FX.Effects.metalFXEffect
import net.minecraft.world.World
import java.util.Random
import dokutoku.golden_thumb.FX.Effects
import net.minecraft.client.particle.EntityRainFX
import net.minecraft.src.ModLoader

class OilCrop(id: Int, germ: Int) extends GoldenCrop(id, germ) {

  val worldType = Desert
  val rarity = Rare
  
  @SideOnly(Side.CLIENT)
  override def randomDisplayTick(world: World, x: Int, y: Int, z: Int, rand: Random) : Unit = {
    
	  if(rand.nextInt() <= 5) {

			val fx = new EntityRainFX(world, x, y, z);
			fx.setRBGColorF(0.0F, 0.0F, 0.0F)

			ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);

	  }
    
  }
}