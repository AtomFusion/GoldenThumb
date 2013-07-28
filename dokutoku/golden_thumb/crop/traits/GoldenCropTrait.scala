package dokutoku.golden_thumb.crop.traits

import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.lib.Rarity.Rarity
import dokutoku.golden_thumb.lib.Reference
import dokutoku.golden_thumb.lib.WorldType.{End, Nether, Overworld, WorldType}
import net.minecraft.util.Icon

trait GoldenCropTrait {
  
  var fullyGrown: Boolean = false
  var needsUpdate: Boolean = false
  val rarity: Rarity
  val cropName: String = this.getClass().getName()
  val worldType: WorldType
  protected val modName = Reference.ModID + ":"
  protected val prefix = modName + cropName
  
  val germling: Int
  
}