package view;

import java.awt.Color;
import java.io.FileNotFoundException;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Cuenta;
import viewmodel.ConsultarValorCuentaViewModel;

@SuppressWarnings("serial")
public class ConsultarValorCuenta extends Dialog<ConsultarValorCuentaViewModel> {
	@SuppressWarnings("serial")
	public ConsultarValorCuenta(WindowOwner owner) {
		super(owner, new ConsultarValorCuentaViewModel());
	}

	public void createContents(Panel mainPanel) {
		this.setTitle("Obtener datos de una cuenta");
		mainPanel.setLayout(new VerticalLayout());

		new Button(mainPanel).setCaption("Consultar cuentas").onClick(
				() -> getModelObject().obtenerCuenta());

		Table<Cuenta> tablaEvaluaciones = new Table<>(mainPanel, Cuenta.class);
		tablaEvaluaciones.bindValueToProperty("cuentas");
		tablaEvaluaciones.setNumberVisibleRows(15).bindItemsToProperty(
				"cuentas");

		Column<Cuenta> columnaNombre = new Column<Cuenta>(tablaEvaluaciones);
		columnaNombre.setTitle("Nombre")
				.bindContentsToProperty("nombre_cuenta");

		Column<Cuenta> columnaNumero_cuenta = new Column<Cuenta>(
				tablaEvaluaciones);
		columnaNumero_cuenta.setTitle("Numero").bindContentsToProperty(
				"numero_cuenta");

		Column<Cuenta> columnaAno = new Column<Cuenta>(tablaEvaluaciones);
		columnaAno.setTitle("Ano").bindContentsToProperty("anio_cuenta");

		Column<Cuenta> columnaGanancia = new Column<Cuenta>(tablaEvaluaciones);
		columnaGanancia.setTitle("Ganancia").bindContentsToProperty("ganancia");

		Column<Cuenta> columnaGananciaNeta = new Column<Cuenta>(
				tablaEvaluaciones);
		columnaGananciaNeta.setTitle("Neta").bindContentsToProperty(
				"gananciaNeta");

		Column<Cuenta> comunaIntereses = new Column<Cuenta>(tablaEvaluaciones);
		comunaIntereses.setTitle("intereses").bindContentsToProperty(
				"intereses");

		Column<Cuenta> columnaImpuestos = new Column<Cuenta>(tablaEvaluaciones);
		columnaImpuestos.setTitle("impuestos").bindContentsToProperty(
				"impuestos");

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