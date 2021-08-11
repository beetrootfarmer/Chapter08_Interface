package ch08_1_interface;
interface Searchable {
	void search(String url);
}

class SmartTelevision implements RemoteControl, Searchable{ //기능중심이기 때문에 able이 많이 붙음
	private int volume;
	
	public SmartTelevision(String string) {
}
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else { 
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨: " + this.volume);
	}
	
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
	}
}

public class SmartTelevisionExample {
	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision("SAMSUNG Smart");
		
		// 자동형변환(Searchable <----- SmartTelevision)
		// Searchable 기능만..
		RemoteControl rc = tv; //SmartTelevision 에서 RemoteControl로 자동 형변환
		rc.turnOn();
		Searchable sc = tv;
		sc.search("www.google.com");
		
		
		
	}

}
