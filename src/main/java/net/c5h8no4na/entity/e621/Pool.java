package net.c5h8no4na.entity.e621;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pools")
public class Pool {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "pool")
    private List<PoolPost> poolPosts;

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<PoolPost> getPoolPosts() {
	return this.poolPosts;
    }

    public void setPoolPosts(List<PoolPost> poolPosts) {
	this.poolPosts = poolPosts;
    }

    public PoolPost addPoolPost(PoolPost poolPost) {
	getPoolPosts().add(poolPost);
	poolPost.setPool(this);

	return poolPost;
    }

    public PoolPost removePoolPost(PoolPost poolPost) {
	getPoolPosts().remove(poolPost);
	poolPost.setPool(null);

	return poolPost;
    }

}