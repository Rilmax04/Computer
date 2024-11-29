package by.kurilo.computer.user;

import by.kurilo.computer.computer.Computer;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void useComputer(Computer comp) {
        System.out.println(name + " is using the computer.");
        comp.boot();
    }
}
