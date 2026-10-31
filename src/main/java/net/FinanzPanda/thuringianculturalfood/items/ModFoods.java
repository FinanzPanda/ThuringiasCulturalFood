package net.FinanzPanda.thuringianculturalfood.items;

import net.minecraft.world.food.FoodProperties;

import static vectorwing.farmersdelight.common.FoodValues.nourishment;

public class ModFoods {

    public static final int SEHR_KURZ= 600;
    public static final int KURZ = 1200;
    public static final int LANG_KURZ = 3600;
    public static final int SEHR_LANG_KURZ = 6000;

    public static final FoodProperties KLOSS = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.3F)
            .build();

    public static final FoodProperties APPLE_RED_CABBAGE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.3F)
            .effect(() -> nourishment(KURZ), 1.0F)
            .build();

    public static final FoodProperties ROULADE_KLOSS_RED_CABBAGE = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.7F)
            .effect(() -> nourishment(SEHR_LANG_KURZ), 1.0F)
            .build();

    public static final FoodProperties ROULADE= new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .effect(() -> nourishment(SEHR_KURZ), 1.0F)
            .build();

    public static final FoodProperties BUN= new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.2F)
            .build();

    public static final FoodProperties GRILLED_SAUSAGE= new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.2F)
            .build();

    public static final FoodProperties ROSTBRATWURST= new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.4F)
            .effect(() -> nourishment(LANG_KURZ), 1.0F)
            .build();
}
