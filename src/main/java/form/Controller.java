package form;

import entities.containers.Garden;
import entities.containers.KaleYard;
import entities.equipment.Tractor;
import entities.equipment.WaterMachine;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Controller {
    public TextField addPlantSizeField;
    public Label plantLabel;
    public TextField deleteIndexField;
    public TextField changeSizeNumberField;

    private Garden garden = new Garden();
    private KaleYard kailyard = new KaleYard();
    private Tractor tractor = new Tractor();
    private WaterMachine waterMachine = new WaterMachine();


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

}
