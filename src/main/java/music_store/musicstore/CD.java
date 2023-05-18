package music_store.musicstore;

public class CD extends Item {
    /**
     * Parameters for CD Item
     * @param artist String for artist
     * @param album String for album title
     * @param year Int for year
     * @param price Int for price
     */
    public CD(String artist, String album, int year, int price) {
        super(artist, album, year, price);
    }

    public String getDescription() {
        return getArtist() + " - " + getAlbum() + " (CD)";
    }

    /**
     * Overrides strings toStrings from application so application UI won't show default package name
     * @return String
     */
    @Override
    public String toString() {
        return getArtist() + " " + getAlbum();
    }
}
