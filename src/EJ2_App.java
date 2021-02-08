import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/*
 * @author Toni Arjona
 * */
public class EJ2_App {

	public static void main(String[] args) {
		 String val = JOptionPane.showInputDialog("Cuantos productos?");
		 int indice = Integer.parseInt(val);
		 
		 double productos[][] = new double[indice][3];//pongo 3 de segundo indice porque hemos de guardar precio, iva y precio total
		 
		 double cliente[][] = new double[1][2];//como solo vamos a genarar un tiquet habra solo 1 cliente y 2 campos (el diner pagado y el cambio)
		 
		 rellenarProduct(productos);
		 
		 rellenarCliente(productos,cliente);
		 
		 imprimirTiquet(productos,cliente);
	}

	private static void rellenarCliente(double[][] productos, double[][] cliente) {
		
		double aux = 0;
		
		
		for (int i = 0; i < cliente.length; i++) {
			aux += productos[i][2];
		}
		cliente[0][0] = aux;//precio total a pagar
		
	
		
	}

	private static void imprimirTiquet(double[][] productos, double[][] cliente) {
		DecimalFormat df = new DecimalFormat("#.##");
		for (int i = 0; i < productos.length; i++) {
			for (int j = 0; j < productos[i].length; j++) {
				switch(j) {
				case 0:
					System.out.println("Producto "+(i+1)+" -> Precio: "+productos[i][j]);
					break;
				case 1:
					System.out.println("Producto "+(i+1)+" -> IVA:"+productos[i][j]*100);
					break;
				case 2:
					System.out.println("Producto "+(i+1)+" -> Precio total (IVA incluido):"+df.format(productos[i][j]));
					break;
				}
			}
		}
		
		String val = JOptionPane.showInputDialog("Total: "+df.format(cliente[0][0])+"\nPago: ");
		
		cliente[0][1] = Double.parseDouble(val) - cliente[0][0]; 
		
		System.out.println("Pago: "+Double.parseDouble(val)+"\nCambio: "+df.format(cliente[0][1]));
		
	}

	private static void rellenarProduct(double[][] productos) {
		
		for (int i = 0; i < productos.length; i++) {
			for (int j = 0; j < productos[i].length; j++) {
				switch(j) {
				case 0:
					String val = JOptionPane.showInputDialog("Producto "+(i+1)+" -> Precio:");
					double precio = Double.parseDouble(val);
					
					productos[i][j] = precio;
					break;
				case 1:
					String val2 = JOptionPane.showInputDialog("Producto "+(i+1)+" -> IVA (21 o 4):");
					double iva = Double.parseDouble(val2)/100;
					
					productos[i][j] = iva;
					break;
				}
				
				productos[i][2] = productos[i][0]-(productos[i][0]*productos[i][1]);
			}
		}
		
	}

}
