package com.osmanyigituygun.libraryapi;

import com.osmanyigituygun.files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import com.osmanyigituygun.Base.BaseTest;
import static io.restassured.RestAssured.*;


public class LibraryTest extends BaseTest {
    @Override
    public String getBaseUrl() {
        return "http://216.10.245.166"; // Replace with the actual base URL of the Library API
    }

    @Test
    public void addBook() {
        System.out.println("addBook test executed");

        String name = "Learn Rest Assured Automation with Java";
        String isbn = "123456789";
        String aisle = "987654321";
        String author = "Osman Yigit Uygun";
        String res = given()
                .header("Content-Type", "application/json")
                .body(Payload.getLibraryPayload(name, isbn, aisle, author))
                .when().post("/Library/Addbook.php")
                .then().statusCode(200)
                .extract().response().asString();
        JsonPath js = new JsonPath(res);
        String bookId = js.getString("ID");
        System.out.println("Book ID: " + bookId);
    }

}

