package Omok;

public class Player {
    String name;
    String stone;
    Player(String name, String stone) {
        this.name = name;
        this.stone = stone;
    }
    
    public String getCircle() {
		return stone;
    	
    }
    
    public String getName() {
    	return name;
    }
    
}