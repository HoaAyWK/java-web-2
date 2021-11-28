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

import group11.business.Product;


public class ProductIO {
	public static void add(Product product, String path) throws IOException {
		BufferedWriter buffer = new BufferedWriter(new FileWriter(path, true));

        buffer.write(product.getCode() + "|" + product.getDescription() + "|"
                + product.getPrice());
        buffer.newLine();
        buffer.close();
	}
	
	public static Product getProduct(String productCode, String path) throws IOException {
		File file = new File(path);
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		Product product = new Product();
		
		String line = in.readLine();
		
		while(line != null) {
			StringTokenizer token = new StringTokenizer(line, "|");
			String code = token.nextToken();
			if (code.equalsIgnoreCase(productCode)) {
				String description = token.nextToken();
				String price = token.nextToken();
				product.setCode(productCode);
				product.setDescription(description);
				product.setPrice(Double.parseDouble(price));
			}
			line = in.readLine();
		}
		in.close();
		return product;
	}
	
	public static ArrayList<Product> getProducts(String path) throws IOException {
		ArrayList<Product> products = new ArrayList<Product>();
		File file = new File(path);
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		String line = in.readLine();
		
		while(line != null) {
			try {
				StringTokenizer token = new StringTokenizer(line, "|");
				String code = token.nextToken();
				String description = token.nextToken();
				String price = token.nextToken();
				
				Product product = new Product();
				product.setCode(code);
				product.setDescription(description);
				product.setPrice(Double.parseDouble(price));
				
				products.add(product);
				line = in.readLine();
				
			} catch(NoSuchElementException e) {
				line = in.readLine();
			}
		}
		in.close();
		return products;
	}
}
