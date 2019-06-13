package labTerminalB;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;
	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}
	public int getPriceCode() {
		return _priceCode;
	}
	public void setPriceCode(int arg) {
		_priceCode = arg;
	}
	public String getTitle (){
		return _title;
	};
}

/*
 * TODO 4		20 Marks
 * Identify the bad smells in the statement method and refactor the code
 * In case you add a new method also provide specifications for new method
 * after refactoring all test cases must still be passed
 * Commit after each change and include a meaningful message about the change you made
 * e.g. Method Move methodName();
 * 
 */

/**
 * TODO 3		10 Marks
 * Provide suitable specification for statement method 
 */

