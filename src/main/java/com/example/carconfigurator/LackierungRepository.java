package com.example.carconfigurator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LackierungRepository extends JpaRepository<Lackierung, Long> {
}
