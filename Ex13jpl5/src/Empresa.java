

public class Empresa implements Cliente {
  private String cif;
  private String nombre;
  private String telefono;

  public Empresa(String cif, String nombre, String telefono) {
    this.cif = cif;
    this.nombre = nombre;
    this.telefono = telefono;
  }
  
  @Override
  public void compra(Comercial c, Articulo a) {
    c.vende(a);
  }
  
}
