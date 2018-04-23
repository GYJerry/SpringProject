package cn.simplemind.di;

public class TextEditorAutowiredByConstructor {
	private SpellChecker checker;

	private String name;

	public TextEditorAutowiredByConstructor(SpellChecker spellChecker, String name) {
		System.out.println("Inside TextEditor constructor.");
		this.checker = spellChecker;
		this.name = name;
	}

	public String getName() {

		System.out.println(name);

		return name;
	}

	public void spellCheck() {
		checker.checkSpelling();
	}
}
