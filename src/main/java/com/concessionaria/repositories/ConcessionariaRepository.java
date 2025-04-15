package com.concessionaria.repositories;

import com.concessionaria.domain.entities.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {
}
