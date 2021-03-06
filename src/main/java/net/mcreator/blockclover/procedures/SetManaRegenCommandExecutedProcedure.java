package net.mcreator.blockclover.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.blockclover.BlockCloverModVariables;
import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverMod;

import java.util.Map;
import java.util.HashMap;

@BlockCloverModElements.ModElement.Tag
public class SetManaRegenCommandExecutedProcedure extends BlockCloverModElements.ModElement {
	public SetManaRegenCommandExecutedProcedure(BlockCloverModElements instance) {
		super(instance, 8);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlockCloverMod.LOGGER.warn("Failed to load dependency entity for procedure SetManaRegenCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				BlockCloverMod.LOGGER.warn("Failed to load dependency cmdparams for procedure SetManaRegenCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		{
			double _setval = (double) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()));
			entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ManaRegen = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
