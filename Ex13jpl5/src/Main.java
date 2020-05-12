import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s  = new Scanner(System.in);
		int centinela = 0;
		int centinela2 = 0;
		int index = 0;
		
		ArrayList<Usuario> u = new ArrayList<Usuario>();
		ArrayList<Comercial> c = new ArrayList<Comercial>();
		
		//Cargo algunos datos
		u.add(new Usuario("Pepe", "pepecorreo", "1234"));
		c.add(new Comercial("Sara", "saracorreo", "empresaria"));
		
		do {
			
			System.out.println("1. Listado");
			System.out.println("2. Alta");
			System.out.println("3. Baja");
			System.out.println("4. Modificar");
			System.out.println("5. Comprar");
			System.out.println("6. Salir");
			
			centinela = Integer.parseInt(s.nextLine());
			
			switch (centinela) {	
				
			case 1:
				System.out.println("LISTADO DE CLIENTES");
				
				for (Usuario cliente : u) {
					System.out.println(cliente);
				}
				
				System.out.println();
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
					
					c.add(new Comercial(nomCom, correoCom, cargo));
					
				} else {
					System.out.println("El dato introducido no es correcto");
				}
				
				break;
				
			case 3:
				
				System.out.println("Para borrar un cliente pulse 1, para borrar un comercial pulse 2");
				
				centinela2 = Integer.parseInt(s.nextLine());
				
				if(centinela2 == 1) {
					
			          System.out.println("Por favor, introduzca el nombre del cliente que desea dar de baja: ");
			          String nomCli = s.nextLine();

			          if (!u.contains(new Usuario(nomCli))) {
			            System.out.println("Lo siento, el nombre introducido no existe.");
			          } else {
			            u.remove((new Usuario(nomCli)));
			            System.out.println("Borrado");
			          }
					
				} else if (centinela2 == 2) {
			          System.out.println("Por favor, introduzca el nombre del comercial que desea dar de baja: ");
			          String nomCom = s.nextLine();

			          if (!c.contains(new Comercial(nomCom))) {
			            System.out.println("Lo siento, el nombre introducido no existe.");
			          } else {
			            c.remove((new Comercial(nomCom)));
			            System.out.println("Borrado");
			          }
					
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
					
					index = u.indexOf(new Usuario(nomCli));
					
					System.out.println("Nombre del cliente");
					nomCli = s.nextLine();
					u.get(index).setNombre(nomCli);
					
					System.out.println("Correo del cliente");
					String correoCli = s.nextLine();
					u.get(index).setCorreoElectronico(correoCli);
					
					System.out.println("Telefono del cliente");
					String tlfCli = s.nextLine();
					u.get(index).setTelefono(tlfCli);
					
					
				} else if (centinela2 == 2) {
					System.out.println("Nombre del comercial que desea modificar");
					String nomCom = s.nextLine();
					
					index = c.indexOf(new Comercial(nomCom));
					
					System.out.println("Nombre del comercial");
					nomCom = s.nextLine();
					c.get(index).setNombre(nomCom);
					
					System.out.println("Correo del comercial");
					String correoCom = s.nextLine();
					c.get(index).setCorreoElectronico(correoCom);
					
					System.out.println("Puesto del comercial");
					String cargo = s.nextLine();
					c.get(index).setCargo(cargo);
					
				} else {
					System.out.println("El dato introducido no es correcto");
				}
				
				break;
				
			case 5:
				System.out.println("Comprar");
				System.out.println("Qué cliente es el que compra?");
				String nomCli = s.nextLine();
				
				System.out.println("A qué comercial compra?");
				String nomCom = s.nextLine();
				
				System.out.println("Qué es lo que compra?");
				String nomArt = s.nextLine();
				
				System.out.println("Cuanta cantidad compra?");
				int nCompra = Integer.parseInt(s.nextLine());
				
		          if (!u.contains(new Usuario(nomCli))) {
			            System.out.println("Lo siento, el nombre introducido no existe.");
			          } else {
			        	  int indexCli = u.indexOf(new Usuario(nomCli));
			        	  int indexCom = c.indexOf(new Comercial(nomCom));
			        	  
			        	  u.get(indexCli).compra(c.get(indexCom), new Articulo(nomArt, nCompra));
			        	  System.out.println(c.get(indexCom));
			          }
			}
		} while (centinela != 6);
	}

}
