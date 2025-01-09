package ici.er.pkmn.repository;

import ici.er.pkmn.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardEntityRepository extends JpaRepository<CardEntity, UUID> {
    List<CardEntity> findAll();

    Optional<CardEntity> findByName(String name);

    Optional<CardEntity> findByPokemonOwnerId(UUID id);

    Optional<CardEntity> findById(UUID id);
}
