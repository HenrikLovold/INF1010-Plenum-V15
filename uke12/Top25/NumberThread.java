
public class NumberThread implements Runnable {

	int start, stop;
	int[] numbers;
	int[] topNums;
	
	public NumberThread(int[] numbers, int start, int stop) {
		this.numbers = numbers;
		this.start = start;
		this.stop = stop;
		
		this.topNums = new int[25];
	}
	
	public void run() {
		for(int i = start; i <= stop; i++) {
			if(numbers[i] > topNums[topNums.length-1]) {
				insert(numbers[i]);
			}
		}
		
	}

	private void insert(int in) {
		int i = topNums.length-1;
		
		while(i > 0 && in > topNums[i-1]) {
			i--;
		}
		
		int tmp;
		
		for( ; i < topNums.length; i++) {
			tmp = topNums[i];
			topNums[i] = in;
			in = tmp;
		}
		
	}

}
