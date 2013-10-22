package com.xghdevelopers.pscd.ejb;

import java.io.Serializable;

import javax.ejb.Singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.xghdevelopers.pscd.model.Dimensao;
import com.xghdevelopers.pscd.model.Pergunta;
import com.xghdevelopers.pscd.model.Pesquisa;
import com.xghdevelopers.pscd.model.TipoDimensao;

@Singleton
public class HibernateConection implements Serializable {

	private static final long serialVersionUID = 4225460254280623671L;

	public HibernateConection() {}

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration config = getConfiguration();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		config.setSessionFactoryObserver(new SessionFactoryObserver() {
			private static final long serialVersionUID = 6775593533881041976L;

			@Override
			public void sessionFactoryCreated(SessionFactory factory) {
			}

			@Override
			public void sessionFactoryClosed(SessionFactory factory) {
				ServiceRegistryBuilder.destroy(serviceRegistry);
			}
		});
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}

	private static Configuration getConfiguration() {
		Configuration cfg = new Configuration();
		
		cfg.addAnnotatedClass(Dimensao.class);
		cfg.addAnnotatedClass(TipoDimensao.class);
		cfg.addAnnotatedClass(Pergunta.class);
		cfg.addAnnotatedClass(Pesquisa.class);
		
//		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		
		cfg.setProperty("hibernate.connection.datasource", "jdbc/PSCD");
		cfg.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

		cfg.setProperty("hibernate.current_session_context_class", "thread");
		cfg.setProperty("hibernate.connemction.autocommit", "false");
		cfg.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");
		

		cfg.setProperty("hibernate.show_sql", "false");
		cfg.setProperty("hibernate.format_sql", "false");
		cfg.setProperty("hibernate.generate_statistics", "false");
		cfg.setProperty("hibernate.use_sql_comments", "false");

		return cfg;
	}
}
