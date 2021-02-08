import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

/*
 * @author Toni Arjona
 * */
public class EJ3_App {

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
		
		boolean fin = true;
		
		do {
			String val = JOptionPane.showInputDialog("Buenos dias"
					+ "\nQue quieres hacer:"
					+ "\n1.- Añadir producto"
					+ "\n2.- Consultar articulo"
					+ "\n3.- Listar almacen"
					+ "\n4.- Salir");
			
			switch(val) {
			case "1":
				añadirProducto(productos, fin);
				break;
			case "2":
				consultarProducto(productos, fin);
				break;
			case "3":
				listarAlmacen(productos,fin);
				break;
			case "4":
				fin = false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion no valida");
				break;
			}
			
			String exit = JOptionPane.showInputDialog("Desea hacer algo mas?[s/n]");
			char aux = exit.charAt(0);
			if(aux == 'n') {
				fin = false;
			}
			
		}while(fin);

	}

	private static void listarAlmacen(Hashtable<String, Integer> productos, boolean fin) {
		
		Enumeration<String> llaves = productos.keys();
		
		while(llaves.hasMoreElements()) {
			String aux = llaves.nextElement();
			//lo imprimo por consola para que no haya spam de ventanas
			System.out.println("Producto: "+aux+"----- Cantidad: "+productos.get(aux));
		}
		
		JOptionPane.showMessageDialog(null,"Producto añadido con exito");
	}

	private static void consultarProducto(Hashtable<String, Integer> productos, boolean fin) {
		String val = JOptionPane.showInputDialog("Producto a buscar:");
		val = val.toLowerCase();
		Enumeration<String> llaves = productos.keys();
		
		while(llaves.hasMoreElements()) {
			if(val.equals(llaves.nextElement())) {
				JOptionPane.showMessageDialog(null,"Producto: "+val
						+ "\nCantidad: "+productos.get(val));
				break;
			}
			
			if(!llaves.hasMoreElements()) {
				JOptionPane.showMessageDialog(null, "Producto no encontrado");
				break;
			}
		}
		
	}

	private static void añadirProducto(Hashtable<String, Integer> productos, boolean fin) {
		
		String val = JOptionPane.showInputDialog("Nombre del producto:");
		
		String val2 =  JOptionPane.showInputDialog("Cantidad:");
		int cantidad = Integer.parseInt(val2);
		
		productos.put(val.toLowerCase(), cantidad);
		
		JOptionPane.showMessageDialog(null,"Producto añadido con exito");
				
		
	}

}
