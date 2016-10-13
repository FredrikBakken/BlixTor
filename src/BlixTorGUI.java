import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BlixTorGUI extends Application {
	
	private static String torrentFile = "";
	private static String downloadLocation = "";
	
	private static int downloadRate = 0;
	private static int uploadRate = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;

		// Create a scene
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border, 480, 300);
		window.setScene(scene);

		window.show();
	}
}
