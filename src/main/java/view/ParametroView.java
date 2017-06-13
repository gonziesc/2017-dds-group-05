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
import model.Cuenta;
import model.Indicador;
import viewmodel.ParametroViewModel;

public class ParametroView extends Dialog<ParametroViewModel>{

	public ParametroView(WindowOwner owner,BuilderIndicador builder) {
		super(owner, new ParametroViewModel(builder));
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		new Label(mainPanel).setText("Ingrese el operador");
		crearBotonesDeOperadores(mainPanel);
		cargarDatosParaIndicador(mainPanel);
	}
	
	public void cargarDatosParaIndicador(Panel mainPanel){
		new Label(mainPanel).setText("Ingrese el tipo del parámetro");
		Selector<String> radioTipo2 = new RadioSelector<String>(mainPanel).onSelection(()->this.getModelObject().limpiarSeleccionados2());
		radioTipo2.bindItemsToProperty("tipoParametros");
		radioTipo2.bindValueToProperty("tipoSeleccionado2");
		
		new Label(mainPanel).setText("Valor Constante");
		new NumericField(mainPanel).bindValueToProperty("valorParametroConstante2");
		
		new Label(mainPanel).setText("Indicadores");
		
		Selector<Indicador> selectorIndicadores2 = new Selector<Indicador>(mainPanel).allowNull(true);
		selectorIndicadores2.bindItemsToProperty("indicadores").adaptWith(Indicador.class, "nombre");
		selectorIndicadores2.bindValueToProperty("indicadorSeleccionado2");
		
		new Label(mainPanel).setText("Cuentas");
		
		Selector<Cuenta> selectorCuentas2 = new Selector<Cuenta>(mainPanel).allowNull(false);
		selectorCuentas2.bindItemsToProperty("cuentas").adaptWith(Cuenta.class, "nombreCuenta");
		selectorCuentas2.bindValueToProperty("cuentaSeleccionada2");
		
		new Button(mainPanel).setCaption("Ingresar parámetro compuesto").onClick(this::ingresar).disableOnError();
		
		new Button(mainPanel).setCaption("Ingresar indicador").onClick(this::ingresarIndicador).disableOnError();	
	}
	
	public void ingresarIndicador(){
		if(this.dosParametrosLlenos()){
			throw new UserException("Seleccione un solo parámetro");
		}
		this.getModelObject().ingresarIndicador();
		this.close();
	}
	

	private boolean dosParametrosLlenos() {
		return getModelObject().getValorParametroConstante1() != null 
					&& getModelObject().getIndicadorSeleccionado1() != null 
						|| getModelObject().getCuentaSeleccionada1() !=null
							&& getModelObject().getIndicadorSeleccionado1() != null;
	}
	//uso dos parametros llenos para que si pasa esto tire la excepcion
	
	public void ingresar(){
		
		if(this.dosParametrosLlenos()){
			throw new UserException("Seleccione un solo parametro");
		}
		//this.getModelObject().ingresarParametro();
		BuilderIndicador builder = this.getModelObject().getBuilderIndicador();
		this.close();
		new ParametroView(this,builder).open();
	}
	/* Esto es lo que falta: cuando toca ingresar parametro compuesto, debe llevarlo 
	 * a una vista igual a esta, pero que en vez de que ingrese el indicador, 
	 * ingrese solamente 1 de sus parametros, que seria compuesto
	 * ya se puede hacer en el modelo, falta en la view. hay que llevar el builder
	 * de vissta en vista y cargarle solamente el primer parametro. Son necesarios otro viewmodel
	 * y otra vista, pero nada mas. hay que limpiar la logica repetida en ESTA vista y
	 * hacer las validaciones que faltan. */
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
