package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Parametro;

@SuppressWarnings("serial")
public class operadoresView extends Dialog<Parametro> {
	public operadoresView(WindowOwner owner) {
		super(owner, new Parametro());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Operaciones");
		
		new TextBox(mainPanel);
		
		crearBotonesDeOperadores(mainPanel);
	}
	public void crearBotonesDeOperadores(Panel mainPanel) {
			new Button(mainPanel).setCaption("+");
			new Button(mainPanel).setCaption("-");
			new Button(mainPanel).setCaption("*");
			new Button(mainPanel).setCaption("/");
			new Button(mainPanel).setCaption("(");
			new Button(mainPanel).setCaption(")");
			
		}
		
}