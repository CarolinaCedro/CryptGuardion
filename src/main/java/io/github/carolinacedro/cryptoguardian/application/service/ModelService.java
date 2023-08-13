package io.github.carolinacedro.cryptoguardian.application.service;

import java.util.List;
import java.util.Optional;

public interface ModelService<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T body);

    T update(Long id, T body);

    void delete(Long id);

}
