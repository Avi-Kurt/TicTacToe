package app.game.TickTacToe.Exeptions;

public class CustomException extends Exception {

	//Exception Attributes.
	private static final long serialVersionUID = -2503787217363647408L;

	//Custom Text Injection.
	public CustomException(String message) {
		super(message);
	}
}
