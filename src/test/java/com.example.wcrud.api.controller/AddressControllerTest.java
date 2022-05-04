package com.example.wcrud.api.controller;

import com.example.wcrud.api.dtos.AddressRequestDTO;
import com.example.wcrud.api.dtos.AddressResponseDTO;
import com.example.wcrud.api.model.Address;
import com.example.wcrud.api.model.Customer;
import com.example.wcrud.api.repository.AddressRepository;
import com.example.wcrud.api.service.AddressService;
import com.example.wcrud.api.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp() {
        addressRepository.deleteAll();
    }

    private Customer genericCustomer() {
        Customer customer = new Customer();
        customer.setName("NMASDAS");
        customer.setCpf("12345678911");
        customer.setEmail("gfamorim@hot.com");
        customer.setCreatedAt(LocalDate.now());
        return customer;
    }

    @Test
    public void shouldSaveAddressWithoutError() {
        Customer savedCustomer = customerService.save(genericCustomer());

        var address = new AddressRequestDTO();
        address.setCustomerId(savedCustomer.getId());
        address.setCep("74363180");
        address.setComplemento("No complement to add ");
        address.setCreatedAt(LocalDate.ofEpochDay(2023 - 04 - 04));
        address.setLocalidade("tu prends de la gare en direction a crissier");
        address.setLogradouro("5asdasd");
        address.setBairro("St. Suplice - Crissier");
        address.setUf("VAUD");
        address.setWeather("weather condition");

        var request = new HttpEntity<>(address);
        var response = testRestTemplate.postForEntity("/address/", request, AddressResponseDTO.class);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(address.getLocalidade(), Objects.requireNonNull(response.getBody().getLocalidade()));
        assertEquals(address.getLogradouro(), response.getBody().getLogradouro());
        assertEquals(address.getComplemento(), response.getBody().getComplemento());
        assertEquals(address.getCep(), response.getBody().getCep());
        assertEquals(address.getBairro(), response.getBody().getBairro());
        assertEquals(address.getComplemento(), response.getBody().getComplemento());
        assertEquals(address.getCreatedAt(), response.getBody().getCreatedAt());
        assertEquals(address.getWeather(), response.getBody().getWeather());
    }

    @Test
    public void shouldFindAddressById() {
        Customer savedCustomer = customerService.save(genericCustomer());

        Address address = new Address();
        address.setComplemento("complemento");
        address.setBairro("bairro");
        address.setLocalidade("sao paulo rj rio grande sul");
        address.setUf("GO");
        address.setCep("743636180");
        address.setLogradouro("logradouro");
        address.setCreatedAt(LocalDate.now());
        address.setWeather("will work on it later *");
        address.setCustomer(savedCustomer);

        Address savedAddress = addressService.save(address);

        var response = testRestTemplate.exchange("/address/" + savedAddress.getId(), GET, null, AddressResponseDTO.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(savedAddress.getLocalidade(), Objects.requireNonNull(response.getBody().getLocalidade()));
        assertEquals(savedAddress.getLogradouro(), response.getBody().getLogradouro());
        assertEquals(savedAddress.getComplemento(), response.getBody().getComplemento());
        assertEquals(savedAddress.getCep(), response.getBody().getCep());
        assertEquals(savedAddress.getBairro(), response.getBody().getBairro());
        assertEquals(savedAddress.getComplemento(), response.getBody().getComplemento());
        assertEquals(savedAddress.getCreatedAt(), response.getBody().getCreatedAt());
        assertEquals(savedAddress.getWeather(), response.getBody().getWeather());
    }

    @Test
    public void shouldDeleteAddressById() {
        Customer savedCustomer = customerService.save(genericCustomer());

        Address address = new Address();
        address.setComplemento("complemento");
        address.setBairro("bairro");
        address.setLocalidade("sao paulo rj rio grande sul");
        address.setUf("GO");
        address.setCep("743636180");
        address.setLogradouro("logradouro");
        address.setCreatedAt(LocalDate.now());
        address.setWeather("will work on it later *");
        address.setCustomer(savedCustomer);

        Address savedAddress = addressService.save(address);

        var response = testRestTemplate.exchange("/address/" + savedAddress.getId(), DELETE, null, Void.class);
        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    public void shouldNotFindAddressById() {
        var response = testRestTemplate.exchange("/address/6", GET, null, NullPointerException.class);
        assertEquals(500, response.getStatusCodeValue());
    }

    private Address genericAddress() {
        var address = new Address();
        address.setCep("74363180");
        address.setComplemento("No complement to add ");
        address.setCreatedAt(LocalDate.ofEpochDay(2023 - 04 - 04));
        address.setUf("545");
        address.setBairro("Gare du Nord");
        address.setId(1L);
        address.setLogradouro("Flon Quartier");
        address.setWeather("weather condition");
        return address;
    }
}