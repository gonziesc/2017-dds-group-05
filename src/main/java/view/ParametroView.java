package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import builder.BuilderIndicador;
import builder.BuilderParametro;
import model.Cuenta;
import model.Indicador;
import viewmodel.ParametroViewModel;

@SuppressWarnings("serial")
public class ParametroView extends Dialog<ParametroViewModel>{

	public ParametroView(WindowOwner owner,BuilderIndicador builder, String unNombreIndicador) {
		super(owner, new ParametroViewModel(builder, null));
		this.getModelObject().obtenerCuentas();
		this.getModelObject().obtenerIndicadores();
		if(this.getModelObject().getNombreIndicador() == null)
			this.getModelObject().setNombreIndicador(unNombreIndicador);
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		new Label(mainPanel).setText("Ingrese el operador");
		
		crearBotonesDeOperadores(mainPanel);
		
		cargarDatosParaIndicador(mainPanel);
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
		this.getModelObject().setearParametroFinal();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new ParametroView(this,builder, this.getModelObject().getNombreIndicador()).open();
	}
	
	public void cargarDatosParaIndicador(Panel mainPanel){
		new Label(mainPanel).setText("Ingrese el tipo del parametro");
		Selector<String> radioTipo2 = new RadioSelector<String>(mainPanel).onSelection(()->this.getModelObject().limpiarSeleccionados());
		radioTipo2.bindItemsToProperty("tipoParametros");
		radioTipo2.bindValueToProperty("tipoSeleccionado");
		
		new Label(mainPanel).setText("Valor Constante");
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante");
		
		new Label(mainPanel).setText("Indicadores");
		
		Selector<Indicador> selectorIndicadores2 = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores2.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores2.bindValueToProperty("indicadorSeleccionado");
		
		new Label(mainPanel).setText("Cuentas");
		
		Selector<Cuenta> selectorCuentas2 = new Selector<Cuenta>(mainPanel).allowNull(false);
		selectorCuentas2.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas2.bindValueToProperty("cuentaSeleccionada");
		
		new Button(mainPanel).setCaption("Ingresar parametro compuesto").onClick(this::ingresar).disableOnError();
		
		new Button(mainPanel).setCaption("Ingresar indicador").onClick(this::ingresarIndicador).disableOnError();	
	}
	
	@Override
	protected void createFormPanel(Panel arg0) {
		
	}
	
	public void crearBotonesDeOperadores(Panel mainPanel) {
		new Button(mainPanel).setCaption("+").onClick(()->this.getModelObject().setOperacionSeleccionada("+"));
		new Button(mainPanel).setCaption("-").onClick(()->this.getModelObject().setOperacionSeleccionada("-"));
		new Button(mainPanel).setCaption("*").onClick(()->this.getModelObject().setOperacionSeleccionada("*"));
		new Button(mainPanel).setCaption("/").onClick(()->this.getModelObject().setOperacionSeleccionada("/"));
		
	}

}
