package global.sesoc.ajax.vo;

public class Person {
	String name;
	String pw;
	
	Person(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Person(String name, String pw) {
		super();
		this.name = name;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", pw=" + pw + "]";
	}
	
	
}
