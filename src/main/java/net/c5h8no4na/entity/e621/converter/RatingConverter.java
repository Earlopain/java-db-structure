package net.c5h8no4na.entity.e621.converter;

import java.util.Objects;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.c5h8no4na.entity.e621.enums.Rating;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Rating rating) {
		Objects.requireNonNull(rating);
		return rating.getId();
	}

	@Override
	public Rating convertToEntityAttribute(Integer dbData) {
		return Rating.from(dbData).get();
	}
}