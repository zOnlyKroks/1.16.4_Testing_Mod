package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class PlayerEvent {

    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent.Pre event) {
        event.getRenderer().getEntityModel().setVisible(false);
    }

    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent.Post event) {
        event.getRenderer().getEntityModel().setVisible(true);
    }

    @SubscribeEvent
    public static void onPlayerChangeSeize(EntityEvent.Size event) {
        event.setNewSize(EntitySize.flexible(128,128));
        event.setNewEyeHeight(1.0F);
    }

    @SubscribeEvent
    public static void entityTick(TickEvent.PlayerTickEvent event) {
        EntitySize size = event.player.getSize(Pose.STANDING);
        if(event.player.getSize(Pose.STANDING).equals(size)) {
            event.player.recalculateSize();
        }
    }
}
