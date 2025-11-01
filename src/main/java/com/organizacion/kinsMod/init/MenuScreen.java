package com.organizacion.kinsMod.init;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;
import com.organizacion.kinsMod.init.ModMessages;
import com.organizacion.kinsMod.init.PacketGenerarCofre;
import com.mojang.blaze3d.vertex.PoseStack;

public class MenuScreen extends Screen {

    protected MenuScreen() {
        super(Component.literal("Menú mágico"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        this.addRenderableWidget(new Button(centerX - 60, centerY - 10, 120, 20,
                Component.literal("Generar cofre"), button -> {
            if (this.minecraft != null && this.minecraft.player != null) {
                // Enviar orden al servidor
                ModMessages.CHANNEL.sendToServer(new PacketGenerarCofre());

                this.minecraft.player.sendSystemMessage(Component.literal("⏳ Enviando orden al servidor..."));
                this.onClose();
            }
        }));
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        drawCenteredString(poseStack, this.font, "Menú mágico", this.width / 2, this.height / 2 - 40, 0xFFFFFF);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}


