
package net.mcreator.blockclover.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.blockclover.BlockCloverModElements;

@BlockCloverModElements.ModElement.Tag
public class UnidentifiedGrimoireItem extends BlockCloverModElements.ModElement {
	@ObjectHolder("block_clover:unidentified_grimoire")
	public static final Item block = null;
	public UnidentifiedGrimoireItem(BlockCloverModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("unidentified_grimoire");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
