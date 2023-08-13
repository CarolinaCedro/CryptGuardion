package io.github.carolinacedro.cryptoguardian.application.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractModelService<T> implements ModelService<T> {

    protected abstract JpaRepository<T, Long> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public T save(T body) {
        return getRepository().save(body);
    }

    @Override
    public T update(Long id, T body) {
        //fazer logica aqui de update posteriormente já que não é o foco
        return getRepository().save(body);
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }
}
