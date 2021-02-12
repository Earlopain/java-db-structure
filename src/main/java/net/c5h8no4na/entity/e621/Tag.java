package net.c5h8no4na.entity.e621;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import net.c5h8no4na.entity.e621.enums.TagType;

@Entity
@Table(name = "tags")
public class Tag {

	@Id
	private Integer id;

	@Column(name = "tag_type_id")
	private TagType tagType;

	private String text;

	@ManyToMany
	@JoinTable(name = "post_tags", joinColumns = { @JoinColumn(name = "tag_id") }, inverseJoinColumns = { @JoinColumn(name = "post_id") })
	private List<Post> posts = new ArrayList<>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TagType getTagType() {
		return this.tagType;
	}

	public void setTagType(TagType tagType) {
		this.tagType = tagType;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}