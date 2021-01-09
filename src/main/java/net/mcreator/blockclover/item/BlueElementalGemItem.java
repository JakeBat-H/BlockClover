
package net.mcreator.blockclover.item;

@BlockCloverModElements.ModElement.Tag
public class BlueElementalGemItem extends BlockCloverModElements.ModElement {

	@ObjectHolder("block_clover:blue_elemental_gem")
	public static final Item block = null;

	public BlueElementalGemItem(BlockCloverModElements instance) {
		super(instance, 1);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("blue_elemental_gem");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}