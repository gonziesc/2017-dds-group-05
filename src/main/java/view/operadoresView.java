package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Parametro;
import viewmodel.IndicadorViewModel;

@SuppressWarnings("serial")
public class operadoresView extends Dialog<IndicadorViewModel> {
	public operadoresView(WindowOwner owner) {
		super(owner, new IndicadorViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Operaciones");
		
		crearBotonesDeOperadores(mainPanel);
		
		new Button(mainPanel).setCaption("Ingresar operador").onClick(this::ingresarOperador);
	}
	
	public void ingresarOperador(){//falta control de errores
		this.getModelObject().ingresarOperador();
		this.close();
		new Parametro2View(this).open();
	}
	
	public void crearBotonesDeOperadores(Panel mainPanel) {
			new Button(mainPanel).setCaption("+").onClick(()->this.getModelObject().setOperacionSeleccionada("+"));
			new Button(mainPanel).setCaption("-").onClick(()->this.getModelObject().setOperacionSeleccionada("-"));
			new Button(mainPanel).setCaption("*").onClick(()->this.getModelObject().setOperacionSeleccionada("*"));
			new Button(mainPanel).setCaption("/").onClick(()->this.getModelObject().setOperacionSeleccionada("/"));
			
		}
		
}