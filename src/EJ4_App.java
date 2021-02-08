
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class EJ4_App {

	public static void main(String[] args) {
		Hashtable<String, Integer> productos = new Hashtable<String, Integer>();
		productos.put("pera", 7);
		productos.put("manzana", 8);
		productos.put("tomate", 12);
		productos.put("harina", 9);
		productos.put("platano", 20);
		productos.put("queso", 13);
		productos.put("maiz", 16);
		productos.put("melocoton", 27);
		productos.put("naranja", 17);
		productos.put("macarrones", 19);

		boolean fin1 = true;

		do {
			String opcion1 = JOptionPane
					.showInputDialog("Bienvenido!!" + "\n1.- Nuevo tiquet" + "\n2.- Gestionar almacen" + "\n3.- Salir");

			switch (opcion1) {
			case "1":
				abrirTiquet(fin1, productos);
				break;
			case "2":
				abrirAlmacen(fin1, productos);
				break;
			case "3":
				fin1 = false;
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcion erronea");
				break;
			}
		} while (fin1);

	}

	private static void abrirAlmacen(boolean fin1, Hashtable<String, Integer> productos) {
		// Codigo reciclado del Ejercicio 3
		boolean fin3 = true;

		do {
			String val = JOptionPane.showInputDialog(
					"Buenos dias" + "\nQue quieres hacer:" + "\n1.- Añadir producto" + "\n2.- Consultar articulo"
							+ "\n3.- Listar almacen" + "\n4.- Cerrar programa" + "\n5.- Volver al  inicio");

			switch (val) {
			case "1":
				añadirProducto(productos, fin3);
				break;
			case "2":
				consultarProducto(productos, fin3);
				break;
			case "3":
				listarAlmacen(productos, fin3);
				break;
			case "4":
				fin1 = false;
				fin3 = false;
				break;
			case "5":
				fin3 = false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion no valida");
				break;
			}

		} while (fin3);

	}

	private static void abrirTiquet(boolean fin1, Hashtable<String, Integer> productos) {
		// codigo reciclado del Ejercicio 2
		String val = JOptionPane.showInputDialog("Cuantos productos?");
		int indice = Integer.parseInt(val);

		double productosTiquet[][] = new double[indice][3];// pongo 3 de segundo indice porque hemos de guardar precio,
															// iva y precio total

		double cliente[][] = new double[1][2];// como solo vamos a genarar un tiquet habra solo 1 cliente y 2 campos (el
												// diner pagado y el cambio)

		// Recorro el diccionario para poder imprimir la lista de productos
		Enumeration<String> e = productos.keys();

		String lista = "";

		int cantidadStock = 0;

		while (e.hasMoreElements()) {

			lista += e.nextElement() + "\n";
			cantidadStock++;

		}

		rellenarProduct(productosTiquet, productos, lista, cantidadStock);

		rellenarCliente(productosTiquet, cliente);

		imprimirTiquet(productosTiquet, cliente);

	}

	private static void listarAlmacen(Hashtable<String, Integer> productos, boolean fin) {

		Enumeration<String> llaves = productos.keys();
		System.out.println("-----------------------------");
		while (llaves.hasMoreElements()) {
			String aux = llaves.nextElement();
			// lo imprimo por consola para que no haya spam de ventanas
			System.out.println("Producto: " + aux + "----- Cantidad: " + productos.get(aux));
		}

	}

	private static void consultarProducto(Hashtable<String, Integer> productos, boolean fin) {
		String val = JOptionPane.showInputDialog("Producto a buscar:");
		val = val.toLowerCase();
		Enumeration<String> llaves = productos.keys();

		while (llaves.hasMoreElements()) {
			if (val.equals(llaves.nextElement())) {
				JOptionPane.showMessageDialog(null, "Producto: " + val + "\nCantidad: " + productos.get(val));
				break;
			}

			if (!llaves.hasMoreElements()) {
				JOptionPane.showMessageDialog(null, "Producto no encontrado");
				break;
			}
		}

	}

	private static void añadirProducto(Hashtable<String, Integer> productos, boolean fin) {

		String val = JOptionPane.showInputDialog("Nombre del producto:");

		String val2 = JOptionPane.showInputDialog("Cantidad:");
		int cantidad = Integer.parseInt(val2);

		productos.put(val.toLowerCase(), cantidad);

		JOptionPane.showMessageDialog(null, "Producto añadido con exito");

	}

	private static void rellenarCliente(double[][] productos, double[][] cliente) {

		double aux = 0;

		for (int i = 0; i < cliente.length; i++) {
			aux += productos[i][2];
		}
		cliente[0][0] = aux;// precio total a pagar

	}

	private static void imprimirTiquet(double[][] productos, double[][] cliente) {
		DecimalFormat df = new DecimalFormat("#.##");
		for (int i = 0; i < productos.length; i++) {
			for (int j = 0; j < productos[i].length; j++) {
				switch (j) {
				case 0:
					System.out.println("Producto " + (i + 1) + " -> Precio: " + productos[i][j]);
					break;
				case 1:
					System.out.println("Producto " + (i + 1) + " -> IVA:" + productos[i][j] * 100);
					break;
				case 2:
					System.out.println(
							"Producto " + (i + 1) + " -> Precio total (IVA incluido):" + df.format(productos[i][j]));
					break;
				}
			}
		}

		String val = JOptionPane.showInputDialog("Total: " + df.format(cliente[0][0]) + "\nPago: ");

		cliente[0][1] = Double.parseDouble(val) - cliente[0][0];

		System.out.println("Pago: " + Double.parseDouble(val) + "\nCambio: " + df.format(cliente[0][1]));

	}

	private static void rellenarProduct(double[][] productos, Hashtable<String, Integer> productosStock, String lista,
			int cantidadStock) {

		boolean end = true;
		int i = 0;
		boolean encontrado = false;
		String llaves[] = new String[cantidadStock];
		Enumeration<String> e = productosStock.keys();

		while (e.hasMoreElements()) {
			// recojo todas la llaves para no encapsular el bucle
			llaves[i] = e.nextElement();
			i++;
		}

		i = 0;

		do {
			encontrado = false;
			String prod = JOptionPane.showInputDialog("Introduce el nombre del producto:" + "\n" + lista);

			for (int h = 0; h < llaves.length; h++) {
				if (llaves[h].equals(prod)) {
					if (productosStock.get(prod) > 0) {
						encontrado = true;
					} else {
						JOptionPane.showMessageDialog(null, "Producto agotado");
						encontrado = false;
					}
					break;
				}
			}

			if (encontrado) {
				productosStock.put(prod, productosStock.get(prod) - 1);
				for (int j = 0; j < productos[i].length; j++) {
					switch (j) {
					case 0:
						String val = JOptionPane.showInputDialog("Producto " + (i + 1) + " -> Precio:");
						double precio = Double.parseDouble(val);

						productos[i][j] = precio;
						break;
					case 1:
						String val2 = JOptionPane.showInputDialog("Producto " + (i + 1) + " -> IVA (21 o 4):");
						double iva = Double.parseDouble(val2) / 100;

						productos[i][j] = iva;
						break;
					}

					productos[i][2] = productos[i][0] + (productos[i][0] * productos[i][1]);

				}
				i++;
				if ((i+1) > productos.length) {
					end = false;
				}
			} 

			
		} while (end);

	}

}
