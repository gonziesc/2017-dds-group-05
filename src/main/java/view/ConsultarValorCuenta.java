package view;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.List;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

import model.Cuenta;
import model.Empresa;
import viewmodel.ConsultarValorCuentaViewModel;

@SuppressWarnings("serial")
public class ConsultarValorCuenta extends Dialog<ConsultarValorCuentaViewModel> {
	@SuppressWarnings("serial")
	public ConsultarValorCuenta(WindowOwner owner) {
		super(owner, new ConsultarValorCuentaViewModel());
		getModelObject().obtenerEmpresas();
	}

	public void createContents(Panel mainPanel) {
		this.setTitle("Obtener datos de una empresa");
		mainPanel.setLayout(new VerticalLayout());

		
		Selector<Empresa> selectorEmpresa = new Selector<Empresa>(mainPanel).allowNull(true);
		selectorEmpresa.bindItemsToProperty("empresas");
		selectorEmpresa.bindValueToProperty("empresaSeleccionada");
		
		new Button(mainPanel)
		.setCaption("Mostrar Cuentas")
		.onClick(this::mostrarCuentas);
		
		Table<Cuenta> tablaEvaluaciones = new Table<>(mainPanel, Cuenta.class);
		
		tablaEvaluaciones.setNumberVisibleRows(15).bindItemsToProperty("cuentasEmpresa");

		Column<Cuenta> columnaNombre = new Column<Cuenta>(tablaEvaluaciones);
		columnaNombre.setTitle("Nombre").bindContentsToProperty("nombre_cuenta");

		Column<Cuenta> columnaNumero_cuenta = new Column<Cuenta>(tablaEvaluaciones);
		columnaNumero_cuenta.setTitle("Valor").bindContentsToProperty("valor");

		Column<Cuenta> columnaAno = new Column<Cuenta>(tablaEvaluaciones);
		columnaAno.setTitle("Ano").bindContentsToProperty("anio_cuenta");
		
	}
	
	public void mostrarCuentas(){
		getModelObject().obtenerCuentasEmpresa();
	}


	@Override
	protected void addActions(Panel arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub

	}
	
	

}