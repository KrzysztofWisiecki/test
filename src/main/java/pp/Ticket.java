package pp;

import java.math.BigDecimal;

public class Ticket {
    private BigDecimal price;
    private String movieTitle;
    private String hallNumber;
    private String rowNumber;
    private String seatNumber;

    public Ticket(BigDecimal price, String movieTitle, String hallNumber, String rowNumber, String seatNumber) {
        this.price = price;
        this.movieTitle = movieTitle;
        this.hallNumber = hallNumber;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber = hallNumber;
    }


    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
