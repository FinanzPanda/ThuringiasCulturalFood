package net.FinanzPanda.thuringianculturalfood.client.plugin;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;
import java.util.Optional;

@JeiPlugin
public class JEIRecepiesRemover  implements IModPlugin {
    private static final ResourceLocation UID =
            ResourceLocation.fromNamespaceAndPath(
                    "thuringianculturalfood",
                    "jei_plugin"
            );

    private static final List<ResourceLocation> HIDDEN_CRAFTING_RECIPES =
            List.of(
                    ResourceLocation.fromNamespaceAndPath(
                            "thuringianculturalfood",
                            "rasinbuns"
                    ),
                    ResourceLocation.fromNamespaceAndPath(
                            "thuringianculturalfood",
                            "stein"
                    ),
                    ResourceLocation.fromNamespaceAndPath(
                            "thuringianculturalfood",
                            "rasinbuns_without_rasins"
                    )
            );

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        var minecraft = net.minecraft.client.Minecraft.getInstance();

        if (minecraft.level == null) {
            return;
        }

        var recipeManager = minecraft.level.getRecipeManager();
        var jeiRecipeManager = jeiRuntime.getRecipeManager();



        for (ResourceLocation craftingId : HIDDEN_CRAFTING_RECIPES) {

            Optional<RecipeHolder<?>> craftingRecipe =
                    recipeManager.byKey(craftingId);

            craftingRecipe.ifPresent(recipe -> {

                if (recipe.value() instanceof CraftingRecipe) {


                    RecipeHolder<CraftingRecipe> holder =
                            (RecipeHolder<CraftingRecipe>) recipe;

                    jeiRecipeManager.hideRecipes(
                            mezz.jei.api.constants.RecipeTypes.CRAFTING,
                            List.of(holder)
                    );
                }
            });
        }
    }
}
