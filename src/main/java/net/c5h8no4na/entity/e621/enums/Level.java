package net.c5h8no4na.entity.e621.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum Level {
	ANONYMOUS(0),
	BLOCKED(10),
	MEMBER(20),
	PRIVILEGED(30),
	CONTRIBUTOR(33),
	FORMERSTAFF(34),
	MODERATOR(40),
	ADMIN(50);

	private Integer id;

	Level(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public static Optional<Level> from(Integer id) {
		return Stream.of(Level.values()).filter(e -> e.getId().equals(id)).findFirst();
	}

}