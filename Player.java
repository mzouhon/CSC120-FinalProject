import java.util.ArrayList;




public class Player {

    private String name;
    private ArrayList<String> inventory; //will eventually become an arraylist of items
    private int lives;
    private boolean isAlive;
    private int row;
    private int column;






    // Constructor
    public Player(String name) {
        this.name = name;
        this.lives = 3;
        this.inventory = new ArrayList<>();
        this.isAlive = true;
        row=0;
        column=0;
    

    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getLoco(jumanjiMap a){
        return (a.getMap()[this.row][this.column]);
    }


    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void addItemToInventory(String item) {
        this.inventory.add(item);
    }

    public double getLivesLeft() {
        return lives;
    }

    public double loseALife() {
        lives--;
        return lives;
    }


    public boolean isAlive() {
        return isAlive;
    }



    public void move(String direction) {
        String directionUpperCase = direction.toUpperCase();  // Convert direction to uppercase once to avoid multiple calls
    
        // Check if the direction is valid
        if (!(directionUpperCase.equals("NORTH") || directionUpperCase.equals("SOUTH") ||
              directionUpperCase.equals("WEST") || directionUpperCase.equals("EAST"))) {
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    
        // Perform movement based on direction
        if (directionUpperCase.equals("NORTH") && this.row > 0) {
            this.row--;
        } else if (directionUpperCase.equals("SOUTH") && this.row < 5) {
            this.row++;
        } else if (directionUpperCase.equals("WEST") && this.column > 0) {
            this.column--;
        } else if (directionUpperCase.equals("EAST") && this.column < 5) {
            this.column++;
        } else {
            throw new IllegalArgumentException("Movement out of bounds: Cannot move " + directionUpperCase);
        }
    }

// displays player health status, inventory, name, and other useful attributes 
    public void displayPlayerStatus() {
        System.out.println("Player: " + name);
        System.out.println("Lives Left: " + lives);
        System.out.println("Inventory: " + inventory);
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println(name + "'s inventory is empty.");
        } else {
            System.out.println(name + "'s Inventory:");
            for (String item : inventory) {
                System.out.println("- " + item);
            }
        }
    }
}