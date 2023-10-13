package multithreading.transient_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientExample {
    public static void main(String[] args) {
        // Serialization
        try {
            Person person = new Person("Alice", 30);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.txt"));
            out.writeObject(person);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // Deserialization
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.txt"));
            Person restoredPerson = (Person) in.readObject();
            in.close();

            restoredPerson.display(); // Age will be 0 because it's transient
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}