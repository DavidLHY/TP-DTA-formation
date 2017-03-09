package fr.pizzeria.exception;

public class SavePizzaException extends DaoException {

	public SavePizzaException() {
		super();
	}

	public SavePizzaException(String string) {
		super(string);
	}

	public SavePizzaException(Throwable cause) {
		super(cause);
	}
	
	public SavePizzaException(String message, Throwable cause) {
		super(message,cause);
	}

}
