import java.util.Random;

class Game {
	
	// initialize new characters and items for the game
	Hero spaceHunter = new Hero(null,0,0,0,0,900,0,0);
	
	Alien randomAlien = new Alien();
	
	Suit zeroSuit = new Suit("Zero Suit","Full-body jumpsuit. No bonus to defence or speed.",0,true,true,0,0);
	Suit powerSuit = new Suit("Power Suit","600 credits. Basic powered armorsuit. Small bonus to defence and speed.",600,false,false,15,15);
	Suit variaSuit = new Suit("Varia Suit","900 credits. Barrier suit providing moderate bonus to defence and low bonus to speed.",900,false,false,40,20);
	Suit gravitySuit = new Suit("Gravity Suit","1200 credits. Allows you to move unhindered. Provides small bonus to defence but large bonus to speed.",1200,false,false,20,40);
	
	Weapon chargeBeam = new Weapon("Charge Beam","200 credits. Allows you to hold your fire and release a stronger energy blast.",200,false,false,10);
	Weapon iceBeam = new Weapon("Ice Beam","600 credits. Freezing beam thats increases damage dealt and slows enemies.",600,false,false,7);
	Weapon spazerBeam = new Weapon("Spazer Beam","1200 credits. Simultaneous blast of three lasers. Has more power and width than the charge beam.",1200,false,false,15);
	Weapon plasmaBeam = new Weapon("Plasma Beam","2000 credits. Strongest beam available. Inflicts heavy damage to enemies.",2000,false,false,75);
	
	// generates a random number
	private static int generateRandomInt(int min, int max){
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	// roll between to a range for player stats
	void setPlayerStats(){
		this.spaceHunter.setHitPoints(generateRandomInt(150,200));
		this.spaceHunter.setAttack(generateRandomInt(35,45));
		this.spaceHunter.setDefence(generateRandomInt(15,20));
		this.spaceHunter.setSpeed(generateRandomInt(15,30)); 
	}
	
	// determines which alien will be fought
	void determineAlien() {
		
		int alienRoll = generateRandomInt(0,12);
		
		if (alienRoll < 1) {
			randomAlien.metroid(randomAlien);
		}
		else if (alienRoll < 4) {
			randomAlien.arachnus(randomAlien);
		}
		else if (3 < alienRoll && alienRoll < 9) {
			randomAlien.sidehopper(randomAlien);
		}
		else if (8 < alienRoll && alienRoll < 11) {
			randomAlien.spacePirate(randomAlien);
		}
		else if (alienRoll == 11){
			randomAlien.ridley(randomAlien);
		}
		
	}


	
	

}
