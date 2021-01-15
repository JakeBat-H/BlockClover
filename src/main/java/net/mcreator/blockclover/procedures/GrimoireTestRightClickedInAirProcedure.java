package net.mcreator.blockclover.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.blockclover.BlockCloverModVariables;
import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverMod;

import java.util.Map;

@BlockCloverModElements.ModElement.Tag
public class GrimoireTestRightClickedInAirProcedure extends BlockCloverModElements.ModElement {
	public GrimoireTestRightClickedInAirProcedure(BlockCloverModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {

		
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlockCloverMod.LOGGER.warn("Failed to load dependency entity for procedure GrimoireTestRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BlockCloverModVariables.PlayerVariables())).Mana) - 10) >= 0)) {
			{
				double _setval = (double) (((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BlockCloverModVariables.PlayerVariables())).Mana) - 10);
				entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
