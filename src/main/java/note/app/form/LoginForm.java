package note.app.form;

public class LoginForm {

    private String name;
    private String password;

    public LoginForm(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public LoginForm() {
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
        return "UserLoginDTO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
