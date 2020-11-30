package com.ul.aos.pokemoncard;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;
import com.sun.jersey.api.json.JSONConfiguration;

import java.util.Scanner;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class PokemonCardClient {

    private WebResource service;

    public PokemonCardClient() {
        this.initializeService();
    }

    private void initializeService() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        service = client.resource(
                UriBuilder.fromUri("http://localhost:9999/pokemoncard-service/Pokemoncards/").build());
    }

    private void callGetAllCardsService() {
        String result = service
                .path("")
                .accept("application/json")
                .get(new GenericType<String>(){});
        System.out.println("------------------------------------");
        System.out.println("Server response :");
        System.out.println(result);
        System.out.println("------------------------------------");
    }

    private void callGetSomeCardsService(String name, String type) {
        String result = service
                .path(name + "/" + type)
                .accept("application/json")
                .get(new GenericType<String>(){});
        System.out.println("------------------------------------");
        System.out.println("Server response :");
        System.out.println(result);
        System.out.println("------------------------------------");
    }

    private void callPutCardService(String name, String type, int hp, String an, String ad, String m1n, String m1d,
                                    String m2n, String m2d, String weakness, String res, int rc, String rarity,
                                    int cn) {
        StringBuilder str = new StringBuilder();
        str.append("{");
        str.append("\"name\": \"" + name + "\",");
        str.append("\"type\": \"" + type + "\",");
        str.append("\"healthPoints\": \"" + hp + "\",");
        str.append("\"abilityName\": \"" + an + "\",");
        str.append("\"abilityDescription\": \"" + ad + "\",");
        str.append("\"move1Name\": \"" + m1n + "\",");
        str.append("\"move1Description\": \"" + m1d + "\",");
        str.append("\"move2Name\": \"" + m2n + "\",");
        str.append("\"move2Description\": \"" + m2d + "\",");
        str.append("\"weakness\": \"" + weakness + "\",");
        str.append("\"resistance\": \"" + res + "\",");
        str.append("\"retreatCost\": \"" + rc + "\",");
        str.append("\"rarity\": \"" + rarity + "\",");
        str.append("\"cardNumber\": \"" + cn + "\"");
        str.append("}");
        ClientResponse response = service
                .path("")
                .accept("application/json")
                .type("application/json")
                .post(ClientResponse.class, str.toString());
        String result = response.getEntity(String.class);
        System.out.println("------------------------------------");
        System.out.println("Server response :");
        System.out.println(result);
        System.out.println("------------------------------------");
    }

    private void callDeleteCardService(int id) {
        String result = service
                .path("" + id)
                .accept("application/json")
                .delete(new GenericType<String>(){});
        System.out.println("------------------------------------");
        System.out.println("Server response :");
        System.out.println(result);
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        PokemonCardClient pokcli = new PokemonCardClient();
        Scanner scan = new Scanner(System.in);
        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("Enter option");
            System.out.println("1: Get all cards");
            System.out.println("2: Get some cards");
            System.out.println("3: Add new card");
            System.out.println("4: Delete card by id");
            System.out.println("5: Exit");
            System.out.println("Your input:");
            String userInput = scan.nextLine();
            try {
                switch (Integer.parseInt(userInput)) {
                    case 1:
                        pokcli.callGetAllCardsService();
                        break;
                    case 2:
                        System.out.println("Pokemon name:");
                        String pnG = scan.nextLine();
                        System.out.println("Pokemon type:");
                        String ptG = scan.nextLine();
                        pokcli.callGetSomeCardsService(pnG, ptG);
                        break;
                    case 3:
                        System.out.println("Pokemon name:");
                        String pnN = scan.nextLine();
                        System.out.println("Pokemon type:");
                        String ptN = scan.nextLine();
                        System.out.println("Health points (please input a number which can be divided by 10)");
                        boolean invalidNumberN = true;
                        int hpN = 0;;
                        while (invalidNumberN) {
                            invalidNumberN = false;
                            try {
                                hpN = Integer.parseInt(scan.nextLine());
                            } catch (NumberFormatException e) {
                                invalidNumberN = true;
                                System.out.println("Input is not a number. Please enter a number and try again.");
                            }
                        }
                        System.out.println("Ability name (leave blank if the pokemon doesn't have one):");
                        String anN = scan.nextLine();
                        System.out.println("Ability description (leave blank if the pokemon doesn't have one):");
                        String adN = scan.nextLine();
                        System.out.println("First move name:");
                        String m1nN = scan.nextLine();
                        System.out.println("First move description (leave blank if the move doesn't have one)");
                        String m1dN = scan.nextLine();
                        System.out.println("Second move name (leave blank if the pokemon doesn't have one):");
                        String m2nN = scan.nextLine();
                        System.out.println("Second move description (leave blank if the move doesn't have one)");
                        String m2dN = scan.nextLine();
                        System.out.println("Weakness:");
                        String wkN = scan.nextLine();
                        System.out.println("Resistance:");
                        String resN = scan.nextLine();
                        System.out.println("Retreat cost (please input a number):");
                        invalidNumberN = true;
                        int rcN = 0;;
                        while (invalidNumberN) {
                            invalidNumberN = false;
                            try {
                                rcN = Integer.parseInt(scan.nextLine());
                            } catch (NumberFormatException e) {
                                invalidNumberN = true;
                                System.out.println("Input is not a number. Please enter a number and try again.");
                            }
                        }
                        System.out.println("Rarity:");
                        String rarityN = scan.nextLine();
                        System.out.println("Card number (please input a number):");
                        invalidNumberN = true;
                        int cnN = 0;;
                        while (invalidNumberN) {
                            invalidNumberN = false;
                            try {
                                cnN = Integer.parseInt(scan.nextLine());
                            } catch (NumberFormatException e) {
                                invalidNumberN = true;
                                System.out.println("Input is not a number. Please enter a number and try again.");
                            }
                        }
                        pokcli.callPutCardService(pnN, ptN, hpN, anN, adN, m1dN, m1dN, m2nN, m2dN, wkN, resN, rcN,
                                rarityN, cnN);
                        break;
                    case 4:
                        System.out.println("Card id (please enter a number):");
                        boolean invalidIdD = true;
                        int idD = 0;;
                        while (invalidIdD) {
                            invalidIdD = false;
                            try {
                                idD = Integer.parseInt(scan.nextLine());
                            } catch (NumberFormatException e) {
                                invalidIdD = true;
                                System.out.println("Invalid input. Please enter a number and try again.");
                            }
                        }
                        pokcli.callDeleteCardService(idD);
                        break;
                    case 5:
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Unrecognized input.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not a number.");
            }
        }
    }
}