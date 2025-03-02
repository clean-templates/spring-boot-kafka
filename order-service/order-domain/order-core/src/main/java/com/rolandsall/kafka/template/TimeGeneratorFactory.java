package com.rolandsall.kafka.template;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class TimeGeneratorFactory {


    public static ZonedDateTime now() {
        return  ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
