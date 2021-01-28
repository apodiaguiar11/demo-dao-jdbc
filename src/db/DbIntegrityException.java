package db;

//Essa é a exceção para o caso da integridade referencial

public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbIntegrityException(String msg) {
		super(msg);
	}
		
	
}
