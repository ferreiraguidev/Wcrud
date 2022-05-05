package com.example.wcrud.api.service;

import com.example.wcrud.api.model.Address;
import com.example.wcrud.api.model.Customer;
import com.example.wcrud.api.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(SpringExtension.class)
class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;


    @Test
    public void shouldSaveAddress() {
        Address address = genericAddress();

        when(addressRepository.save(address))
                .thenReturn(address);

        Address savedAddress = addressService.save(address);

        verify(addressRepository).save(savedAddress);
    }

    @Test
    public void shouldFindAddressById() {
        Address address = genericAddress();
        address.setId(1L);
        when(addressRepository.findById(address.getId()))
                .thenReturn(Optional.of(address));
    }

    @Test
    public void shouldDeleteById() {

        Address savedAddress = genericAddress();
        savedAddress.setId(1L);
        addressRepository.deleteById(savedAddress.getId());
    }

    private Address genericAddress() {
        var address = new Address();
        address.setId(1L);
        address.setBairro("st name example");
        address.setCep("7481651651");
        address.setLogradouro("15");
        address.setLocalidade("no");
        address.setUf("GO");
        address.setWeather("weather wrong");
        address.setCreatedAt(LocalDate.ofEpochDay(2023 - 04 - 04));
        address.setCustomer(new Customer());
        return address;
    }

}