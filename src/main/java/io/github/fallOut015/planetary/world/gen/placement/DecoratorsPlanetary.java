package io.github.fallOut015.planetary.world.gen.placement;

import io.github.fallOut015.planetary.MainPlanetary;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DecoratorsPlanetary {
    private static final DeferredRegister<Placement<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, MainPlanetary.MODID);



    public static final RegistryObject<Placement<NoPlacementConfig>> PLACE_ALL_TO_64 = DECORATORS.register("place_all_to_64", () -> new PlaceAllTo64Placement(NoPlacementConfig.CODEC));



    public static void register(IEventBus bus) {
        DECORATORS.register(bus);
    }
}