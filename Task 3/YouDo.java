public class Main {

    public static void main(String[] args) {
        User user = new User("john", "john@example.com");

        UserRepository repository = new DatabaseUserRepository();
        EmailValidator validator = new EmailValidator();
        UserService userService = new UserService(repository, validator);

        userService.registerUser(user);
    }
}

class User {
    private final String username;
    private final String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

interface UserRepository {
    void save(User user);
}

class DatabaseUserRepository implements UserRepository {

    @Override
    public void save(User user) {
        System.out.println("Connecting to database...");
        System.out.println(
                "Saving user '" + user.getUsername() + "' to the users table.");
    }
}

class EmailValidator {

    public boolean validate(String email) {
        return email != null && email.contains("@");
    }
}

class UserService {

    private final UserRepository userRepository;
    private final EmailValidator emailValidator;

    public UserService(UserRepository userRepository,
                       EmailValidator emailValidator) {
        this.userRepository = userRepository;
        this.emailValidator = emailValidator;
    }

    public void registerUser(User user) {
        if (!emailValidator.validate(user.getEmail())) {
            System.out.println("Invalid email format.");
            return;
        }

        userRepository.save(user);
        System.out.println("User registered successfully.");
    }
}

