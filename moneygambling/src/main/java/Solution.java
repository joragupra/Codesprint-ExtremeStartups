import java.util.Locale;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			double prob = scanner.nextDouble();
			int consecutiveHeads = scanner.nextInt();
			double expectedRounds = expectedTossings(consecutiveHeads, prob);
			System.out.print((int) Math.floor(expectedRounds));
			System.out.println(" "
					+ ((int) Math.floor(calculateEarnings(1, expectedRounds))));
		}
	}
	
	/**
	 * Expected tossings for n consecutive heads is:
	 * E(n) = p . (E(n-1) + 1) + (1 - p) . (1 + E(n))
	 * So with a little algebra we have:
	 * E(n) = (E(n-1) + 1) / p
	 * For 0 consecutive heads we need 0 tossings so:
	 * E(0) = 0
	 * And now we have our recursive function to implement.
	 * 
	 * @param consecutiveHeads Number of consecutive heads we look for.
	 * @param prob Probability for getting head in a tossing.
	 * @return Number of tossings to get the number of consecutive heads.
	 */
	private static double expectedTossings(int consecutiveHeads, double prob) {
		if (consecutiveHeads == 0) {
			return 0;
		} else {
			double aux = (expectedTossings(consecutiveHeads - 1, prob) + 1)
					/ prob;
			return aux;
		}
	}

	private static final double calculateEarnings(int round, double maxRounds) {
		if (round < maxRounds) {
			return (2 * round - 1) + calculateEarnings(round + 1, maxRounds);
		} else {
			return (2 * maxRounds - 1);
		}
	}
}