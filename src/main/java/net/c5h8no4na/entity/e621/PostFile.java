package net.c5h8no4na.entity.e621;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_file")
public class PostFile {

	@Id
	private Integer id;

	private byte[] file;

	@OneToOne(fetch = FetchType.LAZY)
	private Post post;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}