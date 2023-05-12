package music_store.musicstore;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class MusicStoreApp extends Application {

    private final ObservableList<CD> cds = FXCollections.observableArrayList(
            new CD("Michael Jackson", "Thriller", 1982, 10.99),
            new CD("The Beatles", "Abbey Road", 1969, 9.99),
            new CD("Pink Floyd", "The Wall", 1979, 12.99),
            new CD("Jorma Uotila", "SuperbongWall", 1679, 121.30)
    );
    private final ObservableList<Record> records = FXCollections.observableArrayList(
            new Record("Led Zeppelin", "IV", 1971, 19.99),
            new Record("Fleetwood Mac", "Rumours", 1977, 17.99),
            new Record("Prince", "Purple Rain", 1984, 14.99)
    );
    private final ObservableList<Item> cart = FXCollections.observableArrayList();
    private final File file = new File("data.txt");


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Music Store");

        // Set up UI elements
        Label titleLabel = new Label("Music Store");

        Label cdLabel = new Label("CDs");
        ListView<CD> cdListView = new ListView<>(cds);

        Label recordLabel = new Label("Records");
        ListView<Record> recordListView = new ListView<>(records);

        Label cartLabel = new Label("Cart");
        ListView<Item> cartListView = new ListView<>(cart);

        Label totalLabel = new Label("Total: €0.00");

        TextField searchField = new TextField();
        searchField.setPromptText("Search");

        Button searchButton = new Button("Search");

        Button addCdButton = new Button("Add CD to Cart");
        addCdButton.setOnAction(event -> {
            CD selectedCd = cdListView.getSelectionModel().getSelectedItem();
            if (selectedCd != null) {
                cart.add(selectedCd);
            }
        });

        Button removeCdButton = new Button("Remove CD from Cart");
        removeCdButton.setOnAction(event -> {
            Item selectedItem = cartListView.getSelectionModel().getSelectedItem();
            if (selectedItem instanceof CD) {
                cart.remove(selectedItem);
            }
        });

        Button addRecordButton = new Button("Add Record to Cart");
        addRecordButton.setOnAction(event -> {
            Record selectedRecord = recordListView.getSelectionModel().getSelectedItem();
            if (selectedRecord != null) {
                cart.add(selectedRecord);
            }
        });

        Button removeRecordButton = new Button("Remove Record from Cart");
        removeRecordButton.setOnAction(event -> {
            Item selectedItem = cartListView.getSelectionModel().getSelectedItem();
            if (selectedItem instanceof Record) {
                cart.remove(selectedItem);
            }
        });

        Button checkoutButton = new Button("Checkout");
        checkoutButton.setOnAction(event -> {
            double total = cart.stream().mapToDouble(Item::getPrice).sum();
            totalLabel.setText("Total: $" + String.format("%.2f", total));
        });

        TextField artistField;
        artistField = new TextField();
        artistField.setPromptText("Artist");

        TextField titleField = new TextField();
        titleField.setPromptText("Title");

        TextField yearField = new TextField();
        yearField.setPromptText("Year");

        TextField priceField;
        priceField = new TextField();
        priceField.setPromptText("Price");

        Button addNewCdButton = new Button("Add CD");
        addNewCdButton.setOnAction(event -> {
            String artist = artistField.getText();
            String title = titleField.getText();
            int year = Integer.parseInt(yearField.getText());
            double price = Double.parseDouble(priceField.getText());
            cds.add(new CD(artist, title, year, price));
            saveDataToFile();
        });

        TextField artistField2 = new TextField();
        artistField2.setPromptText("Artist");

        TextField titleField2 = new TextField();
        titleField2.setPromptText("Title");

        TextField yearField2 = new TextField();
        yearField2.setPromptText("Year");

        TextField priceField2 = new TextField();
        priceField2.setPromptText("Price");

        Button addNewRecordButton = new Button("Add Record");
        addNewRecordButton.setOnAction(event -> {
            String artist = artistField2.getText();
            String title = titleField2.getText();
            int year = Integer.parseInt(yearField2.getText());
            double price = Double.parseDouble(priceField2.getText());
            records.add(new Record(artist, title, year, price));
            saveDataToFile();
        });

/*        private void loadDataFromFile() {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    String artist = parts[0];
                    String title = parts[0];
                    int year = Integer.parseInt(parts[1]);
                    double price = Double.parseDouble(parts[2]);
                    records.add(new Record(artist, title, year, price));
                    cds.add(new CD(artist, title, year, price));
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Inventory file not found.");
            }
        }
*/




        // Set up layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        HBox searchBox = new HBox(searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER_RIGHT);

        HBox addCdBox = new HBox(artistField, titleField, yearField, priceField, addNewCdButton);
        addCdBox.setSpacing(10);
        addCdBox.setAlignment(Pos.CENTER);

        VBox cdBox = new VBox(cdLabel, cdListView, addCdButton, addCdBox);
        cdBox.setSpacing(10);
        cdBox.setAlignment(Pos.CENTER);

        HBox addRecordBox = new HBox(artistField2, titleField2, yearField2, priceField2, addNewRecordButton);
        addRecordBox.setSpacing(10);
        addRecordBox.setAlignment(Pos.CENTER);

        VBox recordBox = new VBox(recordLabel, recordListView, addRecordButton, addRecordBox);
        recordBox.setSpacing(10);
        recordBox.setAlignment(Pos.CENTER);

        VBox cartBox = new VBox(cartLabel, cartListView, removeCdButton, removeRecordButton, checkoutButton, totalLabel);
        cartBox.setSpacing(10);
        cartBox.setAlignment(Pos.CENTER);

        gridPane.add(titleLabel, 0, 0);
        gridPane.add(searchBox, 0, 1);
        gridPane.add(cdBox, 0, 2);
        gridPane.add(recordBox, 0, 3);
        gridPane.add(cartBox, 1, 2, 1, 2);

        // Set up scene
        Scene scene = new Scene(gridPane, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void saveDataToFile() {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (CD cd : cds) {
                writer.write(String.format("%s,%d,%.2f\n", cd.getArtist(), cd.getYear(), cd.getPrice()));
            }
            for (Record record : records) {
                writer.write(String.format("%s,%d,%.2f\n", record.getArtist(), record.getYear(), record.getPrice()));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




/*    private void saveData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
            for (CD cd : cds) {
                writer.write(String.format("%s,%d,%.2f\n", cd.getArtist(), cd.getYear(), cd.getPrice()));
            }
            for (Record record : records) {
                writer.write(String.format("%s,%d,%.2f\n", record.getArtist(), record.getYear(), record.getPrice()));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    public static void main(String[] args) {
        launch(args);
    }


    private abstract static class Item {
        private final String artist;
        private final String album;
        private final int year;
        private final double price;

        public Item(String artist, String album, int year, double price) {
            this.artist = artist;
            this.album = album;
            this.year = year;
            this.price = price;
        }

        public String getArtist() {
            return artist;
        }

        public String getAlbum() {
            return album;
        }

        public int getYear() {
            return year;
        }

        public double getPrice() {
            return price;
        }

        public abstract String getDescription();
    }

    private static class CD extends Item {
        public CD(String artist, String album, int year, double price) {
            super(artist, album, year, price);
        }

        public String getDescription() {
            return getArtist() + " - " + getAlbum() + " (CD)";
        }
    }

    private static class Record extends Item {
        public Record(String artist, String album, int year, double price) {
            super(artist, album, year, price);
        }

        public String getDescription() {
            return getArtist() + " - " + getAlbum() + " (Record)";

        }
    }
}
