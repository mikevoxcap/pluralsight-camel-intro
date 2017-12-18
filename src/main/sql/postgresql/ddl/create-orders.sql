/*
 * PostgreSQL DML for creating the orders database objects for Pluralsight's 
 * course Apache Camel Introduction to Integration. This should be run 
 * for initial setup or when the database needs to be re-loaded. 
 */

drop table if exists orders.orderItem;
drop table if exists orders.orderType;
drop table if exists orders.catalogitem;
drop table if exists orders.customer;

/*
 * Table: Customer
 * Description: Contains the customer information
 */
create table orders.customer (
	id bigserial not null, 
	firstName text not null, 
	lastName text not null, 
	email text not null, 
	primary key (id)
) tablespace pg_default;

/*
 * Table: CatalogItem
 * Description: Contains the catalog item
 */
create table orders.catalogitem (
	id bigserial not null, 
	itemNumber text not null,
	itemName text not null, 
	itemType text not null, 
	primary key (id)
) tablespace pg_default;


/*
 * Table: OrderType
 * Description: Contains base order type details
 */
create table orders.orderType (
	id bigserial not null, 
	customer_id bigint not null,
	orderNumber text not null, 
	timeOrderPlaced timestamp not null,
	lastUpdate timestamp not null, 
	status text not null, 
	primary key (id)
) tablespace pg_default;

alter table orders.orderType add constraint orders_fk_1 foreign key (customer_id) references orders.customer (id);

create table orders.orderItem (
	id bigserial not null, 
	order_id bigint not null, 
	catalogitem_id bigint not null, 
	status text not null, 
	price decimal(20,5), 
	lastUpdate timestamp not null, 
	quantity integer not null, 
	primary key (id)
) tablespace pg_default;

alter table orders.orderItem add constraint orderItem_fk_1 foreign key (order_id) references orders.orderType (id);
alter table orders.orderItem add constraint orderItem_fk_2 foreign key (catalogitem_id) references orders.catalogitem (id);