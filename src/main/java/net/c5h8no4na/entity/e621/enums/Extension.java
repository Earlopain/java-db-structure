package net.c5h8no4na.entity.e621.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum Extension {
	JPG(1),
	PNG(2),
	WEBM(3),
	GIF(4),
	SWF(5);

	private Integer id;

	Extension(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String toMediaType() {
		switch (this) {
		case JPG:
			return "image/jpeg";
		case PNG:
			return "image/png";
		case WEBM:
			return "video/webm";
		case GIF:
			return "image/gif";
		case SWF:
			return "application/x-shockwave-flash";
		}
		return null;
	}

	public static Optional<Extension> from(Integer id) {
		return Stream.of(Extension.values()).filter(e -> e.getId().equals(id)).findFirst();
	}

	public static Optional<Extension> from(String input) {
		return Stream.of(Extension.values()).filter(e -> e.name().toLowerCase().equals(input.toLowerCase())).findFirst();
	}

}