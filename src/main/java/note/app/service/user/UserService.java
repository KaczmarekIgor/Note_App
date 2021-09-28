package note.app.service.user;

import note.app.form.LoginForm;
import note.app.form.UserRegisterForm;
import note.app.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    void createUser(User user);

}
