package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    @FXML
    private BarChart<String, Integer> browserschart;

    @FXML
    private LineChart<?, ?> uniquevisitorschart;


    @FXML
    private TableColumn<User, String> avgts;

    @FXML
    private TableColumn<User, String> cumts;

    @FXML
    private TableColumn<User, String> data;

    @FXML
    private TableColumn<User, Integer> hits;

    @FXML
    private TableColumn<User, String> maxts;

    @FXML
    private TableColumn<User, Integer> number;

    @FXML
    private TableView<User> uniquevisitorstable;

    @FXML
    private TableColumn<User, String> txamount;

    @FXML
    private TableColumn<User, Integer> visitors;

    ObservableList<User> list = FXCollections.observableArrayList(
            new User(1,4,20,"336.3KiB","12.81 ms","4.00s","12.73ms","17/Nov/2022:16:26"),
            new User(2,7,30,"379.3KiB","12.90 ms","5.00s","13.73ms","17/Nov/2022:16:33"),
            new User(3,9,50,"350.3KiB","12.53 ms","6.00s","15.73ms","17/Nov/2022:16:45"),
            new User(4,4,20,"336.3KiB","12.81 ms","4.00s","12.73ms","17/Nov/2022:16:26"),
            new User(5,7,30,"379.3KiB","12.90 ms","5.00s","13.73ms","17/Nov/2022:16:33"),
            new User(6,9,50,"350.3KiB","12.53 ms","6.00s","15.73ms","17/Nov/2022:16:45"),
            new User(7,4,20,"336.3KiB","12.81 ms","4.00s","12.73ms","17/Nov/2022:16:26"),
            new User(8,7,30,"379.3KiB","12.90 ms","5.00s","13.73ms","17/Nov/2022:16:33"),
            new User(9,9,50,"350.3KiB","12.53 ms","6.00s","15.73ms","17/Nov/2022:16:45")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //unique visitors chart
        XYChart.Series series = new XYChart.Series();
        series.setName("Hits");

        series.getData().add(new XYChart.Data("4:02", 3));
        series.getData().add(new XYChart.Data("4:09", 9));
        series.getData().add(new XYChart.Data("4:12", 7));
        series.getData().add(new XYChart.Data("4:23", 8));
        series.getData().add(new XYChart.Data("4:35", 10));
        series.getData().add(new XYChart.Data("4:42", 9));
        series.getData().add(new XYChart.Data("4:58", 3));
        series.getData().add(new XYChart.Data("5:00", 10));
        series.getData().add(new XYChart.Data("5:12", 6));
        series.getData().add(new XYChart.Data("5:36", 9));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Visitors");

        series2.getData().add(new XYChart.Data("4:02", 7));
        series2.getData().add(new XYChart.Data("4:09", 9));
        series2.getData().add(new XYChart.Data("4:12", 4));
        series2.getData().add(new XYChart.Data("4:23", 7));
        series2.getData().add(new XYChart.Data("4:42", 9));
        series2.getData().add(new XYChart.Data("4:58", 4));
        series2.getData().add(new XYChart.Data("5:00", 5));
        series2.getData().add(new XYChart.Data("5:12", 6));
        series2.getData().add(new XYChart.Data("5:36", 8));

        uniquevisitorschart.getData().addAll(series, series2);

        //uniquevisitorstable
        number.setCellValueFactory(new PropertyValueFactory<User, Integer>("number"));
        hits.setCellValueFactory(new PropertyValueFactory<User, Integer>("hits"));
        visitors.setCellValueFactory(new PropertyValueFactory<User, Integer>("visitors"));
        txamount.setCellValueFactory(new PropertyValueFactory<User, String>("txamount"));
        avgts.setCellValueFactory(new PropertyValueFactory<User, String>("avgts"));
        cumts.setCellValueFactory(new PropertyValueFactory<User, String>("cumts"));
        maxts.setCellValueFactory(new PropertyValueFactory<User, String>("maxts"));
        data.setCellValueFactory(new PropertyValueFactory<User, String>("data"));

        uniquevisitorstable.setItems(list);

        //Requested files chart
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("hits");

        series3.getData().add(new XYChart.Data("Crawlers", 23230));
        series3.getData().add(new XYChart.Data("Safari", 43330));
        series3.getData().add(new XYChart.Data("Chrome", 10000));
        series3.getData().add(new XYChart.Data("Edge", 350000));
        series3.getData().add(new XYChart.Data("Firefox", 12000));
        series3.getData().add(new XYChart.Data("Others", 90000));
        series3.getData().add(new XYChart.Data("Unkown", 30000));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("visitors");

        series4.getData().add(new XYChart.Data("Crawlers", 12000));
        series4.getData().add(new XYChart.Data("Safari", 250000));
        series4.getData().add(new XYChart.Data("Chrome", 100000));
        series4.getData().add(new XYChart.Data("Edge", 43333));
        series4.getData().add(new XYChart.Data("Firefox", 102000));
        series4.getData().add(new XYChart.Data("Others", 150200));
        series4.getData().add(new XYChart.Data("Unkown", 122000));


        browserschart.getData().addAll(series3, series4);
    }
}

