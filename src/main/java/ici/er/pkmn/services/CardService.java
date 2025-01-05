package ici.er.pkmn.services;

import ici.er.pkmn.entity.StudentEntity;
import ici.er.pkmn.models.Card;

import java.util.List;
import java.util.UUID;

public interface CardService {
    List<Card> getAllCards();
    Card getCardByName(String name);
    Card getCardByPokemonOwner(StudentEntity studentEntity);
    Card getCardById(UUID id);
    Card saveCard(Card card);
}
