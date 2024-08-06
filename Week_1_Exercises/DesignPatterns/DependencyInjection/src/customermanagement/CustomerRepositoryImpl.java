// customermanagement/CustomerRepositoryImpl.java
package customermanagement;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerDatabase;

    public CustomerRepositoryImpl() {
        customerDatabase = new HashMap<>();
        customerDatabase.put("123", new Customer("123", "John Doe"));
        customerDatabase.put("456", new Customer("456", "Jane Doe"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerDatabase.get(id);
    }
}
