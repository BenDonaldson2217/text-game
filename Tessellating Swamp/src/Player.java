
public class Player extends Items{
	
	private int maxHealth = 10;
	private int attack = 1;
	private int level = 1;
	private int xp = 0;
	private int currentHealth = 10;
	
	
	
	
	public Player() {
		super(0,0);
	}

	public void move(String direction) {
		int x= getLocation()[0];
		int y = getLocation()[1];
		switch (direction){
		case "north":
			setLocation(x,y+1);
			break;
		case "south":
			setLocation(x,y-1);
			break;
		case "east":
			setLocation(x+1,y);
			break;
		case "west":
			setLocation(x-1,y);
			break;
			
		default: 
			System.out.println("Invalid direction");
		}
		
	}
	
	public void move(String[] array) {
		System.out.println("Can only move in one direction at once!");
	}
	
	
	
	
	public void getXP( int xpGained) {
		xp = xp + xpGained;
		if (xp > level * 5) {
			xp = xp - level*5;
			levelUp(); 
		}
	}
	
	public void levelUp() {
		System.out.println("Congratulations, you've leveled up!");
		level = level + 1;
		maxHealth = maxHealth + 2;
		attack = attack +1;
		currentHealth=currentHealth+2;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getHealth() {
		return currentHealth;
	}
	
	public boolean takeDamage(int damage) {
		
		boolean alive = true;
		currentHealth = currentHealth - damage;
		
		if (currentHealth <= 0) {
			alive =false;
		}
		return alive;
		
	}
	
	
	public boolean wall() {
		boolean wall = false;
		int i = (int) (Math.random() * 10);
		if (i == 0) {
			System.out.println("You see some venomous snakes in this direction and decide to turn back");
			wall = true;
		}
		
		return wall;
	}
	
	
	public void fruit() {
		System.out.println("You have found some fruit!");
		currentHealth = currentHealth + 5;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
		System.out.println("Your health is now " + currentHealth + "!");
	}
	
	public void equipment() {
		maxHealth=maxHealth+2;
		attack = attack+1;
		System.out.println("You have found some better equipment! Your attack is now "+ attack + " and your maximum health is now "+ maxHealth + "!");
	}
	
	public void teleport() {
		System.out.println("You stumbled across a magic rabbit, who in fear teleported you to a random part of the swamp!");
		int x = (int) (Math.random() * 30) -15;
		int y = (int) (Math.random() * 30) -15;
		setLocation(x,y);
	}

	

}
