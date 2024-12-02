package com.colak.springtutorial.cache;

import com.colak.springtutorial.jpa.DynamicUri;
import com.colak.springtutorial.repository.DynamicUriRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Getter
@Setter
public class ApiCache {

    @Autowired
    private DynamicUriRepository dynamicUriRepository;

    private Map<String, String> cacheMap = new HashMap<>();

    public String getApi(String apiName) {
        return cacheMap.get(apiName);
    }

    @PostConstruct
    public void init() {
        List<DynamicUri> dynamicUris = dynamicUriRepository.findAll();
        cacheMap.putAll(dynamicUris.stream()
                .collect(Collectors.toMap(DynamicUri::getUriName, DynamicUri::getUriPath)));
    }
}
