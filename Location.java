import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Represents a location in the game where the player can interact with items, obstacles, and riddles.
 * Each location can have a name, items, a riddle, a message, and an associated obstacle.
 */
public class Location {

  private String name;
  private ArrayList<String> items;
  private String riddleFile;
  private String messageFile;
  private Obstacle obstacle;
  private int level;

  /**
   * Constructs a Location with the specified name, items, and message file.
   * This constructor is used when no riddle or obstacle is associated with the location.
   *
   * @param name the name of the location
   * @param items a list of items present at the location
   * @param messageFile name of the file containing the location's message
   */
  public Location(String name, ArrayList<String> items, String messageFile) {
    this.name = name;
    this.items = items;
    this.riddleFile = null;
    this.messageFile = messageFile;
    this.level = 0;
  }

  /**
   * Constructs a Location with the specified name, items, riddle file, message file, obstacle, and level.
   * This constructor is used when the location has an associated riddle and obstacle.
   *
   * @param name the name of the location
   * @param items a list of items present at the location
   * @param riddleFile the path to the file containing the location's riddle
   * @param messageFile the path to the file containing the location's message
   * @param obstacle the obstacle present at the location
   * @param level the level associated with the location
   */
  public Location(String name, ArrayList<String> items, String riddleFile, String messageFile, Obstacle obstacle, int level) {
    this.name = name;
    this.items = items;
    this.riddleFile = riddleFile;
    this.messageFile = messageFile;
    this.obstacle = obstacle;
    this.level = level;
  }

  /**
   * Returns the name of the location.
   *
   * @return the name of the location
   */
  public String getName() {
    return this.name;
  }

  /**
   * Prints the message associated with the location by reading from the specified message file.
   * If the file cannot be read, an error message is displayed.
   */
  public void printMessage() {
    try (BufferedReader br = new BufferedReader(new FileReader(this.messageFile))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println("Error Message: " + e.getMessage());
    }
  }

  /**
   * Prints the riddle associated with the location by reading from the specified riddle file.
   * If the file cannot be read, an error message is displayed.
   */
  public void printRiddle() {
    try (BufferedReader br = new BufferedReader(new FileReader(this.riddleFile))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println("Error Message: " + e.getMessage());
    }
  }

  /**
   * Returns the list of items present at the location.
   *
   * @return a list of items at the location
   */
  public ArrayList<String> getItems() {
    return this.items;
  }

  /**
   * Prints the list of items present at the location.
   * If there are no items, it prints a message indicating that the location has no items.
   */
  public void printItems() {
    System.out.println("Items in this location:");
    if (this.items != null && !this.items.isEmpty()) {
      for (String item : this.items) {
        System.out.println("- " + item);
      }
    } else {
      System.out.println("No items available in this location.");
    }
  }

  /**
   * Returns the level associated with the location.
   *
   * @return the level of the location
   */
  public int getLevel() {
    return this.level;
  }

  /**
   * Returns the obstacle associated with the location.
   *
   * @return the obstacle at this location
   */
  public Obstacle getObstacle() {
    return this.obstacle;
  }

  /**
   * Removes the specified item from the location's item list.
   * If the item is not present, nothing happens.
   *
   * @param item the item to remove from the location
   */
  public void removeItem(String item) {
    if (items.contains(item)) {
      items.remove(item);
    }
  }

  /**
   * Adds an item to the location's item list.
   *
   * @param item the item to add to the location
   */
  public void addItem(String item) {
    items.add(item);
  }
}