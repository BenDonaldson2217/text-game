
public class Witch extends Enemy{
	
	public Witch(int level) {
		super(level);
		setAttack(level*4);
		setHealth(level*2);
		System.out.println("You meet a level " + level + " witch, do you want fight or escape?");
	}

	public boolean fight(Player player) {
		boolean alive = true;
		double wh = new Double(getHealth());
		double pa = new Double(player.getAttack());
		int num = (int)  Math.ceil((wh/pa));
		double ph = new Double(player.getHealth());
		double wa = new Double(getAttack());
		int numTwo = (int) Math.ceil(ph/wa);
		
		if (num  <= numTwo*2) {
			System.out.println("It took "+ num + " attacks to defeat the witch and you took "+ ((num-1)/2 *getAttack()) + " damage!");
			player.getXP(getLevel()*2);
			alive = player.takeDamage(((num-1)/2 *getAttack()));
		}
		else {
			alive = false;
			System.out.println("Unfortunately you were not able to defeat the witch.");
		}
		return alive;
	}

	

}
