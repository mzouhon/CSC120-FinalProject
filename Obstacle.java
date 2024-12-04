public class Obstacle {
    
    private String name;

    public Obstacle(String name){
        this.name=name;

    }

    public void attack(Player p){
        p.loseALife();
    }

    


}
