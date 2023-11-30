/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca_2;

import java.util.List;

/**
 *
 * @author mileidicabezas
 */
public interface RCInterface {
    enum MenuOption{
    SORT,
    SEARCH_NAME_ON_THE_FILE,
    ADD_PLAYER,
    LIST_PLAYERS,
    SEARCH,
    RANDOM_PLAYER,
    RANDOM_NAME_FROM_FILE,
    EXIT
    
    
    }
    //void selectAndDisplayTeamOrCoach();
    //void printList();
    void listAllplayers();
    void addPlayer(Player player);
    void getRandomPlayer();
    
    
}
