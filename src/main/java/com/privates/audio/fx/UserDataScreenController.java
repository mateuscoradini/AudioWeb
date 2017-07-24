package com.privates.audio.fx;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDataScreenController {

    @Autowired
    private UserAudioModel userAudioModel;

    private ScreensConfiguration screens;

    public UserDataScreenController() {
    }

    public UserDataScreenController(ScreensConfiguration screens) {
        this.screens = screens;
    }

    public void showErrorDialog() {
        screens.errorDialog().show();
    }

//    public ObservableList<Customer> getCustomers() {
//        return customerModel.getCustomers();
//    }
//
//    @Secured({"ROLE_MANAGER", "ROLE_EMPLOYEE"})
//    public void addCustomer() {
//        screens.addCustomerDialog().show();
//    }
//
//    public void removeCustomer(Customer customer) {
//        customerModel.remove(customer);
//    }
}
