import java.util.Random;

public class Alien extends Player {
	
	private int creditDrop;
	
	// getters and setters
	private void setCreditDrop(int creditDrop) {
		this.creditDrop = creditDrop;
	}

	int getCreditDrop() {
		return creditDrop;
	}
	// end getters and setters
	
	// abstract method to return alien attack and defence stats 
	@Override
	public int attack() {
		return getAttack();
	}

	@Override
	public int defend() {
		return getDefence();
	}
	
	// generates a random number
	private static int generateRandomInt(int min, int max){
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

	// construct aliens
	void metroid(Alien metroid) {
		
		metroid.setName("Metroid");
		metroid.setHitPoints(generateRandomInt(450,550));
		metroid.setAttack(generateRandomInt(25,35));
		metroid.setDefence(generateRandomInt(10,15));
		metroid.setSpeed(generateRandomInt(15,20));
		metroid.setCreditDrop(generateRandomInt(60,120));
	}
	
	void arachnus(Alien arachnus) {
			
		arachnus.setName("Arachnus");
		arachnus.setHitPoints(generateRandomInt(200,250));
		arachnus.setAttack(generateRandomInt(15,20));
		arachnus.setDefence(generateRandomInt(25,35));
		arachnus.setSpeed(generateRandomInt(15,20));
		arachnus.setCreditDrop(generateRandomInt(60,80));
	}
	
	void sidehopper(Alien sidehopper) {
		
		sidehopper.setName("Sidehopper");
		sidehopper.setHitPoints(generateRandomInt(175,225));
		sidehopper.setAttack(generateRandomInt(20,30));
		sidehopper.setDefence(generateRandomInt(20,25));
		sidehopper.setSpeed(generateRandomInt(25,35));
		sidehopper.setCreditDrop(generateRandomInt(40,50));
	}
	
	void spacePirate(Alien spacePirate)
	{		
		spacePirate.setName("Space Pirate");
		spacePirate.setHitPoints(generateRandomInt(130,180));
		spacePirate.setAttack(generateRandomInt(45,55));
		spacePirate.setDefence(generateRandomInt(5,15));
		spacePirate.setSpeed(generateRandomInt(30,40));
		spacePirate.setCreditDrop(generateRandomInt(80,140));
	}
	
	// construct bosses
	void ridley(Alien ridley)
	{		
		ridley.setName("Ridley");
		ridley.setHitPoints(1800);
		ridley.setAttack(65);
		ridley.setDefence(25);
		ridley.setSpeed(35);
		ridley.setCreditDrop(30);
	}
	
	void kraid(Alien kraid)
	{		
		kraid.setName("Kraid");
		kraid.setHitPoints(1000);
		kraid.setAttack(15);
		kraid.setDefence(12);
		kraid.setSpeed(10);
		kraid.setCreditDrop(30);
	}
	
	void motherBrain(Alien motherBrain)
	{		
		motherBrain.setName("Mother Brain");
		motherBrain.setHitPoints(3000);
		motherBrain.setAttack(15);
		motherBrain.setDefence(12);
		motherBrain.setSpeed(10);
		motherBrain.setCreditDrop(90);
	}
}
