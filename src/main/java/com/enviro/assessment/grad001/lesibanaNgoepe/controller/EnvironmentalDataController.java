package com.enviro.assessment.grad001.lesibanaNgoepe.controller;

import com.enviro.assessment.grad001.lesibanaNgoepe.entity.EnvironmentalData;
import com.enviro.assessment.grad001.lesibanaNgoepe.service.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EnvironmentalDataController {


    @Autowired
    EnvironmentalDataService dataService;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            dataService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to process the uploaded file.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    @GetMapping("/getAllData")
    public ResponseEntity<List<EnvironmentalData>> getAll() {
        try {
            List<EnvironmentalData> dataList = dataService.dataList();

            if (dataList.isEmpty()) {
                // Return a response with status code 204 (NO_CONTENT) if the list is empty
                return ResponseEntity.noContent().build();
            } else {
                // Return the list of environmental data with status code 200 (OK)
                return ResponseEntity.ok(dataList);
            }
        } catch (IOException e) {
            // Return an appropriate error response, such as status code 500 (INTERNAL_SERVER_ERROR)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getDataById(@PathVariable int id) throws IOException {
        Optional<EnvironmentalData> environmentalData = dataService.getDataById(id);

        if (environmentalData.isPresent()) {
            return ResponseEntity.ok(environmentalData.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found for id: " + id);
        }
    }


    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
