package com.xm666.dodgebullettime;

import com.alrex.parcool.api.unstable.action.ParCoolActionEvent;
import com.alrex.parcool.common.action.impl.Dodge;
import com.alrex.parcool.common.attachment.common.Parkourability;
import com.alrex.parcool.config.ParCoolConfig;
import com.xm666.timescalelib.handler.TimeScaleHandler;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = DodgeBulletTime.MODID)
public class DodgeHandler {
    @SubscribeEvent
    public static void onDodgeStart(ParCoolActionEvent.Start event) {
        if (!(event.getAction() instanceof Dodge)) return;

        var dodgeBulletTimeAlways = Config.DODGE_BULLET_TIME_ALWAYS.get();
        if (!dodgeBulletTimeAlways) return;

        applyBulletTime(event.getPlayer());
    }

    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        var parkourability = Parkourability.get(player);
        if (parkourability == null) return;

        var dodge = parkourability.get(Dodge.class);
        if (!dodge.isDoing()
                || !parkourability.getServerLimitation().get(ParCoolConfig.Server.Booleans.DodgeProvideInvulnerableFrame)
                || event.getSource().is(DamageTypeTags.BYPASSES_ARMOR))
            return;

        var dodgeInvulnerableDuration = Config.DODGE_INVULNERABLE_DURATION.get();
        if (dodge.getDoingTick() > dodgeInvulnerableDuration) return;

        event.setCanceled(true);

        var dodgeBulletTimeAlways = Config.DODGE_BULLET_TIME_ALWAYS.get();
        if (dodgeBulletTimeAlways) return;

        applyBulletTime(player);
    }

    private static void applyBulletTime(Player player) {
        var dodgeBulletTimeScale = Config.DODGE_BULLET_TIME_SCALE.get().floatValue();
        var dodgeBulletTimeDuration = Config.DODGE_BULLET_TIME_DURATION.get();
        var dodgeBulletTimeTransition = Config.DODGE_BULLET_TIME_TRANSITION.get();
        var dodgeBulletTimeMinor = Config.DODGE_BULLET_TIME_MINOR.get();
        TimeScaleHandler.applyScale(dodgeBulletTimeMinor ? player : null, dodgeBulletTimeScale, dodgeBulletTimeDuration, dodgeBulletTimeTransition);
    }
}
