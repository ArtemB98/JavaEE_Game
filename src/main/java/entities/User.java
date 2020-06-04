package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private String magic_val;
    private List<String> myValues;
    private List<String> myResults;
    private boolean isWin;
    private int count;

    public User() {
    }

    public User(String name, String password, String magic_val) {
        this.name = name;
        this.password = password;
        this.magic_val = magic_val;
        this.isWin = false;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getMagicValue() {
        return magic_val;
    }

    public void setMagicValue(String magic_val) {
        this.magic_val = magic_val;
    }

    public List<String> getMyValues() {
        if (myValues == null)
            myValues = new ArrayList<>();
        return myValues;
    }

    public List<String> getMyResults() {
        if (myResults == null)
            myResults = new ArrayList<>();
        return myResults;
    }

    public void addValue(String Value) {
        if (!isWin()) {
            getMyValues().add(Value);
            count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    public boolean isWin() {
        return this.isWin;
    }

    public void setWin() {
        this.isWin = true;
    }

    public void addResult(String Result) {
        if (!isWin()) {
            getMyResults().add(Result);
        }
    }
}