package multithreading.transient_test;

import java.io.Serializable;

/**
 * In this example, the age field is marked as transient, so it won't be serialized when the Person object is written
 * to a file. When the object is deserialized, the age field will be set to its default value (0 in this case).
 */
class Person implements Serializable {
    private String name;
    private transient int age; // Marked as transient, won't be serialized

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}