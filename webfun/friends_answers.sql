-- write a SQL query that returns a list of users along with their friends' names.

SELECT users.first_name, users.last_name, users2.first_name as friend_first_name, users2.last_name as friend_last_name FROM users LEFT JOIN friendships ON users.id=friendships.user_id LEFT JOIN users as users2 ON friendships.friend_id=users2.id;

-- Return all users who are friends with Kermit, make sure their names are displayed in results.
SELECT users.first_name, users.last_name, users2.first_name as friend_first_name, users2.last_name as friend_last_name FROM users LEFT JOIN friendships ON users.id=friendships.user_id LEFT JOIN users as users2 ON friendships.friend_id=users2.id where users.first_name="Kermit";
select * from friendships;
-- select * from users;
 -- Return the count of all friendships
 select count(*) from friendships;
-- Find out who has the most friends and return the count of their friends.
-- Create a new user and make them friends with Eli Byers, Kermit The Frog, and Marky Mark
-- Return the friends of Eli in alphabetical order
-- Remove Marky Mark from Eli’s friends.
-- Return all friendships, displaying just the first and last name of both friends