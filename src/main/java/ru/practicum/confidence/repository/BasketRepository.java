package ru.practicum.confidence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.confidence.model.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {
}
