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
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===Teste 1: Seller findByID ====");
		Seller seller = sellerDao.findById(5);
		
		System.out.println(seller);
		System.out.println();
		
		System.out.println("===Teste 2: Seller findByDepartment ====");
		
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartament(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("===Teste 3: Seller findAll ====");

		 list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		System.out.println("===Teste 4: Seller insert ====");
		Seller newSeller = new Seller(null, "Toninho", "Toninho@gmail.com", new Date(), 4000.0, department );
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		
		System.out.println();
		System.out.println("===Teste 5: Seller Update ====");
		seller = sellerDao.findById(9);
		seller.setName("Toninho Andrade");
		sellerDao.update(seller);
		System.out.println("Update Realizado");
		
		System.out.println();
		System.out.println("===Teste 6: Seller Exclus?o ====");
		System.out.println("Entre com um ID para excluir");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Concluido");
		sc.close();
		
		

	}

}
