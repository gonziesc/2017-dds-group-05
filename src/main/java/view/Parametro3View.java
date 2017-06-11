package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import viewmodel.Parametro3ViewModel;

@SuppressWarnings("serial")
public class Parametro3View extends Dialog<Parametro3ViewModel> {
	public Parametro3View(WindowOwner owner,BuilderIndicador builder) {

		super(owner, new Parametro3ViewModel(builder));
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerCuentas();
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		RadioSelector<String> radioTipo = new RadioSelector<String>(mainPanel);
		radioTipo.bindItemsToProperty("tipoParametros");
		radioTipo.bindValueToProperty("tipoSeleccionado");
		
		new Label(mainPanel).setText("Valor Constante");
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante");
		new Label(mainPanel).setText("Indicadores");
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		new Label(mainPanel).setText("Cuentas");
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel);
		selectorCuentas.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");
		
		new Button(mainPanel).setCaption("Ingresar tercer parametro").onClick(this::ingresar).disableOnError();
		
	}
	
	public void ingresar(){
		if(this.dosParametrosLlenos()){
			throw new UserException("Debe ingresar un solo parametro");
		}
		this.getModelObject().ingresarParametro();
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	
	private boolean dosParametrosLlenos() {
		return getModelObject().getValorParametroConstante() != null 
					&& getModelObject().getIndicadorSeleccionado() != null 
						|| getModelObject().getCuentaSeleccionada() !=null
							&& getModelObject().getIndicadorSeleccionado() != null;
	}

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub
		
	}
}
