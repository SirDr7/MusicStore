package music_store.musicstore;

public class Record extends Item {
    public Record(String artist, String album, int year, int price) {
        super(artist, album, year, price);
    }

    public String getDescription() {
        return getArtist() + " - " + getAlbum() + " (Record)";
    }

    @Override
    public String toString() {
        return getArtist() + " - " + getAlbum();
    }
}
