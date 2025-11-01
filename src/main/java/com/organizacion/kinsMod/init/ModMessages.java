package com.organizacion.kinsMod.init;

import com.organizacion.kinsMod.init.PacketGenerarCofre;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    public static SimpleChannel CHANNEL;
    private static final String PROTOCOL_VERSION = "1";

    public static void register() {
        CHANNEL = NetworkRegistry.newSimpleChannel(
                new ResourceLocation("kinsmod", "main"),
                () -> PROTOCOL_VERSION,
                PROTOCOL_VERSION::equals,
                PROTOCOL_VERSION::equals
        );

        int id = 0;
        CHANNEL.registerMessage(id++, PacketGenerarCofre.class,
                PacketGenerarCofre::encode,
                PacketGenerarCofre::decode,
                PacketGenerarCofre::handle);
    }
}

