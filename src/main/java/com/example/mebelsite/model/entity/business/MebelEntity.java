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
@Table(name = "mebel")
public class MebelEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double width;

    private Double height;

    private Double length;

    private Integer productionTimeDays;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mebel_type_id", referencedColumnName = "id")
    private MebelTypeEntity mebelType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    private ColorEntity color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "furniture_brand_id", referencedColumnName = "id")
    private FurnitureBrandEntity furnitureBrand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "furniture_type_id", referencedColumnName = "id")
    private FurnitureTypeEntity furnitureType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    private MaterialEntity material;
}
