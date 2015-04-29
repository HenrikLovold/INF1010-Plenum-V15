import java.util.Random;

public class Test {

	Test() {
		RecursiveList<String> list = new RecursiveList<String>();

		String sentence = "Dette er en tilfeldig setning med mange ord.";
		String[] words = sentence.split(" ");

		Random r = new Random();

		for (String word : words) {
			if (r.nextBoolean()) {
				list.insert(word);
			} else {
				list.insertRecursive(word);
			}
		}

		// list.print();
		// list.printRecursive();

		// Test iterator:
		for (String s : list) {
			System.out.println(s);
		}
	}
}
