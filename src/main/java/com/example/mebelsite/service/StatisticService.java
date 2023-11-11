package com.example.mebelsite.service;

import com.example.mebelsite.model.dto.CountMebelByMebelType;
import com.example.mebelsite.model.entity.business.MebelTypeEntity;
import com.example.mebelsite.model.repository.MebelRepository;
import com.example.mebelsite.model.repository.MebelTypeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final MebelRepository mebelRepository;

    private final MebelTypeRepository mebelTypeRepository;

    public Long countMebel() {
        return mebelRepository.count();
    }

    public List<CountMebelByMebelType> statistics() {
        return mebelTypeRepository.findAll().parallelStream()
                .map(mebelType ->
                        new CountMebelByMebelType(
                                mebelType.getTitle(),
                                getCountMebelByMebelType(mebelType)
                        )
                ).collect(Collectors.toList());
    }

    public String jsonStatistics() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(statistics());
    }


    public Long getCountMebelByMebelType(MebelTypeEntity mebelType) {
        return mebelRepository.countByMebelType(mebelType);
    }
}