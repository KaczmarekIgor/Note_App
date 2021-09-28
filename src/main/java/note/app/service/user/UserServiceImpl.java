package note.app.service.user;


import note.app.exception.UserExists;
import note.app.form.LoginForm;
import note.app.form.UserRegisterForm;
import note.app.model.User;
import note.app.repository.UserRepo;
import note.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
@Service
public class UserServiceImpl implements UserService {


    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

/*
    @Override
    public void createUser(UserRegisterForm userRegisterForm) {
        if (userRepo
                .existsByName(userRegisterForm.getName())) {
            throw new UserExists(userRegisterForm.getName());
        }
        User user = new User(userRegisterForm.getName(),
               passwordEncoder.encode(userRegisterForm.getPassword()),
                userRegisterForm.getEmail());
        userRepo.save(user);
    }


 */




