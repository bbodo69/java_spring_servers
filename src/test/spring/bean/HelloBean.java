package test.spring.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 컨트롤러 어노테이션 : 컨트롤러에서 이 클래스를 호출할 수 있는 빈이라고 반드시 표시
@Controller
//@RequestMapping("/test/*")    // url, 주소에 context( spring ) 에 /test/ 가 추가 된것. 폴더가 하나 더 추가 된 것과 같음.
public class HelloBean {

	@RequestMapping(value="hello.do", method=RequestMethod.GET) // 메서드 레벨로 매핑해준 것 // get, post 방식 가느앟지만, 설정안하면 두가지 모두 가능
	//@GetMapping("hello.do") // get 방식 요청. 위에 처럼 method=RequestMethod.GET 으로 해도 됨. 2가지 방법이 있다. spring 4.3 버전 부터.
	//@PostMapping("hello.do") // post 방식은 설정 후에 가능. 요청을  post 주기 때문에 받을때 설정이 필요
	public String hello() {
			
		return "/WEB-INF/views/spring01/hello.jsp";
	}

	
}
