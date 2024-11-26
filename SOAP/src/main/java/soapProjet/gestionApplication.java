package soapProjet;
import java.net.MalformedURLException;
import javax.xml.ws.Endpoint; 

public class gestionApplication {
	public static String host="localhost";
	public static short port=8089;
	
	public void demarrerServiceGestion() {
		String urlPersonne="http://"+host+":"+port+"/gestionPersonne";
		String urlMission="http://"+host+":"+port+"/gestionMission";
		Endpoint.publish(urlPersonne, new gestionPersonneWs());
		Endpoint.publish(urlMission, new gestionMission());
	}
	
	public static void main(String [] args)throws MalformedURLException {
		new gestionApplication().demarrerServiceGestion();
		System.out.println("Service a démarré");
	}
}
