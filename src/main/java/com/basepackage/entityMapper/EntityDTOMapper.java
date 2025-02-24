package com.basepackage.entityMapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOMapper {
    

    private final  ModelMapper modelMapper =new ModelMapper();


    

    public <E,T> T EntityToDto(E entity,Class<T> dtoClass){


        return modelMapper.map(entity,dtoClass);
    }

           
public <T,E> E DtoToEntity(T dto,Class<E> entityClass){

    return modelMapper.map(dto,entityClass);
}



}
