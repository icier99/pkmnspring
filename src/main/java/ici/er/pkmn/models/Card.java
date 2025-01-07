package ici.er.pkmn.models;

import ici.er.pkmn.entity.CardEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class Card implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;
    PokemonStage pokemonStage;
    String name;
    int hp;
    EnergyType pokemonType;
    public Card evolvesFrom;
    List<AttackSkill> skills;
    EnergyType weaknessType;
    EnergyType resistanceType;
    String retreatCost;
    String gameSet;
    char regulationMark;
    Student pokemonOwner;
    String number;

    @Override
    public String toString() {
        return
                "\n\npokemonStage=" + pokemonStage +
                "\nname=" + name +
                "\nhp=" + hp +
                "\npokemonType=" + pokemonType +
                "\nevolvesFrom=" + evolvesFrom +
                "\nskills=" + skills +
                "\nweaknessType=" + weaknessType +
                "\nresistanceType=" + resistanceType +
                "\nretreatCost=" + retreatCost  +
                "\ngameSet=" + gameSet  +
                "\nregulationMark=" + regulationMark +
                "\npokemonOwner=" + pokemonOwner +
                "\nnumber=" + number + "\n";
    }

    public static Card fromEntity(CardEntity entity) {
        if (entity != null) {
            return Card.builder()
                    .pokemonStage(entity.getPokemonStage())
                    .name(entity.getName())
                    .hp(entity.getHp())
                    .pokemonType(entity.getPokemonType())
                    .evolvesFrom(fromEntity(entity.getEvolvesFrom()))
                    .skills(entity.getSkills())
                    .weaknessType(entity.getWeaknessType())
                    .resistanceType(entity.getResistanceType())
                    .retreatCost(entity.getRetreatCost())
                    .gameSet(entity.getGameSet())
                    .regulationMark(entity.getRegulationMark())
                    .pokemonOwner(Student.fromEntity(entity.getPokemonOwner()))
                    .number(entity.getNumber())
                    .build();
        }
        return null;
    }
}
