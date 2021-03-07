package net.c5h8no4na.entity.e621.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum Extension {
	JPG(1, "image/jpeg"),
	PNG(2, "image/png"),
	WEBM(3, "video/webm"),
	GIF(4, "image/gif"),
	SWF(5, "application/x-shockwave-flash");

	private final Integer id;
	private final String mediaType;

	Extension(Integer id, String mediaType) {
		this.id = id;
		this.mediaType = mediaType;
	}

	public Integer getId() {
		return id;
	}

	public String getMediaType() {
		return mediaType;
	}

	public static Optional<Extension> from(Integer id) {
		return Stream.of(Extension.values()).filter(e -> e.getId().equals(id)).findFirst();
	}

	public static Optional<Extension> from(String input) {
		return Stream.of(Extension.values()).filter(e -> input.equalsIgnoreCase(e.name()) || input.equalsIgnoreCase("del." + e.name()))
				.findFirst();
	}

}