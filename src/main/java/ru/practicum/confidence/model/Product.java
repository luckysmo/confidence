package ru.practicum.confidence.model;

import jakarta.persistence.*;
import lombok.*;
import ru.practicum.confidence.model.type.ProductTypes;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Enumerated(EnumType.STRING)
    @Column(name = "productTypes")
    private ProductTypes productTypes;

}
