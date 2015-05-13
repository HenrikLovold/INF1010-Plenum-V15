import java.io.File;
import java.util.Scanner;

public class ParaFrekvens {
	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("mangeordsortert.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int ant = Integer.parseInt(sc.nextLine());
		
		String[] array = new String[ant];
		int i = 0;
		
		while(sc.hasNextLine()) {
			array[i++] = sc.nextLine();
		}
		
		Monitor<String> monitor = new Monitor<String>(array);
		
		System.out.println("Ord med flest forekomster: " + monitor.flestObj + " ant: " + monitor.flestAnt);
	}
}

class Monitor<T> {
	final int NUM = 4;
	Traad<T>[] traader;
	T[] alt;
	T flestObj;
	int flestAnt;
	
	public Monitor(T[] alt) {
		this.alt = alt;
		traader = new Traad[NUM];
		
		this.delOppOgBeregn();
	}

	private void delOppOgBeregn() {
		for (int i = 0; i < NUM; i++) {
			traader[i] = new Traad(hentArray(i));
			traader[i].start();
		}
		
		for (int i = 0; i < NUM; i++) {
			try {
				traader[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		flestObj = traader[0].flestObj;
		flestAnt = traader[0].flestAnt;
		
		for (int i = 1; i < NUM; i++) {
			if(traader[i].flestAnt > flestAnt) {
				flestObj = traader[i].flestObj;
				flestAnt = traader[i].flestAnt;
			}
		}
	}
	
	private T[] hentArray(int index) {
		T[] array;
		
		if(index == NUM-1) {
			array = (T[]) new Object[(alt.length/NUM) + alt.length%NUM];
		} else {
			int n = alt.length/NUM;
			
			if(index != 0) {
				for (int i = n; i < alt.length; i++) {
					if(alt[i] == alt[i-1]) {
						n++;
					} else {
						break;
					}
				}
			}
			
			array = (T[]) new Object[n];
		}
		
		int start =	index*(alt.length/NUM);
		
		
		
		for(int i = start, j = 0; i < start + array.length; i++, j++) {
			array[j] = alt[i];
		}
		
		return array;
	}
	
}

class Traad<T> extends Thread {
	T[] minArray;
	T flestObj;
	int flestAnt;
	
	public Traad(T[] minArray) {
		
	}
	
	@Override
	public void run() {
		Frekvens<T> frekvens = new Frekvens<T>(minArray);
		frekvens.likeSammen();
		flestObj = frekvens.hentFlestObjektet();
		flestAnt = frekvens.hentFlestAntallet();
	}
}


