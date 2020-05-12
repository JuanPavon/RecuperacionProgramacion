import java.util.Objects;

public class Usuario extends Persona implements Cliente {
	
	private String telefono;
	
  public Usuario(String nombre, String correoElectronico, String telefono) {
    super(nombre, correoElectronico);
    this.telefono = telefono;
  }

  public Usuario(String nombre) {
	super(nombre);
}

@Override
  public void compra(Comercial c, Articulo a) {
    c.vende(a);
  }
	
	@Override
	  public String toString() {
	    return "Nombre: " + this.getNombre() + "\nCorreo electrónico: " + this.getCorreoElectronico() + "\nTelefon: " + telefono;
	  }

	  
	  public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean equals(Object obj) {
		    if (this == obj) {
		      return true;
		    }
		    if (obj == null) {
		      return false;
		    }
		    if (getClass() != obj.getClass()) {
		      return false;
		    }
		    final Usuario other = (Usuario) obj;
		    if (!Objects.equals(this.nombre, other.nombre)) {
		      return false;
		    }
		    return true;
		  }
	  
		@Override
		public int compareTo(Usuario u) {
			// TODO Auto-generated method stub
			return this.getNombre().compareTo(u.getNombre());
		}

}
