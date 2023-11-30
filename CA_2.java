/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import static ca_2.RCInterface.MenuOption.ADD_PLAYER;
import static ca_2.RCInterface.MenuOption.EXIT;
import static ca_2.RCInterface.MenuOption.LIST_PLAYERS;
import static ca_2.RCInterface.MenuOption.RANDOM_NAME_FROM_FILE;
import static ca_2.RCInterface.MenuOption.RANDOM_PLAYER;
import static ca_2.RCInterface.MenuOption.SEARCH;
import static ca_2.RCInterface.MenuOption.SEARCH_NAME_ON_THE_FILE;
import static ca_2.RCInterface.MenuOption.SORT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mileidicabezas
 */


    
   

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class CA_2 implements RCInterface{
/**
 *
 * @author mileidicabezas
 */


    /**
     * @param args the command line arguments
     */
    
    
//    Initializing an empty array list of the Player objects so we can use this dinamicly
//    so we will have the flexibiblity on choosing the different implentations nedded 
//    such adding new players,listing player,get randon player
    
    private List<Player>players = new ArrayList<>();
     private List<Coach>coaches;
     private List<Team>teams;
    
    
    
    public CA_2(){
     this.coaches= new ArrayList<>();
 //         Creating a new instance of the ArrayList class and assigning it to the coaches and teams variable
 //         Populating the arrays with coaches and teams, this is being used to assign random coach and team for the applicants
 //         that are store in the text file
                 coaches.add(new Head_Coach("Head Coach"));
                 coaches.add(new Assistant_Coach("Assistant Coach"));
                 coaches.add(new Scrum_Coach("Scrum Coach"));
                 
                 this.teams= new ArrayList<>();
                 teams.add(new A_Squad("A Squad"));
                 teams.add(new B_Squad("B Squad"));
                 teams.add(new Under_13_Squad("Under-13 Squad"));
       
//              creating instances of coach and team to populate our ArrayList of Player object
//              we need to do this becouse our player objects contains COACH and TEAM object as a parameter
//              once this is done we can call our instances when adding a new player
                Coach coache= new Head_Coach("Head Coach");
                Coach coache1=new Assistant_Coach("Assistant Coach");
                Coach coache2=new Scrum_Coach("Scrum Coach");
                 
                 
                Team tea=new A_Squad("A Squad");
                Team tea1=new B_Squad("B Squad");
                Team tea2=new Under_13_Squad("Under-13 Squad"); 
        
        
            
            players.add(new Player("Niall","Brennan",35,coache1,tea));
            players.add(new Player("Jonh","Connor",20,coache,tea1));
            players.add(new Player("Luciana","Prado",15,coache2,tea2));
            
    
    }
    

    
    
     
//    This method will allow us to print  our arrayList without the necesesity of printing a for loop everytime we need
//    This methos takes as paraemeter a list of Strings  that will contain the list and an int which will be a limit of the data we want to print
//    base in our system requirement, we are reading a file that contain unknowing amount of data 
//    and we want to print the first 20, with this method we can just add the amount of data we want to see
    public static void printList(List<String> list,int limit) {
        
        int printedRows = 0;
        for (String element : list) {
            System.out.println(element);
            printedRows++;

            if (printedRows >= limit) {
                break;
            }  }}
    
    
    
   
    
    

    @Override
    public void addPlayer(Player player){   

    
    players.add(player);
//  Calling the listAllPlayers method here so we can display the new player added
    listAllplayers();  
//  this message is confirmation that the player was added correctly 
    System.out.println(player.getName() +" "+ player.getLast_name()+ " has been assigned " + player.getCoach() + " as coach and has been successfully added to the " + player.getTeam() + " team.");
    }
    
    
   @Override
    public void listAllplayers() {
 // creating a for loop so it will iterate trough all the list of player avaliable
 // and print them each in the follow format so it is readable for the user
 for (Player p : players) {
        System.out.println("Name: " + p.getName());
        System.out.println("Last Name: " + p.getLast_name());
        System.out.println("Age: " + p.getAge());
        System.out.println("Coach: " + p.getCoach());
        System.out.println("Team: " + p.getTeam());
        System.out.println("------------------------");
    }
          
    }
    

    @Override
    public void getRandomPlayer() {
//  In this condition we use the isEmpty method to check if our array has some data store on it
//  if it does not have any it will tell the user that there is no data to be showm
    if (players.isEmpty()) {
        System.out.println("No players in the system. Add players before generating random players.");
        return;
    }
//  Creating a new instance of the Random class
    Random random = new Random();
//  The index will check if it is not the out of bound and take the player list as a paremeter
//  to get the amount of data store in it 
    int index = random.nextInt(players.size());
//  Using the randomPlayer variable, the player at the random index is chosen from the players list    
    Player randomPlayer = players.get(index);
//  Printing the random player that was selected from the playerList
    System.out.println("--------------------------------------------------------------");
    System.out.println("Randomly Selected Player:");
    System.out.println("--------------------------------------------------------------");
    System.out.println("Name: " + randomPlayer.getName());
    System.out.println("Last Name: " + randomPlayer.getLast_name());
    System.out.println("Age: " + randomPlayer.getAge());
    System.out.println("Coach: " + randomPlayer.getCoach());
    System.out.println("Team: " + randomPlayer.getTeam());
    System.out.println("------------------------");              
    }
    
// Method to validate that user inputs only numbers 
   private static boolean isNumeric(String str){
        // Use regular expression to check if the string contains only numbers    
        return str.matches("-?\\d+(\\.\\d+)?");
    } 
    
// Method to validate that user inputs only Strings    
    private static boolean isValidString(String str) {
        // Use regular expression to check if the string contains only letters
        return str.matches("[a-zA-Z]+");
    }
    
    
    
    public static void main(String[] args) throws IOException {
        
    //    
     File file = null;

        Scanner input = new Scanner(System.in);
// Here we will pront the user until the user provides an existent file
        do {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Enter the name of your file (including file extension): ");
            System.out.println("--------------------------------------------------------------");
            String filename = input.next();

            file = new File(filename);

            if (!file.exists() || !file.isFile()) {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Sorry, file not found. ");
                System.out.println("--------------------------------------------------------------");
            }
        } while (!file.exists() || !file.isFile());
//  Here I am creating two ArrayList to split the information given that the data contains ints and Srings,
//  one will store the id and the other the personal information
//  I do this so it is easier to manipulate the data o the file since we want to sort this list base on the name of the aplicant 
        List<String> personDetails = new ArrayList<>();
        List<Integer> id = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("File found successfully!");

            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    // Skip the header line
                    firstLine = false;
                    continue;
                }

                String[] tokens = line.split(",");
                int tokens_len = tokens.length;

                if (tokens_len > 0) {
                    // Check if the first part of the string is convertible to an integer
                    try {
                        int number = Integer.parseInt(tokens[0].trim());
                        id.add(number);

                        // This loop assembles the rest of the parts as the player details
                        // except the first one
                        String playerInfo = "";
                        for (int l = 1; l < tokens_len; l++) {
                            playerInfo += tokens[l].trim();
                            if (l < tokens_len - 1) {
                                playerInfo += ", ";
                            }
                        }
                        personDetails.add(playerInfo);
                    } catch (NumberFormatException e) {
                        //"Skipping invalid line
                        System.out.println( line);
                        // Handle or log the exception as needed
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printList(personDetails,20);
   
    
        
        // create an object from the constructor
        CA_2 rugby = new CA_2();
        // Taking user input
        Scanner scanner = new Scanner(System.in);
        // Instatiate 
        RCInterface.MenuOption selectOption = null;
        
        //Create a do while block
        
        do{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Please select an option: ");
            System.out.println("1. Sort the content of the file in ascending order by name");
            System.out.println("2. Search for players on the file");
            System.out.println("3. Add new  player");
            System.out.println("4. List players");
            System.out.println("5. Search for players");
            System.out.println("6. Pick a Random Player");
            System.out.println("7. Pick a Random Player from the text file");
            System.out.println("8. Exit");
            System.out.println("--------------------------------------------------------------");
            
      //            Validate that the user input is only numerics
            while(!scanner.hasNextInt()){
                System.out.println("Please enter Valid numbers!");
                scanner.next();      
            }
            
                                  
//        The user choice will be stored in the option variable as an integer
            int option = scanner.nextInt();
            
//            Validate that the user input is within the available range of options
            
            if(option <1 || option > RCInterface.MenuOption.values().length){
                System.out.println("--------------------------------------------------------------");
                    System.out.println("Please select from one of the options available!");
                System.out.println("--------------------------------------------------------------");
            }else{
                
                selectOption = RCInterface.MenuOption.values()[option -1];
            switch(selectOption){
                
                case SORT:
                    SelectionSort.selectionSort(personDetails);
                    printList(personDetails,20);
                    
                    break;
                    
                case SEARCH_NAME_ON_THE_FILE:
                    
                    System.out.println("--------------------------------------------------------------");
                                        System.out.println("Please enter the first letter of the player name that you want to search for: ");
                    System.out.println("--------------------------------------------------------------");

                    scanner.nextLine(); 
                    char firstLetter = scanner.nextLine().charAt(0);

                    int result0 = LinearSearch.linearSearchByFirstLetter(personDetails, firstLetter);

                    if (result0 != -1) {
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Player with name starting with '" + firstLetter + "' was found at index: " + result0);
                        System.out.println("--------------------------------------------------------------");

                        String foundPlayer = personDetails.get(result0);

                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Player information: ");
                        System.out.println("--------------------------------------------------------------");

                        System.out.println("Name: " + foundPlayer);
                    } else {
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("No player with a name starting with '" + firstLetter + "' found.");
                        System.out.println("--------------------------------------------------------------");
                    }
                
                    
                    break;
                
                
              case ADD_PLAYER:
                   String userChoice;
                 do{
                 System.out.println("--------------------------------------------------------------");
                 System.out.println("Enter player details, comma seperated (Name,Lastname,Age):");
                 System.out.println("--------------------------------------------------------------");
//               Here Im creating an array of String to hold all user's input and split the input by a comma
//               so it is easier to capture the information
//               and validate it at the same time
//               To valdate the user input we called the function isValidString for Strings and isNumeric for integers
                 String[] playerDetails = scanner.next().split(",");
                 if(playerDetails.length == 3 && isValidString(playerDetails[0]) && isValidString(playerDetails[1])){
                 String playerName = playerDetails[0].trim();
                 String playerLastName = playerDetails[1].trim();
                 if (isNumeric(playerDetails[2].trim())) {
                 int playerAge = Integer.parseInt(playerDetails[2].trim());
//               I have added a new scanner.nextLine(); to consume the newline character
//               this one will allows to capture the next user input so it is vital this is there 
                 scanner.nextLine(); 
            
    
//                 MENU TO SELECT A COACH 
                 
                 System.out.println("Choose coach type:");
                 System.out.println("1. Head Coach");
                 System.out.println("2. Assistant Coach");
                 System.out.println("3. Scrum Coach");
                 System.out.println("--------------------------------------------------------------");
                 int coachChoice = scanner.nextInt();
                  scanner.nextLine(); // Consume the newline character

                 Coach selectedCoach;
                   switch (coachChoice) {
                   case 1:
                   selectedCoach = new Head_Coach("Head Coach");
                   break;
                   case 2:
                   selectedCoach = new Assistant_Coach("Assistant Coach");
                   break;
                   case 3:
                   selectedCoach = new Scrum_Coach("Scrum Coach");
                   break;
                   default:
                   System.out.println("Invalid choice. Setting default coach.");
                   selectedCoach = new Head_Coach("Head Coach");
                   }
//                  MENU TO SELECT A TEAM
                    
                    System.out.println("Choose team:");
                    System.out.println("1. A Squad");
                    System.out.println("2. B Squad");
                    System.out.println("3. Under 13 Squad");
                    System.out.println("--------------------------------------------------------------");
                    int teamChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Team selectedTeam;
                    switch (teamChoice) {
                        case 1:
                            selectedTeam = new A_Squad("A Squad");
                            break;
                        case 2:
                            selectedTeam = new B_Squad("B Squad");
                            break;
                        case 3:
                            selectedTeam = new Under_13_Squad("Under 13 Squad");
                            break;
                        default:
                            System.out.println("Invalid choice. Setting default team.");
                            selectedTeam = new A_Squad("A Squad");
                    }
                // Create an new player to store the informstion that is being capture from the user
                //every time th euser insert a new player it will be store here
                    Player newPlayer = new Player(playerName, playerLastName, playerAge, selectedCoach, selectedTeam);

                    //here we pass all the information colected from the user input and send it to our addPlayer method
                    //All th user input will be store in the program memory which means all th einformation collected will
                    //disapear when you stop running the program
                    //with this we also are going to be able to display all the players added by th euser and they can be listed as well
                    rugby.addPlayer(newPlayer);
                    
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Do you want to add another player? (yes/no)");
                    

                    userChoice = scanner.nextLine();

                    
                    //this meassage will display if the user input a value different to an integer
                    }else{
                          System.out.println("--------------------------------------------------------------");
                          System.out.println("Invalid input for Age Please input Numeric values only!");
                          userChoice = "yes"; // Setted to "yes" to continue the loop and ask for input again
                          
                          }
                       }else{
                          System.out.println("-------------------------------------------------------------------");
                          System.out.println("Please make sure you follow the correct format: (Name,Lastname,Age)");
                          userChoice = "yes"; // Settted to "yes" to continue the loop and ask for input again
                          
                           }
                 
                 }while("yes".equalsIgnoreCase(userChoice));

                break;


                    
                case LIST_PLAYERS:
                    rugby.listAllplayers();
                    
                    break;
                    
                    case SEARCH:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Please enter the player name that you want to search for: ");
                    
                    
                    scanner.nextLine(); 
                     String targetPlayerName = scanner.nextLine();
                     

                     int result = LinearSearch.searchPlayer(rugby.players, targetPlayerName);

                     if (result != -1) {
                     System.out.println("--------------------------------------------------------------");
                     System.out.println("Player was found at index: " + result);
                     
                     
                     Player foundPlayer = rugby.players.get(result);
                      
                     System.out.println("--------------------------------------------------------------");
                      System.out.println("Player information: ");
                    ;
                     
                      System.out.println("Name: " + foundPlayer.getName());
                      System.out.println("Last Name: " + foundPlayer.getLast_name());
                      System.out.println("Age: " + foundPlayer.getAge());
                      System.out.println("Coach: " + foundPlayer.getCoach());
                      System.out.println("Team: " + foundPlayer.getTeam());
                 } else {
                   System.out.println("--------------------------------------------------------------");
                   System.out.println("Player with name '" + targetPlayerName + "' not found.");
                   
                 }
                    break;

                    
                case RANDOM_PLAYER:
                    rugby.getRandomPlayer();
                    break;
                case RANDOM_NAME_FROM_FILE:
                    Random randomN = new Random();
                    Random randomC = new Random();
                    Random randomT = new Random();
                //  The index will check if it is not the out of bound and take the player list as a paremeter
                //  to get the amount of data store in it 
                    int index = randomN.nextInt(personDetails.size());
                    int index1 = randomC.nextInt(rugby.coaches.size());
                    int index2 = randomT.nextInt(rugby.teams.size());
                //  Using the randomName variable, the player at the random index is chosen from the players list    
                    String randomName = personDetails.get(index);
                    Coach randomNameC = rugby.coaches.get(index1);
                    Team randomNameT = rugby.teams.get(index2);
                //  Printing the random player that was selected from the playerList
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Randomly selected player details: Name,Last Name,Email,Gender");
                    System.out.println("");
                    System.out.println(" ");
                    System.out.println("Aplicant information: " + randomName);
                    System.out.println("");
                    System.out.println("Coach assigned: " + randomNameC.getName());
                    System.out.println("");
                    System.out.println("Team assigned: " + randomNameT.getName());
                    System.out.println("");
                    break;
                case EXIT:
                    System.out.println("Exiting Program.");
                    break;
                default:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Invalid option please select again"); 
                    
                    break;
            }  
          }
        }while(selectOption != RCInterface.MenuOption.EXIT);
   }
}

    
    
