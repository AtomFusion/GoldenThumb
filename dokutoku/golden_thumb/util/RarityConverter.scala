package dokutoku.golden_thumb.util

import dokutoku.golden_thumb.lib.Rarity._

object RarityConverter {
	def conv(r: Rarity) : Int = r match {
	  case ExtremelyCommon => 0
	  case Common 		   => 1
	  case Uncommon		   => 2
	  case Rare			   => 3
	  case ExtremelyRare   => 4
	}
}