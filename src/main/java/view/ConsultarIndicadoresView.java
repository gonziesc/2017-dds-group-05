package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import model.Cuenta;
import model.Empresa;
import model.Indicador;
import viewmodel.ConsultarIndicadoresViewModel;
import viewmodel.ConsultarValorCuentaViewModel;

@SuppressWarnings("serial")
public class ConsultarIndicadoresView extends Dialog<ConsultarIndicadoresViewModel> {
	public ConsultarIndicadoresView(WindowOwner owner) {
		super(owner, new ConsultarIndicadoresViewModel());
		getModelObject().obtenerIndicadores();
	}

	public void createContents(Panel mainPanel) {
		this.setTitle("Obtener indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		Table<Indicador> tablaIndicadores= new Table<Indicador>(mainPanel, Indicador.class);
		
		tablaIndicadores.setNumberVisibleRows(15).bindItemsToProperty("indicadores");
		
		createColumn("Nombre", tablaIndicadores, "nombre");
		createColumn("Valor", tablaIndicadores, "valor");
				
	}
		
	public void createColumn(String title,Table<Indicador> tablaIndicadores, String property){
		new Column<Indicador>(tablaIndicadores)
			.setTitle(title)
			.setFixedSize(100)
			.bindContentsToProperty(property);
	}
	
	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub
		
	}
}
