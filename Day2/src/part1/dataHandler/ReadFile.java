package part1.dataHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entities.Address;
import entities.Classes;
import entities.Gender;
import entities.Student;

class DataProcessor<T> {
    
	private List<T> dataList;

    public DataProcessor() {
        dataList = new ArrayList<>();
    }

    public void addData(T data) {
        dataList.add(data);
    }

    public List<T> getDataList() {
        return dataList;
    }

    // Example method to add multiple elements at once
    public void addAllData(Collection<? extends T> dataCollection) {
        dataList.addAll(dataCollection);
    }
}

public class ReadFile extends Thread{

	private String filename;
	
	private List<Student> studentData;
	private List<Address> addressData;
	private List<Classes> classData;
	
    public ReadFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
    	
    	
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(","); 
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        String[] filenames = {
        		"C:\\\\Users\\\\Tushar Patidar\\\\OneDrive\\\\Desktop\\\\Innogent\\\\Day2 - part1\\\\Student.csv",
        		"C:\\\\Users\\\\Tushar Patidar\\\\OneDrive\\\\Desktop\\\\Innogent\\\\Day2 - part1\\\\Class.csv",
        		"C:\\\\Users\\\\Tushar Patidar\\\\OneDrive\\\\Desktop\\\\Innogent\\\\Day2 - part1\\\\Address.csv"
        };
        long startTime = System.currentTimeMillis();
        for (String filename : filenames) {
            new ReadFile(filename).start();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("file reading time : "+(endTime-startTime));
    }
    
    private interface CollectionType<T> {
        int getNumFields();
        T createObject(String[] parts);
       
    }

    // Implementation of CollectionType for Student
    private class StudentCollectionType implements CollectionType<Student> {
        
    	@Override
        public int getNumFields() {
            return 7; // Assuming two fields for Student (Name, ID)
        }

        @Override
        public Student createObject(String[] parts) {
            String student_name = parts[0].trim();
            int student_id = Integer.parseInt(parts[1].trim());
            int class_id = Integer.parseInt(parts[2]);
            int marks = Integer.parseInt(parts[3]);
            Gender gender = (parts[4].equalsIgnoreCase("m")) ? Gender.M:Gender.F;
            int age = Integer.parseInt(parts[5]);
            String resultStatus = parts[6]; 
            return new Student( student_id,  student_name,  class_id,  marks,  gender,  age,
        			 resultStatus);
        }

        
    }

    // Implementation of CollectionType for Class
    private class ClassCollectionType implements CollectionType<Classes> {
        @Override
        public int getNumFields() {
            return 2; // Assuming two fields for Class (Name, Code)
        }

        @Override
        public Classes createObject(String[] parts) {
            String name = parts[0].trim();
            String code = parts[1].trim();
            return new Classes();
        }

      
    }

    // Implementation of CollectionType for Address
//    private class AddressCollectionType implements CollectionType<Address> {
//        @Override
//        public int getNumFields() {
//            return 4; // Assuming four fields for Address (ID, Street, City, Country)
//        }
//
//        @Override
//        public Address createObject(String[] parts) {
//            String id = parts[0].trim();
//            String street = parts[1].trim();
//            String city = parts[2].trim();
//            String country = parts[3].trim();
//            return new Address(street, city, country);
//        }
//
//        @Override
//        public void addToCollection(Address address) {
//            addressMap.put(address.getId(), address);
//        }
//    }
    
}
