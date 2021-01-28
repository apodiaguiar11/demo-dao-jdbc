package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner temp = new Scanner(System.in);	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ====");		
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ====");		
		Department department = new Department(2,null);				
		List<Seller> list = sellerDao.findByDepartment(department);		
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ====");				
		list = sellerDao.findAll();		
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert ====");				
		//Colocamos o id null, pois o método para inserir vai mandar o restante das informações
		//para o BD, e o BD vai incrementar automaticamente
		Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.0,department);		
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ====");	
		seller = sellerDao.findById(1); 
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: seller delete ====");	
		System.out.println("Digite o id para ser excluido: ");
		int id = temp.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		temp.close();
		
	}

}
