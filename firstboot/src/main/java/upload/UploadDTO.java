package upload;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO {

	String name, desc;
	MultipartFile file1, file2;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {
		return file2;
	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	
}

//폼에서 받아올값. 저장.
//변수 게터세터(자동생성어노테이션있음-스프링부트)