package simuladorDeProcesos;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SimuladorDeProcesos {
	static Proceso[] procesos = {new Proceso(), new Proceso(), new Proceso(), new Proceso(), new Proceso()};
	static int contador = 0;
	static Ejecutar accion = new Ejecutar();
	static AgregarProceso accion2 = new AgregarProceso();
	static Multiprogramacion accion3 = new Multiprogramacion();
	static JLabel etiquetaNuevoProceso = new JLabel("Nuevo proceso:");
	static JTextField campoNuevoProceso = new JTextField();
	static JLabel etiquetaDuracion = new JLabel("Duración:");
	static JTextField campoDuracion = new JTextField();
	static JButton ejecutar = new JButton();
	static JButton agregarProceso = new JButton();
	static JTextField tablaDeProcesos[][] = {
												{ new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField()}, 
												{ new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField()}
											};
	static JCheckBox procesamientoPorLotes = new JCheckBox();
	static JCheckBox multiprogramacion = new JCheckBox();

	public static void main(String[] args) {
		createAndShowGUI();
	}
	
	public static void createAndShowGUI() {
		//Declaración de componentes visuales y configuraciones personalizadas
		JFrame marcoPrincipal = new JFrame("Simulador de procesos");
		marcoPrincipal.setSize(300, 400);
		marcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelDeContenido = new JPanel();
		panelDeContenido.setSize(300, 400);
		campoNuevoProceso.setPreferredSize(new Dimension(150, 20));
		campoDuracion.setPreferredSize(new Dimension(150, 20));
		ejecutar.setPreferredSize(new Dimension(100, 20));
		ejecutar.setAction(accion);
		ejecutar.setText("Ejecutar");
		agregarProceso.setPreferredSize(new Dimension(100, 20));
		agregarProceso.setAction(accion2);
		agregarProceso.setText("Agregar proceso");
		marcoPrincipal.setResizable(false);
		//procesamientoPorLotes.setText("Procesamiento por lotes");
		multiprogramacion.setAction(accion3);
		multiprogramacion.setText("Multiprogramacion");
		
		//Adición de componentes al marco principal
		marcoPrincipal.setContentPane(panelDeContenido);
		panelDeContenido.add(etiquetaNuevoProceso);
		panelDeContenido.add(campoNuevoProceso);
		panelDeContenido.add(etiquetaDuracion);
		panelDeContenido.add(campoDuracion);
		panelDeContenido.add(agregarProceso);
		panelDeContenido.add(ejecutar);
		//panelDeContenido.add(procesamientoPorLotes);
		panelDeContenido.add(multiprogramacion);
		
		for(int i = 0; i < 2; i++) {
			for(int j =  0; j < 5; j++) {
				tablaDeProcesos[i][j].setPreferredSize(new Dimension(30, 20));
				panelDeContenido.add(tablaDeProcesos[i][j]);
			}
		}
		
		marcoPrincipal.setVisible(true);
	}
	
	public static void actualizar() {
			
			for(int j =  0; j < 5; j++) {
				
				tablaDeProcesos[0][j].setText(procesos[j].nombre);
				tablaDeProcesos[1][j].setText(String.valueOf(procesos[j].duracion));
				
			}
		
	}

}
