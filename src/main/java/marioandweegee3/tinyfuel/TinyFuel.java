package marioandweegee3.tinyfuel;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TinyFuel implements ModInitializer{
    public static final String modID = "tinyfuel";

    public static void main(String[] args) {
        System.out.println("What are you doing trying to execute a mod?");
        System.out.println("Don't you know these don't work without Minecraft?");
    }

    @Override
    public void onInitialize() {
        registerItem("tiny_coal", ItemGroup.MISC, 200);
        registerItem("tiny_charcoal", ItemGroup.MISC, 200);
    }

    public static void registerItem(String name, ItemGroup group, int cookTime){
        Item item = new Item(makeSettings().group(group));
        Registry.register(Registry.ITEM, makeID(name), item);
        if(cookTime > 0)
            FuelRegistry.INSTANCE.add(item, cookTime);
    }

    public static Item.Settings makeSettings(){
        return new Item.Settings();
    }

    public static Identifier makeID(String name) {
        return new Identifier(modID, name);
    }
}