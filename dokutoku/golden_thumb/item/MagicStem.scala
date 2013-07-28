package dokutoku.golden_thumb.item

import net.minecraft.item.Item
import dokutoku.golden_thumb.lib.Reference
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.util.EnumMovingObjectType
import net.minecraftforge.liquids.LiquidDictionary
import net.minecraftforge.liquids.ILiquid
import net.minecraft.block.material.Material
import net.minecraft.block.Block
import net.minecraftforge.liquids.LiquidStack
import dokutoku.golden_thumb.mod.Integration
import dokutoku.golden_thumb.util.Logger

class MagicStem(id: Int) extends Item(id) {

  setMaxStackSize(64)
  setUnlocalizedName("seeds.stem")
  setCreativeTab(Reference.tab)
  
  override def registerIcons(iReg: IconRegister) : Unit = 
    itemIcon = iReg.registerIcon(Reference.ModID+":" + "magicStem")
    
  override def onItemRightClick(itemStack: ItemStack, world: World, player: EntityPlayer): ItemStack = {
    
    val movingObject = Option(this.getMovingObjectPositionFromPlayer(world, player, true))
    
    movingObject match {
      
      case None => itemStack
      case Some(movObj) =>
        movObj.typeOfHit match {
          
          case EnumMovingObjectType.TILE => 
            
            val coord = (movObj.blockX, movObj.blockY, movObj.blockZ)
            
            if(!world.canMineBlock(player, coord._1, coord._2, coord._3))
              return itemStack
              
            if(!player.canPlayerEdit(coord._1, coord._2, coord._3, movObj.sideHit, itemStack))
              return itemStack
              
            if(Block.blocksList(world.getBlockId(coord._1, coord._2, coord._3)).isInstanceOf[ILiquid] ||
            		world.getBlockMaterial(coord._1, coord._2, coord._3) == Material.lava) {
              if(Block.blocksList(world.getBlockId(coord._1, coord._2, coord._3)).isInstanceOf[ILiquid]) {
                val liquid = new LiquidStack(Block.blocksList(world.getBlockId(coord._1, coord._2, coord._3)), 1).canonical()
                val oil	   = LiquidDictionary.getCanonicalLiquid("Oil")
                
                
                if(liquid.isLiquidEqual(oil)) {
                  itemStack.stackSize -= 1
                  
                  if(itemStack.stackSize <= 0)
                    return new ItemStack(Integration.LiquidSeeds(0))
                  
                  if(!player.inventory.addItemStackToInventory(new ItemStack(Integration.LiquidSeeds(0))))
                    player.dropPlayerItem(new ItemStack(Integration.LiquidSeeds(0)))
                }
                
              }
              
              if(world.getBlockMaterial(coord._1, coord._2, coord._3) == Material.lava) {
                
            	  itemStack.stackSize -= 1
                  
	              if(itemStack.stackSize <= 0)
	                return new ItemStack(Integration.LiquidSeeds(1))
	              
	              if(!player.inventory.addItemStackToInventory(new ItemStack(Integration.LiquidSeeds(1))))
	                player.dropPlayerItem(new ItemStack(Integration.LiquidSeeds(1)))
                
              }
            }
            
          case EnumMovingObjectType.ENTITY => itemStack
        }
        
        itemStack
      
    }
    
  }
  
}