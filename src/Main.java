import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application  {
    private final StackPane root = new StackPane();
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        // inputs
        Label username_inp = new Label("Your Username");
        username_inp.setFont(new Font("Arial", 24));
        Label password_inp = new Label("Your Password");
        password_inp.setFont(new Font("Arial", 24));

        // make button
        Button button = new Button("LOGIN");
        button.setFont(new Font("Arial", 18));
        // make vbox
        VBox vBox = new VBox();

        // spacing between children
        vBox.setSpacing(8);

        // v = top
        // v1 = right spacing
        // v2 = bottom spacing
        // v3 = left spacing
        vBox.setPadding(new Insets(100,100,10,100));
        vBox.getChildren().addAll(
                // username label and input
                username_inp, new TextField(),
                // password label and input
                password_inp, new PasswordField(),
                // button sign in
                button);
        root.getChildren().addAll(vBox);


        button.setOnAction(actionEvent-> {
            if(stage!=null){
                stage.requestFocus();
                return;
            }
            stage = new Stage();
            StackPane stackPane = new StackPane();
            stage.setScene(new Scene(stackPane, 200,200));
            stage.show();
        });

    }

    @Override
    public void start(Stage primaryStage) {
        // v = width
        // v1 = height
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Sign In");
        // if I want it to run in the background / open in background
        // primaryStage.setAlwaysOnTop(true);
    }

}