package dokutoku.golden_thumb

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.{FingerprintWarning, Instance, Init, PreInit, PostInit}
import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLInitializationEvent, FMLFingerprintViolationEvent}
import dokutoku.golden_thumb.util.Logger
import dokutoku.golden_thumb.lib.Reference
import net.minecraft.block.Block
import net.minecraftforge.common.Configuration
import net.minecraft.item.Item
import dokutoku.golden_thumb.lib.GoldenTab
import net.minecraft.creativetab.CreativeTabs
import dokutoku.golden_thumb.seed.IronSeed
import dokutoku.golden_thumb.crop.IronCrop
import dokutoku.golden_thumb.seed.GoldSeed
import dokutoku.golden_thumb.crop.GoldCrop
import dokutoku.golden_thumb.seed.TinSeed
import dokutoku.golden_thumb.seed.CopperSeed
import dokutoku.golden_thumb.seed.SilverSeed
import dokutoku.golden_thumb.seed.LeadSeed
import dokutoku.golden_thumb.seed.NickelSeed
import dokutoku.golden_thumb.crop.TinCrop
import dokutoku.golden_thumb.crop.SilverCrop
import dokutoku.golden_thumb.crop.LeadCrop
import dokutoku.golden_thumb.crop.NickelCrop
import dokutoku.golden_thumb.crop.CopperCrop
import dokutoku.golden_thumb.crop.ClayCrop
import dokutoku.golden_thumb.crop.RedstoneCrop
import dokutoku.golden_thumb.crop.CoalCrop
import dokutoku.golden_thumb.crop.NetherrackCrop
import dokutoku.golden_thumb.crop.GlowstoneCrop
import dokutoku.golden_thumb.crop.QuartzCrop
import dokutoku.golden_thumb.crop.SoulsandCrop
import dokutoku.golden_thumb.crop.PearlCrop
import dokutoku.golden_thumb.crop.EndstoneCrop
import dokutoku.golden_thumb.crop.LavaCrystalCrop
import dokutoku.golden_thumb.seed.RedstoneSeed
import dokutoku.golden_thumb.seed.ClaySeed
import dokutoku.golden_thumb.seed.CoalSeed
import dokutoku.golden_thumb.seed.NetherrackSeed
import dokutoku.golden_thumb.seed.GlowstoneSeed
import dokutoku.golden_thumb.seed.QuartzSeed
import dokutoku.golden_thumb.seed.SoulsandSeed
import dokutoku.golden_thumb.seed.PearlSeed
import dokutoku.golden_thumb.seed.EndstoneSeed
import dokutoku.golden_thumb.seed.LavaCrystalSeed
import dokutoku.golden_thumb.seed.LapisSeed
import dokutoku.golden_thumb.crop.LapisCrop
import dokutoku.golden_thumb.item.MagicStem
import dokutoku.golden_thumb.seed.OilSeed
import dokutoku.golden_thumb.crop.OilCrop
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.Loader
import dokutoku.golden_thumb.mod.Integration
import cpw.mods.fml.common.registry.LanguageRegistry
import dokutoku.golden_thumb.util.RegisterName
import dokutoku.golden_thumb.seed.traits.GoldenSeed
import net.minecraftforge.common.ChestGenHooks
import net.minecraft.util.WeightedRandomChestContent
import net.minecraft.item.ItemStack
import cpw.mods.fml.common.registry.GameRegistry
import powercrystals.minefactoryreloaded.api.FarmingRegistry
import dokutoku.golden_thumb.mod.java.PlantableSeed
import dokutoku.golden_thumb.mod.java.HarvestablePlant
import dokutoku.golden_thumb.crop.GoldenCrop
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side

object GoldenThumb {
  @Instance("GoldenThumb")
  var INSTANCE: GoldenThumb = null // object instances MUST be set
}

@Mod(modid = Reference.ModID, name = Reference.ModName, version = Reference.VersionNumber)
class GoldenThumb {
  
  /* Metals */
  
  var cropIron: Block = null
  var cropIronID: Int = -1
  
  var cropGold: Block = null
  var cropGoldID: Int = -1
  
