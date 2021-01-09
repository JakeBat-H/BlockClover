
package net.mcreator.blockclover.item;

@BlockCloverModElements.ModElement.Tag
public class GrimoireItem extends BlockCloverModElements.ModElement {

	@ObjectHolder("block_clover:grimoire")
	public static final Item block = null;

	public GrimoireItem(BlockCloverModElements instance) {
		super(instance, 1);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("grimoire");
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
