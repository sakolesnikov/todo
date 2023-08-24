CREATE TABLE TODO (
   id UUID DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY,
   title VARCHAR(256) NOT NULL,
   description VARCHAR(512) NOT NULL
);

insert into TODO(title, description) values('title0', 'description0');