package org.example;

import org.example.DJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DJRepository extends JpaRepository<DJ, Long> {
    // You can define custom query methods if needed
}