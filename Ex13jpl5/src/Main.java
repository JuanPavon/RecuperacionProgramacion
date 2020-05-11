import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//	    Usuario pepe = new Usuario("Pepe", "pepe@yahoo.com", "555 123456");
//	    Usuario pablo = new Usuario("Pablo", "pablo@gmail.com", "555 112233");
//	    Empresa ofiMalaga = new Empresa("B123456", "Ofi Málaga", "555 654321");
//	    Comercial juan = new Comercial("Juan", "juan@hotmail.com", "jefe de ventas");
//	    Comercial luis = new Comercial("Luis", "luis@gmail.com", "coordinador de ventas");
//	    pepe.compra(juan, new Articulo("Impresora Láser", 1));
//	    ofiMalaga.compra(juan, new Articulo("Impresora Láser", 2));
//	    pepe.compra(juan, new Articulo("Paquete de folios", 10));
//	    pablo.compra(luis, new Articulo("Clasificador anillas", 12));
//	    pepe.compra(luis, new Articulo("Paquete de folios", 50));
//	    pablo.compra(luis, new Articulo("Mesa escritorio", 6));
//	    pepe.compra(juan, new Articulo("Paquete de folios", 5));
//	    System.out.println(juan);
//	    System.out.println(luis);
		
		Scanner s  = new Scanner(System.in);
		int centinela = 0;
		int centinela2 = 0;
		int index = 0;
		
		ArrayList<Usuario> u = new ArrayList<Usuario>();
		ArrayList<Comercial> c = new ArrayList<Comercial>();
		
		do {
			
			System.out.println("1. Listado");
			System.out.println("2. Alta");
			System.out.println("3. Baja");
			System.out.println("4. Modificar");
			System.out.println("5. Salir");
			
			centinela = Integer.parseInt(s.nextLine());
			
			switch (centinela) {	
				
			case 1:
				System.out.println("LISTADO DE CLIENTES");
				
				for (Usuario cliente : u) {
					System.out.println(cliente);
				}
				
				System.out.println("LISTADO DE COMERCIALES");
				
				for (Comercial comercial : c) {
					System.out.println(comercial);
				}
				
				break;
				
			case 2:
				
				System.out.println("1. Agregar cliente");
				System.out.println("2. Agregar comercial");
				
				centinela2 = Integer.parseInt(s.nextLine());
				
				if(centinela2 == 1) {
					System.out.println("Nombre del cliente");
					String nomCli = s.nextLine();
					
					System.out.println("Correo del cliente");
					String correoCli = s.nextLine();
					
					System.out.println("Telefono del cliente");
					String tlfCli = s.nextLine();
					
					u.add(new Usuario(nomCli, correoCli, tlfCli));
					
				} else if (centinela2 == 2) {
					System.out.println("Nombre del comercial");
					String nomCom = s.nextLine();
					
					System.out.println("Correo del comercial");
					String correoCom = s.nextLine();
					
					System.out.println("Puesto del comercial");
					String cargo = s.nextLine();
					
					u.add(new Usuario(nomCom, correoCom, cargo));
					
				} else {
					System.out.println("El dato introducido no es correcto");
				}
				
				break;
				
			case 3:
				
				System.out.println("Para borrar un cliente pulse 1, para borrar un comercial pulse 2");
				
				centinela2 = Integer.parseInt(s.nextLine());
				
				if(centinela2 == 1) {
					System.out.println("Nombre del cliente");
					String nomCli = s.nextLine();
					
					u.remove(nomCli);
					
				} else if (centinela2 == 2) {
					System.out.println("Nombre del comercial");
					String nomCom = s.nextLine();
					
					c.remove(nomCom);
					
				} else {
					System.out.println("El dato introducido no es correcto");
				}
				break;
				
			case 4:
				
				System.out.println("Para modificar un cliente pulse 1, para borrar un comercial pulse 2");
				
				centinela2 = Integer.parseInt(s.nextLine());
				
				if(centinela2 == 1) {
					System.out.println("Nombre del cliente que desea modificar");
					String nomCli = s.nextLine();
					
					index = u.indexOf(nomCli);
					
					System.out.println("Nombre del cliente");
					nomCli = s.nextLine();
					
					System.out.println("Correo del cliente");
					String correoCli = s.nextLine();
					
					System.out.println("Telefono del cliente");
					String tlfCli = s.nextLine();
					
					u.add(new Usuario(nomCli, correoCli, tlfCli));
					
				} else if (centinela2 == 2) {
					System.out.println("Nombre del comercial que desea modificar");
					String nomCom = s.nextLine();
					
					index = u.indexOf(nomCom);
					
					System.out.println("Nombre del comercial");
					nomCom = s.nextLine();
					
					System.out.println("Correo del comercial");
					String correoCom = s.nextLine();
					
					System.out.println("Puesto del comercial");
					String cargo = s.nextLine();
					
					u.add(new Usuario(nomCom, correoCom, cargo));
					
				} else {
					System.out.println("El dato introducido no es correcto");
				}
				
				break;
			}
		} while (centinela != 5);
	}

}
