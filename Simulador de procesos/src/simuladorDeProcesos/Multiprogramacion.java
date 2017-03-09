package simuladorDeProcesos;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class Multiprogramacion extends AbstractAction {
	Proceso auxiliar = new Proceso();
	static Proceso auxiliar2[];
	int i, j;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(SimuladorDeProcesos.multiprogramacion.isSelected()) {
			for(j = 0; j < 4; j++) {
				for(i = 0; i < 4; i++) {
					if(SimuladorDeProcesos.procesos[i].duracion > SimuladorDeProcesos.procesos[i + 1].duracion) {
						auxiliar = SimuladorDeProcesos.procesos[i];
						SimuladorDeProcesos.procesos[i] = SimuladorDeProcesos.procesos[i + 1];
						SimuladorDeProcesos.procesos[i + 1] = auxiliar;
					}
				}
			}
			SimuladorDeProcesos.actualizar();
		} else {
			 //SimuladorDeProcesos.procesos = auxiliar2;
			 //SimuladorDeProcesos.actualizar();
		}
	}
}
