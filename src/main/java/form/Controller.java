package form;

import entities.containers.Garden;
import entities.containers.KaleYard;
import entities.containers.Stock;
import entities.equipment.Sprinkler;
import entities.equipment.Tractor;
import entities.plants.Tree;
import entities.plants.Vegetable;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import serialization.FileInputSerializingStream;
import serialization.FileOutputSerializingStream;

import java.io.File;
import java.io.IOException;

/**
 * Created by Evgeny Shilov on 01.04.2016.
 */
public class Controller {
    public TextField sprinklerNameField;
    public TextField sprinklerCapacityField;
    public TextField sprinklerBalanceField;
    public TextField sprinklerPressureField;
    public TextField tractorNameField;
    public TextField tractorPowerField;
    public TextField tractorFuelField;
    public TextField stockCapacityField;
    public TextField stockOccupancyField;
    public TextField vegetableNameField;
    public TextField vegetableAgingField;
    public TextField vegetableMoistureField;
    public TextField vegetableFertilizersField;
    public Label kaleYardLabel;
    public TextField treeAmountField;
    public TextField kaleYardAreaField;
    public TextField treeNameField;
    public TextField treeHeightField;
    public TextField treeAgeField;
    public Label gardenLabel;
    public ComboBox vegetableComboBox;
    public ComboBox treeComboBox;

    private Garden garden = new Garden();
    private KaleYard kaleYard = new KaleYard();
    private Tractor tractor = new Tractor();
    private Sprinkler sprinkler = new Sprinkler();
    private Stock stock = new Stock();

    private final String LOAD_FILE_LOCATION = "savings/save.farm";

    public void loadInfo() {
        File fileToLoad = new File(LOAD_FILE_LOCATION);
        if (fileToLoad.exists()) {
            loadResoursesFromFile(fileToLoad);
        }
        else {
            System.out.println("WRD");
        }
        printAll();
    }

    public void saveInfo() {
        File fileToSave = new File(LOAD_FILE_LOCATION);
        saveResoursesToFile(fileToSave);
    }

    public void printAll() {
        printKaleYard();
        printGarden();
        printTractor();
        printSprinkler();
        printStock();
    }

    private void printKaleYard() {
        printKaleYardContent();
        printKaleYardInfo();
        loadVegetableComboBox();
    }

    private void loadVegetableComboBox() {
        vegetableComboBox.getItems().clear();
        vegetableComboBox.getItems().addAll(kaleYard.getItems());
        vegetableComboBox.getSelectionModel().selectFirst();
    }

    private void loadTreeComboBox() {
        treeComboBox.getItems().clear();
        treeComboBox.getItems().addAll(garden.getItems());
        treeComboBox.getSelectionModel().selectFirst();
    }

    private void printKaleYardContent() {
        kaleYardLabel.setText(kaleYard.toString());
    }

    private void printGarden() {
        printGardenContent();
        printGardenInfo();
        loadTreeComboBox();
    }

    private void printGardenContent() {
        gardenLabel.setText(garden.toString());
    }

    private void printTractor() {
        tractorFuelField.setText("" + tractor.getFuelBalance());
        tractorNameField.setText(tractor.getName());
        tractorPowerField.setText("" + tractor.getPower());
    }

    private void printSprinkler() {
        sprinklerNameField.setText(sprinkler.getName());
        sprinklerCapacityField.setText("" + sprinkler.getCapacity());
        sprinklerPressureField.setText("" + sprinkler.getPressure());
        sprinklerBalanceField.setText("" + sprinkler.getWaterBalance());
    }

