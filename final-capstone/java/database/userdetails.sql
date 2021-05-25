CREATE TABLE userdetails(
   user_id serial NOT NULL,
   firstname varchar(50) NOT NULL,
   lastname varchar(50) NOT NULL,
   emailid varchar(50) NOT NULL,
   contactnumber integer NOT NULL,
   isstudent  boolean NOT NULL,
   CONSTRAINT fk_userdetails_user_id FOREIGN KEY(user_id) REFERENCES users(user_id)   
);

ALTER TABLE userdetails
ADD PRIMARY KEY (user_id);

ALTER TABLE userdetails
DROP COLUMN id;

