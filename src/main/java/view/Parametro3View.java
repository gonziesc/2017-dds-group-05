package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
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
import viewmodel.Parametro3ViewModel;

@SuppressWarnings("serial")
public class Parametro3View extends Window<Parametro3ViewModel> {
	public Parametro3View(WindowOwner owner,BuilderIndicador builder) {

		super(owner, new Parametro3ViewModel(builder));
		this.getModelObject().obtenerIndicadores();
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		RadioSelector<String> radioTipo = new RadioSelector<String>(mainPanel);
		radioTipo.bindItemsToProperty("tipoParametros");
		radioTipo.bindValueToProperty("tipoSeleccionado");
		
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante");//.bindVisibleToProperty("parametro");
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel)
				.allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel);
		selectorCuentas.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");
		
		new Button(mainPanel).setCaption("Ingresar tercer parametro").onClick(this::ingresar).disableOnError();
		
	}
	
	public void ingresar(){
		if(!this.dosParametrosNulos()){
			throw new UserException("Debe ingresar un solo parametro");
		}
		this.getModelObject().ingresarParametro();
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	
	private boolean dosParametrosNulos() {
		return getModelObject().getIndicadorSeleccionado()== null 
					&& getModelObject().getCuentaSeleccionada() == null
						|| getModelObject().getValorParametroConstante() == null 
							&& getModelObject().getCuentaSeleccionada() == null;//HAY QUE ARREGLARLO
	}
}
