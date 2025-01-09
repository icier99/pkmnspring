package ici.er.pkmn.services;

import ici.er.pkmn.models.Card;
import ici.er.pkmn.models.Student;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

public interface CardService {
    List<Card> getAllCards();
    Card getCardByName(String name);
    Card getCardByPokemonOwner(Student student);
    Card getCardById(UUID id);
    Card saveCard(Card card);
    String getPokemonImage(String name, int number);
}
