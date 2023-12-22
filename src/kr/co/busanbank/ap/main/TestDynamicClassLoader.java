package kr.co.busanbank.ap.main;


import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import kr.co.busanbank.ap.core.DynamicParent;
import kr.co.busanbank.ap.core.FileClassLoader;
import kr.co.busanbank.ap.sub.DynamicFirst;
import kr.co.busanbank.ap.util.MessageUtil;

public class TestDynamicClassLoader {
	static String root = null;
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		if ( args.length < 1 ) {
			root = "/";
		} else {
			root = args[0];
		}
		processOnRealTime();

	}
	
	public static void processOnRealTime() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		System.out.println("다이나믹 클래스로더 테스트 시작");
		
		FileClassLoader loader = new FileClassLoader(root);
		
		Class<DynamicParent> klass = ( Class<DynamicParent> )loader.loadClass("sub.DynamicFirst");
		DynamicParent obj = klass.newInstance();
		System.out.println(obj.getClass().getName());

		System.out.println("참조 테스트 시작");
		
		MessageUtil.notice();
		
		System.out.println("메소드 정보 조회...");
		obj.response();
		System.out.println("메소드 실행 완료");
		
		System.out.println("참조 테스트 종료");
		
		System.out.println("다이나믹 클래스로더 테스트 종료");
		
		System.out.println("쓰레스 클래스 변경 감지 및 로더 전환 테스트 시작");
	}
	
	public static void processOnRealTime3() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		System.out.println("다이나믹 클래스로더 테스트 시작");
		
		FileClassLoader loader = new FileClassLoader(root);
		
		Class<?> klass = loader.loadClass("sub.DynamicFirst");
		Object obj = klass.newInstance();
		System.out.println(obj.getClass().getName());

		System.out.println("참조 테스트 시작");
		
		MessageUtil.notice();
		
		try {
			System.out.println("메소드 정보 조회...");
			Method method = klass.getMethod("response");
			method.invoke(obj);
			System.out.println("메소드 실행 완료");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("참조 테스트 종료");
		
		System.out.println("다이나믹 클래스로더 테스트 종료");
		
		System.out.println("쓰레스 클래스 변경 감지 및 로더 전환 테스트 시작");
	}
	
	
	public static void processOnRealTime2() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
		System.out.println("다이나믹 클래스로더 테스트 시작");
		
		FileClassLoader loader = new FileClassLoader(root);
		
		Class<?> klass = loader.loadClass("sub.DynamicFirst");
		Object obj = klass.newInstance();
		System.out.println(obj.getClass().getName());

		System.out.println("참조 테스트 시작");
		
		MessageUtil.notice();

		
		try {
			System.out.println("형변환 진행중...");
			DynamicFirst df = (DynamicFirst)obj;
			System.out.println("형변환 클래스 형변환 성공");
			df.response();
		} catch( Exception e ) {
			System.out.println("참조 실패");
		}
		
		System.out.println("참조 테스트 종료");
		
		System.out.println("다이나믹 클래스로더 테스트 종료");
		
		System.out.println("쓰레스 클래스 변경 감지 및 로더 전환 테스트 시작");
	}

}
