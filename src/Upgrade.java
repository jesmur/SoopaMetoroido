
public abstract class Upgrade {
	
	private String name;
	private String desc;
	private int cost;
	private boolean bought;
	private boolean equipped;
	
	// constructor
	Upgrade(String name, String desc, int cost, boolean bought, boolean equipped) {
		this.name = name;
		this.desc = desc;
		this.cost = cost;
		this.bought = bought;
		this.equipped = equipped;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String getDesc() {
		return desc;
	}

	void setDesc(String desc) {
		this.desc = desc;
	}

	int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	boolean isBought() {
		return bought;
	}

	void setBought(boolean bought) {
		this.bought = bought;
	}

	boolean isEquipped() {
		return equipped;
	}

	void setEquipped(boolean equipped) {
		this.equipped = equipped;
	}
	// end getters and setters
	
	
}
