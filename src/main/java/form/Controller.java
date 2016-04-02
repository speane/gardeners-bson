package form;

import entities.Farm;
import entities.containers.Garden;
import entities.containers.Kailyard;
import entities.equipment.Tractor;
import entities.equipment.WaterMachine;
import entities.plants.Crop;
import entities.plants.Plant;
import entities.plants.Tree;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import serialization.Serializable;
import serialization.serializers.BSONSerializer;
import serialization.serializers.SerializerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Controller {
    public TextField addPlantSizeField;
    public Label plantLabel;
    public TextField deleteIndexField;
    public TextField changeSizeNumberField;

    private Garden garden = new Garden();
    private Kailyard kailyard = new Kailyard();
    private Tractor tractor = new Tractor();
    private WaterMachine waterMachine = new WaterMachine();


    public void addTree(ActionEvent actionEvent) {
        garden
        updateInfo();
    }

    public void addVegetable(ActionEvent actionEvent) {
        farm.garden.addPlant(new Crop(Integer.parseInt(addPlantSizeField.getText())));
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
