package com.enviro.assessment.grad001.lesibanaNgoepe.service;

import com.enviro.assessment.grad001.lesibanaNgoepe.entity.EnvironmentalData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface EnvironmentalDataService {

    void uploadFile(MultipartFile file) throws IOException;

    List<EnvironmentalData> dataList() throws IOException;

    Optional<EnvironmentalData> getDataById(int id);
}
