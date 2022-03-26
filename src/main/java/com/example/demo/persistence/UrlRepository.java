package com.example.demo.persistence;

import com.example.demo.persistence.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<UrlEntity, Integer> {

    @Query(value = "DELETE from TBL_URL u WHERE u.CREATED_TIMESTAMP < :thresholdTimeStamp", nativeQuery = true)
    void removeOlderThan(long thresholdTimeStamp);
}
