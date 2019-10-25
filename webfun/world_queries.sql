-- 1. What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language and language percentage. Your query should arrange the result by language percentage in descending order. (1)
select countries.name, languages.language, languages.percentage from languages join countries on languages.country_id = countries.id where language = 'Slovene' order by percentage desc;

-- 2. What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order. (3)
select countries.name, count(cities.id) as num_cities from countries join cities on countries.id=cities.country_id group by countries.name order by num_cities desc;
-- 3. What query would you run to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order. (1)
select cities.name, cities.population from cities join countries on countries.id=cities.country_id where countries.name="Mexico" and cities.population>500000 order by cities.population desc;

-- 4. What query would you run to get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order. (1)
select countries.name, languages.language, languages.percentage from countries join languages on countries.id=languages.country_id order by languages.percentage desc;
-- 5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000? (2)
select countries.name from countries where surface_area<501 and population>100000;
-- 6. What query would you run to get countries with only Constitutional Monarchy with a capital greater than 200 and a life expectancy greater than 75 years? (1)
select name from countries where government_form="Constitutional Monarchy" and capital>200 and life_expectancy>75;

-- 7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? The query should return the Country Name, City Name, District and Population. (2)
select countries.name, cities.name as city, cities.district, cities.population from countries join cities on countries.id=cities.country_id where countries.name="Argentina" and cities.district="Buenos Aires" and cities.population>500000;
-- 8. What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order. (2)
select region, count(id) as num_countries from countries group by region order by num_countries desc;
