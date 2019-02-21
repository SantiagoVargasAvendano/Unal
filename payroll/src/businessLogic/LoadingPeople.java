package businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import data.*;

public class LoadingPeople {

	public static Undergrad readUndergrad(Scanner sc) {
		Undergrad newUndergrad = null;
		
		String id = sc.next().trim();
		String name = sc.next().trim();
		String hd = sc.next().trim();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
		String dp = sc.next().trim();
		String hours = sc.next().trim();
		int h = Integer.parseInt(hours);	

		Date hiringDate;
		try {
			hiringDate = ft.parse(hd);
			newUndergrad = new Undergrad(id, name,hiringDate,dp,h);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft);
			e.printStackTrace();
		}
		return newUndergrad;
	}

	public static Grad readGrad(Scanner sc) {
		Grad newGrad = null;
		
		String id = sc.next().trim();
		String name = sc.next().trim();
		String hd = sc.next().trim();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
		String dp = sc.next().trim();
		String courses = sc.next().trim();
		int c = Integer.parseInt(courses);	

		Date hiringDate;
		try {
			hiringDate = ft.parse(hd);
			newGrad = new Grad(id, name,hiringDate,dp,c);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft);
			e.printStackTrace();
		}
		return newGrad;
	}

	public static Employee readEmployee(Scanner sc) {
		String type = sc.next().trim();
		if (type.equals("Grad")) return readGrad(sc);
		return readUndergrad(sc);
	}
	
	public static ArrayList<Employee> readStaff(String fileName) {
		ArrayList<Employee> people = new ArrayList<Employee>();
		Scanner sc;
		try {
			sc = new Scanner(new File(fileName));
			sc.useDelimiter(",");
			while (sc.hasNext()) {
				people.add(readEmployee(sc));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found -- " + fileName);
			e.printStackTrace();
		}
		return people;
	}
        
        public static FullTime readFullTime(Scanner sc) {
		FullTime newFullTime = null;
		
		String id = sc.next().trim();
		String name = sc.next().trim();
		String hd = sc.next().trim();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                String sch = sc.next().trim();
		String dp = sc.next().trim();
		String salary = sc.next().trim();
		float c = Float.parseFloat(salary);

		Date hiringDate;
		try {
			hiringDate = ft.parse(hd);
			newFullTime = new FullTime(id, name,hiringDate,sch,dp,c);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft);
			e.printStackTrace();
		}
		return newFullTime;
	}
        
        public static PartialTime readPartialTime(Scanner sc) {
		PartialTime newPartialTime = null;
		
		String id = sc.next().trim();
		String name = sc.next().trim();
		String hd = sc.next().trim();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                String sch = sc.next().trim();
		String dp = sc.next().trim();
                String cat = sc.next().trim();
		String clhr = sc.next().trim();
		int c = Integer.parseInt(clhr);

		Date hiringDate;
		try {
			hiringDate = ft.parse(hd);
			newPartialTime = new PartialTime(id, name,hiringDate,sch,dp,cat,c);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft);
			e.printStackTrace();
		}
		return newPartialTime;
	}
        
        public static Administrative readAdministrative(Scanner sc) {
		Administrative newAdministrative = null;
		
		String id = sc.next().trim();
		String name = sc.next().trim();
		String hd = sc.next().trim();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                String cat = sc.next().trim();
		String salary = sc.next().trim();
		float c = Float.parseFloat(salary);

		Date hiringDate;
		try {
			hiringDate = ft.parse(hd);
			newAdministrative = new Administrative(id, name,hiringDate,cat,c);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft);
			e.printStackTrace();
		}
		return newAdministrative;
	}
        
        public static ByContract readByContract(Scanner sc) {
		ByContract newByContract = null;
		
		String id = sc.next().trim();
		String name = sc.next().trim();
		String hd = sc.next().trim();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                String month = sc.next().trim();
                int m = Integer.parseInt(month);
		String value = sc.next().trim();
		float v = Float.parseFloat(value);

		Date hiringDate;
		try {
			hiringDate = ft.parse(hd);
			newByContract = new ByContract(id, name,hiringDate,m,v);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft);
			e.printStackTrace();
		}
		return newByContract;
	}
        
        public static Employee readEmployee2(Scanner sc) {
		String type = sc.next().trim();
                Employee empleado = null;
                switch(type){
                    case "Grad":
                        empleado = readGrad(sc);
                        break;
                    case "Undergrad":
                        empleado = readUndergrad(sc);
                        break;
                    case "FullTime":
                        empleado = readFullTime(sc);
                        break;
                    case "PartialTime":
                        empleado = readPartialTime(sc);
                        break;
                    case "Administrative":
                        empleado = readAdministrative(sc);
                        break;
                    case "ByContract":
                        empleado = readByContract(sc);
                        break;
                }
                return empleado;
	}
}
