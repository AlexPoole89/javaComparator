package quiz4people;

import java.util.Comparator;

class InvalidArgumentException extends Exception {

    InvalidArgumentException(String message) {
        super(message);
    }
}

//interface
interface Printable {

    public void print(); // display ALL fields of this class
}

//abstract class
abstract class Person implements Printable, Comparable<Person> {

    String name; // 2 or more characters
    int age; // 0-150

    Person(String name, int age) throws InvalidArgumentException {
        setName(name);
        setAge(age);
    }

    public final void setName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name length must be greater than 2");
        }
        this.name = name;
    }

    public final void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0-150");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //comparator by age
    @Override
    public int compareTo(Person compareAge) {
        return this.age - compareAge.age;
    }

    //comparable by name
    public static Comparator<Person> PersonCompareByName
            = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2) {
            String name1 = person1.name;
            String name2 = person2.name;

            return name1.compareTo(name2);
        }
    };
}
