import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BlixTorGUI extends Application {
	private static BlixTorDownload blixTorDownload = new BlixTorDownload();

	private static TextField browseTorrentText;
	private static Button browseTorrent;
	private static TextField selectedDownloadText;
	private static Button browseDownload;
	
	private static Button startDownload;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		window.setTitle("BlixTor Client");

		selectTorrent(window);

		selectDownloadLocation(window);
		
		startTorrentDownload(window);

		BorderPane border = new BorderPane();

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(browseTorrentText, browseTorrent, selectedDownloadText, browseDownload, startDownload);

		border.setTop(layout);

		Scene scene = new Scene(border, 480, 300);
		window.setScene(scene);

		window.show();
	}

	public void selectTorrent(Stage primaryStage) throws Exception {
		browseTorrentText = new TextField("No select torrent file...");

		browseTorrent = new Button("Browse...");
		browseTorrent.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
				File selectedFile = fileChooser.showOpenDialog(null);

				if (selectedFile != null) {
					blixTorDownload.browseTorrentFile = selectedFile.toString();
					browseTorrentText.setText(blixTorDownload.browseTorrentFile);
				} else {
					blixTorDownload.browseTorrentFile = "File selection cancelled.";
				}
			}
		});
	}

	public void selectDownloadLocation(Stage primaryStage) throws Exception {
		selectedDownloadText = new TextField("No selected download location...");

		browseDownload = new Button("Browse...");
		browseDownload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DirectoryChooser directoryChooser = new DirectoryChooser();
				File file = directoryChooser.showDialog(null);
				if(file!=null) {
					blixTorDownload.downloadLocation = file.getAbsolutePath();
					
					selectedDownloadText.setText(blixTorDownload.downloadLocation);
				}
			}
		});
	}
	
	public void startTorrentDownload(Stage primaryStage) throws Exception {
		startDownload = new Button("Start Download");
		
		startDownload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(!blixTorDownload.browseTorrentFile.equals("") && !blixTorDownload.downloadLocation.equals("")) {
					try {
						blixTorDownload.DownloadTorrent();
					} catch (NoSuchAlgorithmException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
}
