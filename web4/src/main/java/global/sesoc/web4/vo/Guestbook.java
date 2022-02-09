package global.sesoc.web4.vo;

/**
 * 방명록 글 정보 VO
 */
public class Guestbook {
	int num;					//글번호
	String name;				//작성자 이름
	String password;			//삭제시 사용할 비밀번호
	String content;				//글내용
	String inputdate;			//작성날짜, 시간
	
	public Guestbook() {
	}

	public Guestbook(int num, String name, String password, String content, String inputdate) {
		this.num = num;
		this.name = name;
		this.password = password;
		this.content = content;
		this.inputdate = inputdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	@Override
	public String toString() {
		return "Guestbook [num=" + num + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", inputdate=" + inputdate + "]";
	}
}
