
public class Queens {
	
	Felt[][] brett;
	final int N;
	
	public Queens(int N) {
		this.N = N;
		this.brett = new Felt[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				brett[i][j] = new Felt();
			}
		}
		
		System.out.println(loes(0));
		printBrett();
	}
	
	private boolean passer(int x, int y) {
		
		for (int i = 0; i < N; i++) {
			if(brett[x][i].tatt) {
				return false;
			}
		}
		
		for(int i = Math.max(x-y, 0), j = Math.max(y-x, 0); i < N && j < N; i++, j++) {
			if(brett[i][j].tatt) {
				return false;
			}
		}
		
		int mirrorx = (N-1)-x;
		for(int i = Math.max(mirrorx-y, 0), j = Math.max(y-mirrorx, 0); i < N && j < N; i++, j++) {
			if(brett[(N-1)-i][j].tatt) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean loes(int kolonne) {
		
		if(kolonne >= N) {
			return true;
		}
		
		for(int i = 0; i < N; i++) {
			if(passer(i, kolonne)) {
				brett[i][kolonne].tatt = true;
				
				if(loes(kolonne+1)) {
					return true;
				}
				
				brett[i][kolonne].tatt = false;
			}
		}
		
		return false;
	}
	
	public void printBrett() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print((brett[i][j].tatt ? 'Q' : 'x') + " ");
			}
			System.out.println();
		}
		
	}
	
	private class Felt {
		public boolean tatt;
		
		
		
	}

}
