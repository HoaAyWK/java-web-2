package group11.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import secret.Secret;



@WebListener
public class MongoDBContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ConnectionString connectionString = new ConnectionString("mongodb+srv://iovay:1matkhauquayeu...@java-web.ds1uw.mongodb.net/java-web?retryWrites=true&w=majority"); // replace Secret.getUrlSecret() with your connection string
			MongoClientSettings settings = MongoClientSettings.builder()
					.applyConnectionString(connectionString)
					.build();
			MongoClient mongo = MongoClients.create(settings);
			System.out.println("MongoClient initialized successful!");
			sce.getServletContext().setAttribute("MONGO_CLIENT", mongo);
		} catch (MongoException e) {
			throw new RuntimeException("MongoClient init failed!");
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		MongoClient mongo = (MongoClient) sce.getServletContext()
											 .getAttribute("MONGO_CLIENT");
		mongo.close();
		System.out.println("MongoClient closed successful!");
	}
}
