package Trees.FamilyTree;

import java.util.Date;

public class Person implements FamilyAble {

    private String name;
    private Date birthDay;
    private boolean isAlive;
    private String gender;

    public Person(String name, Date birthDay, boolean isAlive, String gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.isAlive = isAlive;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", isAlive=" + isAlive +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Person)) return false;
        Person otherPerson = (Person) other;
        return otherPerson.name.equals(this.name);
    }

}
