package com.caglar.postgresqldemo.service.impl;

import com.caglar.postgresqldemo.dto.PersonDto;
import com.caglar.postgresqldemo.model.Address;
import com.caglar.postgresqldemo.model.Person;
import com.caglar.postgresqldemo.repository.AddressRepository;
import com.caglar.postgresqldemo.repository.PersonRepository;
import com.caglar.postgresqldemo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto create (PersonDto personDto){
        Assert.isNull(personDto.getFirstName(), "Name must not be null.");

        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(person.getLastName());
        final Person persondb = personRepository.save(person);
        List<Address> addressList = new ArrayList<>();

        for (String a : personDto.getAddresses()) {
            Address address = new Address();
            address.setAddress(a);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActivity(true);
            address.setPerson(persondb);
            addressList.add(address);
        }

        addressRepository.saveAll(addressList);
        personDto.setId(persondb.getId());
        return personDto;
    }

    public void delete (Long id){

    }

    public List<PersonDto> findAll(){
       List<Person> persons = personRepository.findAll();
       List<PersonDto> personDtos = new ArrayList<>();
       persons.forEach(item -> {
           PersonDto personDto = new PersonDto();
           personDto.setId(item.getId());
           personDto.setFirstName(item.getFirstName());
           personDto.setLastName(item.getLastName());
           personDto.setAddresses(item.getAddresses().stream().map(Address::getAddress)
                   .collect(Collectors.toList()));
           personDtos.add(personDto);
       });

       return personDtos;
    }

    public PersonDto findAll(Pageable pageable){
        return null;
    }
}
