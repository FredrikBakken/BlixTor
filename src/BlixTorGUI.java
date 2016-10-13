import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BlixTorGUI extends Application {

	private static String torrentFile = "";
	private static String downloadLocation = "";

	private static int downloadRate = 0;
	private static int uploadRate = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		window.setTitle("BlixTor Client");

		Button browse = new Button("Browse...");

		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);

		String torrentFile;
		if (selectedFile != null) {
			torrentFile = "File selected: " + selectedFile.toString();
		} else {
			torrentFile = "File selection cancelled.";
		}

		System.out.println(torrentFile);

		// Create a scene
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border, 480, 300);
		window.setScene(scene);

		window.show();
	}
}
