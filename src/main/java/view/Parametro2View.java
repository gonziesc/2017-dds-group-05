package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import viewmodel.Parametro2ViewModel;

@SuppressWarnings("serial")
public class Parametro2View extends Window<Parametro2ViewModel> {
	public Parametro2View(WindowOwner owner,BuilderIndicador builder) {

		super(owner, new Parametro2ViewModel(builder));
		this.getModelObject().obtenerIndicadores();
		this.getModelObject().obtenerCuentas();
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		RadioSelector<String> radioTipo = new RadioSelector<String>(mainPanel);
		radioTipo.bindItemsToProperty("tipoParametros");
		radioTipo.bindValueToProperty("tipoSeleccionado");
		
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante");
		
		espacio(mainPanel);
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("segundoIndicador");
		
		espacio(mainPanel);
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel);
		selectorCuentas.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");
		
		espacio(mainPanel);
		
		new Button(mainPanel).setCaption("Ingresar segundo parametro").onClick(this::ingresar).disableOnError();
		new Button(mainPanel).setCaption("Ingresar indicador").onClick(this::ingresarIndicador).disableOnError();
		
	}
	public void ingresarIndicador(){
		if(!this.dosParametrosNulos()){
			throw new UserException("Seleccione un solo parametro");
		}
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	public void ingresar(){
		this.getModelObject().ingresarParametro2();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new Operador2View(this, builder).open();
	}

	private boolean dosParametrosNulos() {
		return getModelObject().getSegundoIndicador() == null 
					&& getModelObject().getCuentaSeleccionada() == null
						|| getModelObject().getValorParametroConstante() == null 
							&& getModelObject().getCuentaSeleccionada() == null;//HAY QUE ARREGLARLO
	}
	public void espacio(Panel mainPanel){
		new Label(mainPanel);
	}
}