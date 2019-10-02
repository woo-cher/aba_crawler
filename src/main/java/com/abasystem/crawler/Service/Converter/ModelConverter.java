package com.abasystem.crawler.Service.Converter;

import com.abasystem.crawler.Mapper.ModelMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UtilityClass
public class ModelConverter {
    private static final Logger logger = LoggerFactory.getLogger(ModelConverter.class);

    public static <P extends ModelMapper> JsonObject convertModelToJsonObject(P property) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();

        return (JsonObject) parser.parse(gson.toJson(property));
    }
}
