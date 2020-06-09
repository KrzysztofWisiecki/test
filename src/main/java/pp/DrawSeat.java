package pp;

import javafx.scene.shape.Rectangle;

public class DrawSeat extends Rectangle {
    boolean isReservated;
    boolean isClicked;
    boolean reservatedIsClicked;

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public boolean isReservatedIsClicked() {
        return reservatedIsClicked;
    }

    public void setReservatedIsClicked(boolean reservatedIsClicked) {
        this.reservatedIsClicked = reservatedIsClicked;
    }

    DrawSeat() {
        isReservated = false;
        isClicked = false;
        reservatedIsClicked = false;
    }

    public boolean isReservated() {
        return isReservated;
    }

    public void setReservated(boolean reservated) {
        isReservated = reservated;
    }
}
