package com.example.cryptokrypto.mapper;

public interface Mapper<Entity, Dto> {
    Dto fromEntityToDto(Entity entity);
    Entity fromDtoToEntity(Dto dto);
}
