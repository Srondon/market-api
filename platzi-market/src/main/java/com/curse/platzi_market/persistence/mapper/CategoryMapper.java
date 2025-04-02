package com.curse.platzi_market.persistence.mapper;

import com.curse.platzi_market.domain.Category;
import com.curse.platzi_market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration //Notación para indicar que es básicamente la misma pero a la inversa, por eso no la definimos de nuevo.
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}