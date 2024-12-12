import java.util.Scanner;

public class gameLoop {

    public static void main(String[] args) {
        // Initialize game components
        Scanner userInput = new Scanner(System.in);

        // Create a new game map
        jumanjiMap map = new jumanjiMap();
        
        

        // Create a new player
        System.out.print("Enter your player name: ");
        String playerName = userInput.nextLine();
        Player player = new Player(playerName);

        // Start the game
        System.out.println("******************");
        System.out.println("WELCOME TO JUMANJI");
        System.out.println("******************");

        // Game loop
        boolean stillPlaying = true;
        while (stillPlaying) {
            // Display current location and options
            Location currentLocation = player.getLoco(map);

            // Read and display the message for the current location
            currentLocation.printMessage();

           

            // wait for a command
            String userResponse = userInput.nextLine().toUpperCase();

            
            if (userResponse.contains("MOVE")) {
                
                while(player.move(userResponse)==false){
                    userResponse=userInput.nextLine().toUpperCase();
                    player.move(userResponse);

                }
                currentLocation = player.getLoco(map);

                
                // Handle obstacles (if any)
                //if (player.getLevel()==currentLocation.getLevel()){
                    //currentLocation.printRiddle();
                    //System.out.println("Type what you believe is the answer to this riddle.");
                   // String answer = userInput.nextLine();
                    //if (answer.contains(currentLocation"))
                //}

                // Check if the player is alive
                if (!player.isAlive()) {
                    System.out.println("You have died! Game over.");
                    stillPlaying = false;
                }

            }else if(userResponse.contains("ENTER")){
                if(currentLocation.getName().contains("house") && player.getLevel()==currentLocation.getLevel()){
                    currentLocation.printRiddle();
                    String answer=userInput.nextLine().toUpperCase();
                    if (answer.contains("BATS")) {
                        System.out.println(currentLocation.getObstacle().getObstacleHint());
                    }
                }

            


            } else if (userResponse.contains("PICKUP")) {
                // Ask for item to pick up
                System.out.print("Enter the name of the item to pick up: ");
                String itemName = userInput.nextLine();
                Location location = player.getLoco(map);
                if (location.getItems().contains(itemName)) {
                    player.addItemToInventory(itemName);
                    location.getItems().remove(itemName);
                    System.out.println("You picked up: " + itemName);
                } else {
                    System.out.println("Item not found in this location.");
                }

            } else if (userResponse.equals("EXIT")) {
                System.out.println("Thanks for playing!");
                stillPlaying = false;

            } else {
                System.out.println("Invalid option, please try again.");
            }

            // Check for win/lose conditions
            if (player.getLivesLeft() <= 0) {
                System.out.println("You have no lives left. Better luck next time!");
                stillPlaying = false;
            }
        }

        userInput.close();
    }
}