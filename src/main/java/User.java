public class User {
    private String login;
    private String email;
    private String password;
    private int age;

    public User() {
    }

    public User(String login,String email,String password, int age) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
