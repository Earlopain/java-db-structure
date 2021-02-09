package net.c5h8no4na.entity.e621;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pool_posts")

public class PoolPost {
    
    @Id
    private Integer id;

    @ManyToOne
    private Pool pool;

    @ManyToOne
    private Post post;

    private Integer position;

    public Integer getPosition() {
	return this.position;
    }

    public void setPosition(Integer position) {
	this.position = position;
    }

    public Pool getPool() {
	return this.pool;
    }

    public void setPool(Pool pool) {
	this.pool = pool;
    }

    public Post getPost() {
	return this.post;
    }

    public void setPost(Post post) {
	this.post = post;
    }

}