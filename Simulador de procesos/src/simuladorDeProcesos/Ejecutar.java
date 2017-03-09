package simuladorDeProcesos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Timer;

public class Ejecutar extends AbstractAction {
	int tiempo = 0;
	int i, j;
	Timer intervalo;
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		SimuladorDeProcesos.ejecutar.setEnabled(false);
		tiempo = SimuladorDeProcesos.procesos[0].duracion;
		
		ActionListener taskPerformer = new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	
		    	for(j = 0; j < 4; j++) {
					System.out.println(SimuladorDeProcesos.procesos[j].nombre);
					SimuladorDeProcesos.procesos[j].nombre = SimuladorDeProcesos.procesos[j + 1].nombre;
					SimuladorDeProcesos.procesos[j].duracion = SimuladorDeProcesos.procesos[j + 1].duracion;
				}
							

					SimuladorDeProcesos.procesos[4].nombre = "";
					SimuladorDeProcesos.procesos[4].duracion = 0;
				
					
				SimuladorDeProcesos.actualizar();
				if(SimuladorDeProcesos.procesos[0].nombre == "") {
					SimuladorDeProcesos.ejecutar.setEnabled(true);
					SimuladorDeProcesos.agregarProceso.setEnabled(true);
					intervalo.stop();
				}
		    }
		};
		intervalo =  new Timer(tiempo * 1000, taskPerformer);
		intervalo.start();

		SimuladorDeProcesos.contador = 0;
	}
}
