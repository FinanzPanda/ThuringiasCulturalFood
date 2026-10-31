package net.FinanzPanda.thuringianculturalfood;

import net.FinanzPanda.thuringianculturalfood.block.ModBlocks;
import net.FinanzPanda.thuringianculturalfood.data.TCFDataGenerators;
import net.FinanzPanda.thuringianculturalfood.items.ModItems;
import net.FinanzPanda.thuringianculturalfood.util.CreativeModeTap;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(ThuringianCulturalFood.MODID)
public class ThuringianCulturalFood {
    public static final String MODID = "thuringianculturalfood";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ThuringianCulturalFood(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(TCFDataGenerators::gatherData);

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.register(modEventBus);
        CreativeModeTap.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Loading BEST German Staat's food!");
    }
}
