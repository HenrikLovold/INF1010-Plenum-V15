import java.util.concurrent.CountDownLatch;

public class Merge {
	
	public static void main(String[] args) {
		Beholder bmb = null;//hentBeholderMedBeholdere();
		
		MergeTraad[] traader = new MergeTraad[4];
		Monitor m = new Monitor(bmb);
		
		for (int i = 0; i < traader.length; i++) {
			traader[i] = new MergeTraad(m);
		}
		
		m.giTraader(traader);
		
		for (int i = 0; i < traader.length; i++) {
			try {
				traader[i].start();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}

class MergeTraad extends Thread {
	Beholder mineElementer;
	Monitor m;
	
	public MergeTraad(Monitor m) {
		this.m = m;
		mineElementer = new Beholder();
	}
	
	@Override
	public void run() {
		Beholder tmp;
		while((tmp = m.hentBeholder()) != null) {
			mineElementer.ovfAlleFraBeholder(tmp);
		}
		
		if(m.countDown() == 0) {
			m.slaaSammenAlt();
		}
		
	}
	
}

class Monitor {
	Beholder bmb;
	Beholder alt;
	MergeTraad[] traader;
	CountDownLatch latch;
	
	public Monitor(Beholder bmb) {
		this.bmb = bmb;
	}
	
	public void giTraader(MergeTraad[] traader) {
		this.traader = traader;
		latch = new CountDownLatch(traader.length);
	}
	
	public void slaaSammenAlt() {
		for (int i = 0; i < traader.length; i++) {
			alt.ovfAlleFraBeholder(traader[i].mineElementer);
		}
	}
	
	public synchronized int countDown() {
		latch.countDown();
		return (int)latch.getCount();
	}
	
	public synchronized Beholder hentBeholder() {
		Beholder tmp = (Beholder)bmb.hent();
		if(tmp != null) {
			return tmp;
		}
		
		return null;
	}
}








