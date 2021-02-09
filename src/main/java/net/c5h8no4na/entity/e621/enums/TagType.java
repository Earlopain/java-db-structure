package net.c5h8no4na.entity.e621.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum TagType {
    GENERAL(0),
    ARTIST(1),
    COPYRIGHT(3),
    CHARACTER(4),
    SPECIES(5),
    INVALID(6),
    META(7),
    LORE(8);

    private Integer id;

    TagType(Integer id) {
	this.id = id;
    }

    public Integer getId() {
	return id;
    }

    public static Optional<TagType> from(Integer id) {
	return Stream.of(TagType.values()).filter(e -> e.getId().equals(id)).findFirst();
    }
}