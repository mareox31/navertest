package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class HelloController {
@RequestMapping("/helloboot") //requestmapping 겟/포스트 다 됨.
public ModelAndView helloboot() { //String 리턴시 뷰이름. //현재 모델앤뷰 리턴.
	ModelAndView mv = new ModelAndView();
	mv.addObject("model","스프링부트를 시작합니다.");
	mv.setViewName("hello");
	return mv;

}


@RequestMapping("/helloajax") //에이젝스 전송데이터 뭔지, 타입뭔지줘. //보드dto, 지원해도 변환라이브러리 부트내장이라 알아서바뀜.단. responsebody붙여
@ResponseBody //이거붙이면 자동 변환 json 메서드 리턴타입앞이라도됨. 
public String helloajax() { 
	return "{\"model\" : \"스프링부트(ajax)를 시작합니다.\"}"; //변수이름 모델//모델하나전달임.

}



}


/*헬로컨트롤러, 헬로.jsp 에이젝스->responsebody사용.
 * 
 * 
 * 
 */