  var cropTin: Block = null
  var cropTinID: Int = -1
  
  var cropCopper: Block = null
  var cropCopperID: Int = -1
  
  var cropSilver: Block = null
  var cropSilverID: Int = -1
  
  var cropLead: Block = null
  var cropLeadID: Int = -1
  
  var cropNickel: Block = null
  var cropNickelID: Int = -1
  
  var seedIron: Item = null
  var seedIronID: Int = -1
  
  var seedGold: Item = null
  var seedGoldID: Int = -1

  var seedTin: Item = null
  var seedTinID: Int = -1 
  
  var seedCopper: Item = null
  var seedCopperID: Int = -1
  
  var seedSilver: Item = null
  var seedSilverID: Int = -1
  
  var seedLead: Item = null
  var seedLeadID: Int = -1
  
  var seedNickel: Item = null
  var seedNickelID: Int = -1
  
  /* General Resources : Crops */
  
  var cropClay: Block = null
  var cropClayID: Int = -1
  
  var cropRedstone: Block = null
  var cropRedstoneID: Int = -1
  
  var cropCoal: Block = null
  var cropCoalID: Int = -1
  
  var cropLapis: Block = null
  var cropLapisID: Int = -1
  
  //* Nether *//
  
  var cropNetherrack: Block = null
  var cropNetherrackID: Int = -1
  
  var cropGlowstone: Block = null
  var cropGlowstoneID: Int = -1
  
  var cropQuartz: Block = null
  var cropQuartzID: Int = -1
  
  var cropSoulsand: Block = null
  var cropSoulsandID: Int = -1
  
  //* End *//
  
  var cropPearl: Block = null
  var cropPearlID: Int = -1
  
  var cropEndstone: Block = null
  var cropEndstoneID: Int = -1
  
  //* Deep *//
  
  var cropLavaCrystal: Block = null
  var cropLavaCrystalID: Int = -1
  
  //* Desert *//
  
  var cropOil: Block = null
  var cropOilID: Int = -1
  
  /* General Resources : Seeds */
  
  var seedClay: Item = null
  var seedClayID: Int = -1
  
  var seedRedstone: Item = null
  var seedRedstoneID: Int = -1
  
  var seedCoal: Item = null
  var seedCoalID: Int = -1
  
  var seedLapis: Item = null
  var seedLapisID: Int = -1
  
  //* Nether *//
  
  var seedNetherrack: Item = null
  var seedNetherrackID: Int = -1
  
  var seedGlowstone: Item = null
  var seedGlowstoneID: Int = -1
  
  var seedQuartz: Item = null
  var seedQuartzID: Int = -1
  
  var seedSoulsand: Item = null
  var seedSoulsandID: Int = -1
  
  //* End *//
  
  var seedPearl: Item = null
  var seedPearlID: Int = -1
  
  var seedEndstone: Item = null
  var seedEndstoneID: Int = -1
  
  //* Deep *//
  
  var seedLavaCrystal: Item = null
  var seedLavaCrystalID: Int = -1
  
  //* Desert *//
  
  var seedOil: Item = null
  var seedOilID: Int = -1
  
  /* Items */
  
  var magicalStemID: Int = -1
  var magicalStem: Item = null
  
