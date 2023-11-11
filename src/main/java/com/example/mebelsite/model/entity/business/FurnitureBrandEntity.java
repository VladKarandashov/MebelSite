package com.example.mebelsite.model.entity.business;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "furniture_brand")
public class FurnitureBrandEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public FurnitureBrandEntity(String title) {
        this.title = title;
    }
}
