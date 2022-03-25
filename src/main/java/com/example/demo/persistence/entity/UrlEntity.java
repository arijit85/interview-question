package com.example.demo.persistence.entities;

import lombok.*;

import javax.persistence.*;

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
}
