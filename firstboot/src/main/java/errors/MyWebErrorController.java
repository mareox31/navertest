package errors;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

//스캔할수있또록 firstbootAplication 스캔추가해야함.
@Controller
public class MyWebErrorController implements ErrorController {

	@RequestMapping("/error") //이제 jakarta패키지로바뀜 ↓
	public String handleError(HttpServletRequest request) {
		Object status =  request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE); 
		//겟어트리뷰트 오브젝트임 형변환필요
		//에러코드 가져온다. 
		//에러내용읽을때 포워드인클루드할떄쓴 리퀘스트 디스패쳐. 자동으로 포워드해준단소리(스프링부트가)
		//누군가 set어트리뷰트했단소리. 스프링부트가 /error자동이동, 스트링부트가 자동이동하며, 에러내용넣어주면 우린 읽어와.
		
		System.out.println("오류 코드 =  " + status);
		//에러메세지 어떻게 줄수있나보자.
		
		System.out.println("오류 메세지 = " + request.getAttribute(RequestDispatcher.ERROR_MESSAGE)); //리퀘스트어트리뷰트 읽어오는데 오류메세지 읽어와.
		System.out.println("파라미터 정보  = " + request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING));
		System.out.println("오류 발생파일 = " + request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
		
		
		
//		int statusCode=Integer.parseInt(status.toString()); //status자체 타입 Objects 저기까지 스트링으로만들어준다.=>다시정수.//결국 404 405같은 숫자임
		return "errors/"+status.toString();//"404"이렇게 나옴. errors/붙여야 뷰 경로임. 
		//return "error"; //error면 error.jsp
	}
}


//에러컨트롤러 상속받아야함.