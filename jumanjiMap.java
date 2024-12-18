import java.util.ArrayList;

/**
 * Represents the map of the Jumanji game world, consisting of various locations
 * such as houses, fields, jungles, caves, and obstacles.
 * <p>
 * This class initializes a 5x5 grid of locations, where each location can contain items,
 * obstacles, and messages. The map also keeps track of the obstacles' weaknesses and 
 * how players can defeat them using items they collect during the game.
 * </p>
 */
public class jumanjiMap {


  private Location[][] map;

  private Location house;
  private Location garden;
  private Location openField1;
  private Location openField2;
  private Location school;
  private Location openField3;
  private Location jungle1;
  private Location jungle2;
  private Location jungle3;
  private Location openField4;
  private Location openField5;
  private Location jungle4;
  private Location heartOfJungle;
  private Location jungle6;
  private Location rainforest;
  private Location openField6;
  private Location jungle7;
  private Location jungle8;
  private Location jungle9;
  private Location openField7;
  private Location cave;
  private Location openField8;
  private Location openField9;
  private Location quicksandLoco;
  private Location savannah;

  private Obstacle bats;
  private Obstacle mosquitos;
  private Obstacle monkeys;
  private Obstacle lion;
  private Obstacle purpleFlowersAndPods;
  private Obstacle stampede;
  private Obstacle monsoonAndCrocs;
  private Obstacle quicksand;
  private Obstacle spiders;
  private Obstacle earthquake;

  private ArrayList < String > houseItems = new ArrayList < > ();
  private ArrayList < String > gardenItems = new ArrayList < > ();
  private ArrayList < String > openField3Items = new ArrayList < > ();
  private ArrayList < String > jungleItems = new ArrayList < > ();
  private ArrayList < String > rainforestItems = new ArrayList < > ();
  private ArrayList < String > caveItems = new ArrayList < > ();
  private ArrayList < String > menialItems = new ArrayList < > ();

