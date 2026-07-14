package workflow;

public class Battle {
	public static void main(String[] args) {
		/*
		 * BOSS와 Player가 전투를 합니다. BOSS의 체력과 Player의 체력 중 하나라도 0 이하가 된다면 게임은 종료됩니다. BOSS가
		 * Player에게 공격을 합니다. (랜덤 데미지) Player가 BOSS에게 공격을 합니다. (랜덤 데미지) 공격이 끝난 이후 서로의 체력을
		 * 출력합니다.
		 */
		final int BOSS_MAX_HP = 10_000;
		final int PLAYER_MAX_HP = 10_000;
		int bossHp = BOSS_MAX_HP;
		int playerHp = PLAYER_MAX_HP;
		int bossD = 0;
		int playerD = 0;
		System.out.println("\t플레이어의 체력: \t" + playerHp + "\n\t보스의 체력: \t" + bossHp);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		while (bossHp > 0 && playerHp > 0) {
			bossD = (int) (Math.random() * 1000) + 1;
			playerHp -= bossD;
			System.out.println("보스가 플레이어를 공격했습니다. (" + bossD + ")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			playerD = (int) (Math.random() * 1000) + 1;
			bossHp -= playerD;
			System.out.println("플레이어가 보스를 공격했습니다. (" + playerD + ")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println("\t플레이어의 체력: \t" + "*".repeat(playerHp / 200 + 1) + "(" + playerHp + ")"
					+ "\n\t보스의 체력: \t" + "*".repeat(bossHp / 200 + 1) + "(" + bossHp + ")" + "\n" + "=".repeat(35));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
