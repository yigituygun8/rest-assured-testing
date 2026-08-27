package com.osmanyigituygun.files;

public class Payload {

    // Boş constructor veya private constructor ile nesne üretimi engellenebilir
    private Payload() {}

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

    // Parametreler dinamik olarak metoda eklendi ve metot static yapıldı
    public static String getUpdatePlacePayload(String place_id, String newAddress) {
        return "{\n" +
                "\"place_id\":\"" + place_id + "\",\n" +
                "\"address\":\"" + newAddress + "\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }

    public static String coursePrice() {
        return  "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n";
    }

    public static String getLibraryPayload(String name, String isbn, String aisle, String author) {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"isbn\": \"" + isbn + "\",\n" +
                "  \"aisle\": \"" + aisle + "\",\n" +
                "  \"author\": \"" + author + "\"\n" +
                "}";
    }
}
