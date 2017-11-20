package server;

import java.util.Timer;
import jobs.actualizarEmpresas;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		Timer timer = new Timer();
		actualizarEmpresas jobEmpresas = new actualizarEmpresas();

		timer.scheduleAtFixedRate(jobEmpresas, 0, 10000);
		Spark.port(9000);
		DebugScreen.enableDebugScreen();
		Router.configure();
	}
}