package com.javarush.island.burdygin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@Getter
@Setter
public class ConfigReader {

    private final String CONFIGURATION_FILE = "burdygin" + File.separator + "config.yaml";

    protected void read(Config config) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ObjectReader objectReader = objectMapper.readerForUpdating(config);
        URL source = ConfigReader.class.getClassLoader().getResource(CONFIGURATION_FILE);
        if (Objects.nonNull(source)) {
            try {
                objectReader.readValue(source.openStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
