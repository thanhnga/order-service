-- chain/shop
INSERT INTO chain(chain_name) SELECT '101 Digital Coffee Shop' WHERE NOT EXISTS (SELECT * FROM chain WHERE chain_id=1);

-- location
INSERT INTO location(chain_id,location_name, address, district, city, country, phone, latitude, longitude)
SELECT 1, '101 Digital Coffee Shop Singapore', '3 INTERNATIONAL BUSINESS PARK 03-27 NORDIC EUROPEAN CENTRE', 'Singapore', 'Singapore', 'Singapore', '+6565675873', '0.0', '0.0'
    WHERE NOT EXISTS (SELECT * FROM location WHERE location_id=1);

-- opening_hours
INSERT INTO operating_hour(location_id, day_of_week, opening_time, closing_time ) SELECT  1, 'MONDAY', '08:00:00', '17:00:00' WHERE NOT EXISTS (SELECT * FROM operating_hour WHERE hours_id=1);

--location_queue
INSERT INTO location_queue (location_id, max_queue_size, average_wait_time)
SELECT 1, 10, 3 WHERE NOT EXISTS (SELECT * FROM location_queue WHERE queue_id=1);

-- user
INSERT INTO users(name, address, email, phone_number, role, status, username, password) SELECT 'Super Admin', 'vietnam', 'owner@gmail.com', '0983484419', 'OWNER', 'ACTIVE', 'owner', '$2a$10$6wzb.6aS0hv5y2S4wQo32OAPQbUKCnB58jJpijW4eONL94y/Dtq2e' WHERE NOT EXISTS (SELECT * FROM users WHERE username='owner');
INSERT INTO users(location_id, name, address, email, phone_number, role, status, username, password) SELECT 1, 'Operator admin of Singapore','vietnam', 'operator@gmail.com', '0983484419', 'OPERATOR', 'ACTIVE', 'operator', '$2a$10$fYNdKYQr31PosiR6jiZwue34pz77eH00Qb8iuGS6wD630.yjh3sum' WHERE NOT EXISTS (SELECT * FROM users WHERE username='operator');

-- category
INSERT INTO category(category_name, description) SELECT 'Coffee', 'coffee category' WHERE NOT EXISTS (SELECT * FROM category WHERE category_id=1);

-- item
INSERT INTO item(item_name, description, price) SELECT 'Black Coffee', 'black coffee', '1.5' WHERE NOT EXISTS (SELECT * FROM item WHERE item_id=1);
INSERT INTO item(item_name, description, price) SELECT 'Milk Coffee', 'milk coffee', '2.0' WHERE NOT EXISTS (SELECT * FROM item WHERE item_id=2);

-- item_category
INSERT INTO item_category(category_id, item_id) SELECT 1,1 WHERE NOT EXISTS (SELECT * FROM item_category WHERE category_id=1 and item_id=1);
INSERT INTO item_category(category_id, item_id) SELECT 1,2 WHERE NOT EXISTS (SELECT * FROM item_category WHERE category_id=1 and item_id=2);

-- menu
INSERT INTO menu(menu_name, description) SELECT 'Base Coffee Menu', 'base coffee menu of chain/chain' WHERE NOT EXISTS (SELECT * FROM menu WHERE menu_id=1);
INSERT INTO menu(location_id, menu_name, description) SELECT 1, 'Singapore Coffee Menu', ' coffee menu of Singapore location' WHERE NOT EXISTS (SELECT * FROM menu WHERE menu_id=2);

-- menu_item
INSERT INTO menu_item(menu_id, item_id) SELECT 1, 1 WHERE NOT EXISTS (SELECT * FROM menu_item WHERE menu_id=1 and item_id=1);
INSERT INTO menu_item(menu_id, item_id) SELECT 1, 2 WHERE NOT EXISTS (SELECT * FROM menu_item WHERE menu_id=1 and item_id=2);
INSERT INTO menu_item(menu_id, item_id) SELECT 2, 2 WHERE NOT EXISTS (SELECT * FROM menu_item WHERE menu_id=2 and item_id=2);

-- customer
INSERT INTO customer(customer_name, email, phone_number, home_address, total_order)
SELECT 'Nga Nguyen', 'nganguyen@gmail.com', '84983484419', 'vietnam', 0
WHERE NOT EXISTS (SELECT * FROM customer WHERE customer_id=1);

-- orders
INSERT INTO orders (customer_id, location_id, queue_id, order_date, status)
SELECT 1, 1, 1, '2023-10-01 14:30:00', 'WAITING' WHERE NOT EXISTS (SELECT * FROM orders WHERE order_id=1);

-- order_item
INSERT INTO order_item(order_id, item_id) SELECT 1,1 WHERE NOT EXISTS (SELECT * FROM order_item WHERE order_id=1 and item_id=1);
INSERT INTO order_item(order_id, item_id) SELECT 1,2 WHERE NOT EXISTS (SELECT * FROM order_item WHERE order_id=1 and item_id=2);