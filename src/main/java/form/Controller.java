package form;

import entities.Farm;
import entities.plants.Crop;
import entities.plants.Plant;
import entities.plants.Tree;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private Farm farm;

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

    }

    public void loadPlant(ActionEvent actionEvent) {

    }
}
