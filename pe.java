package com.organizacion.kinsMod;

import com.organizacion.kinsMod.eventos.MisEventos;
import com.organizacion.kinsMod.init.BlockIniciar;
import com.organizacion.kinsMod.init.InitItems;
import com.organizacion.kinsMod.init.ModMessages;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

@Mod(pe.MODID)
public class pe {

    public static final String MODID = "kinsmod";
    public pe () {
        IEventBus bus= FMLJavaModLoadingContext.get().getModEventBus();
        InitItems.ITEMS.register(bus);
        BlockIniciar.BLOCKS.register(bus);
        EVENT_BUS.register(new MisEventos());

        bus.addListener(this::setup);
    }
    private void setup(final FMLCommonSetupEvent event) {
        ModMessages.register();
    }
}
