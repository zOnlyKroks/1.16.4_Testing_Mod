package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
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
        if(event.getEntity() instanceof PlayerEntity) {
            event.setNewSize(EntitySize.flexible(1.0F, 0.5F));
            event.setNewEyeHeight(0.4F);
        }
    }

    @SubscribeEvent
    public static void entityTick(TickEvent.PlayerTickEvent event) {
        EntitySize size = event.player.getSize(Pose.STANDING);
        if(event.player.getSize(Pose.STANDING).equals(size)) {
            event.player.recalculateSize();
        }
    }

    @SubscribeEvent
    public static void waterCheck(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if(player.isInWater()) {
            event.player.setAir(300);
        }else if(!player.isInWater()) {
            player.attackEntityFrom(DamageSource.DROWN, 0.5F);
        }
    }
}
