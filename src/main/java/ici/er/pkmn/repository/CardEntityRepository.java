package ici.er.pkmn.repository;

import ici.er.pkmn.entity.CardEntity;
import ici.er.pkmn.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardEntityRepository extends JpaRepository<CardEntity, UUID> {
    // Получение всех карточек
    List<CardEntity> findAll();

    // Получение карточки по имени
    Optional<CardEntity> findByName(String name);

    // Получение карточки по владельцу
    Optional<CardEntity> findByPokemonOwner(StudentEntity studentEntity);

    // Полечение карточки по Id
    Optional<CardEntity> findById(UUID id);
}
