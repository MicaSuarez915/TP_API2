package app;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;
//import config.AppConfig;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		conf.addAnnotatedClass(Duenio.class);
		conf.addAnnotatedClass(Inquilino.class);
		conf.addAnnotatedClass(Usuario.class);
		conf.addAnnotatedClass(Edificio.class);
		conf.addAnnotatedClass(Unidad.class);

		
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		createDuenios(session);
		interfazQueryDuenio(session);

		createInquilino(session);
		interfazQueryInquilino(session);

		
		session.close();

	}
	

	public static void createDuenios(Session session) {
		Duenio duenio = new Duenio("Mario","Lopez",22837463);
		Duenio duenio2 = new Duenio("Victoria","Castarelli",17938746);
		Duenio duenio3 = new Duenio("Tamara","Villaruel",26738472);
		
		Transaction tx = session.beginTransaction();
		session.save(duenio);
		session.save(duenio2);
		session.save(duenio3);
		
		tx.commit();
	}


	public static void createInquilino(Session session) {
		Inquilino inquilino = new Inquilino("Rita","Marciel",23948573,"rmar","jdei");
		Inquilino inquilino2 = new Inquilino("Candelaria","Kerlans",44738294,"cande","jfioep");
		Inquilino inquilino3 = new Inquilino("Marcos","Reinals",40394827,"mmr","ksid");


		Transaction tx = session.beginTransaction();
		session.save(inquilino);
		session.save(inquilino2);
		session.save(inquilino3);

		tx.commit();
	}

	public static void createEdificios(Session session){
		Edificio edificio1= new Edificio("Rivadavia 1657");
		Edificio edificio2= new Edificio("Lima 506");

		Transaction tx = session.beginTransaction();
		session.save(edificio1);
		session.save(edificio2);

		tx.commit();
	}

	public static void interfazQueryEdificios(Session session){
		Query<Edificio> getQuery = session.createQuery("FROM Edificio", Edificio.class);
		List<Edificio> edificios = getQuery.list();
		for (Edificio e : edificios){
			System.out.println(e);
		}
	}

	public static void interfazQueryDuenio(Session session) {
		Query<Duenio> getQuery = session.createQuery("FROM Duenio", Duenio.class);
//		getQuery.setFirstResult(1);
//		getQuery.setMaxResults(2);
		List<Duenio> usuarios = getQuery.list();
		for (Usuario e : usuarios) {
			System.out.println(e);
		}
	}

	public static void interfazQueryInquilino(Session session) {
		Query<Inquilino> getQuery = session.createQuery("FROM Inquilino", Inquilino.class);
		List<Inquilino> usuarios = getQuery.list();
		for (Usuario e : usuarios) {
			System.out.println(e);
		}
	}


	public static void createUnidades(Session session){
		Unidad unidad1= new Unidad(5, 3, true, false);
		Unidad unidad2= new Unidad(9, 1, true, true);

		Transaction tx = session.beginTransaction();
		session.save(unidad1);
		session.save(unidad2);

		tx.commit();
	}

	public static void interfazQueryUnidades(Session session){
		Query<Unidad> getQuery = session.createQuery("FROM Unidad", Unidad.class);
		List<Unidad> unidades = getQuery.list();
		for (Unidad u : unidades){
			System.out.println(u);
		}
	}



	//prueba de inicio de sesion y reclamo
/**	public static void generarReclamoUnidad(Usuario usuario, Unidad unidad){
		if (usuario.condicionUsuario=="Duenio"){
			Reclamo reclamo = new Reclamo();
			
			Scanner sc = new Scanner(System.in);
			
			//pide datos
			reclamo.setUsuario(usuario);
		    System.out.println("Ingrese Razon de Reclamo: ");
			String desc = sc.nextLine();
			//agrega desc
			System.out.println("Ingrese Edificio: ");
			String edi = sc.nextLine();
			//agrega edi
			System.out.println("Ingrese Unidad: ");
			String uni = sc.nextLine();
			//agrega unida
			Foto fotoRec= new Foto();
			//asigna datos+
			reclamo( desc, fotoRec);
			reclamo.setUnidad(uni);

			//asignar estado de reclamo
			//reclamo.estado("nuevo")

		}

	    //


	}**/




}