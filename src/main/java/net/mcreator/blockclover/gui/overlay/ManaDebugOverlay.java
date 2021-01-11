
package net.mcreator.blockclover.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverModVariables;
import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverMod;

@BlockCloverModElements.ModElement.Tag
public class ManaDebugOverlay extends BlockCloverModElements.ModElement {
	public ManaDebugOverlay(BlockCloverModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			
			double currentMana = ((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
			.orElse(new BlockCloverModVariables.PlayerVariables())).Mana);
			double maxMana = ((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
			.orElse(new BlockCloverModVariables.PlayerVariables())).MaxMana);
			double manaRegen = ((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
			.orElse(new BlockCloverModVariables.PlayerVariables())).ManaRegen);
			if (true) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "Mana Values", posX + -211, posY + -117, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "Mana: " + String.valueOf(currentMana), posX + -209, posY + -107, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "Max Mana: " + String.valueOf(maxMana), posX + -209, posY + -97, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "Mana Regen: " + String.valueOf(manaRegen), posX + -209, posY + -87, -12829636);

			}
		}
	}
}
