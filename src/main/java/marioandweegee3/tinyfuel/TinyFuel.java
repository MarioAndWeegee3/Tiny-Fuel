package marioandweegee3.tinyfuel;

import marioandweegee3.tinyfuel.common.items.Fuels;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TinyFuel implements ModInitializer{
    public static final String modID = "tinyfuel";

    @Override
    public void onInitialize() {
        registerItem(Fuels.tiny_coal, "tiny_coal", ItemGroup.MISC, 200);
        registerItem(Fuels.tiny_charcoal, "tiny_charcoal", ItemGroup.MISC, 200);
    }
    
    public static void registerItem(Item item, String name, ItemGroup group){
        registerItem(item, name, group, 0);
    }

    public static void registerItem(Item item, String name, ItemGroup group, int cooktime){
        item = new Item(makeSettings().group(group));
        Registry.register(Registry.ITEM, makeID(name), item);
        if(cooktime > 0)
            FuelRegistry.INSTANCE.add(item, cooktime);
    }

    public static Item.Settings makeSettings(){
        return new Item.Settings();
    }

    public static Identifier makeID(String name) {
        return new Identifier(modID, name);
    }
}