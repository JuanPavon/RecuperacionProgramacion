import java.util.ArrayList;

public class Usuario extends Persona implements Cliente{
	
	private String tlfCli;
	
	public Usuario(String nombre, String correo, String tlfCli) {
		super(nombre, correo);
		this.tlfCli = tlfCli;
		// TODO Auto-generated constructor stub
	}

}
