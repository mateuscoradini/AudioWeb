package com.privates.audio.fx;

public class UserAudioModel {
	
//    private ObservableList<Customer> customers = FXCollections.observableArrayList();
//
//    public ObservableList<Customer> getCustomers() {
//        return customers;
//    }
//
//    private RestTemplate restTemplate;
//
//    public void setRestTemplate(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @SuppressWarnings("unchecked")
//    public void loadData() {
//        Customer[] customers = restTemplate.getForObject("http://localhost:8080/crm/customers", Customer[].class);
//        this.customers.setAll(customers);
//    }
//
//    @Secured("ROLE_MANAGER")
//    public void remove(Customer customer) {
//        restTemplate.delete("http://localhost:8080/crm/customer/" + customer.getId());
//        customers.remove(customer);
//    }
//
//    public void addCustomer(String firstName, String lastName) {
//        Customer customer = new Customer();
//        customer.setFirstName(firstName);
//        customer.setLastName(lastName);
//        customer.setSignupDate(new Date());
//        Integer id = restTemplate.postForObject("http://localhost:8080/crm/customers", customer, Integer.class);
//        customer.setId(id);
//        customers.add(customer);
//    }
}
