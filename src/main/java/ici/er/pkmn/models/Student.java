package ici.er.pkmn.models;

import lombok.Builder;
import lombok.Data;
import ici.er.pkmn.entity.StudentEntity;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String surName;
    String firstName;
    String familyName;
    String group;

    public static Student fromEntity(StudentEntity entity) {
        if (entity != null) {
            return Student.builder()
                    .surName(entity.getSurName())
                    .firstName(entity.getFirstName())
                    .familyName(entity.getFamilyName())
                    .group(entity.getGroup())
                    .build();
        }
        return null;
    }
}
