package dokutoku.golden_thumb.lib

import dokutoku.golden_thumb.lib.Rarity._

object WorldType extends Enumeration {
	type WorldType = Value
	val Overworld, Nether, End, Lava, Desert = Value
}