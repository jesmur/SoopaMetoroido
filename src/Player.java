
abstract public class Player {
	
	private String name;
	private int hitPoints;
	int attack;
	private int defence;
	private int speed;
	
	// getters and setters
	int getHitPoints() {
		return hitPoints;
	}

	void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	int getAttack() {
		return attack;
	}

	void setAttack(int attack) {
		this.attack = attack;
	}

	int getDefence() {
		return defence;
	}

	void setDefence(int defence) {
		this.defence = defence;
	}

	int getSpeed() {
		return speed;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}
	// end getters and setters
	
	
	// abstract methods
	public abstract int attack(); 
	
	public abstract int defend();
	
	
}
