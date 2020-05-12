
import java.util.Objects;

class Articulo {
  private String nombre;
  private int cantidad;

  public Articulo(String nombre, int cantidad) {
    this.nombre = nombre;
    this.cantidad = cantidad;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.nombre);
    return hash;
  }

  @Override
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
    final Articulo other = (Articulo) obj;
    if (!Objects.equals(this.nombre, other.nombre)) {
      return false;
    }
    return true;
  }

  public int getCantidad() {
    return cantidad;
  }
  
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  @Override
  public String toString() {
    return nombre + ", " + cantidad + " unid.";
  }
}
