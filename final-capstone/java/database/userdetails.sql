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

--Insert into userdetails
INSERT INTO userdetails (user_id,firstname,lastname,emailid,contactnumber,isstudent) VALUES (3,'Ron','Fleming','ronf@gmail.com',469321456,true);
INSERT INTO userdetails (user_id,firstname,lastname,emailid,contactnumber,isstudent) VALUES (?,?,?,?,?,?);