  /**
   * Constructs the Jumanji map and initializes the locations, obstacles, and items.
   * 
   * sets up a 5x5 grid of locations, populates each location with 
   * items, defines obstacles and their weaknesses, and places obstacles at specific
   * locations on the map. It also initializes the obstacles' defeat conditions.
   * 
   */
  public jumanjiMap() {
    map = new Location[5][5];

    houseItems.add("tennis racket"); 
    houseItems.add("basket of roses");
    bats = new Obstacle("bats", "Have you ever played tennis with a bat? I've heard they bounce.");
    house = new Location("house", houseItems, "houseRiddle.txt", "houseMessage.txt", bats, 1);
    bats.addWeakness("USE TENNIS RACKET");
    bats.addDefeatItems("TENNIS RACKET");

    gardenItems.add("roses");
    gardenItems.add("violets");
    gardenItems.add("citronella");
    gardenItems.add("lemongrass");
    garden = new Location("garden", gardenItems, "gardenMessage.txt");

    menialItems.add("air");
    openField1 = new Location("open field", new ArrayList < > (menialItems), "openFieldMessage.txt");
    openField2 = new Location("open field", new ArrayList < > (menialItems), "openFieldMessage.txt");

    openField3Items.add("matches");
    openField3Items.add("axe");
    openField3Items.add("spear");
    openField3Items.add("rifle");

    openField3 = new Location("open field", openField3Items, "openFieldMessage.txt");

    openField4 = new Location("open field", new ArrayList < > (menialItems), "openFieldMessage.txt");
    openField5 = new Location("open field", new ArrayList < > (menialItems), "openFieldMessage.txt");
    openField6 = new Location("open field", new ArrayList < > (menialItems), "openFieldMessage.txt");
    openField7 = new Location("open field", new ArrayList < > (menialItems), "openFieldMessage.txt");
    openField8 = new Location("open field", new ArrayList < > (menialItems), "openFieldMessage.txt");
    openField9 = new Location("open field", new ArrayList < > (menialItems), "openFieldMessage.txt");

    jungleItems.add("branches");

    mosquitos = new Obstacle("mosquitos", "Mosquitos despise the chemical compounds in citronella and lemongrass. But you could always just torch them.");
    jungle2 = new Location("jungle", new ArrayList < > (jungleItems), "firstJungleRiddle.txt", "firstJungleMessage.txt", mosquitos, 2);
    mosquitos.addWeakness("USE CITRONELLA");
    mosquitos.addWeakness("USE LEMONGRASS");
    mosquitos.addWeakness("MAKE FIRE");
    mosquitos.addDefeatItems("CITRONELLA");
    mosquitos.addDefeatItems("LEMONGRASS");
    mosquitos.addDefeatItems("MATCHES");

    monkeys = new Obstacle("monkeys", "Axes, spears, and rifles always come in handy in the jungle.");
    jungle8 = new Location("jungle", new ArrayList < > (jungleItems), "secondJungleRiddle.txt", "secondJungleMessage.txt", monkeys, 3);
    monkeys.addWeakness("USE AXE");
    monkeys.addWeakness("USE SPEAR");
    monkeys.addWeakness("USE RIFLE");
    monkeys.addDefeatItems("AXE");
    monkeys.addDefeatItems("SPEAR");
    monkeys.addDefeatItems("RIFLE");

    purpleFlowersAndPods = new Obstacle("purple flowers and pods", "Have you ever tried dehydrating your vegetation?");
    purpleFlowersAndPods.addWeakness("MAKE FIRE");
    purpleFlowersAndPods.addDefeatItems("MATCHES");

    jungle4 = new Location("jungle", new ArrayList < > (jungleItems), "vegetationRiddle.txt", "jungleMessage.txt", purpleFlowersAndPods, 5);

    earthquake = new Obstacle("earthquake", "You might want to build yourself a shelter.");
    heartOfJungle = new Location("heart of jungle", new ArrayList < > (menialItems), "heartOfJungleRiddle.txt", "heartOfJungleMessage.txt", earthquake, 10);
    earthquake.addWeakness("BUILD SHELTER");
    earthquake.addDefeatItems("BRANCHES");

    jungle1 = new Location("jungle", new ArrayList < > (jungleItems), "jungleMessage.txt");
    jungle3 = new Location("jungle", new ArrayList < > (jungleItems), "jungleMessage.txt");

    jungle6 = new Location("jungle", new ArrayList < > (jungleItems), "jungleMessage.txt");
    jungle7 = new Location("jungle", new ArrayList < > (jungleItems), "jungleMessage.txt");

    jungle9 = new Location("jungle", new ArrayList < > (jungleItems), "jungleMessage.txt");

    lion = new Obstacle("lion", "Don't run.");
    school = new Location("school", new ArrayList < > (menialItems), "schoolRiddle.txt", "schoolMessage.txt", lion, 4);
    lion.addWeakness("DON'T RUN");

    stampede = new Obstacle("rhinos and elephants and zebras and pelicans", "Try running in a zigzag pattern.");
    savannah = new Location("savannah", new ArrayList < > (menialItems), "savannahRiddle.txt", "savannahMessage.txt", stampede, 6);
    stampede.addWeakness("RUN ZIGZAG");

    rainforestItems.add("bamboo and twine");
    monsoonAndCrocs = new Obstacle("monsoon and crocodiles", "You may not be able to outrun them but you can certainly outraft them.");
    rainforest = new Location("rainforest", rainforestItems, "rainforestRiddle.txt", "rainforestMessage.txt", monsoonAndCrocs, 7);
    monsoonAndCrocs.addWeakness("BUILD RAFT");
    purpleFlowersAndPods.addDefeatItems("BAMBOO AND TWINE");
    monsoonAndCrocs.addDefeatItems("BRANCHES");

    quicksand = new Obstacle("quicksand", "step pattern: left left left right left");
    quicksandLoco = new Location("quicksand area", new ArrayList < > (menialItems), "quicksandRiddle.txt", "quicksandMessage.txt", quicksand, 8);
    quicksand.addWeakness("LEFT LEFT LEFT RIGHT LEFT");

    caveItems.add("sword");
    caveItems.add("bow and arrow");
    spiders = new Obstacle("spiders", "How much damage can you really do with a bow and arrow? Use your brain.");
    cave = new Location("cave", caveItems, "caveRiddle.txt", "caveMessage.txt", spiders, 9);
    spiders.addWeakness("USE SWORD");
    spiders.addDefeatItems("SWORD");

    Location[] locations = {
      house,
      garden,
      openField1,
      openField2,
      school,
      openField3,
      jungle1,
      jungle2,
      jungle3,
      openField4,
      openField5,
      jungle4,
      heartOfJungle,
      jungle6,
      rainforest,
      openField6,
      jungle7,
      jungle8,
      jungle9,
      openField7,
      cave,
      openField8,
      openField9,
      quicksandLoco,
      savannah
    };

    int locationIndex = 0;

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        map[i][j] = locations[locationIndex];
        locationIndex++;

      }
    }
  }

  /**
   * Returns the 2D array representing the map of Jumanji.
   * 
   * @return a 2D array of Location objects.
   */
  public Location[][] getMap() {
    return (this.map);
  }

   /**
   * Prints the entire map
   */
  public void print() {

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println(this.map[i][j]);
      }
    }

  }

}
