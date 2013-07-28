package dokutoku.golden_thumb.lib

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.util.StringTranslate
import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly

class GoldenTab(id: Int, label: String) extends CreativeTabs(id, label) {
  
  var tabIndex : Int = 1
  
  @SideOnly(Side.CLIENT)
  override def getTranslatedTabLabel() : String = 
    StringTranslate.getInstance().translateKey("" + this.getTabLabel())
    
  @SideOnly(Side.CLIENT)
  override def getTabLabel() : String =
    label
    
  @SideOnly(Side.CLIENT)
  override def getTabIconItemIndex() : Int = tabIndex // TODO: Change this; Tab Index
  
}