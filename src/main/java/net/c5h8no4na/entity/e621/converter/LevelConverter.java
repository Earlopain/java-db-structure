package net.c5h8no4na.entity.e621.converter;

import java.util.Objects;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.c5h8no4na.entity.e621.enums.Level;

@Converter(autoApply = true)
public class LevelConverter implements AttributeConverter<Level, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Level level) {
		Objects.requireNonNull(level);
		return level.getId();
	}

	@Override
	public Level convertToEntityAttribute(Integer dbData) {
		return Level.from(dbData).get();
	}
}