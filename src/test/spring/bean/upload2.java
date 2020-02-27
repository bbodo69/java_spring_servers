package test.spring.bean;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class upload2 {

	@RequestMapping("uploadForm2.do")
	public String uploadForm() {
		System.out.println("test");
		return "spring03/uploadForm2";
		
	}
	
	
	@RequestMapping("uploadPro2.do")
	public String uploadPro(String writer, MultipartHttpServletRequest request, Model md) { 
		// MultipartHttpServletRequest 사용해야함, 기존 HttpServletRequest 로는 파일을 받을 수 없음.		
		System.out.println("writer = " + writer);
		MultipartFile mf = null;
		String newName = null;
		
		try {
			
			
//			// #2. 서버에 저장
//			mf=request.getFile("img");
//			String path = request.getRealPath("save"); // 서버상의 save 폴더 경로 가져오기
//			System.out.println(path);
//			String imgPath = path + "||" + mf.getOriginalFilename(); 
//			File copyFile = new File(imgPath);
//			mf.transferTo(copyFile);
			
			// #3. 파일 이름 중복처리 : 새로운 파일명+확장자만들기
			// 오리지널 파일명+날짜
			mf = request.getFile("img");
			
			String orgName = mf.getOriginalFilename(); // 오리지널 파일명
			String imgName = orgName.substring(0, orgName.lastIndexOf('.')); // 파일이름만
			String ext = orgName.substring(orgName.lastIndexOf('.')); // 확장자만
			long date = System.currentTimeMillis();
			newName = imgName+date+ext;
			System.out.println(newName);
			
			String path = request.getRealPath("save");
			System.out.println(path);
			String imgPath = path + "\\" + newName;
			System.out.println(newName);
			File copyFile = new File(imgPath);
			mf.transferTo(copyFile);
			
			md.addAttribute("newName", newName);
			
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "spring03/uploadPro2";
		
	}
	
}