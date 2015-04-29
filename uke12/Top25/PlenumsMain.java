import java.util.Arrays;
import java.util.Random;

public class PlenumsMain {
	public static void main(String[] args) {
		
		// Sette konstanter
		
		final int NUM_THRS = 8;
		final int LEN = 50000000;
		final int TOP_LEN = 25;
		
		System.out.println("Finding top " + TOP_LEN + " of " + LEN + " numbers");
		
		// Opprette random-array
		
		int[] numbers = new int[LEN];
		Random rng = new Random();
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = Math.abs(rng.nextInt());
		}
		
		// Opprette traader
		NumberThread[] nthrs = new NumberThread[NUM_THRS];
		Thread[] thrs = new Thread[NUM_THRS];
		
		long startTid = System.currentTimeMillis();
		
		for (int i = 0; i < NUM_THRS; i++) {
			nthrs[i] = new NumberThread(numbers, getStart(i, NUM_THRS, LEN), getStop(i, NUM_THRS, LEN));
			thrs[i] = new Thread(nthrs[i]);
			
			thrs[i].start();
		}
		
		// Joine/sykronisere paa traader
		for (int i = 0; i < NUM_THRS; i++) {
			try {
				thrs[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Kjoretid: " + (System.currentTimeMillis() - startTid));
		
		// Slaa sammen tall fra traader
		
		int[] top = new int[TOP_LEN];
		int[] indices = new int[NUM_THRS];
		
		for (int i = 0; i < TOP_LEN; i++) {
			top[i] = getMax(nthrs, indices);
		}
		
		// Print testutskrift
		
		//printTest(numbers, top);
	}
	
	public static int getMax(NumberThread[] thrs, int[] indices) {
		int maxNum = 0;
		int maxIdx = 0;
		for(int i = 0; i < indices.length; i++) {
			if(indices[i] < 25) {
				if(thrs[i].topNums[indices[i]] > maxNum) {
					maxNum = thrs[i].topNums[indices[i]];
					maxIdx = i;
				}
			}
		}
		indices[maxIdx] += 1;
		return maxNum;
	}
	
	public static int getStart(int i, int total, int len) {
		return i*len/total;
	}
	
	public static int getStop(int i, int total, int len) {
		if(i != total-1) {
			return (i+1)*len/total;
		}
		
		return len-1;
	}
	
	public static void printTest(int[] numbers, int[] top) {
		Arrays.sort(numbers);
		
		System.out.println("Arrays.sort\tlik?\tVår sortering");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i = numbers.length-1, j = 0; i >= numbers.length-25; i--, j++) {
			System.out.print(numbers[i]);
			if(numbers[i] == top[j]) {
				System.out.print("\t==\t");
			} else {
				System.out.print("\t!=\t");
			}
			System.out.println(top[j]);
		}
	}
}
