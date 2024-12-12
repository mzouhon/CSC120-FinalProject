import java.util.ArrayList;

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
    
    
    private livingObstacle bats;
    private livingObstacle mosquitos;
    private livingObstacle monkeys;
    private  livingObstacle lion;
    private livingObstacle purpleFlowersAndPods;
    //private livingObstacle vanPelt;
    private livingObstacle stampede;
    private Obstacle monsoonAndCrocs;
    private Obstacle quicksand;
    private livingObstacle spiders;
    private Obstacle earthquake;
    
    
    
    private ArrayList<String> houseItems = new ArrayList<>();
    private ArrayList<String> gardenItems = new ArrayList<>();
    private ArrayList<String> openFieldItems = new ArrayList<>();
    private ArrayList<String> junglePart1Items = new ArrayList<>();
    private ArrayList<String> junglePart2Items = new ArrayList<>();
    
    private ArrayList<String> rainforestItems = new ArrayList<>();
    private ArrayList<String> caveItems = new ArrayList<>();




     public jumanjiMap() {
      map = new Location[5][5];
      

        houseItems.add("tennis racket");  // Found in the attic to fight bats
        bats= new livingObstacle ("bats","Have you ever played tennis with a bat? I've heard they bounce.");
        house=new Location("house", houseItems,"houseRiddle.txt","houseMessage.txt",bats,1);
        
        gardenItems.add("roses");
        gardenItems.add("violets");
        gardenItems.add("citronella");
        gardenItems.add("lemongrass");
        garden= new Location("garden",gardenItems,"gardenMessage.txt");

        
        openField1=new Location("open field",openFieldItems,"openFieldMessage.txt");
        openField2=new Location("open field",openFieldItems,"openFieldMessage.txt");
        openField3=new Location("open field",openFieldItems,"openFieldMessage.txt");
        openField4=new Location("open field",openFieldItems,"openFieldMessage.txt");
        openField5=new Location("open field",openFieldItems,"openFieldMessage.txt");
        openField6=new Location("open field",openFieldItems,"openFieldMessage.txt");
        openField7=new Location("open field",openFieldItems,"openFieldMessage.txt");
        openField8=new Location("open field",openFieldItems,"openFieldMessage.txt");
        openField9=new Location("open field",openFieldItems,"openFieldMessage.txt");


       
        junglePart1Items.add("axe");  // To fight vegetation or animals
        mosquitos= new livingObstacle("mosquitos","Mosquitos despise the chemical compounds in citronella and lemongrass. But you could always just torch them.");
        jungle2=new Location("jungle",junglePart1Items,"firstJungleRiddle.txt","firstJungleMessage.txt", mosquitos,2);
        
        junglePart2Items.add("rifle");  // Needed to fight monkeys
        junglePart2Items.add("spear"); 
        junglePart2Items.add("matches"); 
        junglePart2Items.add("torch"); 
        monkeys= new livingObstacle("monkeys", "Axes, spears, and rifles always come in handy in the jungle.");
        jungle8= new Location("jungle", junglePart2Items, "secondJungleRiddle.txt","secondJungleMessage.txt", monkeys,3);
        
        purpleFlowersAndPods= new livingObstacle("purple flowers and pods","Have you ever tried dehydrating your vegetation?");

        jungle4= new Location("jungle",null,"vegetationRiddle","jungleMessage.txt",purpleFlowersAndPods,5);
        
        earthquake= new Obstacle("earthquake","You might want to build yourself a shelter.");
        heartOfJungle= new Location("heart of jungle",null,"heartOfJungleRiddle.txt","heartOfJungleMessage.txt",earthquake,10);

        jungle1= new Location("jungle",null,"jungleMessage.txt");
        jungle3= new Location("jungle",null,"jungleMessage.txt");
        
        jungle6= new Location("jungle",null,"jungleMessage.txt");
        jungle7= new Location("jungle",null,"jungleMessage.txt");
        jungle8= new Location("jungle",null,"jungleMessage.txt");
        jungle9= new Location("jungle",null,"jungleMessage.txt");

        lion= new livingObstacle("lion", "Whatever you do, don't run.");
        school=new Location("school",null,"schoolRiddle.txt", "schoolMessage.txt", lion,4);

        stampede= new livingObstacle("rhinos and elephants and zebras and pelicans", "Try running in a zigzag pattern.");
        
        savannah= new Location("savannah", null, "savannahRiddle.txt","savannahMessage.txt",stampede,6);

        rainforestItems.add("bamboo");
        rainforestItems.add("twine");
        monsoonAndCrocs= new Obstacle("monsoon and crocodiles","You may not be able to outrun them but you can certainly outraft them.");
        rainforest= new Location("rainforest", rainforestItems, "rainforestRiddle.txt","rainforestMessage.txt",monsoonAndCrocs,7);

        quicksand= new Obstacle("quicksand","step pattern: left left, left right left");
        quicksandLoco= new Location("quicksand area",null, "quicksandRiddle.txt", "quicksandMessage.txt",quicksand,8);
        
       caveItems.add("sword");
       caveItems.add("bow and arrow");
       spiders= new livingObstacle ("spiders", "How much damage can you really do with a bow and arrow? Use your brain.");
       cave=new Location("cave", caveItems,"caveRiddle.txt","caveMessage.txt",spiders,9);

       Location [] locations={house, garden, openField1, openField2, school,openField3, jungle1, jungle2, jungle3, openField4, openField5,jungle4,heartOfJungle, jungle6, rainforest, openField6, jungle7, jungle8, jungle9, openField7, cave, openField8, openField9, quicksandLoco, savannah};



        int locationIndex=0; 

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) { 
                map[i][j] = locations[locationIndex];
                locationIndex++;
                
            }
        }
    }

    public Location[][] getMap(){
        return (this.map);
    }

    public void print(){

        

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) { 
                System.out.println(this.map[i][j]);
            }
        }

    }
    
}
