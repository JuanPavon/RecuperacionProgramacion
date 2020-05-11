import java.util.ArrayList;

public class Comercial extends Persona{
	
	private String cargo;

	//Constructor
	public Comercial(String nombre, String correo, String cargo) {
		super(nombre, correo);
		this.cargo = cargo;
	}

	//Getters y setters
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	//ToString
	@Override
	public String toString() {
	    String resultado = "\nNombre: " + super.getNombre() +
                "\nCorreo electronico: " + super.getCorreo() +
                "\nCargo: " + this.cargo +
                "\nVentas realizadas" +
                "\n=================\n";

		for (Articulo articulo : super.getVenta()) {
			resultado += articulo;
		}
		     
		
		return resultado;
	}
	
	
	
}
