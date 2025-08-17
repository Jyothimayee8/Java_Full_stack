package com.library;
	import org.hibernate.SessionFactory;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;

	public class LibraryConfig {
		private static SessionFactory sessionFactory;
		public static SessionFactory getSessionFactory() {
			try {
	            Configuration configuration = new Configuration();
	            // Database connection settings
	            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
	            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/library");
	            configuration.setProperty("hibernate.connection.username", "root");
	            configuration.setProperty("hibernate.connection.password", "root");
	            // Hibernate settings
	            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	            configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // create, update, validate, none
	            configuration.setProperty("hibernate.show_sql", "true");
	            // Add annotated class
	            configuration.addAnnotatedClass(Book.class);
	            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties());
	            sessionFactory = configuration.buildSessionFactory(builder.build());
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	    return sessionFactory;
	    }
	}