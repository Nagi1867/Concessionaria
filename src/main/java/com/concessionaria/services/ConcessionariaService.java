package com.concessionaria.services;

import com.concessionaria.domain.entities.Concessionaria;
import com.concessionaria.repositories.ConcessionariaRepository;
import com.concessionaria.services.exceptions.DatabaseException;
import com.concessionaria.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Concessionaria insert(Concessionaria obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Concessionaria update(Long id, Concessionaria obj) {
        try {
            Concessionaria entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Concessionaria entity, Concessionaria obj) {
        entity.setModelo(obj.getModelo());
        entity.setPlaca(obj.getPlaca());
        entity.setStatus(obj.getStatus());
    }
}
