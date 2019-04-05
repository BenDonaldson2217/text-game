import java.util.Scanner;

public class Swamp {

	
		
	public void play() {
		int x=0;
		int y= 0;
		boolean alive = true;
		while (x ==0 && y==0) {
			x = (int) (Math.random() * 30) -15;
			y = (int) (Math.random() * 30) -15;
		}
		Treasure treasure = new Treasure(x,y);
		Player player = new Player();
		Scanner sc = new Scanner(System.in);
		System.out.println("Distance to treasure is " + compass(player, treasure));
		while ((player.getLocation()[0] != treasure.getLocation()[0] || player.getLocation()[1] != treasure.getLocation()[1]) && alive) {
			System.out.println("Which direction would you like to go?");
			String input = (sc.nextLine()).toLowerCase();
			String[] split = input.split(" ");
			if (split.length == 1) {
				boolean wall = player.wall();
				if (!wall) {
				
				
					int rand = (int) (Math.random() * 100);
					if (0<=rand && rand<10) {
						int level = (int) (Math.random() * 9) +1;
						Witch witch = new Witch(level);
						String fight = (sc.nextLine()).toLowerCase();
						if (fight.equals("fight")) {
							alive = witch.fight(player);
							if (alive) {
								player.move(input);
							}
						}
						else if (fight.equals("escape")) {
							System.out.println("Successfully escaped!");
						}
						else {
							System.out.println("Not valid command. You hesititated too much and the witch noticed you and attacked.");
							alive = witch.fight(player);
							if (alive) {
								player.move(input);
							}
						}
					}
					else if (10<=rand && rand<18) {
						int level = (int) (Math.random() * 9) +1;
						Bear bear = new Bear(level);
						String fight = (sc.nextLine()).toLowerCase();
						if (fight.equals("fight")) {
							alive = bear.fight(player);
							if (alive) {
								player.move(input);
							}
						}
						else if (fight.equals("escape")) {
							System.out.println("Successfully escaped!");
						}
						else {
							System.out.println("Not valid command. You hesititated too much and the bear noticed you and attacked.");
							alive = bear.fight(player);
							if (alive) {
								player.move(input);
							}
						}
					}
					
					
					
						
							else if (18<=rand && rand<30) {
								int level = (int) (Math.random() * 9) +1;
								Frog frog = new Frog(level);
								String fight = (sc.nextLine()).toLowerCase();
								if (fight.equals("fight")) {
									alive = frog.fight(player);
									if (alive) {
										player.move(input);
									}
								}
								else if (fight.equals("escape")) {
									System.out.println("Successfully escaped!");
								}
								else {
									System.out.println("Not valid command. You hesititated too much and the frog noticed you and attacked.");
									alive = frog.fight(player);
									if (alive) {
										player.move(input);
									}
								}
							
						
							}
							else if (30<=rand && rand<40) {
									player.fruit();
							}
							else if (40<=rand && rand<45) {
								player.equipment();
						}
							else if (45<=rand && rand < 47) {
								player.teleport();
							}
						
					
					else {
						player.move(input);
					}
					
				}
					
			}
			else {
				player.move(split);
			}
			System.out.println("Distance to treasure is " + compass(player, treasure));
		}
		sc.close();
		if (alive) {
			System.out.println("Congratulations you win!");
		}
		else {
			System.out.println("Sorry, you lost. Try again.");
		}
		
		
	}
	
	
	
	public double compass(Player player, Treasure treasure) {
		int xDiff = player.getLocation()[0] - treasure.getLocation()[0];
		int yDiff = player.getLocation()[1] - treasure.getLocation()[1];
		return Math.sqrt((Math.pow(xDiff,2) + Math.pow(yDiff, 2)));
	}

}
