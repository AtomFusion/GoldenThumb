package dokutoku.golden_thumb.lib

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

object Reference {

  final val ModID = "GoldenThumb"
  final val ModName = "Golden Thumb"
  final val VersionNumber = "1.5.2a133"
  final val Depends = "required-after:Forge@[7.8.1.737,)"
    
  final val InvalidFingerprint = "Hey, user, somebody has tampered with this jar file!"
    
  val tab = new GoldenTab(CreativeTabs.getNextID(), "Golden Thumb")
  
  var stem: Item = null // Easy way to catch the stem ID
  
}