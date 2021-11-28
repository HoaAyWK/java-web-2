package group11.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import group11.business.User;


public class UserIO {
	public static void add(User user, String path) throws IOException {
		BufferedWriter buffer = new BufferedWriter(new FileWriter(path, true));

        buffer.write(user.getId() + "|" + user.getEmail() + "|" + user.getFirstName() + "|"
                + user.getLastName());
        buffer.newLine();
        buffer.close();
	}
	
	public static User getUser(String userId, String path) throws IOException {
		File file = new File(path);
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		User user = new User();
		
		String line = in.readLine();
		
		while(line != null) {
			StringTokenizer token = new StringTokenizer(line, "|");
			String id = token.nextToken();
			if (id.equalsIgnoreCase(userId)) {
				String email = token.nextToken();
				String firstName = token.nextToken();
				String lastName = token.nextToken();
				user.setId(id);
				user.setEmail(email);
				user.setFirstName(firstName);
				user.setLastName(lastName);
			}
			line = in.readLine();
		}
		in.close();
		return user;
	}
	
	public static ArrayList<User> getUsers(String path) throws IOException {
		ArrayList<User> users = new ArrayList<User>();
		File file = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		String line = in.readLine();
		
		while(line != null) {
			try {
				StringTokenizer token = new StringTokenizer(line, "|");
				String id = token.nextToken();
				String email = token.nextToken();
				String firstName = token.nextToken();
				String lastName = token.nextToken();
				
				User user = new User(id, email, firstName, lastName);
				
				users.add(user);
				
				line = in.readLine();
				
			} catch(NoSuchElementException e) {
				line = in.readLine();
			}
		}
		in.close();
		return users;
	}
}
