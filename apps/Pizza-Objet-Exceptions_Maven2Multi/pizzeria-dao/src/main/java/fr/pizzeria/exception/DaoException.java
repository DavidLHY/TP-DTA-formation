package fr.pizzeria.exception;

public class DaoException extends RuntimeException {

	public DaoException() {
		super();
	}

	public DaoException(String string) {
		super(string);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message, Throwable cause) {
		super(message,cause);
	}
}
