import java.util.ArrayList;

/**
 * Represents an obstacle in the game that the player must overcome.
 * Each obstacle has a name, a hint for the player, weaknesses, and a list of items that can be used to defeat it.
 */
public class Obstacle {

  private String name;
  private String hint;
  private ArrayList<String> weakness;
  private ArrayList<String> defeatItems;

  /**
   * Constructs a new Obstacle with the specified name and hint.
   * Initializes the weakness and defeat items lists as empty.
   *
   * @param name the name of the obstacle
   * @param hint a hint that may help the player overcome the obstacle
   */
  public Obstacle(String name, String hint) {
    this.name = name;
    this.hint = hint;
    weakness = new ArrayList<>();
    defeatItems = new ArrayList<>();
  }

  /**
   * Returns the name of the obstacle.
   *
   * @return the name of the obstacle
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the hint associated with the obstacle.
   *
   * @return the hint for the obstacle
   */
  public String getObstacleHint() {
    return this.hint;
  }

  /**
   * simulates the obstacle attacking the player,making them lose a life.
   *
   * @param p the player who is being attacked
   */
  public void attack(Player p) {
    p.loseALife();
  }

  /**
   * Adds a weakness to the obstacle.
   *
   * @param weakness the weakness to be added to the obstacle
   */
  public void addWeakness(String weakness) {
    this.weakness.add(weakness);
  }

  /**
   * Returns a list of weaknesses associated with the obstacle.
   *
   * @return a list of weaknesses for the obstacle
   */
  public ArrayList<String> getWeaknesses() {
    return this.weakness;
  }

  /**
   * Returns a list of items that can be used to defeat the obstacle.
   *
   * @return a list of items that can be used to defeat the obstacle
   */
  public ArrayList<String> getDefeatItems() {
    return this.defeatItems;
  }

  /**
   * Adds an item to the list of items that can defeat the obstacle.
   *
   * @param item the item to be added to the list of defeat items
   */
  public void addDefeatItems(String item) {
    this.defeatItems.add(item);
  }
}