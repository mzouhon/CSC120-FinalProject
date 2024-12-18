import java.util.Scanner;

/**
 * The main game loop for the Jumanji game. This class handles user input,
 * the game flow, and manages the interaction between the player and the game world.
 * The player navigates through a map, solves riddles, encounters obstacles,
 * and collects or puts down items during the game.
 */

public class gameLoop {

  public static void main(String[] args) {
    
    Scanner userInput = new Scanner(System.in);

    jumanjiMap map = new jumanjiMap();

    // Create a new player
    System.out.print("Enter your player name: ");
    String playerName = userInput.nextLine();
    Player player = new Player(playerName);

    // Start the game
    System.out.println("******************");
    System.out.println("WELCOME TO JUMANJI");
    System.out.println("******************");

    // Display current location and options
    Location currentLocation = player.getLoco(map);

    // Read and display the message for the current location
    currentLocation.printMessage();
    currentLocation.printItems();

    // Game loop
    boolean stillPlaying = true;
    while (stillPlaying) {

      // Wait for a command
      String userResponse = userInput.nextLine().toUpperCase();
    
      //handles move command
      if (userResponse.contains("MOVE")) {

        while (player.move(userResponse) == false) {
          userResponse = userInput.nextLine().toUpperCase();
        }
        currentLocation = player.getLoco(map);
        currentLocation.printMessage();
        currentLocation.printItems();

        if ((currentLocation.getLevel() == player.getLevel()) && (!currentLocation.getName().equals("house")) && (!currentLocation.getName().equals("cave")) && (!currentLocation.getName().equals("heart of jungle"))) {

          currentLocation.printRiddle();
          System.out.println("Your character is currently on lockdown and you cannot do anything until you've answered the riddle. Any input entered will be interpreted as your answer.");
          String answer = userInput.nextLine().toUpperCase();

          if (answer.contains(currentLocation.getObstacle().getName().toUpperCase())) {
            System.out.println("Your answer was correct, here's a hint to help you defeat the " + currentLocation.getObstacle().getName() + ": " + currentLocation.getObstacle().getObstacleHint());
          } else {
            System.out.println("Your answer was incorrect. The " + currentLocation.getObstacle().getName() + " are here, make your move now!");
            player.printInventory();
          }

          answer = userInput.nextLine().toUpperCase();

          if (currentLocation.getObstacle().getWeaknesses().contains(answer)) {
            if (currentLocation.getObstacle().getDefeatItems().isEmpty()) {
              System.out.println("You've successfully defeated the " + currentLocation.getObstacle().getName() + ".");
            } else if (player.hasAtLeastOneDefeatItem(currentLocation.getObstacle().getDefeatItems())) {
              System.out.println("You've successfully defeated the " + currentLocation.getObstacle().getName() + ".");
            } else {
              currentLocation.getObstacle().attack(player);
              System.out.println("The " + currentLocation.getObstacle().getName() + " has killed you.");
              System.out.println("Lives left: " + player.getLivesLeft());

              if (!player.isAlive()) {
                System.out.println("You have died! Game over.");
                stillPlaying = false;
              }
            }
          } else {
            currentLocation.getObstacle().attack(player);
            System.out.println("The " + currentLocation.getObstacle().getName() + " has killed you.");
            System.out.println("Lives left: " + player.getLivesLeft());
            if (!player.isAlive()) {
              System.out.println("You have died! Game over.");
              stillPlaying = false;
            }
          }
          player.levelUp();

        }
        //handles enter command
      } else if (userResponse.contains("ENTER")) {
        
        // Handle special locations (house, cave, heart of jungle)

        if (userResponse.contains("HOUSE") && currentLocation.getName().contains("house")) {
          System.out.println("You have entered the house.");

          if (player.getLevel() == 1) {

            currentLocation.printRiddle();
            System.out.println("Your character is currently on lockdown and you cannot do anything until you've answered the riddle. Any input entered will be interpreted as your answer.");
            String answer = userInput.nextLine().toUpperCase();

            if (answer.contains("BATS")) {
              System.out.println("Your answer was correct, here's a hint to help you defeat the bats: " + currentLocation.getObstacle().getObstacleHint());
            } else {
              System.out.println("Your answer was incorrect. The bats are here, make your move now!");
            }

            player.printInventory();
            answer = userInput.nextLine().toUpperCase();
            if (currentLocation.getObstacle().getWeaknesses().contains(answer) && player.getInventory().contains("TENNIS RACKET")) {
              System.out.println("You've successfully defeated the bats.");
            } else {
              currentLocation.getObstacle().attack(player);
              System.out.println("The bats have killed you.");
              System.out.println("Lives left: " + player.getLivesLeft());
              if (!player.isAlive()) {
                System.out.println("You have died! Game over.");
                stillPlaying = false;
              }
            }
            player.levelUp();

          }
          // Ensure the player exits before moving again
          String answer = userInput.nextLine().toUpperCase();
          while (!answer.contains("EXIT HOUSE")) {
            System.out.println("You must exit the house before you can resume moving around the map.");
            answer = userInput.nextLine().toUpperCase();
          }
          System.out.println("You have exited the house");

        } else if (userResponse.contains("CAVE") && currentLocation.getName().contains("cave")) {
          System.out.println("You have entered the cave.");

          if (player.getLevel() == 9) {

            currentLocation.printRiddle();
            System.out.println("Your character is currently on lockdown and you cannot do anything until you've answered the riddle. Any input entered will be interpreted as your answer.");
            String answer = userInput.nextLine().toUpperCase();

            if (answer.contains("SPIDERS")) {
              System.out.println("Your answer was correct, here's a hint to help you defeat the spiders: " + currentLocation.getObstacle().getObstacleHint());
            } else {
              System.out.println("Your answer was incorrect. The spiders are here, make your move now!");
            }
            player.printInventory();
            answer = userInput.nextLine().toUpperCase();
            if (currentLocation.getObstacle().getWeaknesses().contains(answer) && player.getInventory().contains("SWORD")) {
              System.out.println("You've successfully defeated the spiders.");
            } else {
              currentLocation.getObstacle().attack(player);
              System.out.println("The spiders have killed you.");
              System.out.println("Lives left: " + player.getLivesLeft());
              if (!player.isAlive()) {
                System.out.println("You have died! Game over.");
                stillPlaying = false;
              }
            }
            player.levelUp();

          }

          // Ensure the player exits before moving again
          String answer = userInput.nextLine().toUpperCase();
          while (!answer.contains("EXIT CAVE")) {
            System.out.println("You must exit the cave before you can resume moving around the map.");
            answer = userInput.nextLine().toUpperCase();
          }
          System.out.println("You have exited the cave");

        } else if (userResponse.contains("HEART OF JUNGLE") && currentLocation.getName().contains("heart of jungle")) {
          System.out.println("You have entered the heart of the jungle");

          if (player.getLevel() == 10) {

            currentLocation.printRiddle();
            System.out.println("Your character is currently on lockdown and you cannot do anything until you've answered the riddle. Any input entered will be interpreted as your answer.");
            String answer = userInput.nextLine().toUpperCase();

            if (answer.contains("EARTHQUAKE")) {
              System.out.println("Your answer was correct, here's a hint to help you survive the earthquake: " + currentLocation.getObstacle().getObstacleHint());
            } else {
              System.out.println("Your answer was incorrect. The earthquake is here, make your move now!");
            }

            player.printInventory();
            answer = userInput.nextLine().toUpperCase();
            if (currentLocation.getObstacle().getWeaknesses().contains(answer) && player.getInventory().contains("BRANCHES")) {
              System.out.println("You've successfully survived the earthquake.");
              System.out.println("Congratulations. You have won the game and escaped Jumanji!");
              break;

            } else {
              currentLocation.getObstacle().attack(player);
              System.out.println("The earthquake has killed you.");
              System.out.println("Lives left: " + player.getLivesLeft());
              if (!player.isAlive()) {
                System.out.println("You have died! Game over.");
                stillPlaying = false;
              }
              System.out.println("Congratulations. You have won the game and escaped Jumanji!");
              break;
            }

          }

          // Ensure the player exits before moving again
          String answer = userInput.nextLine().toUpperCase();
          while (!answer.contains("EXIT HEART OF JUNGLE")) {
            System.out.println("You must exit the heart of the jungle before you can resume moving around the map.");
            answer = userInput.nextLine().toUpperCase();
          }
          System.out.println("You have exited the heart of the jungle");

        } else {
          System.out.println("That cannot be entered at the moment.");
        }
        //handles pickup command
      } else if (userResponse.toUpperCase().contains("PICKUP")) {

        int spaceIndex = userResponse.indexOf(" ");
        if (spaceIndex != -1) {
          String itemName = userResponse.substring(spaceIndex + 1).trim(); // get item name
          Location location = player.getLoco(map);

          if (location.getItems().contains(itemName.toLowerCase())) {
            player.addItemToInventory(itemName); 
            location.removeItem(itemName.toLowerCase());;
            System.out.println("You picked up: " + itemName);

          } else {
            System.out.println("Item not found in this location.");
          }
        } else {
          System.out.println("Please specify the item you want to pick up.");
        }
        //handles putdown command
      } else if (userResponse.toUpperCase().contains("PUTDOWN")) {
        
        int spaceIndex = userResponse.indexOf(" ");
        if (spaceIndex != -1) {
          String itemName = userResponse.substring(spaceIndex + 1).trim(); // get item name
          Location location = player.getLoco(map);

          
          if (player.getInventory().contains(itemName.toUpperCase())) {
            player.removeItemFromInventory(itemName.toUpperCase()); 
            location.addItem(itemName.toLowerCase()); 
            System.out.println("You put down: " + itemName);
          } else {
            System.out.println("You don't have that item in your inventory.");
          }
        } else {
          System.out.println("Please specify the item you want to put down.");
        }
        //handles exit game command
      } else if (userResponse.equals("EXIT GAME")) {
        System.out.println("Thanks for playing!");
        stillPlaying = false;

        //handles all other commands
      } else {
        System.out.println("Invalid option, please try again.");
      }
    }
    userInput.close();

  }
}
