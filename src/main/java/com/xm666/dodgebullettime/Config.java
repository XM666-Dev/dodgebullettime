package com.xm666.dodgebullettime;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue DODGE_BULLET_TIME_ALWAYS = BUILDER
            .comment("Always gain bullet time on dodge, or only in dodging a attack")
            .define("dodge_bullet_time_always", false);

    public static final ModConfigSpec.BooleanValue DODGE_BULLET_TIME_MINOR = BUILDER
            .comment("Whether to use minor bullet time on dodge")
            .define("dodge_bullet_time_minor", false);

    public static final ModConfigSpec.DoubleValue DODGE_BULLET_TIME_SCALE = BUILDER
            .comment("The bullet time scale dodge gains")
            .defineInRange("dodge_bullet_time_scale", 0.25, 0.0, 1.0);

    public static final ModConfigSpec.IntValue DODGE_BULLET_TIME_DURATION = BUILDER
            .comment("The bullet time duration dodge gains")
            .defineInRange("dodge_bullet_time_duration", 20, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue DODGE_BULLET_TIME_TRANSITION = BUILDER
            .comment("The bullet time transition dodge gains")
            .defineInRange("dodge_bullet_time_transition", 20, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue DODGE_INVULNERABLE_DURATION = BUILDER
            .comment("The invulnerable duration dodge gains")
            .defineInRange("dodge_invulnerable_duration", 10, 10, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();
}
