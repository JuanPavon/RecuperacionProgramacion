
public class Empresa implements Cliente{

	 private String CIF;
	 private String nomCli;
	 private String telefono;
	  
	 // Constructor
	 public Empresa(String CIF, String nomCli, String telefono) {
	   this.CIF = CIF;
	   this.nomCli = nomCli;
	   this.telefono = telefono;
	 }
	  
	 //Getters y setters
	 public String getCIF() {
		return CIF;
	}


	public void setCIF(String cIF) {
		CIF = cIF;
	}


	public String getNomCli() {
		return nomCli;
	}


	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
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

}
