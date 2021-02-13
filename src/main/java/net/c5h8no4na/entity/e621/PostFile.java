package net.c5h8no4na.entity.e621;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_file")
public class PostFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne(fetch = FetchType.LAZY)
	private Post post;

	private byte[] file;

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