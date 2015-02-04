public class StakkTest {
	public static void main(String[] args) {
		Pannekake p1 = new Pannekake();
		Pannekake p2 = new Pannekake();
		
		MinStakk stakk = new MinStakk();
		
		stakk.push(p1);
		stakk.push(p2);
		
		System.out.println(stakk.pop() == p2);
	}
}
