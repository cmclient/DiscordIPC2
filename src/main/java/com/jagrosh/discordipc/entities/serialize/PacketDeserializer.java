package com.jagrosh.discordipc.entities.serialize;

import com.google.gson.*;
import com.jagrosh.discordipc.entities.Packet;

import java.lang.reflect.Type;

public class PacketDeserializer implements JsonDeserializer<Packet> {

    private final Packet.OpCode op;

    public PacketDeserializer(Packet.OpCode op) {
        this.op = op;
    }

    @Override
    public Packet deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        // Exclude null values
        jsonObject.entrySet().removeIf(entry -> entry.getValue().isJsonNull());
        return new Packet(op, jsonObject);
    }
}