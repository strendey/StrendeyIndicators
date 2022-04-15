package io.github.strendey.damageindicators;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import io.github.strendey.damageindicators.command.IndicatorCommand;
import io.github.strendey.damageindicators.listener.NameFormatListener;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;

import java.util.Collections;

public class StrendeyIndicators extends DummyModContainer {

    public StrendeyIndicators() {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "strendeyindicators";
        meta.name = "Strendey Indicators";
        meta.version = "3.0";
        meta.authorList = Collections.singletonList("Strendey");
    }

    @Subscribe
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new IndicatorCommand());
        MinecraftForge.EVENT_BUS.register(new NameFormatListener());
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }

}
