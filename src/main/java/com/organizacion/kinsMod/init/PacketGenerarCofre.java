package com.organizacion.kinsMod.init;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;


import java.util.function.Supplier;

public class PacketGenerarCofre {

    public PacketGenerarCofre() {}

    // Encode y Decode para enviar el paquete vacío
    public static void encode(PacketGenerarCofre msg, FriendlyByteBuf buf) {}
    public static PacketGenerarCofre decode(FriendlyByteBuf buf) {
        return new PacketGenerarCofre();
    }

    public static void handle(PacketGenerarCofre msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                Level level = player.getLevel(); // server world
                BlockPos pos = player.blockPosition().above(); // cofre sobre el jugador

                // Genera un cofre real
                level.setBlockAndUpdate(pos, Blocks.CHEST.defaultBlockState());
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