  var magicBucketID: Int = -1
  var magicBucket: Item = null
  
  
  @PreInit
  def preInit(event: FMLPreInitializationEvent): Unit = {
    
    /* Config */
    
    val config = new Configuration(event.getSuggestedConfigurationFile())
    config.load()
    
    /* Crops (Blocks) */
    cropIronID = config.getBlock("crop", "Iron Crop ID", 2800).getInt()
    cropGoldID = config.getBlock("crop", "Gold Crop ID", 2801).getInt()
    
    /* General */
    cropClayID 	   = config.getBlock("crop", "Clay Crop ID", 2802).getInt()
    cropRedstoneID = config.getBlock("crop", "Redstone Crop ID", 2803).getInt()
    cropCoalID 	   = config.getBlock("crop", "Coal Crop ID", 2804).getInt()
    cropLapisID	   = config.getBlock("crop", "Lapis Crop ID", 2817).getInt()
    
    /* Nether */
    cropNetherrackID = config.getBlock("crop", "Netherrack Crop ID", 2805).getInt()
    cropGlowstoneID  = config.getBlock("crop", "Glowstone Crop ID", 2806).getInt()
    cropQuartzID     = config.getBlock("crop", "Quartz Crop ID", 2807).getInt()
    cropSoulsandID   = config.getBlock("crop", "Soulsand Crop ID", 2808).getInt()
    
    /* End */
    cropPearlID = config.getBlock("crop", "Pearl Crop ID", 2809).getInt()
    cropEndstoneID = config.getBlock("crop", "Endstone Crop ID", 2810).getInt()
    
    /* Deep */
    cropLavaCrystalID = config.getBlock("crop", "Lava Crystal Crop ID", 2815).getInt()
    
    /* Desert */
    cropOilID = config.getBlock("crop", "Oil Crop ID", 2818).getInt()
    
    /* Nonstandard */
    cropTinID 	 = config.getBlock("crop", "Tin Crop ID",    2811).getInt()
    cropCopperID = config.getBlock("crop", "Copper Crop ID", 2812).getInt()
    cropSilverID = config.getBlock("crop", "Silver Crop ID", 2813).getInt()
    cropLeadID 	 = config.getBlock("crop", "Lead Crop ID",   2814).getInt()
    cropNickelID = config.getBlock("crop", "Nickel Crop ID", 2816).getInt()
    
    /* Seeds (Items) */
    seedIronID = config.getItem("seed", "Iron Seed ID", 5300).getInt()
    seedGoldID = config.getItem("seed", "Gold Seed ID", 5301).getInt()
    
    /* General */
    seedClayID 	   = config.getItem("seed", "Clay Seed ID", 5302).getInt()
    seedRedstoneID = config.getItem("seed", "Redstone Seed ID", 5303).getInt()
    seedCoalID 	   = config.getItem("seed", "Coal Seed ID", 5304).getInt()
    seedLapisID	   = config.getItem("seed", "Lapis Seed ID", 5319).getInt()
    
    /* Nether */
    seedNetherrackID = config.getItem("seed", "Netherrack Seed ID", 5305).getInt()
    seedGlowstoneID  = config.getItem("seed", "Glowstone Seed ID", 5306).getInt()
    seedQuartzID     = config.getItem("seed", "Quartz Seed ID", 5307).getInt()
    seedSoulsandID   = config.getItem("seed", "Soulsand Seed ID", 5308).getInt()
    
    /* End */
    seedPearlID = config.getItem("seed", "Pearl Seed ID", 5309).getInt()
    seedEndstoneID = config.getItem("seed", "Endstone Seed ID", 5310).getInt()
    
    /* Deep */
    seedLavaCrystalID = config.getItem("seed", "Lava Crystal Seed ID", 5315).getInt()
    
    /* Desert */
    seedOilID = config.getItem("seed", "Oil Seed ID", 5320).getInt()
    
    /* Nonstandard */
    seedTinID    = config.getItem("seed", "Tin Seed ID", 5311)   .getInt()
    seedCopperID = config.getItem("seed", "Copper Seed ID", 5312).getInt()
    seedSilverID = config.getItem("seed", "Silver Seed ID", 5313).getInt()
    seedLeadID   = config.getItem("seed", "Lead Seed ID", 5314)  .getInt()
    seedNickelID = config.getItem("seed", "Nickel Seed ID", 5318).getInt()
    
    /* items */
    magicalStemID = config.getItem("item", "Magical Stem ID", 5316).getInt()

	/* Special Items */
	magicBucketID = config.getItem("item", "Magic Infinite Bucket", 5317).getInt()
    
    config.save()
    
  }
  
