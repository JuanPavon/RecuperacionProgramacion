import java.util.ArrayList;

public class Persona {
	
	  private String nombre;
	  private String correo;
	  private ArrayList<Articulo> venta = new ArrayList<>();
	  
	  
	  //Constructor, sin incluir el arrayList
	public Persona(String nombre, String correo) {

		this.nombre = nombre;
		this.correo = correo;
	}

	//Getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public ArrayList<Articulo> getVenta() {
		return venta;
	}


	public void setVenta(ArrayList<Articulo> venta) {
		this.venta = venta;
	}
	  
	  
	  public void compra(Persona p1, Articulo a1) {
		    if (p1.getVenta().contains(a1)) {
		      int cantidadNueva = a1.getCantidadArt();
		      int posicion = p1.getVenta().indexOf(a1);
		      int cantidadAntigua = p1.getVenta().get(posicion).getCantidadArt();
		      int cantidadActualizada = cantidadAntigua + cantidadNueva;
		      p1.getVenta().get(posicion).setCantidadArt(cantidadActualizada);
		    } else {
		      p1.getVenta().add(a1);
		    }
		  }

	  //ToString
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", correo=" + correo + ", venta=" + venta + "]";
	}
	  
	  
}
