/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import java.util.List;

/**
 *
 * @author mileidicabezas
 */
public class LinearSearch {
// this methoD has been adapted to search for players from our player list
   public static int searchPlayer(List<Player> players, String playerName) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equalsIgnoreCase(playerName)) {
                // Player found, return the index
                return i;
            }
        }

        // If the player was not found, return -1
        return -1;
    }
   
   
    public static int searchString(List<String> stringList, String target) {
        for (int i = 0; i < stringList.size(); i++) {
            String element = stringList.get(i);
            if (element.equalsIgnoreCase(target)) {
                // // If the element was  found, it will return the index
                return i;
            }
        }

        // If the element was not found, it will return  -1
        return -1;
    }
    //ThIS method was modified to search only with a letter
    //this will return only one name that start with the letter the user typed 
    public static int linearSearchByFirstLetter(List<String> playerDetails, char firstLetter) {
        for (int i = 0; i < playerDetails.size(); i++) {
            String playerName = playerDetails.get(i).toLowerCase();

            // this condition to check if the player's name starts with the specified letter
            if (playerName.startsWith(String.valueOf(firstLetter).toLowerCase())) {
                return i;
            }
        }
//       return -1 if player not found
        return -1; 
    }
    
}


