package kr.co.busanbank.ap.sub;


public class DynamicFirst {

	public DynamicFirst() {
		System.out.println("Create DynamicFirst Constructor");
		this.init();
	}
	
	public void init() {
		System.out.println("DynamicFirst init()");
		
		DynamicSecond ds = new DynamicSecond();
		ds.init();
		ds.response();
	}
	
	public  void response() {
		
		System.out.println("DynamicFirst Here~");
	}
}
