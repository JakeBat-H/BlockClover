
package net.mcreator.blockclover.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverModVariables;
import net.mcreator.blockclover.BlockCloverModElements;
import net.mcreator.blockclover.BlockCloverMod;



import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@BlockCloverModElements.ModElement.Tag
public class ManaBarOverlay extends BlockCloverModElements.ModElement {
	public ManaBarOverlay(BlockCloverModElements instance) {
		super(instance, 3);
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
			if (true) {
				double currentMana = ((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BlockCloverModVariables.PlayerVariables())).Mana);
				double maxMana = ((entity.getCapability(BlockCloverModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BlockCloverModVariables.PlayerVariables())).MaxMana);
				double manaPercent = currentMana / maxMana;
				//System.out.println("CurrentMana " + String.valueOf(currentMana) + ", MaxMana" +  String.valueOf(maxMana) + ", ManaPercent " + String.valueOf(manaPercent));
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableAlphaTest();
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("block_clover:textures/mana_bar_full.png"));
				//draw mana bar (change this one)
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 109, posY + 96, 0, 0, (int)(manaPercent * 100.0f), 25, (int)(manaPercent * 100.0f), 25);
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				RenderSystem.enableAlphaTest();
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableAlphaTest();
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("block_clover:textures/mana_bar_base.png"));
				//draw mana bar base
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 109, posY + 96, 0, 0, 100, 25, 100, 25);
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				RenderSystem.enableAlphaTest();
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}
