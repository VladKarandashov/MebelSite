package com.example.mebelsite.service;

import com.example.mebelsite.model.entity.business.MebelEntity;
import com.example.mebelsite.model.repository.MebelRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExportService {

    private final MebelRepository mebelRepository;

    public List<MebelEntity> getAllMebelEntity() {
        return mebelRepository.findAll();
    }

    public ResponseEntity<Resource> jsonFile() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        String entityList = objectMapper.writeValueAsString(getAllMebelEntity());
        ByteArrayResource resource = new ByteArrayResource(entityList.getBytes());

        var currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
        String currentDateTimeString = currentDateTime.format(formatter);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "mebel " + currentDateTimeString + ".json")
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_JSON)
                .body(resource);
    }

}