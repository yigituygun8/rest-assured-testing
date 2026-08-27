package com.osmanyigituygun.Base;

import com.osmanyigituygun.files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class ComplexJsonParsePractice {
   public static void main(String[] args) {
        JsonPath js = new JsonPath(Payload.coursePrice()); // we are sending dummy payload to JsonPath object to parse the JSON data. For example in a real project, when developer is still working on the API, we can use dummy payload to parse the JSON data and validate it. This is a good practice to validate the JSON data before the API is ready to use.

        // Print the number of courses returned by the API
        int courseCount = js.getInt("courses.size()"); // courses is an array
        System.out.println("Number of courses: " + courseCount);

        // Print the purchase amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount: " + purchaseAmount);

        // Print the title of the first course
        String firstCourseTitle = js.getString("courses[0].title");
        System.out.println("Title of the first course: " + firstCourseTitle);

        // Print all course titles and their respective prices
        System.out.println("Course Titles and Prices:");
        for (int i = 0; i < courseCount; i++) {
            String courseTitle = js.getString("courses[" + i + "].title");
            int coursePrice = js.getInt("courses[" + i + "].price");
            System.out.println(courseTitle + ": " + coursePrice);
        }

        // Print the number of copies sold by RPA course
        for (int i = 0; i < courseCount; i++) {
            String courseTitle = js.getString("courses[" + i + "].title");
            if (courseTitle.equalsIgnoreCase("RPA")) {
                int copiesSold = js.getInt("courses[" + i + "].copies");
                System.out.println("Number of copies sold by RPA course: " + copiesSold);
                break; // Exit the loop once we find the RPA course
            }
        }
        // Alternative Way of Retrieving the number of copies sold by RPA course. Better Way -> Groovy syntax is used to find the RPA course and get the number of copies sold. This is a more efficient way to retrieve the data without looping through all courses. Also, readable and shorter code.
       int rpaCopiesSold = js.getInt("courses.find { it.title == 'RPA' }.copies");
       System.out.println("Number of copies sold by RPA course (alternative way): " + rpaCopiesSold);

   }

   @Test
   public void sumValidation() {
       // Verify if the sum of all course prices multiplied by their respective copies matches the purchase amount
       JsonPath js = new JsonPath(Payload.coursePrice());

       // Print the number of courses returned by the API
       int courseCount = js.getInt("courses.size()"); // courses is an array
       System.out.println("Number of courses: " + courseCount);

       // Print the purchase amount
       int purchaseAmount = js.getInt("dashboard.purchaseAmount");
       System.out.println("Purchase Amount: " + purchaseAmount);

       int totalCourseValue = 0;
       for (int i = 0; i < courseCount; i++) {
           int coursePrice = js.getInt("courses[" + i + "].price");
           int copiesSold = js.getInt("courses[" + i + "].copies");
           totalCourseValue += coursePrice * copiesSold;
       }
       System.out.println("Total value of all courses: " + totalCourseValue);
       if (totalCourseValue == purchaseAmount) {
           System.out.println("The sum of all course prices multiplied by their respective copies matches the purchase amount.");
       } else {
           System.out.println("The sum of all course prices multiplied by their respective copies does not match the purchase amount.");
       }
   }
}

