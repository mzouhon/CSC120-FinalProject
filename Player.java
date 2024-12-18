import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the game, with attributes such as name, inventory, lives, position, and level.
 * The player can move, manage an inventory, lose lives, and level up.
 */
public class Player {

  private String name;
  private ArrayList<String> inventory;
  private int lives;
  private boolean isAlive;
  private int row;
  private int column;
  private int level;

  /**
   * Constructs a new Player with the specified name. 
   * Initializes the player with 3 lives, an empty inventory, 
   * starting position at (0, 0), and level 1.
   *
   * @param name the name of the player
   */
  public Player(String name) {
    this.name = name;
    this.lives = 3;
    this.inventory = new ArrayList<>();
    this.isAlive = true;
    row = 0;
    column = 0;
    this.level = 1;
  }

  /**
   * Returns the current location of the player on a Jumanji map.
   *
   * @param map the Jumanji map object
   * @return the location of the player on the map
   */
  public Location getLoco(jumanjiMap map) {
    return (map.getMap()[this.row][this.column]);
  }

  /**
   * Returns the player's inventory as a list of items.
   *
   * @return a list of items in the player's inventory
   */
  public ArrayList<String> getInventory() {
    return inventory;
  }

  /**
   * Adds an item to the player's inventory.
   *
   * @param item the item to be added to the inventory
   */
  public void addItemToInventory(String item) {
    this.inventory.add(item);
  }

  /**
   * Removes an item from the player's inventory.
   * If the item is not in the inventory, nothing happens.
   *
   * @param item the item to be removed from the inventory
   */
  public void removeItemFromInventory(String item) {
    if (this.inventory.contains(item)) {
      this.inventory.remove(item);
    }
  }

  /**
   * Returns the number of lives the player has left.
   *
   * @return the number of lives remaining
   */
  public int getLivesLeft() {
    return lives;
  }

  /**
   * Decreases the player's life by one and returns the updated number of lives.
   *
   * @return the number of lives after the decrease
   */
  public int loseALife() {
    lives--;
    return lives;
  }

  /**
   * Checks whether the player is still alive based on their remaining lives.
   * If the player's lives are 0, the player is marked as dead.
   *
   * @return true if the player is alive, false otherwise
   */
  public boolean isAlive() {
    int livesLeft = this.getLivesLeft();
    if (livesLeft == 0) {
      isAlive = false;
    }
    return isAlive;
  }

  /**
   * Returns the player's current level.
   *
   * @return the current level of the player
   */
  public int getLevel() {
    return this.level;
  }

  /**
   * Increments the player's level by 1 and returns the updated level.
   *
   * @return the player's new level
   */
  public int levelUp() {
    this.level++;
    return this.level;
  }

  /**
   * Moves the player in the specified direction 
   * if the move is within the bounds of the game map 
   * Prints an error message if the move is invalid or out of bounds.
   *
   * @param direction the direction to move the player in
   * @return true if the move was successful, false otherwise
   */
  public boolean move(String direction) {
    String directionUpperCase = direction.toUpperCase();

    if (!(directionUpperCase.contains("NORTH") || directionUpperCase.contains("SOUTH") || directionUpperCase.contains("WEST") || directionUpperCase.contains("EAST"))) {
      System.out.println("Invalid Move: " + direction);
      return false;
    }

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

  /**
   * Prints the player's inventory 
   * If the inventory is empty, it prints a message indicating that the inventory is empty.
   */
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

  /**
   * Checks whether the player has at least one item from a list of defeat items for an obstacle.
   *
   * @param defeatItems a list of items that can be used to defeat an obstacle
   * @return true if the player has at least one of the defeat items, false otherwise
   */
  public boolean hasAtLeastOneDefeatItem(List<String> defeatItems) {
    for (String item : defeatItems) {
      if (inventory.contains(item)) {
        return true;
      }
    }
    return false;
  }
}