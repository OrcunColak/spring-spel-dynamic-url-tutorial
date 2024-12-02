package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.DynamicUri;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DynamicUriRepository extends JpaRepository<DynamicUri, Long> {
}
