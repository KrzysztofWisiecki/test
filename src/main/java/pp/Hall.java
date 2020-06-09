package pp;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.io.*;

public class Hall extends Pane {
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private String hallNumber;
    private int[][] tableOfSeats;
    private DrawSeat[][] tableOfRectSeats;
    private SpinnerValueFactory<Integer> valueFactory;
    private Button reservationBtn;
    private Button cancelReservationBtn;
    private Label rowLabel = new Label("Rzad: ");
    private Label seatLabel = new Label("Miejsce: ");
    private Label movieTitle;
    private Label infoLabel;

    public Hall(String title) {
        file = new File(title + ".txt");
        movieTitle = new Label(title);
        tableOfSeats = new int[10][14];
        tableOfRectSeats = new DrawSeat[10][14];
        for (int[] x : tableOfSeats) {
            for (int y : x) {
                y = 0;
            }
        }
        setPrefSize(378, 450);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                int tmp_i = i;
                int tmp_j = j;
                DrawSeat ds = new DrawSeat();
                ds.setWidth(18);
                ds.setHeight(18);
                ds.setStroke(Color.BLACK);
                ds.setStrokeWidth(1);
                if (getElementTableOfSeats(i, j) == 0) {
                    ds.setFill(Color.LIMEGREEN);

                } else {
                    ds.setReservated(true);
                    ds.setFill(Color.RED);
                }
                ds.setLayoutX((j) * 25 + (j * 3));
                ds.setLayoutY((i) * 25 + (i * 3) + 50);
                tableOfRectSeats[i][j] = ds;

                getChildren().add(tableOfRectSeats[i][j]);
                tableOfRectSeats[i][j].setCursor(Cursor.HAND);
                tableOfRectSeats[i][j].setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        if (ds.isReservated == false) {
                            if (ds.isClicked == false) {
                                ds.setFill(Color.ORANGE);
                                ds.setClicked(true);

                            } else if (ds.isClicked == true) {
                                ds.setFill(Color.LIMEGREEN);
                                ds.setClicked(false);
                            }
                        } else {
                            if (ds.reservatedIsClicked == false) {
                                ds.setFill(Color.DEEPSKYBLUE);
                                ds.setReservatedIsClicked(true);

                            } else if (ds.isReservatedIsClicked() == true) {
                                ds.setFill(Color.RED);
                                ds.setReservatedIsClicked(false);
                            }
                            // JOptionPane.showMessageDialog(null, "To miejsce jest zarezerwowane");
                        }
                    }
                });
                tableOfRectSeats[i][j].setOnMouseMoved(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        rowLabel.setText("Rzad: " + String.valueOf(tmp_i + 1));
                        seatLabel.setText("Miejsce: " + String.valueOf(tmp_j + 1));
                    }
                });
            }
        }

        reservationBtn = new Button("Zarezerwuj");
        reservationBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                secondReservation();
                try {
                    exportTable();
                } catch (IOException e) {
                    System.out.println("błąd exportu");
                    e.printStackTrace();
                }
                //getElementTableOfRectSeats(rowNumSpin.getValue() - 1, seatNumSpin.getValue() - 1).setFill(Color.RED);
            }
        });
        reservationBtn.setLayoutX(230);
        reservationBtn.setLayoutY(420);
        reservationBtn.setScaleX(1.5);
        reservationBtn.setScaleY(1.5);

        cancelReservationBtn = new Button("Anuluj rezerwacje");
        cancelReservationBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                secondCancelReservation();
                try {
                    exportTable();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "exportblad");
                    e.printStackTrace();
                }
                //getElementTableOfRectSeats(rowNumSpin.getValue() - 1, seatNumSpin.getValue() - 1).setFill(Color.GREEN);
            }
        });

        cancelReservationBtn.setLayoutX(60);
        cancelReservationBtn.setLayoutY(420);
        cancelReservationBtn.setScaleX(1.5);
        cancelReservationBtn.setScaleY(1.5);

        rowLabel.setLayoutY(345);
        seatLabel.setLayoutY(375);

        movieTitle.setAlignment(Pos.CENTER);
        movieTitle.setMinWidth(378);
        movieTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        infoLabel = new Label("");
        infoLabel.setMaxWidth(250);
        infoLabel.setWrapText(true);
        infoLabel.setLayoutY(-10);
        infoLabel.setLayoutX(400);
        infoLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        getChildren().addAll(
                rowLabel,
                seatLabel,
                cancelReservationBtn,
                reservationBtn,
                infoLabel,
                movieTitle);

    }

    public Rectangle[][] getTableOfRectSeats() {
        return tableOfRectSeats;
    }

    public DrawSeat getElementTableOfRectSeats(int i, int j) {
        return tableOfRectSeats[i][j];
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int[][] getTableOfSeats() {
        return tableOfSeats;
    }

    public int getElementTableOfSeats(int i, int j) {
        return tableOfSeats[i][j];
    }


    public void setTableOfSeats(int row, int seat, int x) {
        if (x != 0 || x != 1)
            this.tableOfSeats[row][seat] = x;
    }

    public void reservation(int row, int seat) {
        if (getTableOfSeats()[row][seat] == 0) {
            setTableOfSeats(row, seat, 1);
            infoLabel.setText("Zarezerwowano:\nmiejsce " + (seat + 1) + " rzad " + (row + 1));
            getElementTableOfRectSeats(row, seat).setFill(Color.RED);
            getElementTableOfRectSeats(row, seat).setReservated(true);
            getElementTableOfRectSeats(row, seat).setClicked(false);
        } else {
            infoLabel.setText("Wybrane miejsce jest już zarezerwowane!");
        }
    }

    public void secondReservation() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                if (getElementTableOfRectSeats(i, j).isClicked()) {
                    reservation(i, j);
                }
            }
        }
    }

    public void cancelReservation(int row, int seat) {

        if (getTableOfSeats()[row][seat] == 1) {
            setTableOfSeats(row, seat, 0);
            infoLabel.setText("Anulowano rezerwacje");
            getElementTableOfRectSeats(row, seat).setFill(Color.LIMEGREEN);
            getElementTableOfRectSeats(row, seat).setReservated(false);
        } else {
            infoLabel.setText("Wybrane miejsce nie jest zarezerwowane!");
        }
    }

    public void secondCancelReservation() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                if (getElementTableOfRectSeats(i, j).isReservatedIsClicked() == true) {
                    cancelReservation(i, j);
                    getElementTableOfRectSeats(i, j).setReservatedIsClicked(false);
                }
            }
        }
    }

    public void importTable() throws IOException {
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        String[] s;
        for (int i = 0; i < 10; i++) {
            s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 14; j++) {
                tableOfSeats[i][j] = Integer.parseInt(s[j]);
            }
        }
        bufferedReader.close();
        fileReader.close();
        paintRectAfterImport();
    }

    public void exportTable() throws IOException {
        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                bufferedWriter.write(String.valueOf(tableOfSeats[i][j]) + " ");
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public void paintRectAfterImport() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                if (getElementTableOfSeats(i, j) == 1) {
                    getElementTableOfRectSeats(i, j).setReservated(true);
                    getElementTableOfRectSeats(i, j).setFill(Color.RED);
                }
            }
        }
    }
}