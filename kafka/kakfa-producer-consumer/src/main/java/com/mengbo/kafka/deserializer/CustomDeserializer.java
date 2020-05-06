package com.mengbo.kafka.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mengbo.kafka.pojo.CustomObject;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomDeserializer implements Deserializer<CustomObject> {
    @Override
    public CustomObject deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        CustomObject object = null;
        try {
            object = mapper.readValue(data, CustomObject.class);
        } catch (Exception exception) {
            System.out.println("Error in deserializing bytes " + exception);
        }
        return object;
    }
}
