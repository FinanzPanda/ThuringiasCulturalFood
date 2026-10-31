package net.FinanzPanda.thuringianculturalfood.block;


import net.FinanzPanda.thuringianculturalfood.ThuringianCulturalFood;
import net.FinanzPanda.thuringianculturalfood.items.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ThuringianCulturalFood.MODID);

    public static final Supplier<Block> RED_CABBAGE_CROP = BLOCKS.register("red_cabbages",
            () -> new RedCabbageCropBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final Supplier<Block> MUSTARD_CROP = BLOCKS.register("mustards",
            () -> new MustardCropBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
