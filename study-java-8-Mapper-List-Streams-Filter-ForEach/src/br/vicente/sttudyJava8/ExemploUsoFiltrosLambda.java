package br.vicente.sttudyJava8;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploUsoFiltrosLambda {
	
	public static void exemploLambda() {
		
		// List containing names of foodstuffs
		List<String> namesProd = Arrays.asList("Water", "Beans", "Salt", "Bread", "Banana");

	 	System.out.println("For used before java 8");
	 	
        // Print the product with different name "beans".
        for (String name : namesProd) {
            if (!name.equals("Beans")) {
                Product prod = new Product(name);
                System.out.println(prod);
            }
        }

        System.out.println("For used after java 8");
        
        // Obtaining banana product
        List<Product> prodList = namesProd.stream()
                .filter(p -> p.equals("Banana"))
                .map(Product::new)
                .collect(Collectors.toList());
        prodList.forEach(p -> System.out.println(p.getName()));

        // Adding Products different from banana to a Map
        namesProd.stream()
                .filter(ExemploUsoFiltrosLambda::isNotBanana)
                .map(Product::new)
                .forEach(System.out::println);

        // Adding Products to a Map
        List<Product> productList = namesProd.stream()
                .filter(ExemploUsoFiltrosLambda::isNotBanana)
                .map(Product::new)
                .collect(Collectors.toList());

	    // Adding the integer values contained in the map
        int sum = productList.stream()
                .mapToInt(Product::getPrice)
                .sum();

        System.out.println(sum);
        
	} // exemploLambda

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		exemploLambda();
	}	

	/**
	 * 
	 * @param name
	 * @return
	 */
    private static boolean isNotBanana(String name) {
        return !name.equals("Banana");
    }

    /**
     * 
     * @author Vicente
     *
     */
    static class Product {
    	
        private String nameProduct;
        private Integer price = 30;

        public Product(String nameProduct) {
            this.nameProduct = nameProduct;
        }

        public String getName() {
            return nameProduct;
        }

        public void setName(String nameProduct) {
            this.nameProduct = nameProduct;
        }

        public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		@Override
        public String toString() {
            return "Producto : " + nameProduct + " Value : " + price;
        }
		
    } // Product

}