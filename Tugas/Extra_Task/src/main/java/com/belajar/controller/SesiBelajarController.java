package com.belajar.controller;

import com.belajar.model.SesiBelajar;
import com.belajar.service.RekapBelajar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SesiBelajarController {

    @FXML
    private TextField mataKuliahField;
    @FXML
    private TextField durasiField;
    @FXML
    private DatePicker tanggalPicker;
    @FXML
    private Label totalDurasiLabel;
    @FXML
    private TableView<SesiBelajar> sesiBelajarTable;
    @FXML
    private TableColumn<SesiBelajar, String> mataKuliahColumn;
    @FXML
    private TableColumn<SesiBelajar, Integer> durasiColumn;
    @FXML
    private TableColumn<SesiBelajar, String> tanggalColumn;
    @FXML
    private Button tambahSesiButton;

    private ObservableList<SesiBelajar> daftarSesiBelajar = FXCollections.observableArrayList();
    private RekapBelajar rekapBelajar = new RekapBelajar();

    @FXML
    public void initialize() {
        mataKuliahColumn.setCellValueFactory(new PropertyValueFactory<>("mataKuliah"));
        durasiColumn.setCellValueFactory(new PropertyValueFactory<>("durasi"));
        tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

        sesiBelajarTable.setItems(daftarSesiBelajar);

        sesiBelajarTable.setItems(daftarSesiBelajar);

        updateTotalDurasi();

        tanggalPicker.getEditor().focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (isNowFocused) {
                tanggalPicker.show();
            }
        });
    }

    @FXML
    private void handleTambahSesi() {
        String mataKuliah = mataKuliahField.getText();
        String durasiText = durasiField.getText();
        LocalDate tanggalDate = tanggalPicker.getValue();

        if (mataKuliah.isEmpty() || durasiText.isEmpty() || tanggalDate == null) {
            showAlert(Alert.AlertType.ERROR, "Validasi Input", "Semua kolom harus diisi!");
            return;
        }

        int durasi;
        try {
            durasi = Integer.parseInt(durasiText);
            if (durasi < 0) {
                showAlert(Alert.AlertType.ERROR, "Validasi Input", "Durasi tidak boleh negatif!");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validasi Input", "Durasi harus berupa angka!");
            return;
        }

        String tanggal = tanggalDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        SesiBelajar sesiBaru = new SesiBelajar(mataKuliah, durasi, tanggal);
        daftarSesiBelajar.add(sesiBaru);

        mataKuliahField.clear();
        durasiField.clear();
        tanggalPicker.setValue(null);
        updateTotalDurasi();
        sesiBelajarTable.refresh();
    }

    private void updateTotalDurasi() {
        int total = rekapBelajar.hitungTotalDurasi(daftarSesiBelajar);
        totalDurasiLabel.setText("Total Durasi Belajar: " + total + " menit");
    }

    private boolean isValidDate(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}