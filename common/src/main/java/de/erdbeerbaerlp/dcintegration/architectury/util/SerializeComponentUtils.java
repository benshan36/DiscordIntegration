package de.erdbeerbaerlp.dcintegration.architectury.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonElement;

import net.minecraft.core.RegistryAccess;            // present in 1.20.1 (params unused)
import net.minecraft.core.HolderLookup;             // present in 1.20.1 (params unused)
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Component.Serializer;

public class SerializeComponentUtils {
    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    public static String toJson(Component component, RegistryAccess registryAccess) {
        return Serializer.toJson(component);
    }

    public static String toJson(Component component, HolderLookup.Provider holderLookup) {
        return Serializer.toJson(component);
    }

    public static MutableComponent fromJson(String json, RegistryAccess registryAccess) {
        Component c = Serializer.fromJson(json);
        if (c == null) throw new JsonParseException("Invalid component JSON: " + json);
        return c.copy(); // MutableComponent
    }

    public static MutableComponent fromJson(String json, HolderLookup.Provider holderLookup) {
        Component c = Serializer.fromJson(json);
        if (c == null) throw new JsonParseException("Invalid component JSON: " + json);
        return c.copy();
    }

    public static JsonElement toJsonTree(Component component) {
        return Serializer.toJsonTree(component);
    }

    public static MutableComponent fromJsonElement(JsonElement element) {
        Component c = Serializer.fromJson(element);
        if (c == null) throw new JsonParseException("Invalid component JSON element");
        return c.copy();
    }
}
