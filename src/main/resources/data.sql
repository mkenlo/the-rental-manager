/*
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_ADMIN", "admin", "Role defined for Administrators", "/admin", "admin");
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_LANDLORD", "landlord", "Role defined for Landlords or HomeOwners", "/owner", "user");
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_MANAGER", "manager", "Role defined for Property Managers", "/manager", "user");
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_RESIDENT", "resident", "Role defined for RESIDENT or TENANT", "/resident", "user");
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_APPLICANT", "guest or future resident", "Role defined for Guest or Future Resident", "/applicant", "user");


insert into user(email,firstname,lastname,password,username) values 
("admin@test.com","admin","user","$2a$10$RjD8BIzTLySld8ntF6xq5OK7QxlduNTkAwnJHaoxeU3LpJxjWy582","thisisadmin");

insert into users_roles(user_id, role_id) values (1, 1);


insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Sparrow, rufous-collared', '769 Huxley Street', 'imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam', 4, 3, 2509, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Blue peacock', '8114 Loeprich Center', 'in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus', 1, 1, 6969, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Lion, galapagos sea', '50 Mayfield Park', 'volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla', 6, 3, 4646, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Deer, black-tailed', '24 1st Road', 'molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam', 3, 4, 6227, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Cape fox', '69 Talmadge Alley', 'feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet', 5, 4, 8660, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Mallard', '824 Londonderry Street', 'ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae', 3, 2, 6975, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Gazer, sun', '90901 Park Meadow Park', 'elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus', 6, 4, 9405, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Long-billed corella', '66625 Helena Way', 'sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit', 2, 1, 3923, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Heron, grey', '519 Everett Trail', 'cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam', 4, 1, 3493, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Goat, mountain', '3 Reindahl Place', 'consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at', 3, 3, 601, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Ovenbird', '6 Hovde Plaza', 'vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum', 1, 1, 2248, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Bat-eared fox', '0670 Dottie Hill', 'mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus', 8, 3, 962, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Grenadier, common', '9 Hoard Road', 'non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci', 4, 2, 4751, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Skink, blue-tongued', '5359 Clarendon Terrace', 'sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum', 1, 4, 4075, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Long-billed corella', '50 Cherokee Lane', 'aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse', 7, 1, 9115, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Eagle, pallas''s fish', '4 Lake View Hill', 'vestibulum proin eu mi nulla ac enim in tempor turpis', 6, 1, 1608, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Armadillo, seven-banded', '9717 South Hill', 'pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus', 2, 5, 3730, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Woodpecker, downy', '93 Messerschmidt Point', 'elit proin risus praesent lectus vestibulum quam sapien varius ut blandit non interdum in ante vestibulum ante ipsum primis', 4, 4, 6799, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Tsessebe', '7424 Lindbergh Court', 'platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque', 6, 2, 2539, 1,6,2500);
insert into property (name, address, description, num_bed, num_bath, surface, owner_id,min_lease_length,min_lease_price) values ('Trumpeter, green-winged', '8 Katie Road', 'sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec', 4, 1, 8109, 3,6,2500);
*/