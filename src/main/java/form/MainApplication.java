package form;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/form/form.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/form/form.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();

        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWN, event -> controller.loadInfo());
        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, event -> controller.saveInfo());
        primaryStage.setTitle("Gardeners");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
