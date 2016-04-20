package form;

import entities.containers.Garden;
import entities.containers.KaleYard;
import entities.containers.Stock;
import entities.equipment.Sprinkler;
import entities.equipment.Tractor;
import entities.plants.Tree;
import entities.plants.Vegetable;
import exceptions.IncorrectItemNumberException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    public TextField vegetableIndexField;
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
    public TextField treeIndexField;

    private Garden garden = new Garden();
    private KaleYard kaleYard = new KaleYard();
    private Tractor tractor = new Tractor();
    private Sprinkler sprinkler = new Sprinkler();
    private Stock stock = new Stock();

    private void updateInfo() {
        printKaleYard();
    }

    private void printKaleYard() {
        kaleYardLabel.setText(kaleYard.toString());
    }

    private void printGarden() {
        gardenLabel.setText(garden.toString());
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

    public void selectVegetableButtonClicked(ActionEvent actionEvent) {
        try {
            int index = Integer.parseInt(vegetableIndexField.getText());
            Vegetable vegetable = kaleYard.get(index - 1);

            vegetableNameField.setText(vegetable.getName());
            vegetableAgingField.setText("" + vegetable.getAging());
            vegetableFertilizersField.setText("" + vegetable.getFertilizers());
            vegetableMoistureField.setText("" + vegetable.getMoisture());

            showAlert(Alert.AlertType.INFORMATION, "Растение " + index + " выбано");
        } catch (IncorrectItemNumberException | NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Неверный номер растения").showAndWait()
                    .filter(response -> response == ButtonType.OK);
        }
    }

    public void addVegetableButtonClicked(ActionEvent actionEvent) {
        try {
            String name = vegetableNameField.getText();
            int fertilizers = Integer.parseInt(vegetableFertilizersField.getText());
            int moisture = Integer.parseInt(vegetableMoistureField.getText());
            int aging = Integer.parseInt(vegetableAgingField.getText());

            kaleYard.add(new Vegetable(name, fertilizers, moisture, aging));
            showAlert(Alert.AlertType.INFORMATION, "Растение добавлено");
            updateInfo();
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверно введены данные растения");
        }
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        new Alert(alertType, message).showAndWait()
                .filter(response -> response == ButtonType.OK);
    }

    public void updateVegetableButtonClicked(ActionEvent actionEvent) {
        try {
            int index = Integer.parseInt(vegetableIndexField.getText());

            Vegetable vegetable = kaleYard.get(index - 1);

            String name = vegetableNameField.getText();
            int fertilizers = Integer.parseInt(vegetableFertilizersField.getText());
            int moisture = Integer.parseInt(vegetableMoistureField.getText());
            int aging = Integer.parseInt(vegetableAgingField.getText());

            vegetable.setName(name);
            vegetable.setAging(aging);
            vegetable.setMoisture(moisture);
            vegetable.setFertilizers(fertilizers);

            showAlert(Alert.AlertType.INFORMATION, "Растение №" + index + " изменено");
            updateInfo();
        } catch (IncorrectItemNumberException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверный индекс");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверные данные");
        }
    }

    public void removeVegetableButtonClicked(ActionEvent actionEvent) {
        try {
            int index = Integer.parseInt(vegetableIndexField.getText());
            kaleYard.remove(index - 1);
            showAlert(Alert.AlertType.INFORMATION, "Растение №" + index + " удалено");
            updateInfo();
        } catch (IncorrectItemNumberException | NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Неверный индекс");
        }
    }

    public void updateTreeButtonClicked(ActionEvent actionEvent) {

    }

    public void insertTreeButtonClicked(ActionEvent actionEvent) {
        try {
            String name = treeNameField.getText();
            int height = Integer.parseInt(treeHeightField.getText());
            int age = Integer.parseInt(treeAgeField.getText());

            Tree tree = new Tree(name, height, age);
            garden.add(tree);
            printGarden();
            showAlert(Alert.AlertType.INFORMATION, "Дерево добавлено");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверные данные");
        }
    }

    public void selectTreeButtonClicked(ActionEvent actionEvent) {
        try {
            int index = Integer.parseInt(treeIndexField.getText());

            Tree tree = garden.get(index - 1);

            treeNameField.setText(tree.getName());
            treeAgeField.setText("" + tree.getAge());
            treeHeightField.setText("" + tree.getHeight());

            showAlert(Alert.AlertType.INFORMATION, "Дерево " + index + " выбрано");
        } catch (IncorrectItemNumberException | NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверный индекс");
        }
    }

    public void deleteTreeButtonClicked(ActionEvent actionEvent) {

    }

    public void updateGardenButtonClicked(ActionEvent actionEvent) {
        try {
            int amount = Integer.parseInt(treeAmountField.getText());

            garden.setMaxTreesAmount(amount);

            showAlert(Alert.AlertType.INFORMATION, "Максимальное количество деревьев изменено");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверные данные");
            showGardenInfo();
        }
    }

    private void showGardenInfo() {
        treeAmountField.setText("" + garden.getMaxTreesAmount());
    }

    public void updateKaleYardButtonClicked(ActionEvent actionEvent) {
        try {
            int area = Integer.parseInt(kaleYardAreaField.getText());

            kaleYard.setArea(area);

            showAlert(Alert.AlertType.INFORMATION, "Площадь огорода изменена");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Неверные данные");
            showKaleYardInfo();
        }
    }

    private void showKaleYardInfo() {
        kaleYardAreaField.setText("" + kaleYard.getArea());
    }
}
