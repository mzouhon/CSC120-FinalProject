public class livingObstacle extends Obstacle {

    Boolean alive;

    public livingObstacle(String name,String hint){
        super(name,hint);
        this.alive=true;

    }

    public void stop(){
        this.alive=false;
    }


    
}
