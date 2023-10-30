package OmokGame;

public class StatusBar {
	private String stat;
	
	public StatusBar() {
		this.stat="black";
	}
	
	public void print() {
//		System.out.println("turn : " + this.stat);
	}
	
	public void stat(String stat) {
		this.stat=stat;
	}
}
