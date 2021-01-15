package net.mcreator.blockclover.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverMod;

import java.util.Map;

@BlockCloverModElements.ModElement.Tag
public class ResetPlayerGrimoireCommandExecutedProcedure extends BlockCloverModElements.ModElement {
	public ResetPlayerGrimoireCommandExecutedProcedure(BlockCloverModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlockCloverMod.LOGGER.warn("Failed to load dependency entity for procedure ResetPlayerGrimoireCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("hasGrimoire", (false));
	}
}
