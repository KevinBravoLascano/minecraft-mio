package com.organizacion.kinsMod.eventos;

import com.organizacion.kinsMod.init.InitItems;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.organizacion.kinsMod.init.InitItems.ITEMS;


public class MisEventos {

    @SubscribeEvent
    public void pickItem(EntityItemPickupEvent e){
        String mensaje = "cogiste: "+ e.getItem().getName().getString();
        System.out.println(mensaje);//mensaje interno de consola de agarar X item

        var player = Minecraft.getInstance().player;//obtengo el jugador asociado a la accion
        player.displayClientMessage(Component.literal(mensaje), true);//mensaje de agarrar item al chat
    }
    @SubscribeEvent
    public void ataque(AttackEntityEvent e){
        // Asegúrate de que el atacante sea un jugador
        if (!(e.getEntity() instanceof Player)) return;
        String mensaje = "atacaste a : "+ e.getTarget().getName().getString();//diste a una entidad
        System.out.println(mensaje);

        Player player = e.getEntity();
        player.displayClientMessage(Component.literal(mensaje), true);//mostrar en chat ataque
        Item esp_Dra= e.getEntity().getMainHandItem().getItem();
        if (esp_Dra == InitItems.ESPADADRAGON.get()){
            Entity objetivo = e.getTarget();
            objetivo.setSecondsOnFire(5);
        }
        //defino cordenadas random de -50 a 50 desde la posicion
        double randomX = player.getX() + Math.random()*100 -50;
        double randomY = player.getY() + Math.random()*20;
        double randomZ = player.getZ() + Math.random()*100 -50;

        //teleportar
        player.teleportTo(randomX, randomY, randomZ);


    }
}
