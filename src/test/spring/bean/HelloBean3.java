package test.spring.bean;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBean3 {

	@RequestMapping("abcd.do")
	public String abc(String name, Model md) {
		System.out.println(name);
		md.addAttribute("name", name);
		
		return "spring03/abcd" ; 
	}
	
	@RequestMapping("download.do")
	public ModelAndView down() {
		//개발자가 원하는 다운받게 할 파일을 연결.
		File f = new File("D:\\save\\2.png");
		
		
		
		ModelAndView mv = new ModelAndView("fileDown", "downloadFile", f);
		// fileDown 은 추가해준 bean 객체의 ID 값.
		// 페이지 이동이 아니라 DownLoadView를 실행하겠다해서 빈으로 연결.
		// downloadFile : 파라미터명 지정
		// f : 다운받아가게 할 데이터
		
		return mv;
	}
	
}
