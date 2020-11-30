package com.ul.aos.pokemoncard.model.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PokemonCard {

    @Id
    @GeneratedValue
    private Integer id;

    private String name = "Pikachu";
    private String type = "Electric";
    private int healthPoints = 50;
    private String abilityName = "";
    private String abilityDescription = "";
    private String move1Name = "Tackle";
    private String move1Description = "Deals 10 damage to target pokemon.";
    private String move2Name = "";
    private String move2Description = "";
    private String weakness = "";
    private String resistance = "";
    private int retreatCost = 0;
    private String rarity = "common";
    private int cardNumber = 1;

    protected PokemonCard() {}

    public PokemonCard (int id, String name, String type, int hp, String an, String ad, String m1n,
                  String m1d, String m2n, String m2d, String weakness, String res, int rc,
                  String rarity, int cn) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.healthPoints = hp;
        this.abilityName = an;
        this.abilityDescription = ad;
        this.move1Name = m1n;
        this.move1Description = m1d;
        this.move2Name = m2n;
        this.move2Description = m2d;
        this.weakness = weakness;
        this.resistance = res;
        this.retreatCost = rc;
        this.rarity = rarity;
        this.cardNumber = cn;

    }

    public PokemonCard (String name, String type, int hp, String an, String ad, String m1n,
                        String m1d, String m2n, String m2d, String weakness, String res, int rc,
                        String rarity, int cn) {

        this.name = name;
        this.type = type;
        this.healthPoints = hp;
        this.abilityName = an;
        this.abilityDescription = ad;
        this.move1Name = m1n;
        this.move1Description = m1d;
        this.move2Name = m2n;
        this.move2Description = m2d;
        this.weakness = weakness;
        this.resistance = res;
        this.retreatCost = rc;
        this.rarity = rarity;
        this.cardNumber = cn;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            this.name = "pikachu";
        }
        else {
            this.name = name;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals("")) {
            this.type = "electric";
        }
        else {
            this.type = type;
        }
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints <= 0 || healthPoints % 10 != 0) {
            this.healthPoints = 50;
        }
        else {
            this.healthPoints = healthPoints;
        }
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityDescription() {
        return abilityDescription;
    }

    public void setAbilityDescription(String abilityDescription) {
        if (this.abilityName.equals("")) {
            this.abilityDescription = "";
        }
        else {
            this.abilityDescription = abilityDescription;
        }
    }

    public String getMove1Name() {
        return move1Name;
    }

    public void setMove1Name(String move1Name) {
        if (move1Name.equals("")) {
            this.move1Name = "Charge";
        }
        else {
            this.move1Name = move1Name;
        }
    }

    public String getMove1Description() {
        return move1Description;
    }

    public void setMove1Description(String move1Description) {
        if (move1Description.equals("")) {
            this.move1Description = "Deals 10 damage to target pokemon.";
        }
        else {
            this.move1Description = move1Description;
        }
    }

    public String getMove2Name() {
        return move2Name;
    }

    public void setMove2Name(String move2Name) {
        this.move2Name = move2Name;
    }

    public String getMove2Description() {
        return move2Description;
    }

    public void setMove2Description(String getMove2Description) {
        if (this.move2Name.equals("")) {
            this.move2Description = "";
        }
        else {
            this.move2Description = getMove2Description;
        }
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    public int getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(int retreatCost) {
        if (retreatCost < 0) {
            this.retreatCost = 0;
        }
        else {
            this.retreatCost = retreatCost;
        }
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        if (rarity.equals("")) {
            this.rarity = "common";
        }
        else {
            this.rarity = rarity;
        }
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        if (cardNumber <= 0) {
            this.cardNumber = 1;
        }
        else {
            this.cardNumber = cardNumber;
        }
    }

}
