package net.c5h8no4na.entity.e621;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.c5h8no4na.entity.e621.enums.Extension;
import net.c5h8no4na.entity.e621.enums.Rating;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    private Integer id;

    @Column(name = "extension_id")
    private Extension extension;

    @Column(name = "rating_id")
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "approver_id")
    private User approver;

    @ManyToOne
    @JoinColumn(name = "uploader_id")
    private User uploader;

    @Column(name = "parent_id")
    private Integer parentId;

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

    private float duration;

    private byte[] image;

    @ManyToMany
    @JoinTable(name = "post_children", joinColumns = {
	    @JoinColumn(name = "post_id", referencedColumnName = "id") }, inverseJoinColumns = {
		    @JoinColumn(name = "child_id", referencedColumnName = "id") })
    private List<Post> children;

    @OneToMany(mappedBy = "post")
    private List<Source> sources;

    @ManyToMany(mappedBy = "posts")
    private List<Tag> tags;

    @OneToMany(mappedBy = "post")
    private List<PoolPost> poolPosts;

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

    public float getDuration() {
	return this.duration;
    }

    public void setDuration(float duration) {
	this.duration = duration;
    }

    public Extension getExtension() {
	return this.extension;
    }

    public void setExtensionId(Extension extension) {
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

    public byte[] getImage() {
	return this.image;
    }

    public void setImage(byte[] image) {
	this.image = image;
    }

    public String getMd5() {
	return this.md5;
    }

    public void setMd5(String md5) {
	this.md5 = md5;
    }

    public Integer getParentId() {
	return this.parentId;
    }

    public void setParentId(Integer parentId) {
	this.parentId = parentId;
    }

    public Rating getRating() {
	return this.rating;
    }

    public void setRatingId(Rating rating) {
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
	child.setParentId(child.getId());

	return child;
    }

    public Post removeChild(Post child) {
	getChildren().remove(child);
	child.setParentId(null);

	return child;
    }

    public User getApprover() {
	return this.approver;
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

}