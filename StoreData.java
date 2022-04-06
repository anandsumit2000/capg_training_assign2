import entity.Catalog;
import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.getCurrentSession();

        Transaction t = session.beginTransaction();

        Category category = new Category();
        category.setCategoryName("Torso");

        Catalog catalog0 = new Catalog();
        catalog0.setCatalogName("Kid");
        catalog0.setStatus("Active");

        Catalog catalog1 = new Catalog();
        catalog1.setCatalogName("Men");
        catalog1.setStatus("Inactive");

        category.getListt().add(catalog0);
        category.getListt().add(catalog1);

        catalog0.setCategory(category);
        catalog1.setCategory(category);

        session.persist(category);

        t.commit();
        System.out.println("Successfull..!");
        session.close();
        factory.close();
    }
}
