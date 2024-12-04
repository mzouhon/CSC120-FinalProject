public class livingObstacle extends Obstacle {

    Boolean alive;

    public livingObstacle(String name){
        super(name);
        this.alive=true;

    }

    public void stop(){
        this.alive=false;
    }


    
}
