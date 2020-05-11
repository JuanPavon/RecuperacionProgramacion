
public class Articulo {
	
	private String nomArt;
	private int cantidadArt;
	
	//Constructor
	
	public Articulo(String nomArt, int cantidadArt) {
		this.nomArt = nomArt;
		this.cantidadArt = cantidadArt;
	}

	//Getters y setters
	
	public String getNomArt() {
		return nomArt;
	}

	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}

	public int getCantidadArt() {
		return cantidadArt;
	}

	public void setCantidadArt(int cantidadArt) {
		this.cantidadArt = cantidadArt;
	}

	//ToString
	@Override
	public String toString() {
		return this.nomArt + ", " + this.cantidadArt + " unid.\n";
	}

	
	
	
}
