-- Load catalog items
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('078-1344200444', 'Build Your Own JavaScript Framework Framework in Just 24 Hours', 'Book');
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('222-5452210433', 'Object-Oriented Cobol - The Future of Programming', 'Book');
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('516-5982748121', 'There is a Thunderstorm in My Private Cloud', 'Book');
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('048-8273591782', '5,428,101 Things Every Programmer Must Know', 'Book');
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('091-7282346816', 'Java Applets: Through the Eyes of the Criminally Insane', 'Book');
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('329918349', 'Yellow Notepad', 'Office Product');	
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('44910432221', 'Number 2 Pencil', 'Office Product');		
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('28342227', 'Generic Eraser', 'Office Product');
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('0128381', 'Headphones', 'Audio');	
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('4818', 'Microphone', 'Audio');	
insert into orders.catalogitem (itemnumber, itemname, itemtype) 
	values ('69191882', 'Speakers', 'Audio');
	
-- Load customers
insert into orders.customer (firstname, lastname, email) values ('Michael', 'Hoffman', 'mike@michaelhoffmaninc.com');
insert into orders.customer (firstname, lastname, email) values ('John', 'Smith', 'john@somewhere.com');
insert into orders.customer (firstname, lastname, email) values ('Jane', 'Smith', 'jane@somehow.com');
insert into orders.customer (firstname, lastname, email) values ('Jeff', 'Chan', 'john@someway.com');
insert into orders.customer (firstname, lastname, email) values ('Ron', 'River', 'ron@goodbye.com');
insert into orders.customer (firstname, lastname, email) values ('Larry', 'Horse', 'larry@hello.com');

-- Load orders
insert into orders.order (customer_id, orderNumber, timeorderplaced, lastupdate, status) 
	values ((select id from orders.customer where email = 'mike@michaelhoffmaninc.com'), 
		'1001', CURRENT_TIMESTAMP - INTERVAL '1 day', CURRENT_TIMESTAMP - INTERVAL '1 day', 'N');
insert into orders.order (customer_id, orderNumber, timeorderplaced, lastupdate, status) 
	values ((select id from orders.customer where email = 'john@somewhere.com'), 
		'1002', CURRENT_TIMESTAMP - INTERVAL '1 day', CURRENT_TIMESTAMP - INTERVAL '1 day', 'N');
insert into orders.order (customer_id, orderNumber, timeorderplaced, lastupdate, status) 
	values ((select id from orders.customer where email = 'jane@somehow.com'), 
		'1003', CURRENT_TIMESTAMP - INTERVAL '1 day', CURRENT_TIMESTAMP - INTERVAL '1 day', 'N');
insert into orders.order (customer_id, orderNumber, timeorderplaced, lastupdate, status) 
	values ((select id from orders.customer where email = 'john@someway.com'), 
		'1004', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'N');
insert into orders.order (customer_id, orderNumber, timeorderplaced, lastupdate, status) 
	values ((select id from orders.customer where email = 'ron@goodbye.com'), 
		'1005', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'N');
insert into orders.order (customer_id, orderNumber, timeorderplaced, lastupdate, status) 
	values ((select id from orders.customer where email = 'larry@hello.com'), 
		'1006', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'N');
insert into orders.order (customer_id, orderNumber, timeorderplaced, lastupdate, status) 
	values ((select id from orders.customer where email = 'mike@michaelhoffmaninc.com'), 
		'1007', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'N');

-- Load order items
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1001'), 
		(select id from orders.catalogitem where itemnumber = '078-1344200444'), 'N', 20.00, 1, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1001'), 
		(select id from orders.catalogitem where itemnumber = '44910432221'), 'N', 1.25, 10, CURRENT_TIMESTAMP);		
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1002'), 
		(select id from orders.catalogitem where itemnumber = '078-1344200444'), 'N', 20.00, 1, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1003'), 
		(select id from orders.catalogitem where itemnumber = '078-1344200444'), 'N', 20.00, 1, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1004'), 
		(select id from orders.catalogitem where itemnumber = '222-5452210433'), 'N', 40.00, 1, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1004'), 
		(select id from orders.catalogitem where itemnumber = '329918349'), 'N', 2.50, 15, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1004'), 
		(select id from orders.catalogitem where itemnumber = '69191882'), 'N', 101.10, 1, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1005'), 
		(select id from orders.catalogitem where itemnumber = '078-1344200444'), 'N', 20.00, 3, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1006'), 
		(select id from orders.catalogitem where itemnumber = '329918349'), 'N', 2.50, 1, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1007'), 
		(select id from orders.catalogitem where itemnumber = '0128381'), 'N', 65.99, 2, CURRENT_TIMESTAMP);
insert into orders.orderitem (order_id, catalogitem_id, status, price, quantity, lastupdate)
	values ((select id from orders.order where orderNumber = '1004'), 
		(select id from orders.catalogitem where itemnumber = '69191882'), 'N', 101.10, 1, CURRENT_TIMESTAMP);
