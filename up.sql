-- DROP TABLE "extension";

CREATE TABLE "extension" (
	id serial NOT NULL,
	"text" varchar NULL,
	CONSTRAINT extension_pk PRIMARY KEY (id)
);

INSERT INTO "extension" (id,"text") VALUES
	 (1,'jpg'),
	 (2,'png'),
	 (3,'webm'),
	 (4,'gif'),
	 (5,'swf');

-- DROP TABLE levels;

CREATE TABLE levels (
	id serial NOT NULL,
	"text" varchar NOT NULL,
	CONSTRAINT levels_pk PRIMARY KEY (id)
);

INSERT INTO levels (id,"text") VALUES
	 (0,'Anonymous'),
	 (10,'Blocked'),
	 (20,'Member'),
	 (30,'Privileged'),
	 (33,'Contributor'),
	 (34,'Former Staff'),
	 (40,'Moderator'),
	 (50,'Admin'),
	 (35,'Janitor');

-- DROP TABLE pools;

CREATE TABLE pools (
	id int4 NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT pools_pk PRIMARY KEY (id)
);

-- DROP TABLE ratings;

CREATE TABLE ratings (
	id serial NOT NULL,
	"text" varchar NOT NULL,
	CONSTRAINT ratings_pk PRIMARY KEY (id)
);

INSERT INTO ratings (id,"text") VALUES
	 (1,'safe'),
	 (2,'questionable'),
	 (3,'explicit');

-- DROP TABLE tag_types;

CREATE TABLE tag_types (
	id int4 NOT NULL DEFAULT nextval('tag_type_id_seq'::regclass),
	"text" varchar NOT NULL,
	CONSTRAINT tag_type_pk PRIMARY KEY (id)
);

-- DROP TABLE users;

CREATE TABLE users (
	id int4 NOT NULL,
	avatar_id int4 NULL,
	level_id int4 NOT NULL,
	"name" varchar NOT NULL,
	created_at timestamp(0) NOT NULL,
	is_banned bool NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id),
	CONSTRAINT users_fk FOREIGN KEY (level_id) REFERENCES levels(id),
    CONSTRAINT users_fk_1 FOREIGN KEY (avatar_id) REFERENCES posts(id)
);

INSERT INTO tag_types (id,"text") VALUES
	 (0,'general'),
	 (1,'artist'),
	 (3,'copyright'),
	 (4,'character'),
	 (5,'species'),
	 (6,'invalid'),
	 (7,'meta'),
	 (8,'lore');

-- DROP TABLE posts;

CREATE TABLE posts (
	id int4 NOT NULL,
	extension_id int4 NOT NULL,
	rating_id int4 NOT NULL,
	approver_id int4 NULL,
	uploader_id int4 NOT NULL,
	parent_id int4 NULL,
	md5 bpchar(32) NOT NULL,
	width int4 NOT NULL,
	height int4 NOT NULL,
	"size" int4 NOT NULL,
	created_at timestamp(0) NOT NULL,
	updated_at timestamp(0) NOT NULL,
	score_up int4 NOT NULL,
	score_down int4 NOT NULL,
	score_total int4 NOT NULL,
	fav_count int4 NOT NULL,
	description text NOT NULL,
	duration float4 NULL,
	CONSTRAINT posts_pk PRIMARY KEY (id),
	CONSTRAINT posts_un UNIQUE (md5),
	CONSTRAINT posts_fk FOREIGN KEY (extension_id) REFERENCES extension(id),
	CONSTRAINT posts_fk_1 FOREIGN KEY (rating_id) REFERENCES ratings(id),
	CONSTRAINT posts_fk_2 FOREIGN KEY (approver_id) REFERENCES users(id),
	CONSTRAINT posts_fk_3 FOREIGN KEY (uploader_id) REFERENCES users(id),
	CONSTRAINT posts_fk_4 FOREIGN KEY (parent_id) REFERENCES posts(id)
);

-- DROP TABLE post_sources;

CREATE TABLE post_sources (
	id int4 NOT NULL DEFAULT nextval('post_sources_id_seq'::regclass),
	post_id int4 NOT NULL,
	"source" varchar NOT NULL,
	CONSTRAINT post_sources_pk PRIMARY KEY (id),
	CONSTRAINT post_sources_fk FOREIGN KEY (post_id) REFERENCES posts(id)
);

-- DROP TABLE tags;

CREATE TABLE tags (
	id int4 NOT NULL,
	tag_type_id int4 NOT NULL,
	"text" varchar NOT NULL,
	CONSTRAINT tags_pk PRIMARY KEY (id),
	CONSTRAINT tags_fk FOREIGN KEY (tag_type_id) REFERENCES tag_types(id)
);

-- DROP TABLE post_file;

CREATE TABLE post_file (
	post_id int4 NOT NULL,
	file bytea NOT NULL,
	CONSTRAINT post_file_pk PRIMARY KEY (post_id),
	CONSTRAINT post_file_fk FOREIGN KEY (post_id) REFERENCES posts(id)
);

-- DROP TABLE pool_posts;

CREATE TABLE pool_posts (
	id serial NOT NULL,
	pool_id int4 NOT NULL,
	post_id int4 NOT NULL,
	"position" int4 NOT NULL,
	CONSTRAINT pool_posts_pk PRIMARY KEY (id),
	CONSTRAINT pool_posts_un UNIQUE (post_id, pool_id),
	CONSTRAINT pool_posts_fk FOREIGN KEY (pool_id) REFERENCES pools(id),
	CONSTRAINT pool_posts_fk_1 FOREIGN KEY (post_id) REFERENCES posts(id)
);

-- DROP TABLE post_children;

CREATE TABLE post_children (
	post_id int4 NOT NULL,
	child_id int4 NOT NULL,
	CONSTRAINT post_children_un UNIQUE (post_id, child_id),
	CONSTRAINT post_children_fk FOREIGN KEY (post_id) REFERENCES posts(id),
	CONSTRAINT post_children_fk_1 FOREIGN KEY (child_id) REFERENCES posts(id)
);

-- DROP TABLE post_tags;

CREATE TABLE post_tags (
	post_id int4 NOT NULL,
	tag_id int4 NOT NULL,
	CONSTRAINT post_tags_un UNIQUE (post_id, tag_id),
	CONSTRAINT post_tags_fk FOREIGN KEY (post_id) REFERENCES posts(id),
	CONSTRAINT post_tags_fk_1 FOREIGN KEY (tag_id) REFERENCES tags(id)
);
