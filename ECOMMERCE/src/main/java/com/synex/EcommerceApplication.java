package com.synex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class EcommerceApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner(ProductService proSer) {
//		return args -> {
//			// read json and write to db
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/product.json");
//			try {
//				List<Product> product = mapper.readValue(inputStream,typeReference);
//				proSer.saveProducts(product);
//				
//				System.out.println("Products Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save users: " + e.getMessage());
//			}
//		};
//	}

}
