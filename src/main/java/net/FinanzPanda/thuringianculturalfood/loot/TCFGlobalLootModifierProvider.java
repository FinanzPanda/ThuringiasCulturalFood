package net.FinanzPanda.thuringianculturalfood.loot;

import net.FinanzPanda.thuringianculturalfood.ThuringianCulturalFood;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;


public class TCFGlobalLootModifierProvider
        extends GlobalLootModifierProvider {

    public TCFGlobalLootModifierProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider
    ) {
        super(output, lookupProvider, ThuringianCulturalFood.MODID);
    }

    @Override
    protected void start() {
        addTable("abandoned_mineshaft",
                "minecraft:chests/abandoned_mineshaft",
                ModChestLootTables.ABANDONED_MINESHAFT);

        addTable("pillager_outpost",
                "minecraft:chests/pillager_outpost",
                ModChestLootTables.PILLAGER_OUTPOST);

        addTable("ruined_portal",
                "minecraft:chests/ruined_portal",
                ModChestLootTables.RUINED_PORTAL);

        addTable("shipwreck_supply",
                "minecraft:chests/shipwreck_supply",
                ModChestLootTables.SHIPWRECK_SUPPLY);

        addTable("simple_dungeon",
                "minecraft:chests/simple_dungeon",
                ModChestLootTables.SIMPLE_DUNGEON);

        addTable("village_desert_house",
                "minecraft:chests/village/village_desert_house",
                ModChestLootTables.VILLAGE_DESERT_HOUSE);

        addTable("village_plains_house",
                "minecraft:chests/village/village_plains_house",
                ModChestLootTables.VILLAGE_PLAINS_HOUSE);

        addTable("village_savanna_house",
                "minecraft:chests/village/village_savanna_house",
                ModChestLootTables.VILLAGE_SAVANNA_HOUSE);

        addTable("village_snowy_house",
                "minecraft:chests/village/village_snowy_house",
                ModChestLootTables.VILLAGE_SNOWY_HOUSE);

        addTable("village_taiga_house",
                "minecraft:chests/village/village_taiga_house",
                ModChestLootTables.VILLAGE_TAIGA_HOUSE);
    }

    private void addTable(
            String name,
            String targetTable,
            net.minecraft.resources.ResourceKey<net.minecraft.world.level.storage.loot.LootTable> additionalTable
    ) {
        LootItemCondition condition = LootTableIdCondition.builder(
                ResourceLocation.parse(targetTable)
        ).build();

        add(name, new AddTableLootModifier(
                new LootItemCondition[]{condition},
                additionalTable
        ));
    }
}
