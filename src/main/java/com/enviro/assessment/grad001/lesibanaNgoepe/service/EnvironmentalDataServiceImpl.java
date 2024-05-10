package com.enviro.assessment.grad001.lesibanaNgoepe.service;

import com.enviro.assessment.grad001.lesibanaNgoepe.entity.EnvironmentalData;
import com.enviro.assessment.grad001.lesibanaNgoepe.repository.EnvironmentalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentalDataServiceImpl implements EnvironmentalDataService{

    @Autowired
    EnvironmentalDataRepository repository;
    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        // Check if the uploaded file is a text file
        if (!file.getOriginalFilename().endsWith(".txt")) {
            throw new IllegalArgumentException("Only text files (.txt) are supported.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Skip the first line which defines the column names
            String headerLine = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to get individual values
                String[] values = line.split(",");
                if (values.length != 5) {
                    throw new IllegalArgumentException("Invalid data format in the file.");
                }

                // Extract values in order: Date, Location, Temperature, Humidity, AirQualityIndex
                LocalDate dateStr = LocalDate.parse(values[0]);
                String location = values[1];
                double temperature = Double.parseDouble(values[2]);
                double humidity = Double.parseDouble(values[3]);
                int airQualityIndex = Integer.parseInt(values[4]);

                // Create EnvironmentalData object and save it to the database
                EnvironmentalData data = new EnvironmentalData();
                data.setDate(dateStr); // Assuming you have a setter for Date
                data.setLocation(location);
                data.setTemperature(temperature);
                data.setHumidity(humidity);
                data.setAirQualityIndex(airQualityIndex);

                repository.save(data);
            }
        }
    }


    @Override
    public List<EnvironmentalData> dataList() throws IOException {
        return repository.findAll();
    }

    @Override
    public Optional<EnvironmentalData> getDataById(int id) {
        return repository.findById(id);
    }
}
