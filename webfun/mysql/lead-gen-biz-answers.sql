-- 1. What query would you run to get the total revenue for March of 2012?
SELECT sum(amount) from billing where charged_datetime >= '2012/03/01' AND charged_Datetime < '2012/03/31';
-- 2. What query would you run to get total revenue collected from the client with an id of 2?
SELECT sum(amount) from billing where client_id=2;
-- 3. What query would you run to get all the sites that client=10 owns?
select domain_name from sites where client_id=10;
-- 4. What query would you run to get total # of sites created per month per year for the client with an id of 1? What about for client=20?
select client_id, count(site_id), month(created_datetime) as M, year(created_datetime) as Y from sites group by M, Y, client_id;
-- 5. What query would you run to get the total # of leads generated for each of the sites between January 1, 2011 to February 15, 2011?
select site_id, count(*) from leads where registered_datetime <'2011/02/15' and registered_datetime>'2011/01/01' group by site_id ;
-- 6. What query would you run to get a list of client names and the total # of leads we've generated for each of our clients between January 1, 2011 to December 31, 2011?
select c.first_name as first_name, c.last_name as last_name, count(leads_id) as leads from clients as c join sites as s on c.client_id=s.client_id join leads as l on s.site_id=l.site_id where l.registered_datetime <'2011/12/31' and l.registered_datetime >'2011/01/01' group by c.client_id;
-- 7. What query would you run to get a list of client names and the total # of leads we've generated for each client each month between months 1 - 6 of Year 2011?
select c.first_name as first_name, c.last_name as last_name, count(l.leads_id) as leads, month(l.registered_datetime) as m from clients as c join sites as s on c.client_id=s.client_id join leads as l on s.site_id=l.site_id where year(l.registered_datetime)='2011' and month(l.registered_datetime)>=1 and month(l.registered_datetime)<=6 group by c.client_id, m;
-- 8. What query would you run to get a list of client names and the total # of leads we've generated for each of our clients' sites between January 1, 2011 to December 31, 2011? Order this query by client id.  Come up with a second query that shows all the clients, the site name(s), and the total number of leads generated from each site for all time.
select c.first_name as first_name, c.last_name as last_name, count(l.leads_id) as leads from clients as c join sites as s on c.client_id=s.client_id join leads as l on s.site_id=l.site_id where l.registered_datetime <'2011/12/31' and l.registered_datetime >='2011/01/01'  group by c.client_id;
select c.first_name as first_name, c.last_name as last_name, s.domain_name, count(l.leads_id) as leads from clients as c join sites as s on c.client_id=s.client_id join leads as l on s.site_id=l.site_id group by c.client_id, s.domain_name;

-- 9. Write a single query that retrieves total revenue collected from each client for each month of the year. Order it by client id.
select client_id, month(charged_datetime) as month, year(charged_datetime) as year, sum(amount) from billing group by client_id, month, year order by client_id;
-- 10. Write a single query that retrieves all the sites that each client owns. Group the results so that each row shows a new client. It will become clearer when you add a new field called 'sites' that has all the sites that the client owns. (HINT: use GROUP_CONCAT)
select c.first_name as first_name, c.last_name as last_name, group_concat(' ',s.domain_name) from clients as c join sites s on c.client_id=s.client_id group by c.client_id;