-- write a SQL query that returns a list of users along with their friends' names.

SELECT users.first_name, users.last_name, users2.first_name as friend_first_name, users2.last_name as friend_last_name FROM users LEFT JOIN friendships ON users.id=friendships.user_id LEFT JOIN users as users2 ON friendships.friend_id=users2.id;

-- Return all users who are friends with Kermit, make sure their names are displayed in results.
SELECT users.first_name, users.last_name, users2.first_name as friend_first_name, users2.last_name as friend_last_name FROM users LEFT JOIN friendships ON users.id=friendships.user_id LEFT JOIN users as users2 ON friendships.friend_id=users2.id where users.first_name="Kermit";
select * from friendships;
-- select * from users;
 -- Return the count of all friendships
 select count(*) from friendships;
-- Find out who has the most friends and return the count of their friends.
-- select max(num_friends) from (select user_id, count(*) as num_friends from friendships group by user_id) as a;
-- Create a new user and make them friends with Eli Byers, Kermit The Frog, and Marky Mark
-- insert into users (first_name, last_name, created_at, updated_at) values ("JK", "Rowling", NOW(), NOW());
-- insert into friendships (user_id, friend_id, created_at, updated_at) values (6,5,NOW(),NOW());
select * from friendships;
-- Return the friends of Eli in alphabetical order
SELECT users2.first_name as friend_first_name, users2.last_name as friend_last_name FROM users LEFT JOIN friendships ON users.id=friendships.user_id LEFT JOIN users as users2 ON friendships.friend_id=users2.id where users.first_name="Eli" order by friend_first_name asc;

-- Remove Marky Mark from Eli’s friends.
delete from friendships where friend_id = (select id from users where first_name="Marky") and user_id = (select id from users where first_name="Eli");
select * from friendships;
-- Return all friendships, displaying just the first and last name of both friends
-- SELECT users.first_name, users.last_name, users2.first_name as friend_first_name, users2.last_name as friend_last_name FROM users JOIN friendships ON users.id=friendships.user_id JOIN users as users2 ON friendships.friend_id=users2.id;
