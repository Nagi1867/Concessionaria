package com.concessionaria.services;

import com.concessionaria.entities.Concessionaria;
import com.concessionaria.repositories.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcessionariaService {
    @Autowired
    private ConcessionariaRepository repository;

    public List<Concessionaria> findAll() {
        return repository.findAll();
    }

    public Concessionaria findById(Long id) {
        Optional<Concessionaria> obj = repository.findById(id);
        return obj.get();
    }

    public Concessionaria insert(Concessionaria obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Concessionaria update(Long id, Concessionaria obj) {
        Concessionaria entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Concessionaria entity, Concessionaria obj) {
        entity.setModelo(obj.getModelo());
        entity.setPlaca(obj.getPlaca());
        entity.setStatus(obj.getStatus());
    }
}
