package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	@RequestMapping("/filedownloadlist")
	public ModelAndView downladlist() {
		
		//자바 파일클래스
		//파일 -디렉토리정보? 
		//파일시스템정보 = 폴더와 파일 모두 얘기함. 폴더도 파일객체 만들수있음.
		File f = new File("c:/kdt/upload/"); //디렉토리이름
		String[] filearray= f.list();//파일이름만 스트링배열로 리턴함.
		//파일다운로드 목록 나옴.
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filearray", filearray);//전달어트리뷰트이름, 넣을거. //c:'kdt'upload'파일이름 모델로 저장
		mv.setViewName("upload/downloadlist");
		return mv;
	}
	
	//filedownloadresult?filename=${filename }
	//파일다운로드 해줄 코드 만든다. 뷰보여줄거아니므로 void리턴필요없어.
	//받아와야하면, 리스폰스 필요, 매개변수사용.
	@RequestMapping("/filedownloadresult")
	public void downloadresult(String filename,HttpServletResponse response) throws IOException {
		response.setContentType("application/download");//다운로드파일!! 넘어가는게 목적임.
		response.setContentLength((int)(new File("c:/kdt/upload/" + filename).length()));//선택파일 총 길이 / 길이지정 필수, 얼마나 걸리고 그런거?
		//고정표현, 파일다운로드할거 넘어가는거============
		//파일객체 실제 서버내부저장경로는 실제 파일경로.
		//"c:/kdt/upload/" + filename
		//저걸 파일로 만들고 .length.
		//long타입이라 범위가 더 커서. int타입들어갈곳이라. 인트로 형변화해.
		
		response.setHeader("content-Disposition", "attachment;filename=\""+ filename+"\"");
		//클라이언트가 받아야할 파일 이름?"attachment;filename="b.jsp"" 이중따옴표붙어야됨. ↑클라이언트가 받을때 보는이름.
		//---------여기까지 설정임.
		
		//이제부터 다운하라는동작---------
		//response응답.
		//클라이언트쪽으로 파일전송.
		OutputStream out = response.getOutputStream();
		//출력대상 파일형태
		FileInputStream fin = new FileInputStream(new File("c:/kdt/upload/" + filename));
		//실제 다운해야할 파일 new File("c:/kdt/upload/" + filename)
		FileCopyUtils.copy(fin, out); //스프링서 제공하는 파일복사 클래스.
		//fin에서 읽어서, 어디로카피? out으로 카피.(브라우저로가라) 서버도남아있고, 서버 복사본을 브라우저로 복사.
		fin.close();
		out.close();
		
		
	}
	 
	
}
