package net.FinanzPanda.thuringianculturalfood.sounds;

import net.FinanzPanda.thuringianculturalfood.ThuringianCulturalFood;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ThuringianCulturalFood.MODID);

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(ThuringianCulturalFood.MODID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ThuringianCulturalFood.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static final Supplier<SoundEvent> BACH = registerSoundEvent("gregorquendel-bach-toccata-and-fugue-in-d-minor-bwv-565-250589");
    public static final ResourceKey<JukeboxSong> BACH_KEY = createSong("gregorquendel-bach-toccata-and-fugue-in-d-minor-bwv-565-250589");


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
