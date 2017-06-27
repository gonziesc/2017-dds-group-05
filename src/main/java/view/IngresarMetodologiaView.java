package view;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import viewmodel.IngresarMetodologiaViewModel;

@SuppressWarnings("serial")
public class IngresarMetodologiaView extends Dialog<IngresarMetodologiaViewModel>{

	public IngresarMetodologiaView(WindowOwner owner) {
		super(owner, new IngresarMetodologiaViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ingreso de metodologias");
		

	}

}
