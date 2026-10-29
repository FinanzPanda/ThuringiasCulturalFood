package net.FinanzPanda.thuringianculturalfood.items;

import net.FinanzPanda.thuringianculturalfood.ThuringianCulturalFood;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.ModList;
import vectorwing.farmersdelight.common.FoodValues;
import net.FinanzPanda.thuringianculturalfood.block.ModBlocks;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ThuringianCulturalFood.MODID);
    public static LinkedHashMap<Supplier<Item>, ItemFamily[]> CREATIVE_TAB_ITEMS = new LinkedHashMap<>();

    public static final DeferredItem<Item> WASHED_POTATO = ITEMS.registerSimpleItem("washed_potato");
    public static final DeferredItem<Item> GRATED_POTATO = ITEMS.registerSimpleItem("grated_potato");
    public static final DeferredItem<Item> RAW_KLOSS = ITEMS.registerSimpleItem("raw_kloss");

    public static final DeferredItem<Item> KLOSS =
            ITEMS.registerItem("kloss", properties -> new Item(properties) {
            }, new Item.Properties().food(ModFoods.KLOSS));

    public static final DeferredItem<Item> SALT;
    static{
        if(!ModList.get().isLoaded("createfood")){
            SALT = ITEMS.registerSimpleItem("salt");
        }
        else {
            SALT= null;
        }
    }

    public static final Supplier<Item> RED_CABBAGE = registerWithTab("red_cabbage",
            () -> new Item(foodItem(FoodValues.CABBAGE)));
    public static final Supplier<Item> RED_CABBAGE_LEAF = registerWithTab("red_cabbage_leaf",
            () -> new Item(foodItem(FoodValues.CABBAGE_LEAF)));
    public static final Supplier<Item> RED_CABBAGE_SEEDS = registerWithTab("red_cabbage_seeds", () -> new ItemNameBlockItem(ModBlocks.RED_CABBAGE_CROP.get(), basicItem()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static DeferredItem<Item> registerWithTab(final String name, final Supplier<Item> supplier, final ItemFamily... families) {
        DeferredItem<Item> item = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.put(item, families);
        return item;
    }

    public static DeferredItem<Item> registerBlockWithTab(DeferredBlock<Block> block, ItemFamily... families) {
        return registerWithTab(block.getRegisteredName().replaceFirst(ThuringianCulturalFood.MODID + ":", ""), () -> new BlockItem(block.get(), new Item.Properties()), families);
    }

    public static DeferredItem<Item> registerBlockWithTab(DeferredBlock<Block> block, Item.Properties properties) {
        return registerWithTab(block.getRegisteredName().replaceFirst(ThuringianCulturalFood.MODID + ":", ""), () -> new BlockItem(block.get(), properties));
    }

}
