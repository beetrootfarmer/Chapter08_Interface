package ch08_1_interface;

class PerformanceTest {
	//필드
	RemoteControl rc = new Television("LG");
	
	//생성자
	PerformanceTest(){
	}
	
	PerformanceTest(RemoteControl rc) {
		this.rc = rc;
		rc.turnOn();
		rc.setVolume(5);
	}
	
	//메소드
	void audioTest() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}
	void controlTest(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
	}
	
}

public class PerformanceTestExample {
	public static void main(String[] args) {
		System.out.println("1)---------------");
		
		PerformanceTest test1 = new PerformanceTest();
		test1.rc.turnOn();
		test1.rc.setVolume(5);
		
		System.out.println("2)---------------");
		
		PerformanceTest test2 = new PerformanceTest(new Audio());

		System.out.println("3)---------------");
		
		PerformanceTest test3 = new PerformanceTest();
		test3.audioTest();
		
		System.out.println("4)---------------");
		
		PerformanceTest myClass4 = new PerformanceTest();
		myClass4.controlTest(new Television("샘송"));
	}
}
