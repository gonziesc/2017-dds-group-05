
package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import builder.BuilderIndicador;
import model.Cuenta;
import model.Indicador;
import model.Parametro;
import viewmodel.Parametro1ViewModel;

@SuppressWarnings("serial")
public class Parametro1View extends Window<Parametro1ViewModel> {
	public Parametro1View(WindowOwner owner) {

		super(owner, new Parametro1ViewModel());
		this.getModelObject().obtenerIndicadores();
	}
	
	public void createContents(Panel mainPanel) {
		this.setTitle("Ingreso de indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		RadioSelector<String> radioTipo = new RadioSelector<String>(mainPanel);
		radioTipo.bindItemsToProperty("tipoParametros");
		radioTipo.bindValueToProperty("tipoSeleccionado");
		
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante");
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		espacio(mainPanel);
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel).allowNull(true);
		selectorCuentas.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");
		
		espacio(mainPanel);
		
		new Button(mainPanel).setCaption("Ingresar primer parametro").onClick(this::ingresar).disableOnError();
		new Button(mainPanel).setCaption("Ingresar indicador").onClick(this::ingresarIndicador).disableOnError();	

	}
	
	public void ingresarIndicador(){
		if(!this.dosParametrosNulos()){
			throw new UserException("Seleccione un solo parametro");
		}
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	
	private boolean dosParametrosNulos() {
		return getModelObject().getIndicadorSeleccionado() == null 
					&& getModelObject().getCuentaSeleccionada() == null
						|| getModelObject().getValorParametroConstante() == null 
							&& getModelObject().getCuentaSeleccionada() == null;//HAY QUE ARREGLARLO
	}

	public void ingresar(){
		if(!this.dosParametrosNulos()){
			throw new UserException("Seleccione un solo parametro");
		}
		this.getModelObject().ingresarParametro1();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new Operador1View(this,builder).open();
	}

	public void espacio(Panel mainPanel){
		new Label(mainPanel);
	}
}

