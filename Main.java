package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.io.File;
import java.net.MalformedURLException;


public class Main extends Application {
	
	Player player;
	FileChooser fileChooser;
	public void start(final Stage primaryStage) {
		
		MenuItem open = new MenuItem("Open");
		Menu file = new Menu("File");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		fileChooser = new FileChooser();
		
		open.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				//if (player != null && player.player != null){	//my code as getting null pointer exception.
				if (player.player != null){
					player.player.pause();
					File file = fileChooser.showOpenDialog(primaryStage);
					if(file != null){
						try {
							player = new Player(file.toURI().toURL().toExternalForm());
							Scene scene = new Scene(player, 1680, 920, Color.BLACK);
							primaryStage.setScene(scene);
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		File myFile = new File("C:/Users/Adam/Videos/Overwatch/Overwatch 02.05.2017 - 13.04.41.01.mp4");
		String source = myFile.toURI().toString();
		
		player = new Player(source);
		player.setTop(menu);
		Scene scene = new Scene(player, 1680, 920, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
