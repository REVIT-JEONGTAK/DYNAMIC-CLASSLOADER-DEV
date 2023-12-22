package sub;

import core.DynamicParent;
import util.MessageUtil;

public class DynamicFirst implements DynamicParent {

	public DynamicFirst() {
		System.out.println("Create DynamicFirst Constructor");
		this.init();
	}
	
	public void init() {
		System.out.println("DynamicFirst init()");
		
		DynamicSecond ds = new DynamicSecond();
		ds.init();
		ds.response();
		
		MessageUtil.notice();
	}
	
	public  void response() {
		
		System.out.println("DynamicFirst Here~");
	}
}
