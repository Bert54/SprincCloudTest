package com.ul.aos.pokemoncard.model.controllers;

import com.ul.aos.pokemoncard.model.dao.PokemonCardRepository;
import com.ul.aos.pokemoncard.model.objects.PokemonCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PokemonCardController {

    @Value("${me}")
    private String me;

    @Autowired
    private PokemonCardRepository repository;

    @GetMapping(value="/Pokemoncards", produces="application/json")
    public List<PokemonCard> getCards() {
        List<PokemonCard> pc = new ArrayList<>();
        for (PokemonCard pokemonCard : repository.findAll()) {
            pc.add(pokemonCard);
        }
        return pc;
    }

    @GetMapping(value="/Pokemoncards/{name}/{type}", produces="application/json")
    public List<PokemonCard> getCard(@PathVariable String name, @PathVariable String type) {
        if (name.equals("")) {
            name = "Pikachu";
        }
        if (type.equals("")) {
            type = "Electric";
        }
        List<PokemonCard> pc = new ArrayList<>();
        for (PokemonCard pokemonCard : repository.find(name, type)) {
            pc.add(pokemonCard);
        }
        return pc;
    }

    @PostMapping(value="/Pokemoncards", produces="application/json", consumes="application/json")
    public PokemonCard addCard(@RequestBody PokemonCard c) {
        return repository.save(c);
    }

    @DeleteMapping(value="/Pokemoncards/{id}", produces="application/json")
    public PokemonCard deleteCardById(@PathVariable int id) {
        return repository.deleteById(id);
    }


    @DeleteMapping(value="/Pokemoncards/deletebynameandtype", produces="application/json")
    public PokemonCard deleteCard(@RequestBody PokemonCard c) {
        return repository.delete(c.getName(), c.getType());
    }

    @GetMapping(value="Whoami")
    public String getName() {
        return this.me;
    }

}
