package exception;

//アプリケーション内で発生した例外を受け持つ
public class CalorieException extends Exception {

	public CalorieException(String message) {
		super(message);
	}

}
