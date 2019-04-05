
public abstract class Enemy {
		
		private int level;
		private int attack;
		private int health;
		
		public Enemy(int level) {
			if (level == 0) {
				level = level+1;
			}
			this.level = level;
		}
		
		public abstract boolean fight(Player player);
		
		public int getHealth() {
			return health;
		}
		
		public void setHealth(int health) {
			this.health = health;
		}
		public int getAttack() {
			return attack;
		}
		
		public void setAttack(int attack) {
			this.attack=attack;
		}
		
		public int getLevel() {
			return level;
		}
		

}
