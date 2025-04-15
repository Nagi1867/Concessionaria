package com.concessionaria.resources;

import com.concessionaria.entities.Concessionaria;
import com.concessionaria.services.ConcessionariaService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class ConcessionariaResource {
    @Autowired
    private ConcessionariaService service;

    @GetMapping
    public ResponseEntity<List<Concessionaria>> findAll() {
        List<Concessionaria> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Concessionaria> findById(@PathVariable Long id) {
        Concessionaria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Concessionaria> insert(@RequestBody Concessionaria obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Concessionaria> update(@PathVariable Long id, @RequestBody Concessionaria obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
