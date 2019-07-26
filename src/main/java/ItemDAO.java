import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ItemDAO {
    SessionFactory sessionFactory;

    SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }

        return sessionFactory;
    }

    public Item save(Item item){

        Transaction tr = null;

        try(Session session = getSessionFactory().openSession()){

            tr = session.getTransaction();
            tr.begin();

            session.save(item);

            tr.commit();
            System.out.println("Saved");

        } catch (HibernateException e){
            e.printStackTrace();
            if(tr != null) tr.rollback();
        }


        return item;
    }
}
