package sample;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_Field;

    @FXML
    private PasswordField password_Field;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button LoginSignUpButon;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(event -> {
            String loginText = login_Field.getText().trim();
            String loginPassword = password_Field.getText().trim();
            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser (loginText, loginPassword);
            else System.out.println("Please Enter Credentials");
        });


        LoginSignUpButon.setOnAction(event -> {
            LoginSignUpButon.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/signUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

    private void loginUser(String loginText, String loginPassword) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1){
            System.out.println("Success");
        }
    }
}
