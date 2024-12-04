import java.util.ArrayList;
import java.util.Arrays;

public class jumanjiMap {

    private String[][] map;
    private String [] locations= {"house", "garden", "open field", "open field", "school","open field", "jungle", "jungle", "jungle", "open field", "open field", "jungle", "heart of jungle", "jungle", "rainforest", "open field", "jungle", "jungle", "jungle", "open field", "cave", "open field", "open field", "quicksand", "savannah"};



     public jumanjiMap() {
      map = new String[5][5];

        int locationIndex=0; 

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) { 
                map[i][j] = locations[locationIndex];
                locationIndex++;
                
            }
        }
    }
    public String[][] getMap(){
        return (this.map);
    }

    public void print(){

        

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) { 
                System.out.println(this.map[i][j]);
            }
        }

    }

    public static void main(String[] args) {

       jumanjiMap myMap= new jumanjiMap();
       myMap.print();

       

    }

    
}
