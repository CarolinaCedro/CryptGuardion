package io.github.carolinacedro.cryptoguardian.application.controller;

import java.util.List;
import java.util.Optional;

public interface ModelController<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T body);

    T update(Long id, T body);

}
