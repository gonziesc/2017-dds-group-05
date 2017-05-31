import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import model.FixtureCuentas;
import view.StartWindow;

public class DondeInviertoApp extends Application{

	public static void main(String[] args) {
		FixtureCuentas.initialize();
		new DondeInviertoApp().start();
	}
	@Override
	protected Window<?> createMainWindow() {
		return new StartWindow(this);
	}
}
