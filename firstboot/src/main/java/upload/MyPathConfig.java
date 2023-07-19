package upload;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //xml대신하는 자바설정파일
//@ComponentScan(basePackages = "upload") //패키지를 넣어줌 -패키지명 직접알떄
//@ComponentScan(basePackageClasses = MyPathConfig.class) //이 클래스가 존재하는 패키지- 클래스 스캔할때 저 클래스있는 클래스로써라란뜻.
//컴포넌트 스캔 스프링메인클래스로옮겨거라. 
public class MyPathConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/kdt/upload/");
	}
}


//맵핑 - 업로드 하위폴더까지 포함한다 / 실제경로  
	 //sts3 <resources mapping="/upload**" location="file///c:kdt/upload" />
	//맥북 file:kdt/upload
// MyPathConfig - 이파일이 설정파일이야 알려줘야함(xml없으니까 )=>@Configration