public class Motorsykkel {
	
	private String regnr;
	private int motorvolum;
	
	public Motorsykkel(String regnr, int motorvolum){
		this.regnr = regnr;
		this.motorvolum = motorvolum;
	}
	
	public String getRegnr(){
		return regnr;
	}
	
	public int getMotorvolum(){
		return motorvolum;
	}
	
}
