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

@SuppressWarnings("unused")
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ThuringianCulturalFood.MODID);
    public static LinkedHashMap<Supplier<Item>, ItemFamily[]> CREATIVE_TAB_ITEMS = new LinkedHashMap<>();

    // Potatoes
    public static final Supplier<Item> WASHED_POTATO = registerWithTab("washed_potato",
            () -> new Item(basicItem()));
    public static final Supplier<Item> GRATED_POTATO = registerWithTab("grated_potato",
            () -> new Item(basicItem()));
    public static final Supplier<Item> RAW_KLOSS = registerWithTab("raw_kloss",
            () -> new Item(basicItem()));



    //Helper Items
    public static final DeferredItem<Item> SALT;
    public static final DeferredItem<Item> BUN_DOUGH;
    public static final DeferredItem<Item> BUTTER;

    static{
        if(!ModList.get().isLoaded("createfood") && !ModList.get().isLoaded("culturaldelights") ){
            SALT = ITEMS.registerSimpleItem("salt");
            BUN_DOUGH = ITEMS.registerSimpleItem("bun_dough");
            BUTTER = ITEMS.registerSimpleItem("butter");
        }
        else if (!ModList.get().isLoaded("createfood")){
            BUN_DOUGH = ITEMS.registerSimpleItem("bun_dough");
            SALT= null;
            BUTTER=null;
        }
        else {
            SALT= null;
            BUN_DOUGH= null;
            BUTTER= null;
        }
    }

    // Raw
    public static final Supplier<Item> RAW_ROULADE = registerWithTab("raw_roulade",
            () -> new Item(basicItem()));
    public static final Supplier<Item> RAW_SAUSAGE = registerWithTab("raw_sausage",
            () -> new Item(basicItem()));
    public static final Supplier<Item> RAW_ROSTBRAETEL = registerWithTab("raw_rostbraetel",
            () -> new Item(basicItem()));


    // Crops
        // Red Cabbage
        public static final Supplier<Item> RED_CABBAGE = registerWithTab("red_cabbage",
            () -> new Item(foodItem(FoodValues.CABBAGE)));
        public static final Supplier<Item> RED_CABBAGE_LEAF = registerWithTab("red_cabbage_leaf",
            () -> new Item(foodItem(FoodValues.CABBAGE_LEAF)));
        public static final Supplier<Item> RED_CABBAGE_SEEDS = registerWithTab("red_cabbage_seeds", () -> new ItemNameBlockItem(ModBlocks.RED_CABBAGE_CROP.get(), basicItem()));
        // Mustard
        public static final Supplier<Item> MUSTARD_SEEDS = registerWithTab("mustard_seeds", () -> new ItemNameBlockItem(ModBlocks.MUSTARD_CROP.get(), basicItem()));
        public static final Supplier<Item> MUSTARD = registerWithTab("mustard", () -> new Item(basicItem()));

    // Foods
    public static final Supplier<Item> KLOSS = registerWithTab("kloss",
            () -> new Item(foodItem(ModFoods.KLOSS)));
    public static final Supplier<Item> BUN = registerWithTab("bun",
            () -> new Item(foodItem(ModFoods.BUN)));
    public static final Supplier<Item> ROULADE = registerWithTab("roulade",
            () -> new Item(foodItem(ModFoods.ROULADE)));
    public static final Supplier<Item> GRILLED_SAUSAGE = registerWithTab("grilled_sausage",
            () -> new Item(foodItem(ModFoods.GRILLED_SAUSAGE)));
    public static final Supplier<Item> GRILLED_ROSTBRAETEL = registerWithTab("grilled_rostbraetel",
            () -> new Item(foodItem(ModFoods.GRILLED_ROSTBRAETEL)));


    // Meals
    public static final Supplier<Item> APPLE_RED_CABBAGE = registerWithTab("apple_red_cabbage",
            () -> new BowlItem(bowlFoodItem(ModFoods.APPLE_RED_CABBAGE)));
    public static final Supplier<Item> ROULADE_KLOSS_RED_CABBAGE = registerWithTab("roulade_kloss_red_cabbage",
            () -> new BowlItem(bowlFoodItem(ModFoods.ROULADE_KLOSS_RED_CABBAGE)));
    public static final Supplier<Item> MUTZBRATEN = registerWithTab("mutzbraten",
            () -> new BowlItem(bowlFoodItem(ModFoods.MUTZBRATEN)));
    public static final Supplier<Item> ROSTBRATWURST = registerWithTab("rostbratwurst",
            () -> new Item(foodItem(ModFoods.ROSTBRATWURST)));
    public static final Supplier<Item> TH_ROSTBRAETEL = registerWithTab("th_rostbraetel",
            () -> new Item(foodItem(ModFoods.TH_ROSTBRAETEL)));
    public static final Supplier<Item> POTATO_SOUP = registerWithTab("potato_soup",
            () -> new BowlItem(bowlFoodItem(ModFoods.POTATO_SOUP)));


    // Sweats
    public static final Supplier<Item> RAW_PROPHET_CAKE = registerWithTab("raw_prophet_cake",
            () -> new Item(basicItem()));
    public static final Supplier<Item> PROPHET_CAKE = registerWithTab("prophet_cake",
            () -> new Item(basicItem()));
    public static final Supplier<Item> PROPHET_CAKE_SLICE = registerWithTab("prophet_cake_slice",
            () -> new Item(foodItem(ModFoods.PROPHET_CAKE_SLICE)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
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
