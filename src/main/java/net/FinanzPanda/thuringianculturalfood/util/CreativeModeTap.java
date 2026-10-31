package net.FinanzPanda.thuringianculturalfood.util;

import net.FinanzPanda.thuringianculturalfood.ThuringianCulturalFood;
import net.FinanzPanda.thuringianculturalfood.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeModeTap {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThuringianCulturalFood.MODID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("thuringian_cultural_food", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.thuringianculturalfood.thuringian_cultural_food_tab"))
                    .icon(() -> new ItemStack(ModItems.ROSTBRATWURST.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_KLOSS);
                        pOutput.accept(ModItems.KLOSS);
                        pOutput.accept(ModItems.WASHED_POTATO);
                        pOutput.accept(ModItems.GRATED_POTATO);
                        if (ModItems.SALT != null) {
                            pOutput.accept(ModItems.SALT);
                            pOutput.accept(ModItems.BUN_DOUGH);
                        }
                        pOutput.accept(ModItems.GRATED_POTATO);

                        ModItems.CREATIVE_TAB_ITEMS.forEach((item, families) -> {
                            pOutput.accept(item.get());
                        });

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
