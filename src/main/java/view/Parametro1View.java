
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
import viewmodel.Parametro1ViewModel;

@SuppressWarnings("serial")
public class Parametro1View extends Window<Parametro1ViewModel> {
	public Parametro1View(WindowOwner owner,BuilderIndicador builder) {

		super(owner, new Parametro1ViewModel(builder));
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
		
		new Label(mainPanel).setText("Nombre Indicador");
		new TextBox(mainPanel).bindValueToProperty("nombreIndicador");
		new Label(mainPanel).setText("Valor Constante");
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante");
		
		new Label(mainPanel).setText("Indicadores");
		
		Selector<Indicador> selectorIndicadores = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores.bindValueToProperty("indicadorSeleccionado");
		
		new Label(mainPanel).setText("Cuentas");
		
		Selector<Cuenta> selectorCuentas = new Selector<Cuenta>(mainPanel).allowNull(false);
		selectorCuentas.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas.bindValueToProperty("cuentaSeleccionada");
		
		new Button(mainPanel).setCaption("Ingresar primer parametro").onClick(this::ingresar).disableOnError();
		new Button(mainPanel).setCaption("Ingresar indicador").onClick(this::ingresarIndicador).disableOnError();	

	}
	
	public void ingresarIndicador(){
		if(this.dosParametrosLlenos()){
			throw new UserException("Seleccione un solo parametro");
		}
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	

	private boolean dosParametrosLlenos() {
		return getModelObject().getValorParametroConstante() != null 
					&& getModelObject().getIndicadorSeleccionado() != null 
						|| getModelObject().getCuentaSeleccionada() !=null
							&& getModelObject().getIndicadorSeleccionado() != null;
	}
	//uso dos parametros llenos para que si pasa esto tire la excepcion
	

	public void ingresar(){
		if(this.dosParametrosLlenos()){
			throw new UserException("Seleccione un solo parametro");
		}
		this.getModelObject().ingresarParametro();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new Operador1View(this,builder).open();
	}

}

