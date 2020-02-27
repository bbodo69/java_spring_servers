package test.spring.bean;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test.spring.model.testDTO;
import test.spring.model.tvDTO;



@Controller
public class HelloBean2 {
	
	// 의존성 자동 주입
	@Autowired
	private Date day = null;
	
	/*
	  	같은 타입의 빈 두가지 있으면 변수이름에 맞게 주입됨.
	  	자동 의존성 주입될때, 기본적으로 "클래스 타입으로 구분" 해서 가져오는데 
	  	(bean의 id 속성값과 이곳의 변수이름이 달라도 상관없음)
	  	만약 같은 타입의 bean 객체가 여러개가 있다면 bean의 id 속성값과 변수명이
	  	동일한 것을 연결해줌.
	 
	 */
	
	@Autowired
	private testDTO dto = null;
	
	@Autowired
	private testDTO dto2 = null;
	
	@RequestMapping("hello2.do")	
	public String hello2() {
		
		System.out.println(day);
		System.out.println("dto = " + dto.getId());
		System.out.println("dto = " + dto.getReg());
		System.out.println("dto = " + dto.getPw());
		
		System.out.println("dto2 = " + dto2.getId());
		System.out.println("dto2 = " + dto2.getReg());
		System.out.println("dto2 = " + dto2.getPw());
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	
	

	@RequestMapping("form.do")
	
	public String form() {
		// form.do를 요청하면 보여줘야할 jsp(view) 경로 리턴		
		return "/WEB-INF/views/spring02/form.jsp";
		
	}
	
	@RequestMapping("pro.do")
	
	public ModelAndView Pro(testDTO dto) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", dto.getId());
		mv.addObject("pw", dto.getPw());
		mv.setViewName("/WEB-INF/views/spring02/pro.jsp");
		
		return mv;
	}
	
//	public String pro(testDTO dto, Model model) {
//			// 매개변수 나열해서 폼에넘어오는 데이터 받기.
//			//System.out.println(id);
//			//System.out.println(pw);
//			System.out.println(dto.getId());
//			System.out.println(dto.getPw());
////			System.out.println(request);
////			System.out.println(response);
////			System.out.println(session);
////			System.out.println(request.getRequestURI());
//			
////			request.setAttribute("id", dto.getId());
////			request.setAttribute("pw", dto.getPw());
//			
//			model.addAttribute("id", dto.getId());
//			model.addAttribute("pw", dto.getPw());
//			
//			
//		return "/WEB-INF/views/spring02/pro.jsp";
//	}
	
	@RequestMapping("hello3.do")
	//public String hello3(String test) { //매개변수와 요청파라미터명 동일하게, get 방식으로 test 변수에 값 넣어줘서 url 전송 
	public String hello3(@RequestParam("test") String tost) { // 매개변수 이름 변경되도 괜찮음
		
		System.out.println(tost);
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}

	
	// 일반 메서드 @ModelAttribute 어노테이션 추가
	@ModelAttribute // 모든 뷰에 출력시켜줌
	//@modelAttribute("tvInfo");  //별칭 추가
	public tvDTO getTv(String col) {
		System.out.println("getTv 호출");
		tvDTO tv = new tvDTO();
		tv.setPower(true);
		tv.setCh(10);
		tv.setCol(col);
		
		return tv;
	}

	// 매핑 메서드
	@RequestMapping("hello4.do")
	public String hello4() {
		
		System.out.println("hello4 매핑 매서드 호출");
			
		return "/WEB-INF/views/spring02/helloTv.jsp"; 
	}
	
	// 메서드에 @ModelAttribute 지정
	@RequestMapping("form2.do")
	public String sendMsg() {
		return "/WEB-INF/views/spring02/form.jsp";
	}
	@RequestMapping("pro2.do")
	public String viewMsg(@ModelAttribute("dto")testDTO dto) {
		// 매개변수 testDTO dto 라고 지정하면 set메서드로 자동 바인딩됨
		// 어노테이션 효과로 dto라는 별칭으로 Model에 저장 -> view 에서 꺼낼수있음.
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
				
		return "/WEB-INF/views/spring02/pro2.jsp";
	}
	
	@RequestMapping("hello5.do") // Ajax 랑 연동해서 사용. Ajax는 데이터만 불러들여서 데이터를 이용한다.
	@ResponseBody
	public String hello5() {
		return "hello5";
	}
	
	// RequestMapping 옵션들
	// value=주소 method=전송방식, params=파라미터
	@RequestMapping(value="hello6.do", params="id=java") // id 값이 java 여야 한다.
	public String hello6(String id, String pw, Model md) {
		
		System.out.println(id);
		System.out.println(pw);
		md.addAttribute("id", id);
		md.addAttribute("pw", pw);
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	
	@RequestMapping(value="hello7.do", params= {"id=java", "pw=1234"}) // id, pw 값이 java, 1234 여야 한다.
	public String hello7(String id, String pw, Model md) {
			
		System.out.println(id);
		System.out.println(pw);
		md.addAttribute("id", id);
		md.addAttribute("pw", pw);
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	@RequestMapping(value="hello8.do", params= {"id=java", "!pw"}) // id 값이 java pw 파라미터는 없어야 한다.
	public String hello8(String id, String pw, Model md) {
			
		System.out.println(id);
		System.out.println(pw);
		md.addAttribute("id", id);
		md.addAttribute("pw", pw);
			
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	
	// value : 파라미터명     required : 파라미터 필수 여부 지정     defaultValue : 기본값
	@RequestMapping("hello9.do")
	public String hello9(@RequestParam() String msg) { // msg 가 필요하다
		
			
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	@RequestMapping("hello10.do")
	public String hello10(@RequestParam("id") String msg) { // id 가 필요하다

			
		return "/WEB-INF/views/spring01/hello.jsp";
	}	
	
	@RequestMapping("hello11.do")
	public String hello11(@RequestParam(value="msg", defaultValue="hello") String msg){ 
		//value에 기본값이 들어가있음
			
		System.out.println(msg);
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}		
	
	@RequestMapping("hello12.do")
	public String hello12(@RequestParam(value="msg", required=false) String msg){
		// msg 에 값을 안 넣어주어도 맵핑을 시켜줌
			
		System.out.println(msg);
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}	

	@RequestMapping("hello13.do")	// 자동로그인, 유효성 검사 해주는 방법
	public String hello13(	
			@RequestParam(value="id", required=true) String id,
			@RequestParam(value="pw", required=true) String pw,
			@RequestParam(value="auto", required=false, defaultValue="0")String auto
			){

					
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}		
}
