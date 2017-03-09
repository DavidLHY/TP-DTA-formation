package fr.pizzeria.exception;

public class DeletePizzaException extends DaoException {

	public DeletePizzaException() {
		super();
	}

	public DeletePizzaException(String string) {
		super(string);
	}

	public DeletePizzaException(Throwable cause) {
		super(cause);
	}
	
	public DeletePizzaException(String message, Throwable cause) {
		super(message,cause);
	}

}
