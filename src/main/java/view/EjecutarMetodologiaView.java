package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Cuenta;
import model.Empresa;
import model.Metodologia;
import viewmodel.EjecutarMetodologiaViewModel;

@SuppressWarnings("serial")
public class EjecutarMetodologiaView extends Dialog<EjecutarMetodologiaViewModel>{

	public EjecutarMetodologiaView(WindowOwner owner) {
		super(owner, new EjecutarMetodologiaViewModel());
		getModelObject().obtenerMetodologias();
		getModelObject().obtenerEmpresas();
	}

	public void ejecutarMetodologia(){
		this.getModelObject().ejecutarMetodologia();
	}
	
	public void createColumnEmpresa(String title,Table<Empresa> tablaEmpresa, String property){
		new Column<Empresa>(tablaEmpresa).setTitle(title).setFixedSize(100).bindContentsToProperty(property);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Pantalla para probar una metodologia contra una determinada cantidad de empresas");
	
		new Label(mainPanel).setText("Ingrese metodologia");
		Selector<Metodologia> selectorMetodologias = new Selector<Metodologia>(mainPanel);
		selectorMetodologias.bindItemsToProperty("metodologias").adaptWith(Metodologia.class, "nombre");
		selectorMetodologias.bindValueToProperty("metodologiaSeleccionada");
		
		new Button(mainPanel).setCaption("Ejecutar metodologia").onClick(this::ejecutarMetodologia);
		
		Table<Empresa> tablaEmpresas = new Table<>(mainPanel, Empresa.class);
		tablaEmpresas.setNumberVisibleRows(5).bindItemsToProperty("empresas");
		createColumnEmpresa("Empresa",tablaEmpresas, "nombreEmpresa");
	}

}
