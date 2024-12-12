public class Obstacle {
    
    private String name;
    private String hint;

    public Obstacle(String name, String hint){
        this.name=name;
        this.hint=hint;

    }


    public String getObstacleHint(){
        return (this.hint);

    }

    public void attack(Player p){
        p.loseALife();
    }

    


}
