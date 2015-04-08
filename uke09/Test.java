import java.util.concurrent.locks.ReentrantLock;


public class Test {
	
	public static void main(String[] args) {
		MyMonitor m = new MyMonitor();
		
		RegneTraad rt[] = new RegneTraad[4];
		Thread thr[] = new Thread[4];
		
		for(int i = 0; i < 4; i++) {
			rt[i] = new RegneTraad(m);
			thr[i] = new Thread(rt[i]);
			thr[i].start();
		}
		
		for(int i = 0; i < 4; i++) {
			try {
				thr[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(m.d);
	}

}

class RegneTraad implements Runnable {
	
	MyMonitor m;
	
	RegneTraad(MyMonitor m) {
		this.m = m;
	}

	@Override
	public void run() {
		for(int i = 0; i < 3000000; i++) {
			m.gjorEtVanskeligRegnestykke();
		}
	}
	
}

class MyMonitor {
	double d = 0.0;
	ReentrantLock lock = new ReentrantLock();
	
	public void gjorEtVanskeligRegnestykke() {
		double d2 = 0;
		for(int i = 500000; i > 0; i--) {
			d2 = i;
		}
		
		lock.lock();
		try {
			d = d+d2;
		} finally {
			lock.unlock();
		}
	}
}