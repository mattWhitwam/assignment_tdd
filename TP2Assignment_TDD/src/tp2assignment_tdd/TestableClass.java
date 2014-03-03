/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp2assignment_tdd;

import java.util.Objects;

/**
 *
 * @author Matt
 */
public class TestableClass {
    private String name;
    private int age;
    private double weight;
    private float balance;
    private boolean alive;

    public TestableClass(TestableClass other) {
        name = other.getName();
        age = other.getAge();
        weight = other.getWeight();
        balance = other.getBalance();
        alive = other.isAlive();
    }

    public TestableClass(String name, int age, double weight, float balance, boolean alive) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.balance = balance;
        this.alive = alive;
    }

    public TestableClass() {
        name = "Unset";
        age = 0;
        weight = 0;
        balance = 0;
        alive = false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.age;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 59 * hash + Float.floatToIntBits(this.balance);
        hash = 59 * hash + (this.alive ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestableClass other = (TestableClass) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (Float.floatToIntBits(this.balance) != Float.floatToIntBits(other.balance)) {
            return false;
        }
        if (this.alive != other.alive) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    
}
