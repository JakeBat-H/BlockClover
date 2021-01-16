package net.mcreator.jpf;

import net.minecraft.util.NonNullList;
import net.minecraft.item.Item;
import net.mcreator.blockclover.BlockCloverModElements;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

public class BaseGrimoire extends BlockCloverModElements.ModElement{
	public String type = "";
	public int level = 0;

	//public NonNullList<BaseAbility> abilities = NonNullList.create();

	private NonNullList<ItemStack> hotbarItems = NonNullList.create();
	
	public BaseGrimoire(BlockCloverModElements instance) {
		super(instance, 11);
	}

	protected boolean isInOffhand()
	{
		
	}

	public void onSwitchedToOffHand(PlayerEntity player)
	{
		hotbarItems.clear();
		for (int i = 0; i < 9; i++) {
			ItemStack stack = player.inventory.mainInventory.get(i);
			hotbarItems.set(i, stack);
			stack.setCount(0);
		}
	}
	
	public void onSwitchedFromOffHand(PlayerEntity player)
	{
		for (int i = 0; i < 9; i++) {
			ItemStack stack = hotbarItems.get(i);
			player.inventory.mainInventory.set(i, stack);
			stack.setCount(0);
		}
	}
}
