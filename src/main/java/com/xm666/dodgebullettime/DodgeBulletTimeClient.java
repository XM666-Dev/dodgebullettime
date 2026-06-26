package com.xm666.dodgebullettime;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = DodgeBulletTime.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = DodgeBulletTime.MODID, value = Dist.CLIENT)
public class DodgeBulletTimeClient {
    public DodgeBulletTimeClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
