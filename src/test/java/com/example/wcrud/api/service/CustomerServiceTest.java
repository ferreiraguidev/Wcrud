package com.example.wcrud.api.service;

import com.example.wcrud.api.model.Customer;
import com.example.wcrud.api.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void shouldSaveCustomer() {
        //arrange
        Customer customer = genericCustomer();

        // act
        customerService.save(customer);

        //assert
        verify(customerRepository).save(customer);

    }
    @Test
    public void shouldFindCustomerById(){
        Customer customer = genericCustomer();
        customer.setId(1L);
        when(customerRepository.findById(customer.getId()))
                .thenReturn(Optional.of(customer));

        Customer byId = customerService.findById(customer.getId());

        verify(customerRepository).findById(customer.getId());
        assertEquals(customer.getName(),byId.getName());
        assertEquals(customer.getCpf(),byId.getCpf());
        assertEquals(customer.getCreatedAt(),byId.getCreatedAt());
        assertEquals(customer.getEmail(),byId.getEmail());
    }

    private Customer genericCustomer() {
        var customer = new Customer();
        customer.setName("Marcos Barbosa");
        customer.setCpf("12345678911");
        customer.setEmail("email@email.com");
        customer.setCreatedAt(LocalDate.now());
        return customer;
    }
    // delete list all

}