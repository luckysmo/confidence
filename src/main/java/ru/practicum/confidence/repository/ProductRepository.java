package ru.practicum.confidence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.confidence.model.Product;
import ru.practicum.confidence.model.type.ProductTypes;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByProductTypes(ProductTypes productTypes);
}
