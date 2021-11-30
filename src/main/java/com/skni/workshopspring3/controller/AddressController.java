package com.skni.workshopspring3.controller;

import com.skni.workshopspring3.dto.AddressResponse;
import com.skni.workshopspring3.repo.AddressRepository;
import com.skni.workshopspring3.repo.entity.Address;
import com.skni.workshopspring3.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AddressController {

    private final AddressRepository addressRepository;
    private final AddressService addressService;

    @GetMapping("/address")
    public List<AddressResponse> getAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        Optional<Address> result = addressRepository.findById(id);

        if(result.isPresent())
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/address")
    public void addAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> addAddress(@PathVariable Long id) {
       if(addressRepository.findById(id).isPresent()){
           addressRepository.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @PatchMapping("/address/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        if(addressService.updateAddress(id, address)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
