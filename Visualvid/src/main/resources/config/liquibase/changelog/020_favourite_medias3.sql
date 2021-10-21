create table PUBLIC.favourite_medias (
id UUID PRIMARY KEY,
media_id UUID NOT NULL,
user_id UUID NOT NULL,
slide_namslide_name VARCHAR(100),
created_date TIMESTAMP,
last_modified_date TIMESTAMP,
created_by VARCHAR(30),
last_modified_by VARCHAR(30)
);

ALTER TABLE PUBLIC.favourite_medias ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES PUBLIC.jhi_user(id);
