import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {
	public static void main(String[] args) {

		Bord b = new SmartBord();

		Thread t1 = new Thread(new Kokk(3, b, "Per"));
		Thread t2 = new Thread(new Kokk(3, b, "Ali"));
		Thread t3 = new Thread(new Servitor(b, 3, "Lisa"));
		Thread t4 = new Thread(new Servitor(b, 3, "Gunnar"));

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Alle er ferdige!");
	}
}

class Kokk implements Runnable {
	String navn;
	private final int ANTALL;
	private Bord bord;
	private int laget = 0;
	Random r = new Random();

	Kokk(int antall, Bord bord, String navn) {
		this.navn = navn;
		this.ANTALL = antall;
		this.bord = bord;
	}

	public void run() {

		while (laget != ANTALL) {
			bord.settTallerken();
			System.out.println(navn + " har satt tallerken nr: " + ++laget);
			try {
				Thread.sleep(r.nextInt(4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Servitor implements Runnable{
	Bord bord;
	String navn;
	private final int ANTALL;
	private int servert = 0;
	Random r = new Random();

	Servitor (Bord bord, int antall, String navn) {
		this.navn = navn;
		this.bord = bord;
		this.ANTALL = antall;
	}

	public void run() {
		while (servert != ANTALL) {
			bord.taTallerken();
			System.out.println(navn + " har servert nr: " + ++servert);
			try {
				Thread.sleep(r.nextInt(4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class Bord {
	int tallerkner = 0;
	final int BORD_KAPASITET = 4;

	public synchronized void settTallerken() {
		while(tallerkner >= BORD_KAPASITET) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		tallerkner++;
		notify();
	}

	public synchronized void taTallerken() {
		while(tallerkner == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		tallerkner--;
		notify();
	}
}

class SmartBord extends Bord {
	ReentrantLock laas = new ReentrantLock();
	Condition ikkeFull = laas.newCondition();
	Condition ikkeTom = laas.newCondition();
	
	
	@Override
	public void settTallerken() {
		laas.lock();
		try {
			while(tallerkner >= BORD_KAPASITET) {
				ikkeFull.await();
			}
			tallerkner++;
			ikkeTom.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			laas.unlock();
		}
	}
	
	@Override
	public void taTallerken() {
		laas.lock();
		try {
			while(tallerkner == 0) {
				ikkeTom.await();
			}
			tallerkner--;
			ikkeFull.signal();
		} catch (InterruptedException e) {
			
		} finally {
			laas.unlock();
		}
	}
}


