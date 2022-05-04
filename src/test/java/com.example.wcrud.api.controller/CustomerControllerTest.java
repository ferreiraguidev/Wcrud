package com.example.wcrud.api.controller;

import com.example.wcrud.api.dtos.CustomerRequestDTO;
import com.example.wcrud.api.dtos.CustomerResponseDTO;
import com.example.wcrud.api.model.Customer;
import com.example.wcrud.api.repository.CustomerRepository;
import com.example.wcrud.api.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp(){
        customerRepository.deleteAll();
    }

    @Test
    public void shouldSaveCustomerWithoutError() {

        var customer = new CustomerRequestDTO();
        customer.setName("YouthB SurnameFr Defois");
        customer.setCpf("123.456.456.11");
        customer.setEmail("fghba@gmail.com");
        customer.setCreatedAt(LocalDate.now());

        var request = new HttpEntity<>(customer);
        var response =
                testRestTemplate.postForEntity("/api/customer", request, CustomerResponseDTO.class);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(customer.getName(), Objects.requireNonNull(response.getBody()).getName());
        assertEquals(customer.getCpf(), response.getBody().getCpf());
        assertEquals(customer.getEmail(), response.getBody().getEmail());
        assertEquals(customer.getCreatedAt(), response.getBody().getCreatedAt());
    }

    @Test
    public void shouldFindCustomerById() {

        Customer savedCustomer = customerService.save(genericCustomer());

        var response =
                testRestTemplate.exchange("/api/customer/" + savedCustomer.getId(), GET,
                        null, CustomerResponseDTO.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(savedCustomer.getName(), Objects.requireNonNull(response.getBody()).getName());
        assertEquals(savedCustomer.getCpf(), response.getBody().getCpf());
        assertEquals(savedCustomer.getEmail(), response.getBody().getEmail());
        assertEquals(savedCustomer.getCreatedAt(), response.getBody().getCreatedAt());
    }

    @Test
    public void shouldNotFindCustomerById() {

        var response =
                testRestTemplate.exchange("/api/customer/6", GET,
                        null, NullPointerException.class);
        assertEquals(500, response.getStatusCodeValue());
    }

    @Test
    public void shouldListAll() {

        Customer firtsPerson = genericCustomer();
        firtsPerson.setCpf("15616516565");

        Customer secondPerson = genericCustomer();
        secondPerson.setName("Guilherme ferreira faixa laranja");

        List<Customer> customers = customerRepository.saveAll(List.of(firtsPerson, secondPerson));

        var response =
                testRestTemplate.exchange("/api/customer", GET,
                        null, new ParameterizedTypeReference<List<CustomerResponseDTO>>() {
                        });

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals(customers.get(0).getName(), response.getBody().get(0).getName());
        assertEquals("15616516565", response.getBody().get(0).getCpf());
        assertEquals(customers.get(0).getEmail(), response.getBody().get(0).getEmail());
        assertEquals(customers.get(0).getCreatedAt(), response.getBody().get(0).getCreatedAt());

        assertEquals("Guilherme ferreira faixa laranja", response.getBody().get(1).getName());
        assertEquals(customers.get(1).getCpf(), response.getBody().get(1).getCpf());
        assertEquals(customers.get(1).getEmail(), response.getBody().get(1).getEmail());
        assertEquals(customers.get(1).getCreatedAt(), response.getBody().get(1).getCreatedAt());
    }

    @Test
    public void shouldDeleteCustomerById() {

        Customer savedCustomer = customerService.save(genericCustomer());

        var response =
                testRestTemplate.exchange("/api/customer/" + savedCustomer.getId(), DELETE,
                        null, Void.class);

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    private Customer genericCustomer() {
        var customer = new Customer();
        customer.setName("Marcos Barbosa");
        customer.setCpf("12345678911");
        customer.setEmail("email@email.com");
        customer.setCreatedAt(LocalDate.now());
        return customer;
    }
}
