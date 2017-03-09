package fr.pizzeria.exception;

public class UpdatePizzaException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdatePizzaException() {
		super();
	}

	public UpdatePizzaException(String string) {
		super(string);
	}

	public UpdatePizzaException(Throwable cause) {
		super(cause);
	}
	
	public UpdatePizzaException(String message, Throwable cause) {
		super(message,cause);
	}

}
