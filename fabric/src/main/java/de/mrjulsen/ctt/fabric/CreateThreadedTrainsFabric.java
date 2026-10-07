package de.mrjulsen.ctt.fabric;

import de.mrjulsen.ctt.CreateThreadedTrains;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class CreateThreadedTrainsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CreateThreadedTrains.init();

        // Fabric equivalent of the NeoForge-side MinecraftServerMixin hooks:
        // START/END_SERVER_TICK bracket tickServer(), STARTED/STOPPED bracket the run loop.
        ServerLifecycleEvents.SERVER_STARTED.register(CreateThreadedTrains::start);
        ServerLifecycleEvents.SERVER_STOPPED.register(CreateThreadedTrains::stop);
        ServerTickEvents.START_SERVER_TICK.register(CreateThreadedTrains::preTick);
        ServerTickEvents.END_SERVER_TICK.register(CreateThreadedTrains::postTick);
    }
}
