package form;

import entities.containers.Garden;
import entities.containers.KaleYard;
import entities.containers.Stock;
import entities.equipment.Sprinkler;
import entities.equipment.Tractor;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Controller {
    public TextField sprinklerNameField;
    public TextField sprinklerCapacityField;
    public TextField sprinklerBalanceField;
    public TextField sprinklerPressureField;

    private Garden garden = new Garden();
    private KaleYard kaleYard = new KaleYard();
    private Tractor tractor = new Tractor();
    private Sprinkler sprinkler = new Sprinkler();
    private Stock stock = new Stock();


    public void addTree(ActionEvent actionEvent) {
        /*garden
        updateInfo();*/
    }

    public void addVegetable(ActionEvent actionEvent) {
        //farm.garden.addPlant(new Crop(Integer.parseInt(addPlantSizeField.getText())));
        updateInfo();
    }

    private void updateInfo() {

    }
    private int getIntFromField(TextField textField) {
        return Integer.parseInt(textField.getText());
    }
    private File chooseSaveFile() {
        return new FileChooser().showSaveDialog(null);
    }
    private File chooseOpenFile() {
        return new FileChooser().showOpenDialog(null);
    }

    public void changeTree(ActionEvent actionEvent) {

    }

    public void removeTree(ActionEvent actionEvent) {

    }

    public void removeVegetable(ActionEvent actionEvent) {

    }

    public void updateSprinklerButtonClicked(ActionEvent actionEvent) {
        try {
            String newName = sprinklerNameField.getText();
            double newCapacity = Double.parseDouble(sprinklerCapacityField.getText());
            double newPressure = Double.parseDouble(sprinklerPressureField.getText());
            double newBalance = Double.parseDouble(sprinklerBalanceField.getText());

            sprinkler.setName(newName);
            sprinkler.setCapacity(newCapacity);
            sprinkler.setPressure(newPressure);
            sprinkler.setWaterBalance(newBalance);
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Введены неверные данные").showAndWait()
                    .filter(response -> response == ButtonType.OK);
        }
    }
}
