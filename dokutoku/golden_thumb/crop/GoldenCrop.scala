package dokutoku.golden_thumb.crop

import java.util.ArrayList
import java.util.Random
import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import dokutoku.golden_thumb.crop.traits.GoldenCropTrait
import dokutoku.golden_thumb.lib.Reference
import dokutoku.golden_thumb.lib.WorldType.{Desert, End, Lava, Nether, Overworld}
import dokutoku.golden_thumb.util.RarityConverter.conv
import net.minecraft.block.Block
import net.minecraft.block.BlockCrops
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Icon
import net.minecraft.world.World
import dokutoku.golden_thumb.util.Logger
import scala.collection.mutable.ListBuffer
import cpw.mods.fml.common.registry.LanguageRegistry
import dokutoku.golden_thumb.mod.Integration
import powercrystals.minefactoryreloaded.api.IFactoryHarvestable
import powercrystals.minefactoryreloaded.api.IFactoryFertilizable
import powercrystals.minefactoryreloaded.api.HarvestType
import powercrystals.minefactoryreloaded.api.FertilizerType

abstract class GoldenCrop(id: Int, germ: Int) extends BlockCrops(id)
with GoldenCropTrait {
  
  setCreativeTab(Reference.tab)
  
  val germling = germ
  
  var IconList: ListBuffer[Icon] = ListBuffer()
  
  @SideOnly(Side.CLIENT)
  override def registerIcons(iReg: IconRegister) : Unit = {
    
    val wPrefix = worldType match {
	    case Overworld => Reference.ModID + ":" + "overworld"
	    case Nether    => Reference.ModID + ":" + "hell"
	    case End       => Reference.ModID + ":" + "end"
	    case Lava	   => Reference.ModID + ":" + "lava"
	    case Desert	   => Reference.ModID + ":" + "desert"
	    //case _		   => Reference.ModID + ":" + "overworld"
	  }
    
    val IconNameList = List(wPrefix + "_0", wPrefix + "_1", wPrefix + "_2", modName + prefix.split('.').reverse(0))
    
    for(path <- IconNameList)
      IconList += iReg.registerIcon(path)
          
  }
  
  @SideOnly(Side.CLIENT)
  override def getIcon(par1: Int, metadata: Int) : Icon = {
    
    var mdata = metadata
    
    if(mdata < 7)
    {
      if (mdata == 6)
        mdata = 5
        
      IconList(mdata >> 1) // 6 => 3 | 5,4 => 2 | 3,2,1 => 1 | 0 => 0
    } else IconList(3)
  }
  
  override def getSeedItem(): Int = germ
  override def getCropItem(): Int = this.blockID
  
  override def fertilize(world: World, x: Int, y: Int, z: Int) = {
    super.fertilize(world, x, y, z)
    updateNeighbors(world, x, y, z)
  }
  
  def getPlantBlockID() = worldType match {
    case Nether 	=> Block.slowSand.blockID
    case Overworld 	=> Block.tilledField.blockID
    case End 		=> Block.whiteStone.blockID
    case Lava 		=> Block.obsidian.blockID
    case Desert 	=> Block.sand.blockID
    case _ 			=> Block.tilledField.blockID
  }
  
  override def canThisPlantGrowOnThisBlockID(id: Int) = id == getPlantBlockID()
  
  override def getBlockDropped(world: World, x: Int, y: Int, z: Int, metadata: Int, fortune: Int): ArrayList[ItemStack] = {
    
    val ret = new ArrayList[ItemStack]
    val item = new ItemStack(this.getSeedItem, 1, 0)
    
    // mature enough?
    if(metadata >= 7)
        if(world.rand.nextInt(15 + (conv(rarity))) <= 7)
        {
          ret add item
          
          if(world.rand.nextInt(30 + (conv(rarity))) <= 10)
          {
            ret add item
          }
        }
    
    ret add item
    ret
  }
  
  override def updateTick(world: World, x: Int, y: Int, z: Int, rand: Random) = {
    
    val growthRate = 14.875 * (conv(rarity) / 10.0f)
    
    if(world.getBlockLightValue(x, y+1, z) >= 9)
    {
      var l = world.getBlockMetadata(x, y, z)
      var chance = (25 / growthRate).toInt + 1
      if(chance < 0)
        chance = 0
      
      if(l < 7)
	      if(rand.nextInt(chance) == 0)
	      {
	        l += 1
	        world.setBlockMetadataWithNotify(x, y, z, l, 2)
	      }
    }
    
    updateNeighbors(world, x, y, z)
    
  }
  
  def updateNeighbors(world: World, x: Int, y: Int, z: Int) = if(needsUpdate) {
    
    world.notifyBlockOfNeighborChange(x - 1, y, z, this.blockID)
    world.notifyBlockOfNeighborChange(x + 1, y, z, this.blockID)
    world.notifyBlockOfNeighborChange(x, y - 1, z, this.blockID)
    world.notifyBlockOfNeighborChange(x, y + 1, z, this.blockID)
    world.notifyBlockOfNeighborChange(x, y, z - 1, this.blockID)
    world.notifyBlockOfNeighborChange(x, y, z + 1, this.blockID)
    
  }
  
  def doPostWork(): Block = {
    
    val saneName = this.getClass().getSimpleName().split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")
    
    LanguageRegistry.addName(this, saneName.mkString(" "))
    
    this
    
  }
  
}