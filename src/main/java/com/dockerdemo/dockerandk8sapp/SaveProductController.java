package com.dockerdemo.dockerandk8sapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class SaveProductController {

    @PostMapping("/saveProduct")
    public String saveProduct(@RequestBody String productDetails) throws IOException {
        Path fileName = Path.of(
            "/app/data/productInfo.txt");
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(String.valueOf(fileName), true))) {
                out.write(productDetails);
                out.close();

            return "Data saved to file successfully..!!!";
        }
        catch (IOException e) {
            return "Exception occurred while saving data to file." + e;
        }
    }
}
