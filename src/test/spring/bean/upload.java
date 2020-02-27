package test.spring.bean;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class upload {

	@RequestMapping("uploadForm.do")
	public String uploadForm() {
		System.out.println("test");
		return "spring03/uploadForm";
		
	}
	
	
	@RequestMapping("uploadPro.do")
	public String uploadPro(String writer, MultipartHttpServletRequest request) { 
		// MultipartHttpServletRequest 사용해야함, 기존 HttpServletRequest 로는 파일을 받을 수 없음.		
		System.out.println("writer = " + writer);
		MultipartFile mf = null;
		try {
			mf = request.getFile("img"); // 보내는 jsp 파일의 보내는 속성의 name 을 적어주기.
			// 파일 저장할 경로 + 파일명 -> File 객체 생성
			File copyFile = new File("d://save//" + mf.getOriginalFilename()); // 파일의 이름을 정해서 해당 주소에 저장해줌.
			// 파일을 위치 + 파일명으로 저장
			mf.transferTo(copyFile);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "spring03/uploadPro";
		
	}
	
}
