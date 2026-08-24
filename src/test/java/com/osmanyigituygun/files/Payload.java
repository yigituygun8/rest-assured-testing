package com.osmanyigituygun.files;

public class Payload {
    public static String getAddPlacePayload() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Osman Uygun\",\n" +
                "  \"phone_number\": \"+1 012 345 6789\",\n" +
                "  \"address\": \"29, side layout, cohen 01\",\n" +
                "  \"types\": [\"school\", \"library\"],\n" +
                "  \"website\": \"https://oyigituygun.com\",\n" +
                "  \"language\": \"Turkish-IN\"\n" +
                "}";
    }
}
