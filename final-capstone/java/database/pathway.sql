CREATE TABLE technical_questions (
id SERIAL,
response VARCHAR(200),

CONSTRAINT pk_technical_questions primary key (id)

);

INSERT INTO technical_questions (response) VALUES ('What is a class?');
INSERT INTO technical_questions (response) VALUES ('What is an object?');
INSERT INTO technical_questions (response) VALUES ('What is a method?');
INSERT INTO technical_questions (response) VALUES ('What is the difference between reference and primitive datatypes');
INSERT INTO technical_questions (response) VALUES ('Can you explain the principles of OOP?');
INSERT INTO technical_questions (response) VALUES ('What is inheritence?');
INSERT INTO technical_questions (response) VALUES ('Can you explain encapsulation?');
INSERT INTO technical_questions (response) VALUES ('Describe normalization.');
INSERT INTO technical_questions (response) VALUES ('What is a primary key?');
INSERT INTO technical_questions (response) VALUES ('What is a foreign key?');
INSERT INTO technical_questions (response) VALUES ('Describe the difference between Java and JavaScript.');
INSERT INTO technical_questions (response) VALUES ('What is a relational database?');
INSERT INTO technical_questions (response) VALUES ('Can you give some common HTML tags?');
INSERT INTO technical_questions (response) VALUES ('Give an example of how you have used Spring Boot.');
INSERT INTO technical_questions (response) VALUES ('Explain the difference between HTML, CSS, and JavaScript');
INSERT INTO technical_questions (response) VALUES ('What is an SPA?');

