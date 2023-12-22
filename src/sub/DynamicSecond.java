package sub;

import core.DynamicParent;
import util.MessageUtil;

public class DynamicSecond implements DynamicParent {
	
	public void init() {
		System.out.println("DynamicSecond init()");
		MessageUtil.notice();
	}
	
	
	public  void response() {
		
		System.out.println("DynamicSecond Here~");
		MessageUtil.notice();
	}
}
