
public class Bear extends Enemy{

	public Bear(int level) {
		super(level);
		setAttack(level*5);
		setHealth(level*5);
		System.out.println("You meet a level " + level + " bear, do you want fight or escape?");
	}

	public boolean fight(Player player) {
		boolean alive = true;
		double wh = new Double(getHealth());
		double pa = new Double(player.getAttack());
		int num = (int)  Math.ceil((wh/pa));
		double ph = new Double(player.getHealth());
		double wa = new Double(getAttack());
		int numTwo = (int) Math.ceil(ph/wa);
		
		if (num  <= numTwo*8) {
			System.out.println("It took "+ num + " attacks to defeat the bear and you took "+ ((num-1)/8 *getAttack()) + " damage!");
			player.getXP(getLevel()*3);
			alive = player.takeDamage(((num-1)/8 *getAttack()));
		}
		else {
			alive = false;
			System.out.println("Unfortunately you were not able to defeat the bear.");
		}
		return alive;
	}

	
	

}
