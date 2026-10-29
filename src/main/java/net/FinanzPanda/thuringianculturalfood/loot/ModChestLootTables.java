package net.FinanzPanda.thuringianculturalfood.loot;

import net.FinanzPanda.thuringianculturalfood.util.TCFRecipeUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModChestLootTables {
    public static final ResourceKey<LootTable> ABANDONED_MINESHAFT = register("chests/tcf_abandoned_mineshaft");
    public static final ResourceKey<LootTable> PILLAGER_OUTPOST = register("chests/tcf_pillager_outpost");
    public static final ResourceKey<LootTable> RUINED_PORTAL = register("chests/tcf_ruined_portal");
    public static final ResourceKey<LootTable> SHIPWRECK_SUPPLY = register("chests/tcf_shipwreck_supply");
    public static final ResourceKey<LootTable> SIMPLE_DUNGEON = register("chests/tcf_simple_dungeon");
    public static final ResourceKey<LootTable> VILLAGE_DESERT_HOUSE = register("chests/tcf_village_desert_house");
    public static final ResourceKey<LootTable> VILLAGE_PLAINS_HOUSE = register("chests/tcf_village_plains_house");
    public static final ResourceKey<LootTable> VILLAGE_SAVANNA_HOUSE = register("chests/tcf_village_savanna_house");
    public static final ResourceKey<LootTable> VILLAGE_SNOWY_HOUSE = register("chests/tcf_village_snowy_house");
    public static final ResourceKey<LootTable> VILLAGE_TAIGA_HOUSE = register("chests/tcf_village_taiga_house");

    private static ResourceKey<LootTable> register(String id) {
        return ResourceKey.create(Registries.LOOT_TABLE, TCFRecipeUtils.FDLocation(id));
    }
}
