package corejava;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapAndHashTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<String, String> employee = new HashMap<String, String>();
		employee.put("name", "Smith");
		employee.put("salary", ""+50000); // not thread safe
		
		//allows one null key and multiple null values
		employee.put(null, "1");
		employee.put(null, "2");
		
		Iterator<Entry<String, String> > iterator = employee.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Entry e = iterator.next();
//			System.out.println("key : "+ e.getKey()+" and value : "+e.getValue());
		}
//		System.out.println(employee);
		
		
		Hashtable<String, String> account = new Hashtable<String, String>();
		account.put("username", "Adam");
		account.put("password", "*******");
		
		//thread safe, legacy class, null key & null values not allowed
		
		Enumeration<String> en = account.elements();
//		en.asIterator()
		while(en.hasMoreElements()) {
			
			System.out.println(en.nextElement());
		}
	}
}

//employee table in db
class Employee{
	String name;
	double salary;
}