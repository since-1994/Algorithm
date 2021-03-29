import java.io.*;
import java.util.*;

class Base {
    public String getName() {
        return "hello";
    }

    public void printName() {
        System.out.print(getName());
    }
}

class Derived extends Base {
    @Override
    public String getName() {
        return "hi";
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Base base = new Derived();
        Derived derived = new Derived();

        base.printName();
        derived.printName();
    }

}
