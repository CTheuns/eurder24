package com.example.eurder.abstraction.mappers.eurder;

import com.example.eurder.abstraction.dto.eurder.EurderAfterCreationDto;
import com.example.eurder.abstraction.dto.eurder.EurderCreationDto;
import com.example.eurder.abstraction.dto.eurder.EurderDto;
import com.example.eurder.abstraction.dto.eurder.ItemGroupDto;
import com.example.eurder.abstraction.mappers.customer.AdressMapper;
import com.example.eurder.domain.eurder.Eurder;
import com.example.eurder.domain.user.userDetails.Adress;
import com.example.eurder.services.CustomerService;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.eurder.domain.eurder.Eurder.EurderBuilder.eurderBuilder;

@Component
public class EurderMapper {

    private final EurderItemMapper eurderItemMapper;
    private final AdressMapper addressMapper;
    private final CustomerService customerService;

    public EurderMapper(EurderItemMapper eurderItemMapper, AdressMapper addressMapper, CustomerService customerService) {
        this.eurderItemMapper = eurderItemMapper;
        this.addressMapper = addressMapper;
        this.customerService = customerService;
    }

    public EurderDto toDto(Eurder eurder) {
        return new EurderDto()
                .withOrderId(eurder.getUuid().toString())
                .withItemGroups(eurder.getOrderItems().stream()
                                      .map(eurderItem -> eurderItemMapper.toDto(eurderItem))
                                      .toArray(ItemGroupDto[]::new))
                .withAddress(addressMapper.toDto(getAdressForCustomer(eurder.getCustomerId())));
    }

    private Adress getAdressForCustomer(UUID customerId) {
        return customerService.getCustomer(customerId).getAdress();
    }

    public Eurder toDomain(EurderCreationDto eurderCreationDto) {
        return eurderBuilder()
                .withCustomerId(UUID.fromString(eurderCreationDto.getCustomerId()))
                .withOrderItems(eurderCreationDto.getItemGroups().stream()
                                                 .map(itemGroup -> eurderItemMapper.toDomain(itemGroup))
                                                 .collect(Collectors.toList()))
                .build();
    }

    public EurderAfterCreationDto toEurderAfterCreationDto(Eurder eurder) {
        return new EurderAfterCreationDto()
                .withOrderId(eurder.getUuid().toString())
                .withTotalPrice(eurder.getTotalPrice().getAmountAsFloat());
    }
}
