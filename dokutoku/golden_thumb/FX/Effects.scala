package dokutoku.golden_thumb.FX

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import java.util.Random
import net.minecraft.world.World
import net.minecraft.src.ModLoader
import net.minecraft.client.particle.EntityRainFX

object Effects {

	@SideOnly(Side.CLIENT)
	def metalFXEffect(world: World, par2: Float, par3: Float, par4: Float, par5Random: Random, r: Float, g: Float, b: Float) = {
	
		if(par5Random.nextInt() <= 5) {
			var fx = new CropParticleFX(world,
			/* Motion to */ par2 + .5f, par3, par4 + .5f,
			/* Spawn at  */ par5Random.nextDouble() - .5f, .9D, par5Random.nextDouble() - .5f,
			/* Color     */ r, g, b);
	
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
		}
	}
	
	@SideOnly(Side.CLIENT)
	def rainFXEffect(par1World: World, f: Float, g: Float, h: Float, par5Random: Random)
	{

		if(par5Random.nextInt() <= 5) {

			val fx = new EntityRainFX(par1World, f, g, h);

			ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);

		}

	}
  
}