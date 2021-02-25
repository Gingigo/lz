package datastructure.tree.help;

public class Person implements Comparable<Person> {

    int age;

    public Person(int age) {
        this.age = age;
    }

    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return String.valueOf(age);
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
