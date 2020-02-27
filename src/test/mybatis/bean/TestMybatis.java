package test.mybatis.bean;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.model.TestMybatisDTO;

@Controller
public class TestMybatis {
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;	// 쿼리문 작성, 쿼리문 가져오기
	
	@RequestMapping("mybatis.do")
	public String helloMybatis() {
		
		System.out.println();
		return "spring01/hello";
	}
	
	@RequestMapping("testTable.do")
	public String testTable(Model md) {
		
		// sqlSession -> DB -> sql쿼리문 호출 데이터 가져오기
		int count = (Integer)sqlSession.selectOne("test.userCount");		//test(table 이름), userCount (testSQL 에 select 에 id 넣어준값)
		// age가 가장 높은 수 가져오기
		int maxAge = (Integer)sqlSession.selectOne("test.maxAge");
		// 테이블 전체 레코드 가져오기
		List<TestMybatisDTO> userList = sqlSession.selectList("test.selectAll");
		//List userList = sqlSession.selectList("test.selectAll");
		// id를 주고 해당 id에 일치하는 레코드 가져오기
		// 파라미터는 한개만 보낼수 있다.
		// 여러개의 파라미터를 보내고 싶으면 Map 만들어 데이터 넣고 보내야함.
		String id = "123";
		TestMybatisDTO dto = (TestMybatisDTO)sqlSession.selectOne("test.getUser",id);
		// id주고 reg 결과 하나 가져오기
		Timestamp reg = (Timestamp)sqlSession.selectOne("test.getReg", id);
		
		md.addAttribute("count", count);
		md.addAttribute("maxAge", maxAge);
		md.addAttribute("userList", userList);
		md.addAttribute("dto", dto);
		md.addAttribute("reg", reg);
		
		return "spring04/test";
	}
	
	@RequestMapping("insertForm.do")
	public String insertForm() {
		
		
		return "spring04/form";
	}
	
	@RequestMapping("insertPro.do")
	public String insertPro(TestMybatisDTO dto, Model md) {
		
		//DB에 insert
		sqlSession.insert("testInsertUser", dto);
		
		md.addAttribute("dto", dto);
		
		
		return "spring04/pro";
	}
	
	@RequestMapping("updateForm.do")
	public String updateForm(Model md) {
		
		//id 하나 던져주고 해당 전체 정보 가져오기
		String id = "123";
		TestMybatisDTO dto = (TestMybatisDTO)sqlSession.selectOne("test.getUser", id);
		md.addAttribute("dto", dto);
		
		return "spring04/update";
	}
	
	@RequestMapping("updatePro.do")
	public String updatePro(String pw, int age, Model md) {
		
		HashMap map = new HashMap();
		map.put("mapId", "123");
		map.put("mapPw", pw);
		map.put("mapAge", age);
		
		sqlSession.update("test.updateUser", map);
		
		TestMybatisDTO dto = (TestMybatisDTO)sqlSession.selectOne("test.getUser", "123");
		md.addAttribute("dto", dto);
		
		return "spring04/updatePro";
	}
	
	@RequestMapping("delete.do")
	public String delete() {
		
		return "spring04/delete";
	}
	
	
	@RequestMapping("deletePro.do")
	public String deletePro(String id, Model md) {
		
		sqlSession.delete("test.deleteUser", id);
		md.addAttribute("id", id);
		
		return "spring04/deletePro";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
