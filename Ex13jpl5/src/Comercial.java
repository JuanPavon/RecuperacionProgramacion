

import java.util.ArrayList;
import java.util.Objects;

public class Comercial extends Persona {
  private String cargo;
  private ArrayList<Articulo> articulos = new ArrayList<>();

  public Comercial(String nombre, String correoElectronico, String cargo) {
    super(nombre, correoElectronico);
    this.cargo = cargo;
  }

  public Comercial(String nombre) {
	super(nombre);
}

public String getCargo() {
	return cargo;
}

public void setCargo(String cargo) {
	this.cargo = cargo;
}

public void vende(Articulo a) {
    if (this.articulos.contains(a)) {
      int posicion = this.articulos.indexOf(a);
      int cantidadActual = this.articulos.get(posicion).getCantidad();
      this.articulos.get(posicion).setCantidad(cantidadActual + a.getCantidad());
    } else {
      articulos.add(a);
    }
  }

  @Override
  public String toString() {
    String resultado = super.toString(); // nombre y correo electrónico
    
    resultado += "\nCargo: " + this.cargo;
    resultado += "\nVentas realizadas\n=================\n";
    
    for (Articulo articulo : articulos) {
      resultado += articulo.toString() + "\n";
    }
    
    return resultado;
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
	    final Comercial other = (Comercial) obj;
	    if (!Objects.equals(this.nombre, other.nombre)) {
	      return false;
	    }
	    return true;
	  }
  
	@Override
	public int compareTo(Comercial c) {
		// TODO Auto-generated method stub
		return this.getNombre().compareTo(c.getNombre());
	}
  
}
