package upload;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	//업로드시 필요한 절차. 처음엔 겟방식, 전송후 포스트방식.어자피 파일전송포스트방식밖에안됨.
	
	//업로드 폼 화면 리턴
	//STring이면 뷰 이름됨.
	@GetMapping("/fileupload")
	public String uploadform() {
		return "upload/uploadform"; //WEB-INF/VIEWS/upload/uploadform.jsp
	}

	
	
	//업로드 처리 결과 보여주는 메소드.
	@PostMapping("/fileupload")
	public ModelAndView uploadresult(UploadDTO dto) throws IOException{
		String savePath = "c:/kdt/upload/";//경로 프로젝트 외부경로 / first 저안의건 클라이언트가 못봐.
		//볼 수 있도록 해보자. //프로젝트 외부경로 =>웹브라우저가 url로 접근할 수 있는 공간이 아니다. 
		//접근 공간으로 만들어주자. 업로드한 파일 다운로드도해야함. 
		//저 폴더자체가 브라우저로 접속못하니까 하게해준다. 
		//프로젝트 외부 경로 - 기본적 브라우저 url접근 공간x
		//프로젝트 외부 경로 - http://localhost:8071/first/upload/xxx파일들. url로 볼 수 있도록 처리.
		
		
		MultipartFile file1 = dto.getFile1();
		String newFilename1=null;
		if(!file1.isEmpty()) { //첫파일 널아니면 저장.
		String originalname1 = file1.getOriginalFilename();
		String beforeext1 = originalname1.substring(0, originalname1.indexOf(".")); //pom
		String ext1 = originalname1.substring(originalname1.indexOf(".")); //xml
		newFilename1 = beforeext1 + "("+ UUID.randomUUID().toString() + ")" + ext1; //중복회피
		file1.transferTo(new java.io.File(savePath + newFilename1 ));//서버에 파일하나만듬. 복사중. 
		//파일내용 가져와서 복사한다 transfreTo(복사할파일이름과 경로 하나 지정->파일이 서버측에 저장됨)
		}//if
		
		
		MultipartFile file2 = dto.getFile2();
		String newFilename2=null;
		if(!file2.isEmpty()) { //첫파일 널아니면 저장.
		String originalname2 = file2.getOriginalFilename();
		String beforeext2 = originalname2.substring(0, originalname2.indexOf(".")); //pom
		String ext2 = originalname2.substring(originalname2.indexOf(".")); //xml
		newFilename2 = beforeext2 + "("+ UUID.randomUUID().toString() + ")" + ext2; 
		file2.transferTo(new java.io.File(savePath + newFilename2 ));//서버에 파일하나만듬. 복사중. 
		}//if
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("uploadresult", savePath + newFilename1 + "파일에 저장했습니다.");
		mv.addObject("uploadresult2", savePath + newFilename2 + "파일에 저장했습니다.");
		mv.setViewName("upload/uploadresult");
		
		return mv;
	}
	
}

//메소드2개 
//업로드폼 리턴, + 