package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import builder.BuilderMetodologia;
import model.Comparador;
import viewmodel.IngresarMetodologiaViewModel;

@SuppressWarnings("serial")
public class IngresarComparadoresView extends Dialog<IngresarMetodologiaViewModel>{

	public IngresarComparadoresView(WindowOwner owner, BuilderMetodologia builder) {
		super(owner, new IngresarMetodologiaViewModel(builder));
		this.getModelObject().obtenerComparadores();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		new Label(mainPanel).setText("Ordenable");
		new CheckBox(mainPanel).bindValueToProperty("esOrdenable");
		
		new Label(mainPanel).setText("Ingresar comparador");
		
		Selector<Comparador> selectorComparadores = new Selector<Comparador>(mainPanel);
		selectorComparadores.bindItemsToProperty("comparadoresOrden").adaptWith(Comparador.class, "nombreComparador");
		selectorComparadores.bindValueToProperty("comparadorOrdenSeleccionado");
		
		new Button(mainPanel).setCaption("Ingresar otro comparador").onClick(this::ingresarComparador);
		new Button(mainPanel).setCaption("Ingresar metodologia").onClick(this::ingresarMetodologia);
	}
	
	public void ingresarMetodologia(){
		this.getModelObject().validarComparadorSeleccionado();
		this.getModelObject().agregarComparadores();
		this.getModelObject().ingresarMetodologia();
		this.close();
	}
	public void ingresarComparador(){
		this.getModelObject().validarComparadorSeleccionado();
		this.getModelObject().agregarComparadores();
		BuilderMetodologia builder = this.getModelObject().getBuilderMetodologia();
		this.close();
		new IngresarComparadoresView(this, builder).open();
	}
	
}