    private void printStock() {
        stockCapacityField.setText("" + stock.getCapacity());
        stockOccupancyField.setText("" + stock.getOccupancy());
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        new Alert(alertType, message).showAndWait()
                .filter(response -> response == ButtonType.OK);
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

            new Alert(Alert.AlertType.INFORMATION, "Данные поливалки изменены").showAndWait()
                    .filter(response -> response == ButtonType.OK);
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Введены неверные данные").showAndWait()
                    .filter(response -> response == ButtonType.OK);
        }
    }

    public void updateTractorButtonClicked(ActionEvent actionEvent) {
        try {
            String newName = tractorNameField.getText();
            double newFuelBalance = Double.parseDouble(tractorFuelField.getText());
            double newPower = Double.parseDouble(tractorPowerField.getText());

            tractor.setName(newName);
            tractor.setFuelBalance(newFuelBalance);
            tractor.setPower(newPower);

            new Alert(Alert.AlertType.INFORMATION, "Данные трактора изменены").showAndWait()
                    .filter(response -> response == ButtonType.OK);
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Введены неверные данные").showAndWait()
                    .filter(response -> response == ButtonType.OK);
        }
    }

    public void updateStockButtonClicked(ActionEvent actionEvent) {
        try {
            int newCapacity = Integer.parseInt(stockCapacityField.getText());
            int newOccupancy = Integer.parseInt(stockOccupancyField.getText());

            stock.setCapacity(newCapacity);
            stock.setOccupancy(newOccupancy);

            new Alert(Alert.AlertType.INFORMATION, "Данные склада изменены").showAndWait()
                    .filter(response -> response == ButtonType.OK);
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Введены неверные данные").showAndWait()
                    .filter(response -> response == ButtonType.OK);
        }
    }

    public void addVegetableButtonClicked(ActionEvent actionEvent) {
        try {
            String name = vegetableNameField.getText();
            int fertilizers = Integer.parseInt(vegetableFertilizersField.getText());
            int moisture = Integer.parseInt(vegetableMoistureField.getText());
            int aging = Integer.parseInt(vegetableAgingField.getText());

            Vegetable newVegetable = new Vegetable(name, fertilizers, moisture, aging);
            kaleYard.add(newVegetable);

            printKaleYardContent();
            vegetableComboBox.getItems().add(newVegetable);
            vegetableComboBox.getSelectionModel().select(newVegetable);

            showAlert(Alert.AlertType.INFORMATION, "Растение добавлено");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверно введены данные растения");
        }
    }

    public void updateVegetableButtonClicked(ActionEvent actionEvent) {
        try {
            Vegetable vegetable = getSelectedVegetable();

            String name = vegetableNameField.getText();
            int fertilizers = Integer.parseInt(vegetableFertilizersField.getText());
            int moisture = Integer.parseInt(vegetableMoistureField.getText());
            int aging = Integer.parseInt(vegetableAgingField.getText());

            vegetable.setName(name);
            vegetable.setAging(aging);
            vegetable.setMoisture(moisture);
            vegetable.setFertilizers(fertilizers);

            vegetableComboBox.getSelectionModel().clearSelection();
            vegetableComboBox.getSelectionModel().select(vegetable);
            printKaleYardContent();
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверные данные");
        } catch (NullPointerException ex) {
            showAlert(Alert.AlertType.ERROR, "Не выбран овощ");
        }
    }

    public void removeVegetableButtonClicked(ActionEvent actionEvent) {
        try {
            Vegetable vegetable = getSelectedVegetable();
            if (vegetable == null) throw new NullPointerException();
            kaleYard.remove(vegetable);
            vegetableComboBox.getItems().remove(vegetable);
            vegetableComboBox.getSelectionModel().selectFirst();
            printKaleYardContent();
        } catch (NullPointerException e) {
            showAlert(Alert.AlertType.ERROR, "Не выбран овощ");
        }
    }

    public void updateTreeButtonClicked(ActionEvent actionEvent) {
        try {
            Tree tree = getSelectedTree();

            String name = treeNameField.getText();
            int height = Integer.parseInt(treeHeightField.getText());
            int age = Integer.parseInt(treeAgeField.getText());

            tree.setAge(age);
            tree.setName(name);
            tree.setHeight(height);

            treeComboBox.getSelectionModel().clearSelection();
            treeComboBox.getSelectionModel().select(tree);

            printGardenContent();
        } catch (NullPointerException ex) {
            showAlert(Alert.AlertType.ERROR, "Не выбрано дерево");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверно введенные данные");
        }
    }

    public void insertTreeButtonClicked(ActionEvent actionEvent) {
        try {
            String name = treeNameField.getText();
            int height = Integer.parseInt(treeHeightField.getText());
            int age = Integer.parseInt(treeAgeField.getText());

            Tree tree = new Tree(name, height, age);
            garden.add(tree);
            treeComboBox.getItems().add(tree);
            treeComboBox.getSelectionModel().select(tree);
            printGardenContent();
            showAlert(Alert.AlertType.INFORMATION, "Дерево добавлено");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверные данные");
        }
    }

    public void deleteTreeButtonClicked(ActionEvent actionEvent) {
        try {
            Tree tree = getSelectedTree();
            if (tree == null) throw new NullPointerException();

            garden.remove(tree);
            treeComboBox.getItems().remove(tree);

            treeComboBox.getSelectionModel().selectFirst();
            printGardenContent();
        } catch (NullPointerException ex) {
            showAlert(Alert.AlertType.ERROR, "Не выбрано дерево");
        }
    }

    public void updateGardenButtonClicked(ActionEvent actionEvent) {
        try {
            int amount = Integer.parseInt(treeAmountField.getText());

            garden.setMaxTreesAmount(amount);

            showAlert(Alert.AlertType.INFORMATION, "Максимальное количество деревьев изменено");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверные данные");
            printGardenInfo();
        }
    }

    private void printGardenInfo() {
        treeAmountField.setText("" + garden.getMaxTreesAmount());
    }

    public void updateKaleYardButtonClicked(ActionEvent actionEvent) {
        try {
            int area = Integer.parseInt(kaleYardAreaField.getText());

            kaleYard.setArea(area);

            showAlert(Alert.AlertType.INFORMATION, "Площадь огорода изменена");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверные данные");
            printKaleYardInfo();
        }
    }

    private void printKaleYardInfo() {
        kaleYardAreaField.setText("" + kaleYard.getArea());
    }

    public Vegetable getSelectedVegetable() {
        return (Vegetable) vegetableComboBox.getSelectionModel().getSelectedItem();
    }

    public Tree getSelectedTree() {
        return (Tree) treeComboBox.getSelectionModel().getSelectedItem();
    }

    public void vegetableSelect(ActionEvent actionEvent) {
        Vegetable vegetable = getSelectedVegetable();

        if (vegetable != null) {
            vegetableNameField.setText(vegetable.getName());
            vegetableAgingField.setText("" + vegetable.getAging());
            vegetableFertilizersField.setText("" + vegetable.getFertilizers());
            vegetableMoistureField.setText("" + vegetable.getMoisture());
        }
    }

    public void treeSelect(ActionEvent actionEvent) {
        Tree tree = getSelectedTree();
        if (tree != null) {
            treeAgeField.setText("" + tree.getAge());
            treeNameField.setText(tree.getName());
            treeHeightField.setText("" + tree.getHeight());
        }
    }

    public void saveToFileButtonClicked(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл для сохранения");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Файлы садоводов и огородников", "*.farm"));
        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile != null) {
            saveResoursesToFile(selectedFile);
        }
    }

    public void loadFromFileButtonClicked(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Файлы садоводов и огородников", "*.farm"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            loadResoursesFromFile(selectedFile);
        }
    }

    private void saveResoursesToFile(File file) {
        try {
            FileOutputSerializingStream outputSerializingStream = new FileOutputSerializingStream(file);
            outputSerializingStream.write(sprinkler);
            outputSerializingStream.write(tractor);
            outputSerializingStream.write(stock);
            outputSerializingStream.write(garden);
            outputSerializingStream.write(kaleYard);
            outputSerializingStream.close();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Ошибка во время сохранения файла");
            System.out.println(e);
        }
    }

    private void loadResoursesFromFile(File file) {
        try {
            FileInputSerializingStream inputSerializingStream = new FileInputSerializingStream(file);
            sprinkler = inputSerializingStream.read(Sprinkler.class);
            tractor = inputSerializingStream.read(Tractor.class);
            stock = inputSerializingStream.read(Stock.class);
            garden = inputSerializingStream.read(Garden.class);
            kaleYard = inputSerializingStream.read(KaleYard.class);
            inputSerializingStream.close();
            printAll();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Ошибка во время загрузки файла");
            System.out.println(e);
        }
    }
}
