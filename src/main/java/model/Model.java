package model;

import entities.User;

import java.util.*;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();
    private double avg = 0;
    private int winUsersCount = 0;
    private double commonCount = 0;
    private Set<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashSet<>();
    }

    public void add(User user) {
        model.add(user);
    }

    public User get(User user1) {
        Iterator<User> iterator = model.iterator();
        while (iterator.hasNext()) {
            User obj = iterator.next();
            if (obj.equals(user1)) {
                return obj;
            }
        }
        return null;
    }

    public double getAvg(int count) {
        this.winUsersCount++;
        this.avg = (count + commonCount) / winUsersCount;
        this.commonCount += count;
        return avg;
    }

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

}