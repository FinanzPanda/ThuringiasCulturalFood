package net.FinanzPanda.thuringianculturalfood.loot;

import net.FinanzPanda.thuringianculturalfood.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.data.loot.LootTableSubProvider;

import java.util.function.BiConsumer;

public class TCFChestLootSubProvider implements LootTableSubProvider {

    private final HolderLookup.Provider registries;

    public TCFChestLootSubProvider(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    @Override
    public void generate(
            BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer
    ) {
        consumer.accept(ModChestLootTables.ABANDONED_MINESHAFT, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(EmptyLootItem.emptyItem().setWeight(2))
                )
        );

        consumer.accept(ModChestLootTables.PILLAGER_OUTPOST, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 12.0F))))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(EmptyLootItem.emptyItem().setWeight(2))
                ));

        consumer.accept(ModChestLootTables.RUINED_PORTAL, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get())
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)))
                        .add(EmptyLootItem.emptyItem().setWeight(3))
                ));

        consumer.accept(ModChestLootTables.SHIPWRECK_SUPPLY, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get()).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE.get()).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(ModItems.KLOSS.get()).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                ));

        consumer.accept(ModChestLootTables.SIMPLE_DUNGEON, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                ));

        consumer.accept(ModChestLootTables.VILLAGE_DESERT_HOUSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))));

        consumer.accept(ModChestLootTables.VILLAGE_PLAINS_HOUSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))));

        consumer.accept(ModChestLootTables.VILLAGE_SAVANNA_HOUSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))));

        consumer.accept(ModChestLootTables.VILLAGE_SNOWY_HOUSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))));

        consumer.accept(ModChestLootTables.VILLAGE_TAIGA_HOUSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(ModItems.RED_CABBAGE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))));
    }
}