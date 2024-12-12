import java.util.ArrayList;




public class Player {

    private String name;
    private ArrayList<String> inventory; 
    private int lives;
    private boolean isAlive;
    private int row;
    private int column;
    private int level;






    // Constructor
    public Player(String name) {
        this.name = name;
        this.lives = 3;
        this.inventory = new ArrayList<>();
        this.isAlive = true;
        row=0;
        column=0;
        this.level=1;
    

    }


    public Location getLoco(jumanjiMap a){
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

    public int getLevel(){
        return (this.level);
    }

    public boolean move(String direction) {
        String directionUpperCase = direction.toUpperCase();  // Convert direction to uppercase once to avoid multiple calls
    
        // Check if the direction is valid
        if (!(directionUpperCase.contains("NORTH") || directionUpperCase.contains("SOUTH") ||
              directionUpperCase.contains("WEST") || directionUpperCase.contains("EAST"))) {
            System.out.println("Invalid Move: " + direction);
            return false;
        }
    
        // Perform movement based on direction
        if (directionUpperCase.contains("NORTH") && this.row > 0) {
            this.row--;
            return true;
        } else if (directionUpperCase.contains("SOUTH") && this.row < 4) {
            this.row++;
            return true;
        } else if (directionUpperCase.contains("WEST") && this.column > 0) {
            this.column--;
            return true;
        } else if (directionUpperCase.contains("EAST") && this.column < 4) {
            this.column++;
            return true;
        } else {
            System.out.println("Movement out of bounds: " + directionUpperCase);
            return false;
        }
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