import java.util.ArrayList;
public class Location {

    private String name;
    private ArrayList<String> items;
    private String riddleFile;
    private String messageFile;
    

    
    public Location(String name, ArrayList<String> items, String messageFile){
        this.name=name;
        this.items=items;
        this.riddleFile=null;
        this.messageFile=messageFile;
    }

    public Location(String name, ArrayList<String> items, String riddleFile, String messageFile, Obstacle a){
        this.name=name;
        this.items=items;
        this.riddleFile=riddleFile;
        this.messageFile=messageFile;
        
        ArrayList <Obstacle> obstacles= new ArrayList<>();
        obstacles.add(a);
    }

    public Location(String name, ArrayList<String> items, String riddleFile, String messageFile, Obstacle a, Obstacle b ){
        this.name=name;
        this.items=items;
        this.riddleFile=riddleFile;
        this.messageFile=messageFile;

        ArrayList <Obstacle> obstacles= new ArrayList<>();
        obstacles.add(a);
        obstacles.add(b);
    }

    public Location(String name, ArrayList<String> items,String riddleFile, String messageFile, Obstacle a, Obstacle b, Obstacle c, Obstacle d ){
        this.name=name;
        this.items=items;
        this.riddleFile=riddleFile;
        this.messageFile=messageFile;

        ArrayList <Obstacle> obstacles= new ArrayList<>();
        obstacles.add(a);
        obstacles.add(b);
        obstacles.add(c);
        obstacles.add(d);
    }


}
