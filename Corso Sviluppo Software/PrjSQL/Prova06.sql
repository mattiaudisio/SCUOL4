SELECT sakila.customer.first_name as Nome,sakila.customer.last_name as Cognome,sakila.address.address as Indirizzo, sakila.city.city as Città, sakila.address.postal_code as CAP
FROM sakila.customer, sakila.address
INNER join sakila.city
WHERE sakila.customer.address_id = sakila.address.address_id
AND sakila.address.city_id = sakila.city.city_id
AND customer.last_name LIKE "WI%";
