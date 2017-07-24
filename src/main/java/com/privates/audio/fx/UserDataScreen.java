package com.privates.audio.fx;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;

public class UserDataScreen extends StackPane {

    UserDataScreenController controller;
    
    //private TableView<Customer> tableView = new TableView<Customer>();

    public UserDataScreen(UserDataScreenController controller) {
        this.controller = controller;
        getChildren().add(VBoxBuilder.create()
            .children(
                createHeader()
                //createToolbar(),
               // createDataTable()
                )
            .build());
    }

    private Node createHeader() {
        return new ImageView(getClass().getResource("header.jpg").toString());
    }

//    private Node createToolbar() {
//        Button removeButton;
//        ToolBar toolBar = ToolBarBuilder.create()
//            .items(
//                ButtonBuilder.create()
//                    .text("Add Customer")
//                    .onAction(new EventHandler<ActionEvent>() {
//                        public void handle(ActionEvent actionEvent) {
//                            controller.addCustomer();
//                        }
//                    })
//                    .build(),
//                removeButton = ButtonBuilder.create()
//                    .text("Remove Customer")
//                    .onAction(new EventHandler<ActionEvent>() {
//                        public void handle(ActionEvent actionEvent) {
//                            try {
//                                controller.removeCustomer(tableView.getSelectionModel().getSelectedItem());
//                                tableView.getSelectionModel().select(Math.min(tableView.getSelectionModel().getSelectedIndex(),
//                                    tableView.getItems().size() - 1));
//                            } catch (AccessDeniedException e) {
//                                controller.showErrorDialog();
//                            }
//                        }
//                    })
//                    .build()
//            )
//            .build();
//        removeButton.disableProperty().bind(tableView.getSelectionModel().selectedItemProperty().isNull());
//        return toolBar;
//    }

//    @SuppressWarnings("unchecked")
//    private Node createDataTable() {
//        StackPane dataTableBorder = new StackPane();
//        dataTableBorder.getChildren().add(tableView);
//        dataTableBorder.setPadding(new Insets(8));
//        dataTableBorder.setStyle("-fx-background-color: lightgray");
//        tableView.setItems(controller.getCustomers());
//        tableView.getColumns().setAll(
//            TableColumnBuilder.<Customer, String>create()
//                .text("First Name")
//                .cellValueFactory(new PropertyValueFactory<Customer, String>("firstName"))
//                .prefWidth(204)
//                .build(),
//            TableColumnBuilder.<Customer, String>create()
//                .text("Last Name")
//                .cellValueFactory(new PropertyValueFactory<Customer, String>("lastName"))
//                .prefWidth(204)
//                .build(),
//            TableColumnBuilder.<Customer, String>create()
//                .text("Sign-up Date")
//                .cellValueFactory(new PropertyValueFactory<Customer, String>("signupDate"))
//                .prefWidth(351)
//                .build()
//        );
//        tableView.setPrefHeight(500);
//        return dataTableBorder;
//    }
}
