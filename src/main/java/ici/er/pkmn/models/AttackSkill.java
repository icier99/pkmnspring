package ici.er.pkmn.models;

import lombok.*;

import java.io.Serializable;

@Data
public class AttackSkill implements Serializable {
    public static final long serialVersionUID = 1L;
    String name;
    String description;
    String cost;
    int damage;

    @Override
    public String toString() {
        return  "name=" + name +
                ", description=" + description  +
                ", cost=" + cost +
                ", damage=" + damage;
    }
}
