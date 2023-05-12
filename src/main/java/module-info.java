module music_store.musicstore {
    requires javafx.controls;
    requires javafx.fxml;


    opens music_store.musicstore to javafx.fxml;
    exports music_store.musicstore;
}