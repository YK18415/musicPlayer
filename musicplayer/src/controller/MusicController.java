package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Song;

public class MusicController {
	
	 public static final String Column1MapKey = "A";
	private static final String NOT_FOUND = "Nichts gefunden";
	private String s; 
	private List<Song> playlist = new LinkedList<Song>();
	private Desktop desktop = Desktop.getDesktop();
	private String path;
	
	@FXML
	ListView<String> listViewData;
	@FXML
	ListView<String> listViewDataSearch;
	@FXML
	TextField txtSearch;
	@FXML
	TextField txtDataPath;
	@FXML
	TableView<String> table;
	@FXML
	TableColumn<String, String> listViewData2;
	
	@FXML
	public void handleFileChooser() throws IOException {
		table.setEditable(true);
		
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Open File");
	    File file = chooser.showOpenDialog(new Stage());
	    s = file.getName();
	    addToListViewAndToPlaylist(s);
	    
	 // Pfad:
	    path = file.getAbsolutePath();
	    txtDataPath.setText(path);
	
	    TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
	    final ObservableList<String> data = FXCollections.observableArrayList("Ich");
	    table.setItems(data);
	    
	    openFile(file);
	}
	
	public void handleSearchData() {
		String tofind = txtSearch.getText();
		
		for (Song song : playlist) {
			if(song.getTitle().equals(tofind)) {
				listViewDataSearch.getItems().add(tofind);
			} else {
				listViewDataSearch.getItems().add(NOT_FOUND);
			}
		}
	}
	
	@FXML
	public void handlePlaySelectedItem() {
		
		try {
			//String selectedItem = listViewData.getSelectionModel().getSelectedItem();
			
			
			File file = new File(path);
			openFile(file);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(NOT_FOUND);
			alert.showAndWait();
		}
	}

	private void addToListViewAndToPlaylist(String song) {
		table.getItems().add(song);// listViewData2.getItems().add(song);
		Song newSong = new Song(song, "Kira", 2015);
		playlist.add(newSong);
	}
	
	private void openFile(File file) throws IOException {
            desktop.open(file);
    }
}
