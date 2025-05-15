package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1 : Department FindByAll ===");
		
		List<Department> depList = depDao.findAll();
		
		for (Department dep : depList) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== TEST 2 : Department FindById ===");
		
		Department dep = depDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 3 : Department Insert ===");
		
		//Department newDep = new Department(null, "Shoes");
		//depDao.insert(newDep);
		
		depList = depDao.findAll();
		
		for (Department dep1 : depList) {
			System.out.println(dep1);
		}
		
		System.out.println("\n=== TEST 4 : Department Update ===");
		
		Department newDep = new Department(8, "Toys");
		
		depDao.update(newDep);
		
		depList = depDao.findAll();
		
		for (Department dep1 : depList) {
			System.out.println(dep1);
		}
		
		System.out.println("\n=== TEST 5 : Department Delete ===");
		
		depDao.deleteById(8);
		
		depList = depDao.findAll();
		
		for (Department dep1 : depList) {
			System.out.println(dep1);
		}
	
	
	}

}
