package application;

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

	}

}
