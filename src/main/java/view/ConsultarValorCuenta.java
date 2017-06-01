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
import viewmodel.ConsultarValorCuentaViewModel;

@SuppressWarnings("serial")
public class ConsultarValorCuenta extends Dialog<ConsultarValorCuentaViewModel> {
	public ConsultarValorCuenta(WindowOwner owner) {
		super(owner, new ConsultarValorCuentaViewModel());
		getModelObject().obtenerEmpresas();
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Obtener datos de una empresa");
		mainPanel.setLayout(new VerticalLayout());
		
		Selector<Empresa> selectorEmpresa = new Selector<Empresa>(mainPanel);
		selectorEmpresa.bindItemsToProperty("empresas");
		selectorEmpresa.bindValueToProperty("empresaSeleccionada");
		
		new Button(mainPanel)
			.setCaption("Mostrar Cuentas")
			.onClick(this::mostrarCuentas);
		
		new Button(mainPanel)
		.setCaption("Mostrar Indicadores")
		.onClick(this::mostarIndicadores);
		
		Table<Cuenta> tablaCuentas = new Table<>(mainPanel, Cuenta.class);
		
		tablaCuentas.setNumberVisibleRows(15).bindItemsToProperty("cuentasEmpresa");
		
		createColumnCuenta("Nombre", tablaCuentas, "nombreCuenta");
		createColumnCuenta("Valor ", tablaCuentas, "valor");
		createColumnCuenta("Ano ", tablaCuentas, "anioCuenta");
		
		Table<Indicador> tablaIndicadores= new Table<Indicador>(mainPanel, Indicador.class);
		
		tablaIndicadores.setNumberVisibleRows(15).bindItemsToProperty("indicadores");
		
		createColumnIndicador("Nombre", tablaIndicadores, "nombre");
		createColumnIndicador("Valor", tablaIndicadores, "valor");
				
	}
	
	public void mostrarCuentas(){
		if(getModelObject().getEmpresaSeleccionada() == null){
			throw new UserException("Seleccione una empresa");
		}
		getModelObject().obtenerCuentasEmpresa();
	}
	public void createColumnCuenta(String title,Table<Cuenta> tablaCuentas, String property){
		new Column<Cuenta>(tablaCuentas).setTitle(title).setFixedSize(150).bindContentsToProperty(property);
	}
	
	public void createColumnIndicador(String title,Table<Indicador> tablaIndicador, String property){
		new Column<Indicador>(tablaIndicador).setTitle(title).setFixedSize(150).bindContentsToProperty(property);
	}
	public void mostarIndicadores(){
		if(getModelObject().getEmpresaSeleccionada() == null){
			throw new UserException("Seleccione una empresa");
		}
		getModelObject().obtenerIndicadores();
	}

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub
		
	}
}