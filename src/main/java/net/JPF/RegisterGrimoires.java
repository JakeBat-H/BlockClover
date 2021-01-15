package net.mcreator.blockclover;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.StringNBT;
import javax.annotation.Nullable;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.client.world.ClientWorld;
import org.w3c.dom.ls.LSException;

public class RegisterGrimoires {
	public static void registerGrimoires(BlockCloverModElements elements)
	{
		elements.items.forEach(item -> {
			System.out.println("penis    " + item.get().getRegistryName().getPath());
			if(item.get().getRegistryName().getPath() == "block_clover:grimoire_test")
			{
				ItemModelsProperties.registerProperty(item.get(), new ResourceLocation("block_clover:grimoire_blue"), new IItemPropertyGetter() {
					@Override
					public float call (ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity entity)
					{
						String s = entity.getEntity().getPersistentData().getString("grimoireType");
						if(s == "blue")
						{
							return 1;
						}
						else if(s == "green")
						{
							return 2;
						}
						else if(s == "red")
						{
							return 3;
						}
						else
						{
							return 0;
						}
					}
				});
			}
		});
	}
}
