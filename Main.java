public class Main {
    
    public static void main(String[] args) {
        
    livingObstacle bats= new livingObstacle ("bats");
    Obstacle imprisonment= new Obstacle("imprisonment");
    livingObstacle mosquitos= new livingObstacle("mosquitos");
    
    livingObstacle monkeys= new livingObstacle("monkeys");
    livingObstacle lion= new livingObstacle("lion");
    
    livingObstacle purpleFlowers= new livingObstacle("purple flower");
    livingObstacle pods= new livingObstacle("pods");
    livingObstacle vanPelt= new livingObstacle("Van Pelt");
    //stampede
    livingObstacle rhinos= new livingObstacle("rhinos");
    livingObstacle elephants= new livingObstacle("elephants");
    livingObstacle zebras= new livingObstacle("zebras");
    livingObstacle pelicans= new livingObstacle("pelicans");
    
    Obstacle monsoon= new Obstacle("monsoon");
    livingObstacle crocodiles= new livingObstacle("crocodiles");
    Obstacle quicksand= new Obstacle("quicksand");
    livingObstacle spiders= new livingObstacle ("spiders");
    Obstacle earthquake= new Obstacle("earthquake");

    Player moya= new Player("Moya");
    jumanjiMap jumanji= new jumanjiMap();
    
    

  

    System.out.print(moya.getLoco(jumanji));

    //for each obstacle, if you get riddle right you get help in navigating obstacle
    //abandoned house attic (bats) enter house and find tennis racket 
    
    //has to find citronella, lemongrass, or specific flowers and torches and matches maybe in cellar
    //jungle(mosquitos)
    // find an axe, spear, or rifle
    //jungle part 2 (monkeys)
    //run into house where encounter lion, if riddle is right, hint is given to help, if not, up to chance
    //axe or fire can defeat vegetation
    //pistol, rifle, evade, saber, bow and arrow
    //back to jungle(van pelt)
    // savannah strategically navigate the board, avoiding landing on spaces that trigger the stampede if riddle is right, you get help
    //rainforest, find bamboo an dtwine to make raft (monsoon and crocodiles)
    //if you get riddle right, you know where to step to avoid quicksand, if not up to chance
    //spiders can be defeated by fly-swatter, axe, spear, or rifle
    //earthquake: if riddle is right you get time to hide in shelter, else you die, if you're sucessful to just call out jukanji at heart of forest and win

    
        //house  (attic and locked cellar)
        //garden
        //jungle
        //abandoned school building
        //second jungle
        //savannah
        //rainforest
        //quicksand
        //cave
        //house in jungle



   
    

        
    }
}
