
create table PUBLIC.cart_info (
id UUID PRIMARY KEY,
media_id UUID NOT NULL,
user_id UUID NOT NULL,
media_name VARCHAR(30),
created_date TIMESTAMP,
last_modified_date TIMESTAMP,
created_by VARCHAR(30),
last_modified_by VARCHAR(30)
);

ALTER TABLE PUBLIC.cart_info ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES PUBLIC.jhi_user(id);
