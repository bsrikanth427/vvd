CREATE TABLE PUBLIC.databasechangeloglock 
  ( 
     id          INT NOT NULL, 
     locked      BOOLEAN NOT NULL, 
     lockgranted TIMESTAMP, 
     lockedby    VARCHAR(255), 
     CONSTRAINT pk_databasechangeloglock PRIMARY KEY (id) 
  );


CREATE TABLE PUBLIC.databasechangelog 
  ( 
     id            VARCHAR(255) NOT NULL, 
     author        VARCHAR(255) NOT NULL, 
     filename      VARCHAR(255) NOT NULL, 
     dateexecuted  TIMESTAMP NOT NULL, 
     orderexecuted INT NOT NULL, 
     exectype      VARCHAR(10) NOT NULL, 
     md5sum        VARCHAR(35), 
     description   VARCHAR(255), 
     comments      VARCHAR(255), 
     tag           VARCHAR(255), 
     liquibase     VARCHAR(20), 
     contexts      VARCHAR(255), 
     labels        VARCHAR(255), 
     deployment_id VARCHAR(10) 
  ); 
  

  
CREATE SEQUENCE public.sequence_generator 
  START WITH 5 
  INCREMENT BY 1;
  
 INSERT INTO PUBLIC.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) 
 VALUES ('00000000000000', 'jhipster', 'config/liquibase/changelog/00000000000000_initial_schema.xml', NOW(), 1, '8:b8c27d9dc8db18b5de87cdb8c38a416b', 'createSequence sequenceName=sequence_generator', '', 'EXECUTED', NULL, NULL, '3.9.0', '0619264042');

CREATE TABLE PUBLIC.jhi_user 
  ( 
     id                 BIGINT NOT NULL, 
     login              VARCHAR(50) NOT NULL, 
     password_hash      VARCHAR(60), 
     first_name         VARCHAR(50), 
     last_name          VARCHAR(50), 
     email              VARCHAR(191), 
     image_url          VARCHAR(256), 
     activated          BOOLEAN NOT NULL, 
     lang_key           VARCHAR(10), 
     activation_key     VARCHAR(20), 
     reset_key          VARCHAR(20), 
     created_by         VARCHAR(50) NOT NULL, 
     created_date       TIMESTAMP, 
     reset_date         TIMESTAMP, 
     last_modified_by   VARCHAR(50), 
     last_modified_date TIMESTAMP, 
     CONSTRAINT pk_jhi_user PRIMARY KEY (id), 
     CONSTRAINT ux_user_email UNIQUE (email), 
     CONSTRAINT ux_user_login UNIQUE (login) 
  ); 
  
  CREATE TABLE PUBLIC.jhi_authority 
  ( 
     NAME VARCHAR(50) NOT NULL, 
     CONSTRAINT pk_jhi_authority PRIMARY KEY (NAME) 
  );
  CREATE TABLE PUBLIC.jhi_role 
  ( 
     NAME VARCHAR(50) NOT NULL, 
     CONSTRAINT pk_jhi_role PRIMARY KEY (NAME) 
  );
  
  CREATE TABLE PUBLIC.jhi_user_role 
  ( 
     user_id   BIGINT NOT NULL, 
     role_name VARCHAR(50) NOT NULL 
  );
  
  CREATE TABLE PUBLIC.jhi_role_authority 
  ( 
     role_name      VARCHAR(50) NOT NULL, 
     authority_name VARCHAR(50) NOT NULL 
  );
  
  ALTER TABLE PUBLIC.jhi_user_role ADD PRIMARY KEY (user_id, role_name);
  ALTER TABLE PUBLIC.jhi_role_authority ADD PRIMARY KEY (role_name, authority_name);
  ALTER TABLE PUBLIC.jhi_user_role ADD CONSTRAINT fk_role_name FOREIGN KEY (role_name) REFERENCES PUBLIC.jhi_role (name);
  ALTER TABLE PUBLIC.jhi_role_authority ADD CONSTRAINT fk_authority_name FOREIGN KEY (authority_name) REFERENCES PUBLIC.jhi_authority (name);
  ALTER TABLE PUBLIC.jhi_user_role ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES PUBLIC.jhi_user (id);
  ALTER TABLE PUBLIC.jhi_user ALTER COLUMN password_hash SET NOT NULL;

 INSERT INTO PUBLIC.jhi_user(id, login, password_hash, first_name, last_name, email, image_url, activated, lang_key, created_by, last_modified_by) 
 VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
 
 ALTER TABLE PUBLIC.jhi_user ALTER COLUMN  created_date SET DEFAULT NULL;
 INSERT INTO PUBLIC.jhi_role(name) VALUES(?);
 INSERT INTO PUBLIC.jhi_authority(name) VALUES(?);
 INSERT INTO PUBLIC.jhi_user_role(user_id, role_name) VALUES(?, ?);
 INSERT INTO PUBLIC.jhi_role_authority(role_name, authority_name) VALUES(?, ?);
 CREATE TABLE PUBLIC.jhi_persistent_audit_event 
  ( 
     event_id   BIGINT NOT NULL, 
     principal  VARCHAR(50) NOT NULL, 
     event_date TIMESTAMP, 
     event_type VARCHAR(255), 
     CONSTRAINT pk_jhi_persistent_audit_event PRIMARY KEY (event_id) 
  );
  
  CREATE TABLE PUBLIC.jhi_persistent_audit_evt_data 
  ( 
     event_id BIGINT NOT NULL, 
     NAME     VARCHAR(150) NOT NULL, 
     value    VARCHAR(255) 
  );
   ALTER TABLE PUBLIC.jhi_persistent_audit_evt_data ADD PRIMARY KEY (event_id, name);
   CREATE INDEX PUBLIC.idx_persistent_audit_event ON PUBLIC.jhi_persistent_audit_event(principal, event_date);
   CREATE INDEX PUBLIC.idx_persistent_audit_evt_data ON PUBLIC.jhi_persistent_audit_evt_data(event_id);
   ALTER TABLE PUBLIC.jhi_persistent_audit_evt_data ADD CONSTRAINT fk_evt_pers_audit_evt_data FOREIGN KEY (event_id) REFERENCES PUBLIC.jhi_persistent_audit_event (event_id);
   
   INSERT INTO PUBLIC.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) 
   VALUES ('00000000000001', 'jhipster', 'config/liquibase/changelog/00000000000000_initial_schema.xml', NOW(), 2, '8:b7397351cd15e88c5404e394e884dd63', 'createTable tableName=jhi_user; createTable tableName=jhi_authority; createTable tableName=jhi_role; createTable tableName=jhi_user_role; createTable tableName=jhi_role_authority; addPrimaryKey tableName=jhi_user_role; addPrimaryKey tableName=jhi_...', '', 'EXECUTED', NULL, NULL, '3.9.0', '0619264042');
  