## web.demo2b

### Create webshoppe Schema
```
CREATE USER webshoppe IDENTIFIED BY webshoppe;
GRANT CONNECT TO webshoppe;
GRANT CONNECT, RESOURCE, DBA TO webshoppe;
GRANT create session TO webshoppe;
GRANT create table TO webshoppe;
GRANT create view TO webshoppe;
GRANT create any trigger TO webshoppe;
GRANT create any procedure TO webshoppe;
GRANT create sequence TO webshoppe;
GRANT create synonym TO webshoppe;
GRANT UNLIMITED TABLESPACE TO webshoppe;
```

### Execute SQL
```
create table Authors
(
AID char(10),
PRIMARY KEY(AID),
AName varchar(50) not null ,
AAge int,
ACountry varchar(30),
AMail varchar(50),
APhone char(12)
);

create table BooksDetails
(
BID char(10),
Primary Key (BID),
Title varchar(50) not null ,
BookDesc varchar(100),
AID char(10),
FOREIGN KEY (AID) REFERENCES AUTHORS(AID),
BookPrice int not null
);

create table CustomerDetails
(CustID char(10),
Primary Key(CustID),
CustName char(30) not null,
CustAge int not null,
Phone char(20)not null,
email char(40)not null,
Country char(50)not null
);

create table FlowersDetails
(
FID char(10),
Primary Key (FID),
FName varchar(50) not null,
FDesc varchar(100),
FPrice int not null
);

create table OrderDetails
(
InvID char(10),
Primary Key (InvID),
InvDate char(10) not null,
PID char(10) not null,
CID char(10),
FOREIGN KEY (CID) REFERENCES CustomerDetails(CustID),
Qty int not null,
Price int not null,
TotalPrice int not null,
CCCompany char(30) not null,
CCNumber char(30) not null
);

create table ToysDetails
(
TID char(10),
Primary Key(TID),
TName varchar(50) not null,
TDesc varchar(100),
TPrice int not null
);

insert into Authors values('A001','Katherine Kanes',41,'America','kn@yahoo.com','34-89-09');
insert into Authors values('A002','Jonty Kolkar',34,'Australia','jnt@hotmail.com','34-33-78');
insert into Authors values('A003','Sandy Artherson',32,'South Africa','san@yahoo.com','32-66-77');
insert into Authors values('A004','Steve Walsh',37,'America','stevec@yahoo.com','12-00-67');
insert into Authors values('A005','Anderson Robin',30,'Australia','andy@hotmail.com','51-71-43');
insert into Authors values('A006','Danniel Steller',36,'Florida','dan@hotmail.com','21-44-44');
insert into Authors values('A007','Rosemerry Kanes',31,'France','rsm@yahoo.com','23-08-98');
insert into Authors values('A008','Collin Robinson',40,'France','col@hotmail.com','45-98-76');
insert into Authors values('A009','Goerge Clinton',35,'America','gr2@hotmail.com','32-09-56');
insert into Authors values('A010','Julia Kolkar',31,'Australia','jkl@yahoo.com','43-98-76');

/*inserting data in the BooksDetails table*/
insert into BooksDetails values('B001','Journey to White House','A suspense thriller','A006',21);
insert into BooksDetails values('B002','Good For You','A romantic novel','A001',30);
insert into BooksDetails values('B003','Healthy Tips','Keeps you fit and fine','A010',30);
insert into BooksDetails values('B004','Bed Night Stories','Perfect day end for a child','A007',16);
insert into BooksDetails values('B005','Fallen Dreams','A story about two sisters','A010',62);
insert into BooksDetails values('B006','Journey to White House','A suspense thriller','A009',76);
insert into BooksDetails values('B007','Rich Bad Guys','A true story about todays society','A004',55);
insert into BooksDetails values('B008','Good Old World','A peep into the real world','A005',65);
insert into BooksDetails values('B009','Road Back Home','A story of a poor child and his encounter with the cruel world','A003',25);
insert into BooksDetails values('B010','A Rich Tribute','A tribute to worlds ten greatest people','A010',62);
insert into BooksDetails values('B011','Jungle Kings','Fantasy story for children','A008',66);
insert into BooksDetails values('B012','I am the Best','A heart ripping comedy','A001',90);
insert into BooksDetails values('B013','Easy Way to Healthy Life','Useful tips for keeping you fit','A004',52);
insert into BooksDetails values('B014','What Time That Was','The real reasons and effects of the world WarII','A009',60);
insert into BooksDetails values('B015','Your Personality','Tips to improve your personality','A006',50);
insert into BooksDetails values('B016','World Over','Facts about the most beautiful places in the world','A005',58);
insert into BooksDetails values('B017','Food Delights','Mouth-watering recipies','A007',20);


/*inserting data in the CustomerDetails table*/
insert into CustomerDetails values('C001','Kathy',19,'23-34-67','kath@yahoo.com','America');
insert into CustomerDetails values('C002','Jones',34,'344-09-112','jn@hotmail.com','Australia');
insert into CustomerDetails values('C003','Cindrella',32,'56-99-88','cin@yahoo.com','South Africa');
insert into CustomerDetails values('C004','Roger',23,'33-01-10','rg@yahoo.com','America');
insert into CustomerDetails values('C005','John',30,'440-334-331','jo@hotmail.com','Australia');

/*Inserting data in the FlowersDetails table*/
insert into FlowersDetails values('F001','White Rose','Expesses peace',10);
insert into FlowersDetails values('F002','Red Rose','Perfect to express your love',100);
insert into FlowersDetails values('F003','Yellow Rose','For your best friend',30);
insert into FlowersDetails values('F004','Red Carnations','Decorate yor house with these lovely flowers',56);
insert into FlowersDetails values('F005','White Carnations','Lovely flowers for your house',62);
insert into FlowersDetails values('F006','Tulips','In beautiful colors',34);
insert into FlowersDetails values('F007','White Lilies','For a soothing effect',23);
insert into FlowersDetails values('F008','Gerber Dasies','A great gift for your friend',45);
insert into FlowersDetails values('F009','Pompons','A delightful way to enjoy an occasion',35);
insert into FlowersDetails values('F010','Snapdragons','For a bright birthday',38);

/*Inserting data in the OrderDetails table*/
insert into OrderDetails values('I001','01/11/2001','T002','C001',1,1009,1009,'American Express','3444-3333-1111-1234');
insert into OrderDetails values('I002','23/11/2001','F001','C002',1,10,10,'American Express','5757-5757-5232-3233');
insert into OrderDetails values('I003','13/12/2001','B003','C003',2,30,60,'American Express','3454-3334-6666-7888');
insert into OrderDetails values('I004','10/01/2002','T001','C004',3,100,300,'American Express','5757-7878-1919-0234');
insert into OrderDetails values('I005','14/11/2002','F002','C005',4,100,400,'American Express','4444-5653-4234-5678');

/*Inserting data in the ToysDetails table*/
insert into ToysDetails values('T001','Teddy Bear','A cute stuff for cute children',100);
insert into ToysDetails values('T002','Casio','A musical friend for a child',1009);
insert into ToysDetails values('T003','Cricket Kit','For all those sporty people',708);
insert into ToysDetails values('T004','Doll House','Build your own dream house',560);
insert into ToysDetails values('T005','Word Scrabble','An educational game',120);
insert into ToysDetails values('T006','Bussiness','A game to sharpen your mind',130);
insert into ToysDetails values('T007','Card Pack','A game for the entire family',20);
insert into ToysDetails values('T008','Tennis Kit','The worlds favourite sport',150);
insert into ToysDetails values('T009','Pictionary','Improves your imagination skills',140);
insert into ToysDetails values('T010','Musical Doll','A singing friend for your child',180);



create table AdminAccount
(
  username char(10) not null,
  primary key (username),
  password char(10) not null
);

insert into AdminAccount(username,password) values('admin','admin');

COMMIT;
```