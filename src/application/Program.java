package application;

import java.sql.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1 : Seller FindById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2 : Seller FindByDepartment ===");
		
		Department dep = new Department (4, null);
		List<Seller> sellerList = sellerDao.findByDepartment(dep);
		for (Seller obj : sellerList) {

			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3 : Seller FindaAll ===");
		
		List<Seller> sellerListAll = sellerDao.findAll();
		for (Seller obj : sellerListAll) {

			System.out.println(obj);
		}
		

		System.out.println("\n=== TEST 4 : Seller Insert ===");
		
		Seller seller1 = new Seller(null, "Isaac Green", "isaac@santos.com", new Date(0), 4500.0, new Department(1, null) );

		//sellerDao.insert(seller1);
		System.out.println("Inserted! new id = " + seller1.getId());
		
		System.out.println("\n=== TEST 5 : Seller Update ===");
		
		seller1 =sellerDao.findById(10);
		seller1.setBaseSalary(10000.0);

		sellerDao.update(seller1);
		System.out.println(sellerDao.findById(seller1.getId()));
		System.out.println("Update Completed");
		

		System.out.println("\n=== TEST 6 : Seller Delete ===");
		

		//sellerDao.deleteById(15);
		sellerListAll = sellerDao.findAll();
		for (Seller obj : sellerListAll) {

			System.out.println(obj);
		}
	
	
	}

}
