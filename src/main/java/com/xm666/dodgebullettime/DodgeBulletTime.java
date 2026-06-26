package com.xm666.dodgebullettime;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(DodgeBulletTime.MODID)
public class DodgeBulletTime {
    public static final String MODID = "dodgebullettime";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DodgeBulletTime(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
