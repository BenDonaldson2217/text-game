
public class Frog extends Enemy{
	
	public Frog(int level) {
		super(level);
		setAttack(level*10);
		setHealth(level);
		System.out.println("You meet a level " + level + " frog, do you want fight or escape?");
	}

	public boolean fight(Player player) {
		boolean alive = true;
		double wh = new Double(getHealth());
		double pa = new Double(player.getAttack());
		int num = (int)  Math.ceil((wh/pa));
		double ph = new Double(player.getHealth());
		double wa = new Double(getAttack());
		int numTwo = (int) Math.ceil(ph/wa);
		
		if (num  <= numTwo) {
			System.out.println("It took "+ num + " attacks to defeat the frog and you took "+ ((num-1)/1 *getAttack()) + " damage!");
			player.getXP(getLevel());
			alive = player.takeDamage(((num-1)/1 *getAttack()));
		}
		else {
			alive = false;
			System.out.println("Unfortunately you were not able to defeat the frog.");
		}
		return alive;
	}


}
