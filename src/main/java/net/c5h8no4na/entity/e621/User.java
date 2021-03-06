package net.c5h8no4na.entity.e621;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.c5h8no4na.entity.e621.enums.Level;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "avatar_id")
	private Post avatar;

	@Column(name = "level_id")
	private Level level;

	private String name;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "is_banned")
	private Boolean isBanned;

	@OneToMany(mappedBy = "approver")
	private List<Post> approvedPosts = new ArrayList<>();

	@OneToMany(mappedBy = "uploader")
	private List<Post> uploadedPosts = new ArrayList<>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Optional<Post> getAvatar() {
		return Optional.ofNullable(this.avatar);
	}

	public void setAvatar(Post avatar) {
		this.avatar = avatar;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsBanned() {
		return this.isBanned;
	}

	public void setIsBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getApprovedPosts() {
		return this.approvedPosts;
	}

	public void setApprovedPosts(List<Post> approvedPosts) {
		this.approvedPosts = approvedPosts;
	}

	public Post addApprovedPost(Post post) {
		getApprovedPosts().add(post);
		post.setApprover(this);

		return post;
	}

	public Post removeApprovedPost(Post post) {
		getApprovedPosts().remove(post);
		post.setApprover(null);

		return post;
	}

	public List<Post> getUploadedPosts() {
		return this.uploadedPosts;
	}

	public void setUploadedPosts(List<Post> uploadedPosts) {
		this.uploadedPosts = uploadedPosts;
	}

	public Post addUploadedPost(Post post) {
		getUploadedPosts().add(post);
		post.setUploader(this);

		return post;
	}

	public Post removeUploadedPost(Post post) {
		getUploadedPosts().remove(post);
		post.setUploader(null);

		return post;
	}

}