package ici.er.pkmn.dao;

import ici.er.pkmn.entity.CardEntity;
import ici.er.pkmn.entity.StudentEntity;
import ici.er.pkmn.models.Card;
import ici.er.pkmn.repository.CardEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CardDao {
    @Autowired
    private final CardEntityRepository cardentityrepository;

    @SneakyThrows
    public List<CardEntity> getAll() {
        return cardentityrepository.findAll();
    }

    @SneakyThrows
    public CardEntity getByName(String name) {
        return cardentityrepository.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("Not Found"));
    }

    @SneakyThrows
    public CardEntity getByPokemonOwner(StudentEntity studentEntity) {
        return cardentityrepository.findByPokemonOwner(studentEntity).orElseThrow(
                () -> new IllegalArgumentException("Not Found"));
    }

    @SneakyThrows
    public CardEntity getById(UUID id) {
        return cardentityrepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not Found"));
    }

    @SneakyThrows
    public CardEntity saveCard(CardEntity cardEntity) {
        return cardentityrepository.save(cardEntity);
    }

    public boolean cardExists(Card card) {
        return cardentityrepository.findByName(card.getName()).isPresent();
    }
}
