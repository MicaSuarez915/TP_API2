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
		conf.addAnnotatedClass(Usuario.class);
		conf.addAnnotatedClass(Duenio.class);
		conf.addAnnotatedClass(Inquilino.class);
		conf.addAnnotatedClass(AreaComun.class);
		conf.addAnnotatedClass(Unidad.class);
		conf.addAnnotatedClass(Edificio.class);
		conf.addAnnotatedClass(Reclamo.class);


		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		createDuenios(session);
		interfazQueryDuenio(session);

		createInquilino(session);
		interfazQueryInquilino(session);

		createEdificios(session);
		interfazQueryEdificios(session);

		createUnidades(session);
		interfazQueryUnidades(session);





		
		session.close();

	}
	

	public static void createDuenios(Session session) {
		Duenio duenio = new Duenio("Mario","Lopez",22837463, "mlopez", "mlopez");
		Duenio duenio2 = new Duenio("Victoria","Castarelli",17938746, "vcast", "viviki");
		Duenio duenio3 = new Duenio("Tamara","Villaruel",26738472, "tamiVillaruel", "pirinchito");
		
		Transaction tx = session.beginTransaction();
		session.save(duenio);
		session.save(duenio2);
		session.save(duenio3);
		
		tx.commit();
	}


	//creates
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

	public static void createUnidades(Session session){
		Unidad unidad1= new Unidad(5, 3, true, false);
		Unidad unidad2= new Unidad(9, 1, true, true);
		Unidad unidad3= new Unidad(5, 2, true, true);

		Transaction tx = session.beginTransaction();
		session.save(unidad1);
		session.save(unidad2);
		session.save(unidad3);

		tx.commit();
	}

	public static void createUnidad1(Session session, Unidad unidad){
		Transaction tx = session.beginTransaction();
		session.save(unidad);
		tx.commit();
	}

	public static void createAreaComun1(Session session, AreaComun areaComun){
		Transaction tx = session.beginTransaction();
		session.save(areaComun);
		tx.commit();
	}

	public static void createAreasComunes(Session session){
		AreaComun areaComun1= new AreaComun("Pasillo Principal", "Vestidor rojo");
		AreaComun areaComun2= new AreaComun("Ascensores", "Ascensor 1");
		AreaComun areaComun3= new AreaComun("Zoom", "Area cubierta");
		AreaComun areaComun4= new AreaComun("Piscina", "Area descubierta");

		Transaction tx = session.beginTransaction();
		session.save(areaComun1);
		session.save(areaComun2);
		session.save(areaComun3);
		session.save(areaComun4);

		tx.commit();
	}


	public static void createReclamoAC(Session session, AreaComun areaComun, Duenio duenio){
		Reclamo reclamo1 = new Reclamo("Reclamo 1",null);
		areaComun.agregarReclamo(reclamo1);
		reclamo1.setAreaComun(areaComun);
		duenio.agregarReclamo(reclamo1);
		reclamo1.setDuenio(duenio);
		Transaction tx = session.beginTransaction();
		session.save(areaComun);
		session.save(duenio);
		session.save(reclamo1);
		session.getTransaction().commit();
	}

	public static void createReclamoU(Session session, Unidad unidad, Duenio duenio){
		Reclamo reclamo1 = new Reclamo("Reclamo unidad",null);
		unidad.agregarReclamo(reclamo1);
		reclamo1.setUnidad(unidad);
		duenio.agregarReclamo(reclamo1);
		reclamo1.setDuenio(duenio);
		Transaction tx = session.beginTransaction();
		session.save(unidad);
		session.save(duenio);
		session.save(reclamo1);
		session.getTransaction().commit();
	}


	//interfazQuery

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