
package net.FinanzPanda.thuringianculturalfood.data;

import net.FinanzPanda.thuringianculturalfood.loot.TCFChestLootSubProvider;
import net.FinanzPanda.thuringianculturalfood.loot.TCFGlobalLootModifierProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

public class TCFDataGenerators {

    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(
                event.includeServer(),
                new LootTableProvider(
                        event.getGenerator().getPackOutput(),
                        Set.of(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        TCFChestLootSubProvider::new,
                                        LootContextParamSets.CHEST
                                )
                        ),
                        event.getLookupProvider()
                )
        );

        event.getGenerator().addProvider(
                event.includeServer(),
                new TCFGlobalLootModifierProvider(
                        event.getGenerator().getPackOutput(),
                        event.getLookupProvider()
                )
        );
    }
}
