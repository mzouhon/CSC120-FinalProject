import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Location {

    private String name;
    private ArrayList<String> items;
    private String riddleFile;
    private String messageFile;
    private Obstacle obstacle;
    private int level;
    
    

    
    public Location(String name, ArrayList<String> items, String messageFile){
        this.name=name;
        this.items=items;
        this.riddleFile=null;
        this.messageFile=messageFile;
        this.level=0;
        
    }

    public Location(String name, ArrayList<String> items, String riddleFile, String messageFile, Obstacle obstacle, int level){
        this.name=name;
        this.items=items;
        this.riddleFile=riddleFile;
        this.messageFile=messageFile;
        this.obstacle=obstacle;
        this.level=level;
    }


    public String getName(){
        return (this.name);
    }

    public void printMessage(){
        
    try(BufferedReader br = new BufferedReader(new FileReader(this.messageFile))){;
        String line;
   
        while ((line = br.readLine()) != null) {
               System.out.println(line);
           }
   
       }catch (IOException e){
           System.err.println("Error Message `: " + e.getMessage());
       }
   
    }

    public void printRiddle(){
        try(BufferedReader br = new BufferedReader(new FileReader(this.riddleFile))){;
            String line;
       
            while ((line = br.readLine()) != null) {
                   System.out.println(line);
               }
       
           }catch (IOException e){
               System.err.println("Error Message `: " + e.getMessage());
           }  
    }

    public ArrayList<String> getItems(){
        return (this.items);
    }

    public int getLevel(){
        return (this.level);
    }

    public Obstacle getObstacle(){
        return (this.obstacle);
    }


}
