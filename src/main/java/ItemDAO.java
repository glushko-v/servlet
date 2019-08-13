import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


 class ItemDAO {

    //считывание данных
    //обработка данных - маппинг
    //CRUD операции


     SessionFactory sessionFactory;

     SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }

        return sessionFactory;
    }

    public Item save(Item item) {

        Transaction tr = null;

        try (Session session = getSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.save(item);

            tr.commit();
            System.out.println("Saved");

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tr != null) tr.rollback();
        }


        return item;
    }

    public Item findById(long id) {

        Transaction tr = null;
        Item item = null;

        try (Session session = getSessionFactory().openSession()) {


            tr = session.getTransaction();
            tr.begin();

            item = session.get(Item.class, id);


            tr.commit();



        } catch (HibernateException e) {
            e.printStackTrace();
            if (tr != null) tr.rollback();
        }

        return item;
    }

    public void delete(long id){

        Transaction tr = null;

        try(Session session = getSessionFactory().openSession()){

            tr = session.getTransaction();
            tr.begin();

            Item item = findById(id);
            session.delete(item);

            tr.commit();
            System.out.println("Deleted");

        } catch (HibernateException e){
            e.printStackTrace();
            if (tr!= null) tr.rollback();
        }
    }

    public Item update(Item item) {

        Transaction tr = null;

        try (Session session = getSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.update(item);

            tr.commit();
            System.out.println("Updated");

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tr != null) tr.rollback();
        }


        return item;
    }
}
