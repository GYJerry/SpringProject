package cn.simplemind.di;

public class TextEditorUseConstructor {
	private SpellChecker spellChecker;

	public TextEditorUseConstructor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
