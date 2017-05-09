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
import org.uqbar.commons.model.UserException;
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
		
		Table<Cuenta> tablaCuentas = new Table<>(mainPanel, Cuenta.class);
		
		tablaCuentas.setNumberVisibleRows(15).bindItemsToProperty("cuentasEmpresa");
		
		createColumn("Nombre", tablaCuentas, "nombre_cuenta");
		createColumn("Valor", tablaCuentas, "valor");
		createColumn("Ano", tablaCuentas, "anio_cuenta");
		
	}
	
	public void mostrarCuentas(){
		if(getModelObject().getEmpresaSeleccionada() == null){
			throw new UserException("Seleccione una empresa");
		}
		getModelObject().obtenerCuentasEmpresa();
	}
	public void createColumn(String title,Table<Cuenta> tablaCuentas, String property){
		new Column<Cuenta>(tablaCuentas).setTitle(title).setFixedSize(100).bindContentsToProperty(property);
		
	}

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub
		
	}
}