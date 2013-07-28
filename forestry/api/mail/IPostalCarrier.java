package forestry.api.mail;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public interface IPostalCarrier {

	String getUID();
	
	String getName();
	
	@SideOnly(Side.CLIENT)
	Icon getIcon();

	IPostalState deliverLetter(World world, IPostOffice office, String recipient, ItemStack letterstack, boolean doDeliver);

}
