import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application  {
    private final StackPane root = new StackPane();
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        Button button = new Button("OPEN");
        VBox vBox = new VBox();

        vBox.setSpacing(8);
        // v = top
        // v1 = right spacing
        // v2 = bottom spacing
        // v3 = left spacing

        vBox.setPadding(new Insets(100,100,10,100));
        vBox.getChildren().addAll(
                new Label("Your Username"),
                new TextField(),
                new Label("Your Password"),
                new PasswordField(),
                new Button("LOGIN"));
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
        primaryStage.setAlwaysOnTop(true);
    }

}