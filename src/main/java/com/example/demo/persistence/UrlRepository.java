package com.example.demo.persistence;

import com.example.demo.persistence.entities.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlEntity, Integer> {
}
