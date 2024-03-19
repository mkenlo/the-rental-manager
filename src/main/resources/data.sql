insert into role(name, display_name, description, base_url, role_type) values ("ROLE_ADMIN", "admin", "Role defined for Administrators", "/admin", "admin");
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_LANDLORD", "landlord", "Role defined for Landlords or HomeOwners", "/owner", "user");
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_MANAGER", "manager", "Role defined for Property Managers", "/manager", "user");
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_RESIDENT", "resident", "Role defined for RESIDENT or TENANT", "/resident", "user");
insert into role(name, display_name, description, base_url, role_type) values ("ROLE_APPLICANT", "guest or future resident", "Role defined for Guest or Future Resident", "/applicant", "user");


insert into user(email,firstname,lastname,password,username) values 
("admin@test.com","admin","user","$2a$10$RjD8BIzTLySld8ntF6xq5OK7QxlduNTkAwnJHaoxeU3LpJxjWy582","thisisadmin");

insert into users_roles(user_id, role_id) values (1, 1);