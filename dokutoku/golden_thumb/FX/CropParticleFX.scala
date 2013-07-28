package dokutoku.golden_thumb.FX

import net.minecraft.world.World
import net.minecraft.client.particle.EntityPortalFX

// Messy

class CropParticleFX(par1World: World, par2: Double, par4: Double,
			par6: Double, par8: Double, par10: Double, par12: Double, r: Float, g: Float, b: Float)
			extends EntityPortalFX(par1World, par2, par4, par6, par8, par10, par12) {

		this.particleRed = r;
        this.particleGreen = g;
        this.particleBlue = b;
        this.setParticleTextureIndex(65);
  
}