package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import builder.BuilderIndicador;
import viewmodel.Operador1ViewModel;;

@SuppressWarnings("serial")
public class Operador1View extends Dialog<Operador1ViewModel> {
	public Operador1View(WindowOwner owner,BuilderIndicador builder) {
		super(owner, new Operador1ViewModel(builder));
	}
	public void createContents(Panel mainPanel) {
		this.setTitle("Operaciones");
		mainPanel.setLayout(new VerticalLayout());
		
		crearBotonesDeOperadores(mainPanel);
		
		new Button(mainPanel).setCaption("Ingresar operador").onClick(this::ingresarOperador);
	}
	
	public void ingresarOperador(){//falta control de errores
		this.getModelObject().ingresarOperador();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new Parametro2View(this, builder).open();
	}
	
	public void crearBotonesDeOperadores(Panel mainPanel) {
			new Button(mainPanel).setCaption("+").onClick(()->this.getModelObject().setOperacionSeleccionada("+"));
			new Button(mainPanel).setCaption("-").onClick(()->this.getModelObject().setOperacionSeleccionada("-"));
			new Button(mainPanel).setCaption("*").onClick(()->this.getModelObject().setOperacionSeleccionada("*"));
			new Button(mainPanel).setCaption("/").onClick(()->this.getModelObject().setOperacionSeleccionada("/"));
			
		}
	@Override
	protected void createFormPanel(Panel mainPanel) {

	}
		
}