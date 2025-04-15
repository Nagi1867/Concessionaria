package com.concessionaria.config;

import com.concessionaria.domain.entities.Concessionaria;
import com.concessionaria.enums.Status;
import com.concessionaria.repositories.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private ConcessionariaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Concessionaria concessionaria = new Concessionaria(null, "Gol", "dfsD45", Status.NOVO);
        repository.save(concessionaria);
    }
}
