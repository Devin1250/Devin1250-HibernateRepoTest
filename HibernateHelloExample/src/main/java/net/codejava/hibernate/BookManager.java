package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookManager {
	private static final SessionFactory sessionFactory = buildSessionFactorys();
	// code to load Hibernate Session factory
	public BookManager() {
		
	}
	private static SessionFactory buildSessionFactorys() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

	protected void exit() {
		// code to close Hibernate Session factory
		sessionFactory.close();
	}

	protected void create() {
		Book book = new Book();
		book.setTitle("Effective Java");
		book.setAuthor("Joshua Bloch");
		book.setPrice(32.59f);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void read() {
		Session session = sessionFactory.openSession();

		long bookId = 1;
		Book book = session.get(Book.class, bookId);

		System.out.println("Title: " + book.getTitle());
		System.out.println("Author: " + book.getAuthor());
		System.out.println("Price: " + book.getPrice());

		session.close();
	}

	protected void update() {
		Book book = new Book();
		book.setBookId(1);
		book.setTitle("Ultimate Java Programming");
		book.setAuthor("Nam Ha Minh");
		book.setPrice(19.99f);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void delete() {
		Book book = new Book();
		book.setBookId(1);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(book);

		session.getTransaction().commit();
		session.close();
	}


	public static void main(String[] args) {
		BookManager manager = new BookManager();
		//manager.setup();
		manager.create();
		manager.read();
		manager.update();
		manager.read();
		manager.exit();
	}
}