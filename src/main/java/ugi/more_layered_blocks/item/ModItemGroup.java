package ugi.more_layered_blocks.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ugi.more_layered_blocks.MoreLayeredBlocks;
import ugi.more_layered_blocks.block.ModBlocks;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> MORE_LAYERED_BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MoreLayeredBlocks.MOD_ID, "more_layered_blocks"));

    public static void registerItemgroups() {


        Registry.register(Registries.ITEM_GROUP, MORE_LAYERED_BLOCKS, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModBlocks.LAYERED_SAND))
                .displayName(Text.translatable("itemgroup.layered_sand"))
                .build());
    }
}
