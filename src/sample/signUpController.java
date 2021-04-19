package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUp_Login;

    @FXML
    private PasswordField SignUp_passw;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField sign_first_name;

    @FXML
    private TextField signUp_second_name;

    @FXML
    private TextField signUp_location;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(event -> {
            signUpNewUser();
        });
    }
    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String firstName = sign_first_name.getText();
        String lastName = signUp_second_name.getText();
        String userName = SignUp_Login.getText();
        String password = SignUp_passw.getText();
        String location = signUp_location.getText();
        String gender = "";
        if (signUpCheckBoxMale.isSelected())
            gender = "Male";
        else
            gender = "Female";

        User user = new User(firstName, lastName, userName, password, location, gender);
        dbHandler.signUpUser(user);
    }
}
