import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class NPC {

    private String name;
    private String fileName;

    public NPC(String name, String fileName){
        this.name=name;
        this.fileName=fileName;

    
}


public void sayMessage(){

    try(BufferedReader br = new BufferedReader(new FileReader(fileName))){;
     String line;

     System.out.println("Hello, I am "+ name );

     while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }catch (IOException e){
        System.err.println("Error Message `: " + e.getMessage());
    }

}


}
