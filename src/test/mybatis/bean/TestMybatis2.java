package test.mybatis.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.model.TestMybatisDTO;

@Controller
public class TestMybatis2 {

	@Autowired	
	private SqlSessionTemplate sqlSession = null;
	
	@RequestMapping("selectIf.do")
	public String selectIf() {
		
//		int count = (Integer)sqlSession.selectOne("myba.selectIf", null);
//		System.out.println(count);
		
//		TestMybatisDTO dto = new TestMybatisDTO();
//		dto.setId("adas");
//		dto.setPw("asdad");
//		dto.setAge(123);
		
//		int count = (Integer)sqlSession.selectOne("myba.selectIf2", dto);
//		System.out.println(count);
				
//		int count = (Integer)sqlSession.selectOne("myba.choose", dto);
//		System.out.println(count);
		
//		sqlSession.update("myba.updateTest", dto);
		
		List list = new ArrayList();
		list.add("java");
		list.add("java1");
		list.add("java2");
		list.add("java3");
//		int count = (Integer)sqlSession.selectOne("myba.selectIn", list);
//		System.out.println(count);
		
		// like 구문
//		HashMap map = new HashMap();
//		map.put("sel", "id");	// 검색할 카테고리 : DB 컬럼명
//		map.put("keyword", "java"); // 검색키워드 : 사용자가 입력한값
//		int count = (Integer)sqlSession.selectOne("myba.selectLike", map);
//		System.out.println(count);
		
//		TestMybatisDTO dto = new TestMybatisDTO();
//		dto.setId("adas");
//		dto.setPw("asdad");
//		sqlSession.update("myba.updateKey", dto);
		
		TestMybatisDTO dto = new TestMybatisDTO();
		dto.setPw("asdad");
		dto.setAge(123);
		// 위에 id 값을 set 해주지 않았지만 xml 파일 keyProperty 에 값을 넣어줬다.
		sqlSession.insert("myba.insertKey", dto);
		
		return "spring05/selectIf";
	}
	
}
