package io.github.carolinacedro.cryptoguardian.application.service;

import io.github.carolinacedro.cryptoguardian.application.model.Client;
import io.github.carolinacedro.cryptoguardian.application.repository.ClientRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends AbstractModelService<Client> {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Client, Long> getRepository() {
        return repository;
    }

}
