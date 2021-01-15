package net.mcreator.blockclover.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.blockclover.item.GrimoireTestItem;
import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@BlockCloverModElements.ModElement.Tag
public class UnidentifiedGrimoireRightClickedInAirProcedure extends BlockCloverModElements.ModElement {
	public UnidentifiedGrimoireRightClickedInAirProcedure(BlockCloverModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlockCloverMod.LOGGER.warn("Failed to load dependency entity for procedure UnidentifiedGrimoireRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BlockCloverMod.LOGGER.warn("Failed to load dependency itemstack for procedure UnidentifiedGrimoireRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlockCloverMod.LOGGER.warn("Failed to load dependency world for procedure UnidentifiedGrimoireRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(entity.getPersistentData().getBoolean("hasGrimoire")))) {
			((itemstack)).shrink((int) 1);
			entity.getPersistentData().putBoolean("hasGrimoire", (true));
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(GrimoireTestItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				
				double val = Math.random();
				int num = (int)Math.round(val * 2);
				if(num == 0)
				{
					(_setstack).getOrCreateTag().putString("grimoireType", "blue");
				}
				else if(num == 1)
				{
					(_setstack).getOrCreateTag().putString("grimoireType", "green");
				}
				else if(num == 2)
				{
					(_setstack).getOrCreateTag().putString("grimoireType", "red");
				}
			}
		}
	}
}
