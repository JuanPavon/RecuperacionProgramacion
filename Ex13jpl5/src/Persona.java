

public class Persona {
  protected String nombre;
  private String correoElectronico;

  public Persona(String nombre, String correoElectronico) {
    this.nombre = nombre;
    this.correoElectronico = correoElectronico;
  }

  public Persona(String nombre2) {
	this.nombre = nombre2;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCorreoElectronico() {
	return correoElectronico;
}

public void setCorreoElectronico(String correoElectronico) {
	this.correoElectronico = correoElectronico;
}

@Override
  public String toString() {
    return "Nombre: " + nombre + "\nCorreo electrónico: " + correoElectronico;
  }

public int compareTo(Usuario u) {
	// TODO Auto-generated method stub
	return 0;
}

public int compareTo(Comercial c) {
	// TODO Auto-generated method stub
	return 0;
}

}
