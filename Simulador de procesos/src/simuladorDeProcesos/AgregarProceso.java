package simuladorDeProcesos;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class AgregarProceso extends AbstractAction {
	@Override
	public void actionPerformed(ActionEvent evento) {
		//Multiprogramacion.auxiliar2 = SimuladorDeProcesos.procesos;
		for(int i = 0; i < 2; i++) {
			
			for(int j =  0; j < 5; j++) {
				
				SimuladorDeProcesos.tablaDeProcesos[i][j].setLocation(225 - (j * 35), 150 + (i * 25));
			
			}
			
		}
		
		if(SimuladorDeProcesos.contador < 5) {
			
			SimuladorDeProcesos.procesos[SimuladorDeProcesos.contador].nombre = SimuladorDeProcesos.campoNuevoProceso.getText();
			SimuladorDeProcesos.procesos[SimuladorDeProcesos.contador].duracion = Integer.parseInt(SimuladorDeProcesos.campoDuracion.getText());
			SimuladorDeProcesos.actualizar();
				
				SimuladorDeProcesos.contador++;
			
		} else {
			SimuladorDeProcesos.agregarProceso.setEnabled(false);
		}
		
	}	
}
