import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CharacterFrequencyCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String readLine = scan.nextLine();

		//frequencyCount1(readLine);
		frequencyCount2(readLine);

		scan.close();
	}

	private static void frequencyCount1(final String value) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		int size = value.length();

		for (int i = 0; i < size; i++) {
			Character ch = value.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Character, Integer> entry = it.next();
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}

	}

	private static void frequencyCount2(final String value) {
		int size = value.length();

		/**
		 * 1st row contains indexes of 2nd row.
		 * 2nd row contains frequency count of each character.
		 * 
		 *  e.g)
		 *  input	:	s	t	r	e	s	s
		 *  1st row	:	0	1	2	3	0	0
		 *  2st row :	3	1	1	1	0	0
		 */
		int arr[][] = new int[2][size];
		int index = 0;
		int sum = 0;

		for (int i = 0; i < size; i++) {
			char ch = value.charAt(i);
			int count = 0;

			for (int j = i; j < size; j++) {
				if (ch == value.charAt(j)) {
					count++;
					arr[0][j] = index;
				}
			}

			arr[1][index] = count;
			sum += count;

			if (sum == size) {
				break;
			}

			index++;
		}

		for (int i = 0; i <= index; i++) {
			System.out.println(value.charAt(i) + "\t" + arr[1][i]);
		}
	}
}
