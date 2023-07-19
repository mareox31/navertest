package board.spring.mybatis;

//dto.getMember().getName() //작성자 이름이 이렇게 해야 나옴. 
//컬럼이름 변수이름 일치하면 dto변수에 자동주입. 근데 만약, 
// member컬럼이 있으면 자동주입이지만, name이랑 똑같은 변수는없어. 
//그래서 name가져오는데, memberDTO안의 member자리에 셋팅해줘 해야함. 
//컬럼명 name, 저장 변수는 member안의 name임.
//member.name 변수 - name 컬럼 =>일치안하니까, 일치하는거라고 알려줘야 한다. 그래야 boardMEmber관련값 지정변수에 다 가져올수있음.
//board-mapping으로간다.

//board가 주가되고 member가 포함됨. 형태로 만들음. ->board포함 종속관계 member
public class BoardMemberDTO {
	int seq;
	String title, contents;
	MemberDTO member; //writer를 바꿈. c_member에 맵핑되는 변수선언. writer대신함. /이름,이메일,폰번호까지알아내려고.
	int pw, viewcount;
	String writingtime;
	
	
	//getter/setter 
		//#{dto.memberid} 직접적 멤버id변수가아니라, 겟터메서드 가져오는 표현이다. 그래서, mybatis DTO쓸거는 변수선언후 게터세터필수!!!!!!!!!!!!
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MemberDTO getMember() {
		return member;
	}
	public void setMember(MemberDTO member) {
		this.member = member;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}
	
	
	
	
	
}
