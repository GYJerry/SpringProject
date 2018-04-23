package cn.simplemind.springCfgBaseJave;

public class HelloWorld {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}
	
	public void goInit() {
		System.out.println("The bean is going through init.");
	}
	
	public void goDestroy() {
		System.out.println("The bean will destroy now.");
	}
	
}
