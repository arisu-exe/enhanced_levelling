package io.github.fallOut015.enhanced_levelling;

import io.github.fallOut015.enhanced_levelling.client.gui.screen.PlayerUpgradesScreen;
import io.github.fallOut015.enhanced_levelling.common.capabilities.CapabilitiesEnhancedLevelling;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MainEnhancedLevelling.MODID)
public class MainEnhancedLevelling {
    public static final String MODID = "enhanced_levelling";
    private static final Logger LOGGER = LogManager.getLogger();

    public MainEnhancedLevelling() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        CapabilitiesEnhancedLevelling.setup(event);
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {
    }
    private void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class Events {
        @SubscribeEvent
        public static void onAttachCapabilities(final AttachCapabilitiesEvent<Entity> event) {
            CapabilitiesEnhancedLevelling.onAttachCapabilities(event);
        }
        @SubscribeEvent
        public static void onLevelChange(final PlayerXpEvent.LevelChange playerXpEvent$LevelChange) {
            if(playerXpEvent$LevelChange.getPlayer() instanceof ClientPlayerEntity) {
                Minecraft.getInstance().setScreen(new PlayerUpgradesScreen((ClientPlayerEntity) playerXpEvent$LevelChange.getPlayer()));
            }
        }
    }
}