package lab4.playlist;

public class ItemObject {
    String Title;
    String Year;
    String Artist;
    String Country;
    String Company;
    String Sold;
    int Price;

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title){
        this.Title = title;
    }
    public String getYear() {
        return Year;
    }
    public void setYear(String year) {
        this.Year = year;
    }
    public String getArtist() {
        return Artist;
    }
    public void setArtist(String artist) {
        this.Artist = artist;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        this.Country = country;
    }
    public String getCompany() {
        return Company;
    }
    public void setCompany(String company){
        this.Company = company;
    }
    public String getSold() {
        return Sold;
    }
    public void setSold(String sold){
        this.Sold = sold;
    }
    public int getPrice() {
        return Price;
    }
    public void setPrice(int price) {
        Price = price;
    }
    public ItemObject (String songTitle, String songYear, String songArtist){
        this.Title = songTitle;
        this.Year = songYear;
        this.Artist = songArtist;
    }
}
