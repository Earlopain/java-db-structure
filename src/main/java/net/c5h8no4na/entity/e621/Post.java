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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.c5h8no4na.entity.e621.enums.Extension;
import net.c5h8no4na.entity.e621.enums.Rating;

@Entity
@Table(name = "posts")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name = "extension_id")
	private Extension extension;

	@Column(name = "rating_id")
	private Rating rating;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "approver_id")
	private User approver;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uploader_id")
	private User uploader;

	private String md5;

	private Integer width;

	private Integer height;

	private Integer size;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "score_up")
	private Integer scoreUp;

	@Column(name = "score_down")
	private Integer scoreDown;

	@Column(name = "score_total")
	private Integer scoreTotal;

	@Column(name = "fav_count")
	private Integer favCount;

	private String description;

	private Float duration;

	@ManyToOne
	@JoinTable(name = "post_children", joinColumns = { @JoinColumn(name = "child_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "post_id", referencedColumnName = "id") })
	private Post parent;

	@ManyToMany
	@JoinTable(name = "post_children", joinColumns = { @JoinColumn(name = "post_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "child_id", referencedColumnName = "id") })
	private List<Post> children = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<Source> sources = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "post_tags", joinColumns = { @JoinColumn(name = "post_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "tag_id", referencedColumnName = "id") })
	private List<Tag> tags = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PoolPost> poolPosts = new ArrayList<>();

	@OneToOne(mappedBy = "post", fetch = FetchType.LAZY)
	private PostFile postFile;

	@OneToMany(mappedBy = "avatar", fetch = FetchType.LAZY)
	private List<User> usersWithAvatar = new ArrayList<>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Optional<Float> getDuration() {
		return Optional.ofNullable(this.duration);
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Extension getExtension() {
		return this.extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public Integer getFavCount() {
		return this.favCount;
	}

	public void setFavCount(Integer favCount) {
		this.favCount = favCount;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Optional<PostFile> getPostFile() {
		return Optional.ofNullable(this.postFile);
	}

	public void setPostFile(PostFile postFile) {
		this.postFile = postFile;
	}

	public String getMd5() {
		return this.md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Optional<Post> getParent() {
		return Optional.ofNullable(this.parent);
	}

	public void setParent(Post parent) {
		this.parent = parent;
	}

	public Rating getRating() {
		return this.rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Integer getScoreDown() {
		return this.scoreDown;
	}

	public void setScoreDown(Integer scoreDown) {
		this.scoreDown = scoreDown;
	}

	public Integer getScoreTotal() {
		return this.scoreTotal;
	}

	public void setScoreTotal(Integer scoreTotal) {
		this.scoreTotal = scoreTotal;
	}

	public Integer getScoreUp() {
		return this.scoreUp;
	}

	public void setScoreUp(Integer scoreUp) {
		this.scoreUp = scoreUp;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getWidth() {
		return this.width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public List<PoolPost> getPoolPosts() {
		return this.poolPosts;
	}

	public void setPoolPosts(List<PoolPost> poolPosts) {
		this.poolPosts = poolPosts;
	}

	public PoolPost addPoolPost(PoolPost poolPost) {
		getPoolPosts().add(poolPost);
		poolPost.setPost(this);

		return poolPost;
	}

	public PoolPost removePoolPost(PoolPost poolPost) {
		getPoolPosts().remove(poolPost);
		poolPost.setPost(null);

		return poolPost;
	}

	public List<Post> getChildren() {
		return this.children;
	}

	public void setChildren(List<Post> children) {
		this.children = children;
	}

	public Post addChild(Post child) {
		getChildren().add(child);
		child.setParent(child);

		return child;
	}

	public Post removeChild(Post child) {
		getChildren().remove(child);
		child.setParent(null);

		return child;
	}

	public Optional<User> getApprover() {
		return Optional.ofNullable(this.approver);
	}

	public void setApprover(User approver) {
		this.approver = approver;
	}

	public User getUploader() {
		return this.uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}

	public List<Source> getSources() {
		return this.sources;
	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

	public Source addSource(Source source) {
		getSources().add(source);
		source.setPost(this);

		return source;
	}

	public Source removeSource(Source source) {
		getSources().remove(source);
		source.setPost(null);

		return source;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<User> getUsersWithAvatar() {
		return this.usersWithAvatar;
	}

	public void setUsersWithAvatar(List<User> users) {
		this.usersWithAvatar = users;
	}

	public User setAvatarForUser(User user) {
		getUsersWithAvatar().add(user);
		user.setAvatar(this);

		return user;
	}

	public User removeAvatarForUser(User user) {
		getUsersWithAvatar().remove(user);
		user.setAvatar(null);

		return user;
	}

}