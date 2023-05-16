package music_store.musicstore;

public class CD extends Item {
    public CD(String artist, String album, int year, int price) {
        super(artist, album, year, price);
    }

    public String getDescription() {
        return getArtist() + " - " + getAlbum() + " (CD)";
    }

    @Override
    public String toString() {
        return getArtist() + " " + getAlbum();
    }
}
