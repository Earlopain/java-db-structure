package net.c5h8no4na.entity.e621;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts_destroyed")
public class DestroyedPost implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
