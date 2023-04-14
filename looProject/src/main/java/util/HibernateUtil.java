package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Employee;



public class HibernateUtil {

	public enum DefaultEnv{
		DRIVER("com.mysql.cj.jdbc.Driver"),
		URL("jdbc:mysql://localhost:3306/loo20231"),
		PASS("developer"),
		USER("developer"),
		DIALECT("org.hibernate.dialect.MySQL8Dialect"),
		SHOW_SQL("true"),
		CURRENT_SESSION_CONTEXT_CLASS("thread"),
		HBM2DDL_AUTO("create-drop");

		private String value;
		private DefaultEnv(String value){
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	};

	public static Properties getDBProperties(){
		Properties settings = new Properties();
		//DRIVER
		String envAcumulator = System.getenv(DefaultEnv.DRIVER.name());
		settings.put(Environment.DRIVER, 
		envAcumulator != null ? envAcumulator: DefaultEnv.DRIVER.getValue());
		//URL
		envAcumulator = System.getenv(DefaultEnv.URL.name());
		settings.put(Environment.URL, 
		envAcumulator != null ? envAcumulator: DefaultEnv.URL.getValue());
		//USER
		envAcumulator = System.getenv(DefaultEnv.USER.name());
		settings.put(Environment.USER, 
		envAcumulator != null ? envAcumulator: DefaultEnv.USER.getValue());
		//PASS
		envAcumulator = System.getenv(DefaultEnv.PASS.name());
		settings.put(Environment.PASS, 
		envAcumulator != null ? envAcumulator: DefaultEnv.PASS.getValue());
		//DIALECT
		envAcumulator = System.getenv(DefaultEnv.DIALECT.name());
		settings.put(Environment.DIALECT, 
		envAcumulator != null ? envAcumulator: DefaultEnv.DIALECT.getValue());
		//SOW_SQL
		envAcumulator = System.getenv(DefaultEnv.SHOW_SQL.name());
		settings.put(Environment.SHOW_SQL, 
		envAcumulator != null ? envAcumulator: DefaultEnv.SHOW_SQL.getValue());
		//CURRENT_SESSION_CONTEXT_CLASS
		envAcumulator = System.getenv(DefaultEnv.CURRENT_SESSION_CONTEXT_CLASS.name());
		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, 
		envAcumulator != null ? envAcumulator: DefaultEnv.CURRENT_SESSION_CONTEXT_CLASS.getValue());
		//HBM2DDL_AUTO
		envAcumulator = System.getenv(DefaultEnv.HBM2DDL_AUTO.name());
		settings.put(Environment.HBM2DDL_AUTO, 
		envAcumulator != null ? envAcumulator: DefaultEnv.HBM2DDL_AUTO.getValue());
		
		return settings;
	}

	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if( sessionFactory==null ) {	
			try {
				Configuration configuration = new Configuration();
				
				// equivalente ao hibernate.cfg.xml
				
				configuration.setProperties(getDBProperties());
				
				// aqui cadastro as classes que serão persistidas
				configuration.addAnnotatedClass(Employee.class);
			
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	
}
