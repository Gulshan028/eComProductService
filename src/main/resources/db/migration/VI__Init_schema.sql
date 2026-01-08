-- V1__init_schema.sql
-- Initial database schema

CREATE TABLE category (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          name VARCHAR(255),
                          PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE jt_instructors (
                                avg_rating FLOAT(53),
                                specialization VARCHAR(255),
                                user_id BIGINT NOT NULL,
                                PRIMARY KEY (user_id)
) ENGINE=InnoDB;

CREATE TABLE jt_mentors (
                            avg_rating FLOAT(53),
                            company_name VARCHAR(255),
                            user_id BIGINT NOT NULL,
                            PRIMARY KEY (user_id)
) ENGINE=InnoDB;

CREATE TABLE jt_tas (
                        no_of_help_requests INTEGER NOT NULL,
                        user_id BIGINT NOT NULL,
                        PRIMARY KEY (user_id)
) ENGINE=InnoDB;

CREATE TABLE jt_users (
                          user_id BIGINT NOT NULL,
                          email VARCHAR(255),
                          name VARCHAR(255),
                          password VARCHAR(255),
                          PRIMARY KEY (user_id)
) ENGINE=InnoDB;

CREATE TABLE msc_instructors (
                                 id BIGINT NOT NULL,
                                 email VARCHAR(255),
                                 name VARCHAR(255),
                                 password VARCHAR(255),
                                 avg_rating FLOAT(53),
                                 specialization VARCHAR(255),
                                 PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE msc_mentors (
                             id BIGINT NOT NULL,
                             email VARCHAR(255),
                             name VARCHAR(255),
                             password VARCHAR(255),
                             avg_rating FLOAT(53),
                             company_name VARCHAR(255),
                             PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE msc_tas (
                         id BIGINT NOT NULL,
                         email VARCHAR(255),
                         name VARCHAR(255),
                         password VARCHAR(255),
                         no_of_help_requests INTEGER NOT NULL,
                         PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE products (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          description VARCHAR(255),
                          image_url VARCHAR(255),
                          price FLOAT(53) NOT NULL,
                          title VARCHAR(255),
                          category_id BIGINT,
                          PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE st_users (
                          user_type INTEGER NOT NULL CHECK ((user_type IN (0,1,2,3))),
                          id BIGINT NOT NULL,
                          email VARCHAR(255),
                          name VARCHAR(255),
                          password VARCHAR(255),
                          avg_rating FLOAT(53),
                          specialization VARCHAR(255),
                          company_name VARCHAR(255),
                          no_of_help_requests INTEGER,
                          PRIMARY KEY (id),
                          CHECK (user_type <> 3 OR (no_of_help_requests IS NOT NULL))
) ENGINE=InnoDB;

CREATE TABLE tpc_instructors (
                                 id BIGINT NOT NULL,
                                 email VARCHAR(255),
                                 name VARCHAR(255),
                                 password VARCHAR(255),
                                 avg_rating FLOAT(53),
                                 specialization VARCHAR(255),
                                 PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tpc_mentors (
                             id BIGINT NOT NULL,
                             email VARCHAR(255),
                             name VARCHAR(255),
                             password VARCHAR(255),
                             avg_rating FLOAT(53),
                             company_name VARCHAR(255),
                             PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tpc_tas (
                         id BIGINT NOT NULL,
                         email VARCHAR(255),
                         name VARCHAR(255),
                         password VARCHAR(255),
                         no_of_help_requests INTEGER NOT NULL,
                         PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tpc_users (
                           id BIGINT NOT NULL,
                           email VARCHAR(255),
                           name VARCHAR(255),
                           password VARCHAR(255),
                           PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Now add the constraints and foreign keys

ALTER TABLE category
    ADD CONSTRAINT UK46ccwnsi9409t36lurvtyljak UNIQUE (name);

ALTER TABLE jt_instructors
    ADD CONSTRAINT FKfcvjoonghpm022veo6us1ifyp
        FOREIGN KEY (user_id)
            REFERENCES jt_users (user_id);

ALTER TABLE jt_mentors
    ADD CONSTRAINT FKjf8q53loch2j5whhm3b4xq2hg
        FOREIGN KEY (user_id)
            REFERENCES jt_users (user_id);

ALTER TABLE jt_tas
    ADD CONSTRAINT FKq53t3mrsynwbnu89l0bmkprsx
        FOREIGN KEY (user_id)
            REFERENCES jt_users (user_id);

ALTER TABLE products
    ADD CONSTRAINT FK1cf90etcu98x1e6n9aks3tel3
        FOREIGN KEY (category_id)
            REFERENCES category (id);