package ch08_1_interface;

interface RemoteControl {
	// 상수	
//	~ static final 메소드 영역에 저장되기때문에 사실 interface RemoteControl 밖에 위치
//	~ static은 전역변수이기 때문에 메소드영역에 저장
//	~ static final 안써도 interface 안에서 필드는 static final 으로 저장된다
	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	//추상 메소드
//	~ abstract 안써도 interface 안에서 필드는 abstract 으로 저장된다
//	~일부로 구현부를 써주지 않아서 강제성을 만들어 준 것
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void setVolume(int volume);	
}

//	A implements B ... A는 B를 구현했다
// A implements B, C, D... interface는 다중으로 구현 할 수 있다! 그게 목적이니까
//  -> 이 구조가 맞는지 모르겠음
class Television implements RemoteControl {
	//필드
	private int volume;
	private String name;
	
	public Television(String name) {
		this.name = name;
	}
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
}

public class RemoteControlExample {
	public static void main(String[] args) {
		// 각 제조사 전자기기가 완성되어야만 실행 코드를 작성할 수 있다.
		Television tv1 = new Television("샘송");
		Television tv2 = new Television("엘지");
		tv1.turnOn();
		tv2.turnOn();
	}
}
class Audio implements RemoteControl {
	//필드
	private int volume;
	
	//turnOn() 추상 메소드의 실체 메소드
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	//turnOff() 추상 메소드의 실체 메소드
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}
	//setVolume() 추상 메소드의 실체 메소드
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
}
