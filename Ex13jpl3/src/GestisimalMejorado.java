/**
 * 13. Modifica el programa Gestisimal realizado anteriormente aÃ±adiendo las
 * siguientes mejoras:
 * <ul>
 * <li>Utiliza una lista en lugar de un array para el almacenamiento de los
 * datos.
 * <li>Comprueba la existencia del cÃ³digo en el alta, la baja y la modificaciÃ³n
 * de artÃ­culos para evitar errores.
 * <li>Cambia la opciÃ³n "Salida de stock" por "Venta". Esta nueva opciÃ³n
 * permitirÃ¡ hacer una venta de varios artÃ­culos y emitir la factura
 * correspondiente. Se debe preguntar por los cÃ³digos y las cantidades de cada
 * artÃ­culo que se quiere comprar. Aplica un 21% de IVA.
 * </ul>
 *
 * @author Luis JosÃ© SÃ¡nchez
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;

public class GestisimalMejorado {
	
	static ArrayList<Articulo> a = new ArrayList<Articulo>();

  public static void main(String[] args) {

    HashMap<String, Integer> lineasFra = new HashMap<String, Integer>();

    int opcion;
    int opcion2;
    int i;
    int stockIntro;
    int unidades = 0;
    int unidadesEnFactura = 0;
    double precioDeCompraIntro;
    double precioDeVentaIntro;
    double subtotal;
    double baseImponible;
    double totalFactura;
    String codigo;
    String codigoIntro = "";
    String descripcionIntro;
    String precioDeCompraIntroString;
    String precioDeVentaIntroString;
    String stockIntroString;

    Scanner s = new Scanner(System.in);

    // Menu ////////////////////////////////////////////////////////////
    do {
      System.out.println("\n\nG E S T I S I M A L");
      System.out.println("===================");
      System.out.println("1. Listado");
      System.out.println("2. Alta");
      System.out.println("3. Baja");
      System.out.println("4. ModificaciÃ³n");
      System.out.println("5. Entrada de mercancÃ­a");
      System.out.println("6. Venta");
      System.out.println("7. Listado de artículos bajos de stock");
      System.out.println("8. Salir");
      System.out.print("Introduzca una opciÃ³n: ");
      opcion = Integer.parseInt(s.nextLine());

      switch (opcion) {

        case 1: // Listado /////////////////////////////////////////////
          // Apartado A: intento de ordenar los articulos
          //Collections.sort(a);
        	
          //Apartado B
        	
        	int nArt = 0;
            double pCompraTotal = 0;
            double pVentaTotal = 0;
          System.out.println("\nLISTADO\n=======");

          for (Articulo aux : a) {
            System.out.println(aux);
            nArt++;
            pCompraTotal += aux.getPrecioDeCompra();
            pVentaTotal += aux.getPrecioDeVenta();
          }
          
          //Creo y defino las variables con los datos que me interesan y los muestro
          
          double pCompraMedio = pCompraTotal / nArt;
          double pVentaMedio = pVentaTotal / nArt;
          double margenBeneficioMedio = pVentaMedio - pCompraMedio;
          
          System.out.println("\nNúmero total de artículos: " + nArt);
          System.out.println("Precio de compra medio: " + String.format("%.2f", pCompraMedio));
          System.out.println("Precio de venta medio: " + String.format("%.2f", pVentaMedio));
          System.out.println("Margen de beneficio medio: " + String.format("%.2f", margenBeneficioMedio));
          
          break;

        case 2: // Alta ////////////////////////////////////////////////
          System.out.println("\nNUEVO ARTÃ�CULO\n==============");

          System.out.println("Por favor, introduzca los datos del artÃ­culo.");
          System.out.print("CÃ³digo: ");
          codigoIntro = s.nextLine();
          
          if (a.contains(new Articulo(codigoIntro))) {
            System.out.print("Ese cÃ³digo ya existe.\nIntroduzca otro cÃ³digo: ");
          } else {
            System.out.print("Descripcion: ");
            descripcionIntro = s.nextLine();

            System.out.print("Precio de compra: ");
            precioDeCompraIntro = Double.parseDouble(s.nextLine());

            System.out.print("Precio de venta: ");
            precioDeVentaIntro = Double.parseDouble(s.nextLine());

            System.out.print("Stock: ");
            stockIntro = Integer.parseInt(s.nextLine());

            a.add(new Articulo(codigoIntro, descripcionIntro, precioDeCompraIntro, precioDeVentaIntro, stockIntro));
          }

          break;

        case 3: // Baja ////////////////////////////////////////////////
          System.out.println("\nBAJA\n====");
          System.out.print("Por favor, introduzca el cÃ³digo del artÃ­culo que desea dar de baja: ");
          codigoIntro = s.nextLine();

          if (!a.contains(new Articulo(codigoIntro))) {
            System.out.println("Lo siento, el cÃ³digo introducido no existe.");
          } else {
            a.remove(new Articulo(codigoIntro));
            System.out.println("articulo borrado.");
          }

          break;

        case 4: // ModificaciÃ³n ////////////////////////////////////////
          System.out.println("\nMODIFICACIÃ“N\n============");
          System.out.print("Por favor, introduzca el cÃ³digo del artÃ­culo cuyos datos desea cambiar: ");
          codigoIntro = s.nextLine();

          if (!a.contains(new Articulo(codigoIntro))) {
            System.out.println("No hay ningÃºn artÃ­culo con ese cÃ³digo.");
          } else {

            i = a.indexOf(new Articulo(codigoIntro));

            System.out.println("Introduzca los nuevos datos del artÃ­culo o INTRO para dejarlos igual.");

            System.out.println("CÃ³digo: " + a.get(i).getCodigo());
            System.out.print("Nuevo cÃ³digo: ");
            codigoIntro = s.nextLine();
            if (!codigoIntro.equals("")) {
              a.get(i).setCodigo(codigoIntro);
            }

            System.out.println("DescripciÃ³n: " + a.get(i).getDescripcion());
            System.out.print("Nueva descripciÃ³n: ");
            descripcionIntro = s.nextLine();
            if (!descripcionIntro.equals("")) {
              a.get(i).setDescripcion(descripcionIntro);
            }

            System.out.println("Precio de compra: " + a.get(i).getPrecioDeCompra());
            System.out.print("Nuevo precio de compra: ");
            precioDeCompraIntroString = s.nextLine();
            if (!precioDeCompraIntroString.equals("")) {
              a.get(i).setPrecioDeCompra(Double.parseDouble(precioDeCompraIntroString));
            }

            System.out.println("Precio de venta: " + a.get(i).getPrecioDeVenta());
            System.out.print("Nuevo precio de venta: ");
            precioDeVentaIntroString = s.nextLine();
            if (!precioDeVentaIntroString.equals("")) {
              a.get(i).setPrecioDeVenta(Double.parseDouble(precioDeVentaIntroString));
            }

            System.out.println("Stock: " + a.get(i).getStock());
            System.out.print("Nuevo stock: ");
            stockIntroString = s.nextLine();
            if (!stockIntroString.equals("")) {
              a.get(i).setStock(Integer.parseInt(stockIntroString));
            }
          }
          break;

        case 5: // Entrada de mercancÃ­a //////////////////////////////
          System.out.println("\nENTRADA DE MERCANCÃ�A\n====================");
          System.out.print("Por favor, introduzca el cÃ³digo del artÃ­culo: ");
          codigoIntro = s.nextLine();

          if (!a.contains(new Articulo(codigoIntro))) {
            System.out.println("No hay ningÃºn artÃ­culo con ese cÃ³digo.");
          } else {
            i = a.indexOf(new Articulo(codigoIntro));
            System.out.println("Entrada de mercancÃ­a del siguiente artÃ­culo: ");
            System.out.println(a.get(i));
            System.out.print("Introduzca el nÃºmero de unidades que entran al almacÃ©n: ");
            stockIntro = Integer.parseInt(s.nextLine());
            a.get(i).setStock(stockIntro + a.get(i).getStock());
            System.out.println("La mercancÃ­a ha entrado en el almacÃ©n.");
          }

          break;

        case 6: // Venta
          System.out.println("\nVENTA\n=====");

          do {
            System.out.println("\n1. AÃ±adir artÃ­culo");
            System.out.println("2. Generar factura");
            System.out.println("3. Cancelar");
            System.out.print("Introduzca una opciÃ³n: ");
            opcion2 = Integer.parseInt(s.nextLine());

            switch (opcion2) {

              case 1: // AÃ±adir lÃ­nea ////////////////////////////
                System.out.print("Por favor, introduzca el cÃ³digo del artÃ­culo: ");
                codigoIntro = s.nextLine();
                
                if (!a.contains(new Articulo(codigoIntro))) {
                  System.out.println("No hay ningÃºn artÃ­culo con ese cÃ³digo.");
                } else {
                  i = a.indexOf(new Articulo(codigoIntro));
                  
                  System.out.println(a.get(i));

                  if (lineasFra.containsKey(codigoIntro)) {
                    unidadesEnFactura = lineasFra.get(codigoIntro);
                  } else {
                    unidadesEnFactura = 0;
                  }

                  System.out.println("Unidades en la factura provisional: " + unidadesEnFactura);

                  System.out.print("Unidades que quiere incorporar a la factura: ");
                  unidades = Integer.parseInt(s.nextLine());

                  if ((a.get(i).getStock()) - unidadesEnFactura < unidades) {
                    System.out.println("No hay suficiente stock. Puede aÃ±adir a la venta un mÃ¡ximo de " + (a.get(i).getStock() - unidadesEnFactura) + " unidades de ese producto.");
                  } else if (lineasFra.containsKey(codigoIntro)) {
                    lineasFra.put(codigoIntro, lineasFra.get(codigoIntro) + unidades);
                  } else {
                    lineasFra.put(codigoIntro, unidades);
                  }
                }

                // Muestra las lÃ­neas
                System.out.println("\n\n CÃ“DIGO |    DESCRIPCIÃ“N    | UNIDADES | PRECIO UNID. | SUBTOTAL");
                System.out.println("------------------------------------------------------------------");
                for (Map.Entry pareja : lineasFra.entrySet()) {
                  codigo = pareja.getKey().toString();
                  i = a.indexOf(new Articulo(codigo));
                  unidades = Integer.parseInt(pareja.getValue().toString());
                  subtotal = unidades * a.get(i).getPrecioDeVenta();
                  System.out.printf(" %6s | %17s | %8d | %12.2f | %8.2f\n", codigo, a.get(i).getDescripcion(), unidades, a.get(i).getPrecioDeVenta(), subtotal);
                }

                break;

              case 2: // Genera la factura ///////////////////////
                baseImponible = 0;
                System.out.println("\n\n CÃ“DIGO |   DESCRIPCIÃ“N   | UNIDADES | PRECIO UNID. | SUBTOTAL");
                System.out.println("----------------------------------------------------------------");
                for (Map.Entry pareja : lineasFra.entrySet()) {
                  codigo = pareja.getKey().toString();
                  i = a.indexOf(new Articulo(codigoIntro));
                  unidades = Integer.parseInt(pareja.getValue().toString());
                  subtotal = unidades * a.get(i).getPrecioDeVenta();
                  System.out.printf(" %6s | %15s | %8d | %12.2f | %8.2f\n", codigo, a.get(i).getDescripcion(), unidades, a.get(i).getPrecioDeVenta(), subtotal);
                  baseImponible += subtotal;
                  a.get(i).setStock(a.get(i).getStock() - unidades); // decrementa el stock
                }

                System.out.println("----------------------------------------------------------------");
                System.out.printf("                                      BASE IMPONIBLE: %8.2f \n", baseImponible);
                System.out.printf("                                           IVA (21%%): %8.2f \n", baseImponible * 0.21);
                System.out.printf("                                               TOTAL: %8.2f \n", baseImponible * 1.21);

                System.out.println("\n\nFactura generada.\nPulse INTRO para volver al menÃº principal.");
                s.nextLine();

                break;
            } // switch (venta)

          } while (opcion2 == 1);

          break;

        case 7:
        	//Apartado C
        	System.out.print("Introduce un stock máximo: ");
            int stockMax = Integer.parseInt(s.nextLine());
            
            System.out.println("LISTADO POR STOCK");
            System.out.println("=================");
            
            //si el stock del articulo es menor, muestra el articulo
            for (Articulo aux2 : a) {
              if (aux2.getStock() <= stockMax) {
                System.out.println(aux2);
              }
            }
            break;
      } // switch (menÃº principal)

    } while (opcion != 8);

  }
}
