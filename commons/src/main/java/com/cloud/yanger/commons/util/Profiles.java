package com.cloud.yanger.commons.util;


public class Profiles {

    public static boolean DEV;
    public static boolean PROD;

    static {
        switch (PropertiesUtils.getProperty("spring.profiles.active")) {
            case "prod":
                PROD = true;
                break;
            case "dev":
                DEV = true;
                break;
        }
    }
}
