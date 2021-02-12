package net.c5h8no4na.entity.e621.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum Rating {
	SAFE(1),
	QUESTIONABLE(2),
	EXPLICIT(3);

	private Integer id;

	Rating(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public static Optional<Rating> from(Integer id) {
		return Stream.of(Rating.values()).filter(e -> e.getId().equals(id)).findFirst();
	}

	public static Optional<Rating> from(String input) {
		switch (input.toLowerCase()) {
		case "s":
			return Optional.of(Rating.SAFE);
		case "q":
			return Optional.of(Rating.QUESTIONABLE);
		case "e":
			return Optional.of(Rating.EXPLICIT);
		default:
			return Stream.of(Rating.values()).filter(e -> e.name().toLowerCase().equals(input.toLowerCase())).findFirst();
		}
	}
}