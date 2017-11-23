package server;

import java.util.Timer;
import jobs.actualizarEmpresas;
import jobs.precalcularIndicadores;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		Timer timer = new Timer();
		// actualizarEmpresas jobEmpresas = new actualizarEmpresas();

		// timer.scheduleAtFixedRate(jobEmpresas, 0, 60000);
		//precalcularIndicadores jobIndicadores = new precalcularIndicadores();

		//timer.scheduleAtFixedRate(jobIndicadores, 0, 60000);
		if(System.getenv("PORT")!=null)
		{
		Spark.port(Integer.parseInt(System.getenv("PORT")));
		} else {
			Spark.port(9000);
		}
		// DebugScreen.enableDebugScreen();
		Router.configure();
	}
}