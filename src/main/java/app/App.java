package app;

import DAO.*;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		conf.addAnnotatedClass(Usuario.class);
		conf.addAnnotatedClass(Duenio.class);
		conf.addAnnotatedClass(Inquilino.class);
		conf.addAnnotatedClass(AreaComun.class);
		conf.addAnnotatedClass(Unidad.class);
		conf.addAnnotatedClass(Edificio.class);
		conf.addAnnotatedClass(Reclamo.class);
		conf.addAnnotatedClass(EstadoReclamo.class);


		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		DaoDuenio dueños= new DaoDuenio();
		dueños.save(session);
		dueños.gelAll(session);


		DaoAreaComun areaComun= new DaoAreaComun();
		areaComun.save(session);
		areaComun.gelAll(session);

		DaoInquilino inquilino= new DaoInquilino();
		inquilino.save(session);
		inquilino.gelAll(session);

		DaoEdificio edificio= new DaoEdificio();
		edificio.save(session);
		edificio.gelAll(session);

		DaoUnidad unidad= new DaoUnidad();
		unidad.gelAll(session);
		unidad.save(session);

		DaoReclamo reclamo= new DaoReclamo();
		reclamo.gelAll(session);
		reclamo.save(session);

		session.close();

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

	 //RECLAMO PARA UNIDADES Y PARA AREAS COMUNES
	public static void createReclamoAC(Session session/**, AreaComun areaComun, Duenio duenio**/){
		Duenio duenio = new Duenio("Mariano","Lopez",23456876, "marianlopez", "marianlopez");
		AreaComun areaComun= new AreaComun("Jacuzzi", "Area cubierta");
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

	public static void createReclamoU(Session session/**, AreaComun areaComun, Duenio duenio**/){
		Inquilino inquilino = new Inquilino("Mariano","Lopez",23456876, "marianlopez", "marianlopez");
		Unidad unidad= new Unidad(1, 3, true, true);
		Reclamo reclamo1 = new Reclamo("Reclamo unidad",null);

		unidad.agregarReclamo(reclamo1);
		reclamo1.setUnidad(unidad);
		inquilino.agregarReclamo(reclamo1);
		reclamo1.setInquilino(inquilino);
		Transaction tx = session.beginTransaction();
		session.save(unidad);
		session.save(inquilino);
		session.save(reclamo1);
		session.getTransaction().commit();
	}




	//uniones
	public static void DuenioUnidad(Session session, Duenio duenio, Unidad unidad){
		duenio.agregarUnidad(unidad);
		unidad.setDuenio(duenio);
		session.beginTransaction();
		session.save(duenio);
		session.getTransaction().commit();
	}

	public static void UnidadInquilino(Session session, Unidad unidad, Inquilino inquilino){
		unidad.addInquilinos(inquilino);
		inquilino.setUnidad(unidad);
		session.beginTransaction();
		session.save(unidad);
		session.getTransaction().commit();
	}

	public static void UnidadEdificio(Session session, Unidad unidad, Edificio edificio){
		edificio.agregarUnidad(unidad);
		unidad.setEdificio(edificio);
		session.beginTransaction();
		session.save(edificio);
		session.getTransaction().commit();
	}

	public static void AreaComunEdificio(Session session, AreaComun areaComun, Edificio edificio){
		edificio.addAreaComun(areaComun);
		areaComun.setEdificio(edificio);
		session.beginTransaction();
		session.save(edificio);
		session.getTransaction().commit();
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