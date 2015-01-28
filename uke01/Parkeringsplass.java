public class Parkeringsplass<T> {
	
	private T kjoretoy;
	
	public void parker(T kjoretoy){
		this.kjoretoy = kjoretoy;
	}
	
	public T kjorUt(){
		return kjoretoy;
	}
	
}
