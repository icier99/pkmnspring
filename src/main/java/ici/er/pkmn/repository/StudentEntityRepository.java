package ici.er.pkmn.repository;

import ici.er.pkmn.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, UUID> {
    Optional<StudentEntity> findBySurNameAndFirstNameAndFamilyName(String surName, String firstName, String familyName);

    List<StudentEntity> findByGroup(String group);

    List<StudentEntity> findAll();

    Optional<StudentEntity> findBySurNameAndFirstNameAndFamilyNameAndGroup(String surName, String firstName, String familyName, String group);
}
