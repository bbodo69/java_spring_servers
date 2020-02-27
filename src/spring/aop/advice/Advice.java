package spring.aop.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Advice {

	// Joinpoint : 대상 객체 및 호출되는 메서드에대한 정보 또는 전달되는 파라미터에 대한 정보가 필요하여 작성.
	// * 스프링에서 aop는 데이터 받는 등의 처리는 불가능, 예를 들어 로그인 체크하는 것 정도나 유효성
	// 검사등으로 사용이 가능함.
	public void before(JoinPoint j) {
		System.out.println("before 발생!!");
		System.out.println("=====" + j.getTarget()); // 타겟이 어떤 객체인지 출력
		
		// AOP에서 MVC request 객체 사용방법
		RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes sa = (ServletRequestAttributes)ra;
		HttpServletRequest request = sa.getRequest();
		HttpSession session = request.getSession();
	/*
	  	RequestContextHolder
	  	controller, service, DAO 전 구간에서
	  	HttpServletRequest에 접근할 수 있도록 도와주는 클래스
	  	
	  	#HttpServletRequest
	  	요청받은 HTTP URI, HTTP method, HTTP body 등을 사용할수 있고
	  	HTTP header 에서 cookie 를 확인 할 수 있다.
	  	
	  	# session에 대한 주의사항
	  	
	  
	 */
		
	}
	
	public void after() {
		System.out.println("after 발생!!!");
	}
	
	public void afterReturning() {
		System.out.println("afterReturning 발생!!!");
	}
	
	public void afterThrowing() {
		System.out.println("afterThrowing 발생!!!");
	}
	
/*
	  around advice 메서드 구현 방법 !
	  org.aspectj.lang.ProceedingJoinpoint 타입의 매개변수를 첫번째로 지정해줘야함.
  	     그렇지 안흥면 초기화 과정에서 인셥션 발생
  	     리턴타입은 Object 타입으로 지정.
  	  j.proceed() 호출시 돌려주는 객체의 타입이  Object이며, 이 객체를 리턴해줘야
  	     원하는 페이지까지 잘 처리가 된다.  	     	      
*/
	
	public Object around(ProceedingJoinPoint j) throws Throwable {
		
		// around는 전후 동작을 포함하는것이 아니라, 어디부터 어디까지가 전이고 후인지
		// 구분해줘야함
		// proceed() 메서드는 핵심메서드 즉, 원래 호출되어야하는메서드(main*) 를 호출해준다.
		
		System.out.println("around before!!!");		
		Object obj = j.proceed();
		System.out.println("around after!!!");
		return obj;
		
	}
}