  @Init
  def loaded(event: FMLInitializationEvent): Unit = {
    
    magicalStem = new MagicStem(magicalStemID)
    Reference.tab.tabIndex = magicalStem.itemID
    Reference.stem = magicalStem
    LanguageRegistry.addName(magicalStem, "Magic Stem")
    
    seedOil  = new OilSeed(seedOilID, cropOilID).addRecipe.doPostWork
    cropOil  = new OilCrop(cropOilID, seedOil.itemID)
    Integration.LiquidSeeds += seedOil.asInstanceOf[GoldenSeed]
    Integration.MFRCropRegistry += Tuple2(cropOil.asInstanceOf[GoldenCrop], seedOil.asInstanceOf[GoldenSeed])
    
    seedIron = new IronSeed(seedIronID, cropIronID).addRecipe.doPostWork
    cropIron = new IronCrop(cropIronID, seedIron.itemID)
    Integration.MFRCropRegistry += Tuple2(cropIron.asInstanceOf[GoldenCrop], seedIron.asInstanceOf[GoldenSeed])
    
    seedGold = new GoldSeed(seedGoldID, cropGoldID).addRecipe.doPostWork
    cropGold = new GoldCrop(cropGoldID, seedGold.itemID)
    Integration.MFRCropRegistry += Tuple2(cropGold.asInstanceOf[GoldenCrop], seedGold.asInstanceOf[GoldenSeed])
    
    seedTin = new TinSeed(seedTinID, cropTinID).addRecipe.doPostWork
    cropTin = new TinCrop(cropTinID, seedTin.itemID)
    Integration.MFRCropRegistry += Tuple2(cropTin.asInstanceOf[GoldenCrop], seedTin.asInstanceOf[GoldenSeed])
    
    seedCopper = new CopperSeed(seedCopperID, cropCopperID).addRecipe.doPostWork
    cropCopper = new CopperCrop(cropCopperID, seedCopper.itemID)
    Integration.MFRCropRegistry += Tuple2(cropCopper.asInstanceOf[GoldenCrop], seedCopper.asInstanceOf[GoldenSeed])
    
    seedSilver = new SilverSeed(seedSilverID, cropSilverID).addRecipe.doPostWork
    cropSilver = new SilverCrop(cropSilverID, seedSilver.itemID)
    Integration.MFRCropRegistry += Tuple2(cropSilver.asInstanceOf[GoldenCrop], seedSilver.asInstanceOf[GoldenSeed])
    
    seedLead = new LeadSeed(seedLeadID, cropLeadID).addRecipe.doPostWork
    cropLead = new LeadCrop(cropLeadID, seedLead.itemID)
    Integration.MFRCropRegistry += Tuple2(cropLead.asInstanceOf[GoldenCrop], seedLead.asInstanceOf[GoldenSeed])
    
    seedNickel = new NickelSeed(seedNickelID, cropNickelID).addRecipe.doPostWork
    cropNickel = new NickelCrop(cropNickelID, seedNickel.itemID)
    Integration.MFRCropRegistry += Tuple2(cropNickel.asInstanceOf[GoldenCrop], seedNickel.asInstanceOf[GoldenSeed])
    
    seedClay = new ClaySeed(seedClayID, cropClayID).addRecipe.doPostWork
    cropClay = new ClayCrop(cropClayID, seedClay.itemID)
    Integration.MFRCropRegistry += Tuple2(cropClay.asInstanceOf[GoldenCrop], seedClay.asInstanceOf[GoldenSeed])
    
    seedRedstone = new RedstoneSeed(seedRedstoneID, cropRedstoneID).addRecipe.doPostWork
    cropRedstone = new RedstoneCrop(cropRedstoneID, seedRedstone.itemID)
    Integration.MFRCropRegistry += Tuple2(cropRedstone.asInstanceOf[GoldenCrop], seedRedstone.asInstanceOf[GoldenSeed])
    
    seedCoal = new CoalSeed(seedCoalID, cropCoalID).addRecipe.doPostWork
    cropCoal = new CoalCrop(cropCoalID, seedCoal.itemID)
    Integration.MFRCropRegistry += Tuple2(cropCoal.asInstanceOf[GoldenCrop], seedCoal.asInstanceOf[GoldenSeed])
    
    seedNetherrack = new NetherrackSeed(seedNetherrackID, cropNetherrackID).addRecipe.doPostWork
    cropNetherrack = new NetherrackCrop(cropNetherrackID, seedNetherrack.itemID)
    Integration.MFRCropRegistry += Tuple2(cropNetherrack.asInstanceOf[GoldenCrop], seedNetherrack.asInstanceOf[GoldenSeed])
    
    seedGlowstone = new GlowstoneSeed(seedGlowstoneID, cropGlowstoneID).addRecipe.doPostWork
    cropGlowstone = new GlowstoneCrop(cropGlowstoneID, seedGlowstone.itemID)
    Integration.MFRCropRegistry += Tuple2(cropGlowstone.asInstanceOf[GoldenCrop], seedGlowstone.asInstanceOf[GoldenSeed])
    
    seedQuartz = new QuartzSeed(seedQuartzID, cropQuartzID).addRecipe.doPostWork
    cropQuartz = new QuartzCrop(cropQuartzID, seedQuartz.itemID)
    Integration.MFRCropRegistry += Tuple2(cropQuartz.asInstanceOf[GoldenCrop], seedQuartz.asInstanceOf[GoldenSeed])
    
    seedSoulsand = new SoulsandSeed(seedSoulsandID, cropSoulsandID).addRecipe.doPostWork
    cropSoulsand = new SoulsandCrop(cropSoulsandID, seedSoulsand.itemID)
    Integration.MFRCropRegistry += Tuple2(cropSoulsand.asInstanceOf[GoldenCrop], seedSoulsand.asInstanceOf[GoldenSeed])
    
    seedPearl = new PearlSeed(seedPearlID, cropPearlID).addRecipe.doPostWork
    cropPearl = new PearlCrop(cropPearlID, seedPearl.itemID)
    Integration.MFRCropRegistry += Tuple2(cropPearl.asInstanceOf[GoldenCrop], seedPearl.asInstanceOf[GoldenSeed])
    
    seedEndstone = new EndstoneSeed(seedEndstoneID, cropEndstoneID).addRecipe.doPostWork
    cropEndstone = new EndstoneCrop(cropEndstoneID, seedEndstone.itemID)
    Integration.MFRCropRegistry += Tuple2(cropEndstone.asInstanceOf[GoldenCrop], seedEndstone.asInstanceOf[GoldenSeed])
    
    seedLavaCrystal = new LavaCrystalSeed(seedLavaCrystalID, cropLavaCrystalID).addRecipe.doPostWork
    cropLavaCrystal = new LavaCrystalCrop(cropLavaCrystalID, seedLavaCrystal.itemID)
    Integration.LiquidSeeds += seedLavaCrystal.asInstanceOf[GoldenSeed]
    Integration.MFRCropRegistry += Tuple2(cropLavaCrystal.asInstanceOf[GoldenCrop], seedLavaCrystal.asInstanceOf[GoldenSeed])
    
    seedLapis = new LapisSeed(seedLapisID, cropLapisID).addRecipe.doPostWork
    cropLapis = new LapisCrop(cropLapisID, seedLapis.itemID)
    Integration.MFRCropRegistry += Tuple2(cropLapis.asInstanceOf[GoldenCrop], seedLapis.asInstanceOf[GoldenSeed])
    
    // Chest Gen Hooks
    
    ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(magicalStem), 1, 3, 5))
	ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(magicalStem), 1, 3, 5))
	ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(magicalStem), 1, 3, 5))
	ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(magicalStem), 1, 3, 5))
	ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(magicalStem), 1, 3, 5))
	ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(magicalStem), 1, 3, 5))
	ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(magicalStem), 1, 3, 5))
    
  }
  
  @PostInit
  def modsLoaded(event: FMLPostInitializationEvent): Unit = {
    
    if(Loader.isModLoaded("Forestry")) {
      try {
        Integration.doForestryIntegration
      } catch {
        case e: Exception => println("Forestry integration not loaded")
      }
    }
    
    if(Loader.isModLoaded("ThermalExpansion")) {
      try {
        Integration.doThermalExpansionIntegration
      } catch {
        case e: Exception => println("ThermalExpansion integration not loaded")
      }
    }
    
    if(Loader.isModLoaded("MineFactoryReloaded")) {
      try {
        Integration.doMineFactoryIntegration
      } catch {
        case e: Exception => println("MineFactoryReloaded integration not loaded")
      }
    }
    
  }
  
}