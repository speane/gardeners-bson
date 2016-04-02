package form;

import entities.Farm;
import entities.plants.Crop;
import entities.plants.Plant;
import entities.plants.Tree;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
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
    public Label gardenSizeLabel;
    public Label stockSizeLabel;
    public TextField changeSizeField;
    public TextField saveIndexField;
    private Farm farm;

    //private BSONSerializer serializer = new BSONSerializer();

    public Controller() {
        farm = new Farm();
    }

    public void addTree(ActionEvent actionEvent) {
        farm.garden.addPlant(new Tree(Integer.parseInt(addPlantSizeField.getText())));
        updateInfo();
    }

    public void addCrop(ActionEvent actionEvent) {
        farm.garden.addPlant(new Crop(Integer.parseInt(addPlantSizeField.getText())));
        updateInfo();
    }

    private void updateInfo() {
        updateFarmSizesInfo();
        updatePlants();
    }

    private void updateFarmSizesInfo() {
        gardenSizeLabel.setText(String.valueOf(farm.garden.getPlants().size()));
    }

    private void updatePlants() {
        String plantLine = "";
        for (Plant plant : farm.garden.getPlants()) {
            plantLine += "[" + plant.getName() + "(" + plant.getSize() + ")]";
        }
        plantLabel.setText(plantLine);
    }

    public void changePlantSize(ActionEvent actionEvent) {
        farm.garden.setPlantSizeAtIndex(Integer.parseInt(changeSizeNumberField.getText()),
                                        Integer.parseInt(changeSizeField.getText()));
        updateInfo();
    }

    public void deletePlant(ActionEvent actionEvent) {
        farm.garden.deletePlant(Integer.parseInt(deleteIndexField.getText()));
        updateInfo();
    }

    public void loadGarden(ActionEvent actionEvent) {

    }

    public void saveGarden(ActionEvent actionEvent) {

    }

    public void savePlant(ActionEvent actionEvent) {
        try {
            File saveFile = chooseSaveFile();
            if (saveFile != null) {
                int index = getIntFromField(saveIndexField);
                Plant plant = farm.garden.getPlants().get(index - 1);
                BSONSerializer serializer = SerializerFactory.getSerializer(plant.getClass());
                serializer.saveToFile(saveFile, plant);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
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

    public void loadCrop(ActionEvent actionEvent) {
        loadPlant(Crop.class);
    }

    public void loadPlant(Class type) {
        try {
            File openFile = chooseOpenFile();
            if (openFile != null) {
                BSONSerializer serializer = SerializerFactory.getSerializer(type);
                Plant plant = (Plant)serializer.loadFromFile(openFile);
                farm.garden.addPlant(plant);
                updateInfo();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void loadTree(ActionEvent actionEvent) {
        loadPlant(Tree.class);
    }
}
