package com.codecool;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utility {

    public void navigateBackMultipleTimes(WebDriver driver, int times) {
        for (int i = 0; i < times; i++) {
            driver.navigate().back();
        }
    }

    public void deleteUsers() {

        String filePath = "C:\\Users\\User\\IdeaProjects\\system-under-testing-registration-form-general-Hyacinto\\student_data.json";
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode rootNode = (ObjectNode) mapper.readTree(new File(filePath));
            rootNode.putArray("students").removeAll();
            mapper.writeValue(new File(filePath), rootNode);
            System.out.println("JSON file successfully cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudents() {

        String filePath = "C:\\Users\\User\\IdeaProjects\\system-under-testing-registration-form-general-Hyacinto\\user_data.json";
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode rootNode = (ObjectNode) mapper.readTree(new File(filePath));
            rootNode.putArray("users").removeAll();
            mapper.writeValue(new File(filePath), rootNode);
            System.out.println("JSON file successfully cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
