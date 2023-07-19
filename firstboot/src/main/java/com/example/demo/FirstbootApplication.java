package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import upload.MyPathConfig;

@SpringBootApplication //대장,메인임//@ComponentScan(basePackages =com.example.demo) 1.서버시작+2.저 패키지스캔을 표현함. 
//근데 밑에 컴포넌트 스캔 추가하면 기본 @ComponentScan(com.example.demo)이게 사라짐 그래서 추가해줘야함.
//패키지 늘때마다 여기다가죄다 스캔 넣어주는것임.
@ComponentScan //(basePackages ="com.example.demo") -자기패키지는 걍 저거만써도됨.-현재패키지

//@ComponentScan(basePackages = "upload") //패키지를 넣어줌 -패키지명 직접알떄
@ComponentScan(basePackageClasses = MyPathConfig.class) //둘중하나표현써-자기패키지, 여기꺼 두개 스캔하게됨.
@ComponentScan(basePackages = "errors")
@ComponentScan(basePackages = "board.spring.mybatis")
//@Service, @Repository, @Component, @Controller, @Configuration

@MapperScan(basePackages = "board.spring.mybatis")
//@Mapper는 스캔못해(DB관련, db연결시만 씀. ) 그래서 맵퍼 읽는 맵퍼스캔써야함. db읽는부분 또 생기면 또 해줘야함.
public class FirstbootApplication {

	//1.스프링부트 메인클래스 : 서버 자동시작 -com.example.demo;  @패키지 스캔도 포함한다
	//2. jsp파일 경로 / 확장자 비포함. -서블릿api비포함, jstl 비포함 - pom.xml 수동 추가설정 
	//(알려줘야함. xml없애자했으니, 하나로통일하던가, xml사용하지말고 설정하나로만들자.) 다양확장뷰써.
	//3. xml은 최소화된다. (sql정의파일은 필요함) / application.properties 파일 설정.(스프링부트모든설정가진곳)
	// src/main/resources/application.properties - 서버포트, jsp확장자/경로설정.
	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
		System.out.println("서버 시작중-메인시작 출력용도. 메인건드릴거없음.");
	}

}

/*4. ajax - pom.xml-라이브러리추가x
 * 
 * ** jquery 라이브러리는 추가해줘야함O ( 위치 : 스프링mvc모든 라이브러리추가 src-main/webapp/resources(sts3)
 * ** src/main/resources/static/js/jqueryxxx.js
 * 						/static/images/*.*
 * 						/static/css/*.css
 * [sts4저게기본**스테틱폴더** ↑ sts3에선 리소스-리소시즈 서블릿컨텍스트.xml에있었었음]
 * [url서 호출할 땐 =>http://localhost:8063/js/jquery...js 경로가져와서쓴다. //에이젝스는 제이쿼리파일필요하므로]
 * [정적폴더 이미잡혀있어서 static은 빼  // 정적파일 위치올바른가보자]
 * 
 * 
 *  file upload- pom.xml에 dependency 추가라이브러리가 있었음(sts3)
 *
 * 5-1. 파일업로드 - pom.xml 라이브러리추가X
 * 5-2.servlet-context.xml ...불필요  = > 파일업로드는 - >멀티파트리졸버=>멀티파트 해석해줘도 있었다.
 * 4+5, 추가안해도 자동으로됨. 소스만 작성하면 된다.  
 * 
 * 
 * 5-3. javax.servlet 패키지명 - jakarta.servlet import (기존임포트 삭제, 다시 임포트) -새로 임포트할 것.!
 * 업로드 c:/kdt/upload/a.png 업로드 했다면, 웹브라우저서 
 * 업로드 파일 저기다 만들어놨엄 ↑ 그대로 되나 보자. 
 * http://localhost:8063/upload/a.png 호출해서 브라우저내부서 그대로 보여주고싶다. 
 * STS3  c:/kdt/upload 외부환경. resources mapping에다  썼었음.   
 *리소스 태그에 의해서 보는건. 
 *스프링 mvc선.컨텍스트포함되었었음 sts3 http://localhost:8063/first/upload/a.png
 * 
 * =>xml없이 설정 추가하는 방법!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * boot 외부 환경 접근 위해 URL하나 맵핑하는 과정 !%%%%%%%%%@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%@@@@@@@@@@@@@@
 * 서버파일저장폴더 = url맵핑 ( 브라우저에서도 직접 url통해 해당 폴더 접근해서 내용을 보여주고 싶다)
 * 
 * 
 * 
 */





//역할 : 톰캣서버 시작역할을 한다. 저 코드에 다 포함되어있음. 서버시작코드임.
//@패지키 스캔 메인메서드 가진  package com.example.demo;이 패키지꺼만 스캔한다. 
//( sts3@패키지 어딨냐? 그래야 서버시작-패키지읽어감.)


//jsp기본뷰 아님. mvc서 저 설정이 기본있었어.부트는 저 설정이없어. 필요하면, 수동추가설정.