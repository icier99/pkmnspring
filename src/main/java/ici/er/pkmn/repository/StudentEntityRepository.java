package ici.er.pkmn.repository;

import ici.er.pkmn.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, UUID> {
    // Получение студента по ФИО
    Optional<StudentEntity> findBySurNameAndFirstNameAndFamilyName(String surName, String firstName, String familyName);

    // Получение студентов по группе
    List<StudentEntity> findByGroup(String group);

    //Получение всех студентов
    List<StudentEntity> findAll();

    Optional<StudentEntity> findBySurNameAndFirstNameAndFamilyNameAndGroup(String surName, String firstName, String familyName, String group);
}
