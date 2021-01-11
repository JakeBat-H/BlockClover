package net.mcreator.blockclover.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverModVariables;
import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverMod;


import java.util.Map;
import java.util.HashMap;

@BlockCloverModElements.ModElement.Tag
public class ManaRegenProcedure extends BlockCloverModElements.ModElement {
	public ManaRegenProcedure(BlockCloverModElements instance) {
		super(instance, 5);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();

			double manaRegen = ((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BlockCloverModVariables.PlayerVariables())).ManaRegen);
			double currentMana = (((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BlockCloverModVariables.PlayerVariables())).Mana));
			if(!(currentMana >= 100))
			{
			double _setval = (double) currentMana + 0.2;
				entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			//System.out.println("ManaRegen " + String.valueOf(manaRegen));

			
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
