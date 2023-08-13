package io.github.carolinacedro.cryptoguardian.application.repository;

import io.github.carolinacedro.cryptoguardian.application.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
