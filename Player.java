/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 *
 * @author mileidicabezas
 */
public class Player {
    private String name;
    private String last_name;
    private int age;
    private Coach coach;
    private Team team;
    
  
    
    
    public Player(String name, String last_name, int age,Coach coach,Team team){

       this.name = name;
       this.last_name = last_name;
       this.age = age;
       this.coach=coach;
       this.team=team;
       
       
       
    }
    
    public String getName(){ 
//    This getter allows us to get the player name from the Player class
        return name;
    }
    
    public void setName(String name){
//        Overwrite the name of the player with this value
        this.name = name;
    }
    
    public String getLast_name(){
    
        return last_name;
    }
    
    public void setLast_name(String last_name){
        
    this.last_name = last_name;
    
    }
    
    
    public int getAge(){
    
        return age;
    }
    
    public void setAge(int age){
        
    this.age = age;
    
    }

    public String getCoach() {
        return this.coach.getName();
    }

    public String getTeam() {
        return this.team.getName();
    }
    
    
    
    
}
