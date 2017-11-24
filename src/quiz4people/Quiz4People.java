package quiz4people;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz4People {
    
    //file and ArrayList
    static ArrayList<Person> people = new ArrayList<>();
    static final String FILE_NAME = "input.txt";
      
    public static void main(String[] args) throws FileNotFoundException {
    // 1. Parse file and add to geoList
    try (Scanner fileInput = new Scanner(new File(FILE_NAME))){
        while(fileInput.hasNextLine()){
            try {
                String line = fileInput.nextLine();
                System.out.println("Processing line: " + line);
                String[] data = line.split(";");
                
                if(data.length < 5) {
                    System.out.println("Warning: Invalid number of data in line: "+ line);
                    continue;
                }
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                
                switch(data[0]) {
                    case "Teacher": {
                        if(data.length < 5) {
                            System.out.println("Warning: Invalid number of data in line" + line);
                            continue;
                        }
                        String subject = data[3];
                        int yearsExp = Integer.parseInt(data[4]);
                        people.add(new Teacher(name, age, subject, yearsExp));
                    }
                    break;
                    case "Student": {
                        if (data.length < 5) {
                            System.out.println("Warning: Invalid number of data in line" + line);
                            continue;
                        }
                        String program = data[3];
                        String gpaStr = data[4];
                        BigDecimal gpa = new BigDecimal(gpaStr);
                        people.add(new Student(name,age,program,gpa));                        
                    }
                    break;
                    default:
                        System.out.println("Warning invalid data in line " + line);
                } // switch case ended
            } catch (NumberFormatException | InvalidArgumentException e){
                System.out.println("Warning: invalid data: " + e.getMessage());
            }
        } //loop ended
    } catch (IOException e){
        System.err.println("Error reading file");
    } 
    
    // print out ArrayList
        System.out.println("============");
        for(Person p : people) {
            p.print();
            System.out.println();
        }
        
        
        //Sort ArrayList by Age
        Collections.sort(people);
        System.out.println("======== AFTER SORTING BY AGE ========");
        for(Person p : people) {
            p.print();
            System.out.println();
        }
        
        
        //Sort ArrayList by name
        Collections.sort(people, Person.PersonCompareByName);
        System.out.println("======== AFTER SORTING BY NAME =========");
         for(Person p : people) {
            p.print();
            System.out.println();
        }
}

}
