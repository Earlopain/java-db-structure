package net.c5h8no4na.entity.e621.converter;

import java.util.Objects;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.c5h8no4na.entity.e621.enums.Extension;

@Converter(autoApply = true)
public class ExtensionConverter implements AttributeConverter<Extension, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Extension extension) {
		Objects.requireNonNull(extension);
		return extension.getId();
	}

	@Override
	public Extension convertToEntityAttribute(Integer dbData) {
		return Extension.from(dbData).get();
	}
}