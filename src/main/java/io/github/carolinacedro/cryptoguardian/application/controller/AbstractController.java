package io.github.carolinacedro.cryptoguardian.application.controller;

import io.github.carolinacedro.cryptoguardian.application.model.CryptoConvertion;
import io.github.carolinacedro.cryptoguardian.application.service.AbstractModelService;
import io.github.carolinacedro.cryptoguardian.application.service.CryptoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public abstract class AbstractController<T> extends CryptoServiceImpl {

    public AbstractController(CryptoConvertion convertion) {
        super(convertion);
    }

    protected abstract AbstractModelService<T> getService();


    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        List<T> data = getService().findAll();
        return ResponseEntity.ok(data);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<T>> findById(@PathVariable Long id) {
//        Optional<T> dataResponse = getService().findById(id);
//        if (dataResponse.isPresent()) {
//            return ResponseEntity.ok(dataResponse);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }

//    @PostMapping
//    public ResponseEntity<T> save(@RequestBody T body) {
//        return ResponseEntity.ok(getService().save(body));
//    }


    @PutMapping
    public ResponseEntity<T> update(Long id, @RequestBody T body) {
        //Logica n implementada
        return ResponseEntity.ok(getService().save(body));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        getService().delete(id);
    }


}
