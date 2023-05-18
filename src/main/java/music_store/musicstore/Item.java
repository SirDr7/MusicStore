package music_store.musicstore;

public class Item {
    /**
     * String artist name
     */
    private String artist;
    /**
     * String album name
     */
    private String album;
    /**
     * Integer for year
     */
    private int year;
    /**
     * Integer for Price
     */
    private int price;

    /**
     * Creates new Item with params
     * @param artist
     * @param album
     * @param year
     * @param price
     */
    public Item(String artist, String album, int year, int price) {
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.price = price;
    }

    /**
     * Returns artist
     * @return String
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns album title
     * @return String
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Returns Year
     * @return Integer
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns Price
     * @return Integer
     */
    public int getPrice() {
        return price;
    }
}
