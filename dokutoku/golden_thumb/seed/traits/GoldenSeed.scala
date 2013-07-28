package dokutoku.golden_thumb.seed.traits

import dokutoku.golden_thumb.crop.GoldenCrop
import dokutoku.golden_thumb.lib.Reference
import net.minecraft.block.Block
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemSeeds
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import java.util.ArrayList
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.registry.LanguageRegistry
import net.minecraft.item.Item
import dokutoku.golden_thumb.mod.Integration
import powercrystals.minefactoryreloaded.api.IFactoryPlantable
import net.minecraftforge.common.IPlantable
import net.minecraftforge.common.ForgeDirection

abstract class GoldenSeed(id: Int, crop: Int) extends ItemSeeds(id, crop, Block.tilledField.blockID)
with GoldenSeedTrait {

  setCreativeTab(Reference.tab)
  
  def addRecipe() : GoldenSeed = {
    
    GameRegistry.addShapelessRecipe(product, new ItemStack(this)) // Output
    GameRegistry.addShapelessRecipe(new ItemStack(this), product, new ItemStack(Reference.stem))
    
    this
    
  }
  
  override def registerIcons(iReg: IconRegister) =
    itemIcon = iReg.registerIcon(Reference.ModID+":" + this.getClass.getName.toLowerCase.split('.').reverse(0))
  
  override def onItemUse(item: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float): Boolean =

	  if(player.canPlayerEdit(x, y, z, side, item) && player.canPlayerEdit(x, y+1, z, side, item) && side == 1) {
	    val block = world.getBlockId(x, y, z);
	    val soil: Block = Block.blocksList(block)
	    
	    if (soil != null && canSustainPlant(world, x, y, z) && world.isAirBlock(x, y+1, z)) {
	      world.setBlock(x, y+1, z, this.crop)
	      item.stackSize -= 1
	      true
	    } else false
	    
	  } else false
  
  def canSustainPlant(world: World, x: Int, y: Int, z: Int) =
  	(Block.blocksList(crop).asInstanceOf[GoldenCrop]).canThisPlantGrowOnThisBlockID(world.getBlockId(x, y, z))
  	
  def doPostWork(): Item = {
    
    val saneName = this.getClass().getSimpleName().split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")
    setUnlocalizedName(saneName(0) + ":" + saneName(1))    
    LanguageRegistry.addName(this, saneName.mkString(" "))
    
    this
    
  }
  
}