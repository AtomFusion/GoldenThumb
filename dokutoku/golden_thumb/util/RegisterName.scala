package dokutoku.golden_thumb.util

import net.minecraft.item.Item
import cpw.mods.fml.common.registry.LanguageRegistry

object RegisterName {

  def register(item: Item): Item = {
    
    val saneName = item.getClass().getSimpleName().split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")
    
    LanguageRegistry.addName(item, saneName.mkString(" "))
    
    item
    
  }
  
}