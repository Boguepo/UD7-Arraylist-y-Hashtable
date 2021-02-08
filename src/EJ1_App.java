
import java.util.Hashtable;

import javax.swing.JOptionPane;

/*
 * @author Toni Arjona
 * */
public class EJ1_App {

	public static void main(String[] args) {
		Hashtable<String, Double> notasMedias = new Hashtable<String, Double>();

		String val = JOptionPane.showInputDialog("Nuemro de alumnos:");
		int alumnos = Integer.parseInt(val);

		String val2 = JOptionPane.showInputDialog("Numero de notas:");
		int notas = Integer.parseInt(val2);

		double cuadro[][] = new double[alumnos][notas];

		rellenarNotas(cuadro);

		calculoMedia(cuadro, notasMedias);

		imprimirMedias(alumnos, notasMedias);
	}

	private static void imprimirMedias(int alumnos, Hashtable<String, Double> notasMedias) {
		int i = 0;
		
		while(i<alumnos) {
			String aux = "Alumno "+(i+1);
			JOptionPane.showMessageDialog(null, "Alumno "+(i+1)+" -> Media: "+notasMedias.get(aux));
			i++;
		}
		
	}

	private static void calculoMedia(double[][] cuadro, Hashtable<String, Double> notasMedias) {
		double aux = 0;
		for (int i = 0; i < cuadro.length; i++) {
			aux = 0;
			for (int j = 0; j < cuadro[i].length; j++) {
				aux += cuadro[i][j];
			}
			aux = aux / cuadro[i].length;
			notasMedias.put("Alumno " + (i+1), aux);
		}

	}

	private static void rellenarNotas(double[][] cuadro) {

		for (int i = 0; i < cuadro.length; i++) {
			for (int j = 0; j < cuadro[i].length; j++) {
				String val = JOptionPane.showInputDialog("Alumno " + (i + 1) + "\nNota " + (j + 1));
				Double nota = Double.parseDouble(val);

				if (nota >= 0) {
					cuadro[i][j] = nota;
				}
			}
		}

	}

}
