package cn.simplemind.di;

public class TextEditorAutowiredByType {
	private SpellChecker checker;
	
	private String name;
	
	public SpellChecker getChecker() {
		return checker;
	}

	public void setChecker(SpellChecker checker) {
		this.checker = checker;
	}

	public String getName() {
		
		System.out.println(name);
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void spellCheck() {
		checker.checkSpelling();
	}
}
