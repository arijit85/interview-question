package com.example.demo.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name="TBL_URL")
public class UrlEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="URL")
    private String url;

    @Column(name = "CREATED_TIMESTAMP")
    private long createdTimeStamp;

    @PrePersist
    protected void onCreate() {
        createdTimeStamp = System.currentTimeMillis();
    }
}
