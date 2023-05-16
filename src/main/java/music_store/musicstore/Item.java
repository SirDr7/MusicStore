package music_store.musicstore;

public class Item {
    /**
     * Artistin nimi
     */
    private String artist;

    /**
     * Albumin nimi
     */
    private String album;

    /**
     * Vuosiluku kokonaislukuna
     */
    private int year;

    /**
     * Hinta desimaalilukuna
     */
    private int price;

    public Item(String artist, String album, int year, int price) {
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

    public int getPrice() {
        return price;
    }
}
