package kr.co.busanbank.ap.util;

public class MessageUtil {

	private static MessageUtil mu = new MessageUtil();
	
	private MessageUtil(){}
	
	public static void notice() {
		System.out.println("MessageUtil Reference Test START");
		System.out.println("MessageUtil is referenced on Default ClassLoader");
		System.out.println("MessageUtil Reference Test FINISH");
	}
}
