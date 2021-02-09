package net.c5h8no4na.entity.e621.converter;

import java.util.Objects;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.c5h8no4na.entity.e621.enums.TagType;

@Converter(autoApply = true)
public class TagTypeConverter implements AttributeConverter<TagType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TagType type) {
	Objects.requireNonNull(type);
	return type.getId();
    }

    @Override
    public TagType convertToEntityAttribute(Integer dbData) {
	return TagType.from(dbData).get();
    }
}