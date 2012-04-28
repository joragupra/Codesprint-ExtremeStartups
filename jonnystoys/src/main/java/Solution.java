import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> components = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		int numComponents = scanner.nextInt();
		for (int i = 0; i < numComponents; i++) {
			orderedInsert(scanner.nextInt(), components);
		}
		int accEffort = 0;
		while (components.size() > 1) {
			int newComponent = assembleMinEffort(components);
			accEffort += newComponent;
			orderedInsert(newComponent, components);
		}
		System.out.println(accEffort);
	}

	private static int assembleMinEffort(List<Integer> components) {
		return components.remove(0) + components.remove(0);
	}

	private static void orderedInsert(int integer, List<Integer> orderedList) {
		boolean found = false;
		int i = 0;
		int numComponents = orderedList.size();
		while (i < numComponents && !found) {
			if (orderedList.get(i) > integer) {
				orderedList.add(i, integer);
				found = true;
			}
			i++;
		}
		if (!found) {
			orderedList.add(integer);
		}
	}
}
