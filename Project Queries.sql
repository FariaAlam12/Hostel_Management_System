
commit;
create table Student_Information
(
    S_ID varchar2(9),
    S_Name varchar2(30),
    S_Pass varchar2(10),
    S_Email varchar2(30),
    S_Dept varchar2(4),
    S_Regularity_Status varchar2(9),
    S_Father_Name varchar2(30),
    S_Mother_Name varchar2(30),
    S_DOB Date,
    S_Gender varchar2(6),
    S_Home_Address varchar2(50),
    S_Status varchar2(1) DEFAULT '0',
    Room_No varchar2(3),
    constraint Student_Information_S_ID_pk primary key(S_ID),
    foreign key (Room_No) references Room_Information (Room_No)
        on delete cascade
);


create table Student_Contact
(
     S_ID varchar2(9),
     phone_no varchar2(11),
     primary key (S_ID,phone_no),
     foreign key (S_ID) references Student_Information (S_ID)
        on delete cascade
     
);





create table Room_Information
(
    Room_No varchar2(3),
    Room_Cap INTEGER,
    Cur_No_Seat INTEGER,
    Floor_No INTEGER,
    primary key (Room_No)

);

create table Mill_Information
(
    Day varchar2(20),
    Breakfast_Menu varchar2(100),
    Lunch_Menu varchar2(100),
    Dinner_Menu varchar2(100),
    Breakfast_Cost Integer,
    Lunch_Cost Integer,
    Dinner_Cost Integer,
    primary key (Day)
);





create table Stuff_Information
(
    Stuff_ID varchar2(9),
    Stuff_Pass varchar2(9),
    Stuff_Name varchar2(30),
    Stuff_Rank varchar2(20),
    Assigned_Room_Lower varchar2(3),
    Assigned_Room_Upper varchar2(3),
    Manager_ID varchar2(9) references Stuff_Information(Stuff_ID),
    primary key (Stuff_ID)
);

create table Stuff_Contact
(
     Stuff_ID varchar2(9),
     Stuff_Phone_No varchar2(11),
     primary key (Stuff_ID,Stuff_Phone_No),
     foreign key (Stuff_ID) references Stuff_Information (Stuff_ID)
        on delete cascade
);

create table Response_Issue
(
    Issue_Name varchar2 (20),
    S_ID varchar2(9),
    Stuff_ID varchar2(9),
    Issue_Status Integer,
    Issue_Descr varchar2(100),
    Issue_Cost number(9,0),
    primary key (Issue_Name,S_ID,Stuff_ID),
    foreign key (S_ID) references Student_Information(S_ID)  on delete cascade,
    foreign key (Stuff_ID) references Stuff_Information (Stuff_ID)
        on delete cascade
);
alter table Response_Issue 
add RECEIPT BLOB default null;



create table Bills
(
    S_ID varchar2(9),
    Hall_Bill number(9,0) default 0,
    Mess_Bill number(9,0) default 0,
    Laundary_Bill number(9,0) default 0,
    Fine number(9,0) default 0,
    Additional_Bill number(9,0) default 0,
    RECEIPT BLOB default null,
    primary key (S_ID),
    foreign key (S_ID) references Student_Information(S_ID)  on delete cascade
);


create table Student_Mill
(
    S_ID varchar2(9),
    Day varchar2(20),
    Total Integer,
    Breakfast_Status Integer,
    Launch_Status Integer,
    Dinner_Status Integer,
    primary key (S_ID ,Day),
    foreign key (S_ID) references Student_Information(S_ID)  on delete cascade,
    foreign key (Day) references Mill_Information(Day)  on delete cascade
);

/*Insert in Student_Information table*/
insert into Student_Information values('201914012','Faria Alam','201914012','fariavns9@gmail.com','CSE','Regular','Mahbubul Alam','Farhana Akter','11-JAN-2000','Female','Mirpur Dohs, Dhaka','1','101');
insert into Student_Information values('201914049','Md. Abdul Al Emon','201914049','rafiemon71@gmail.com','CSE','Regular','Abdul Mannan','Nurun Nahar','17-JUL-2000','Male','Sadar, Noakhali','1','103');




/*Insert in Student_Contact table*/
insert into Student_Contact values('201914012','01304736910');
insert into Student_Contact values('201914012','01552310508');
insert into Student_Contact values('201914049','01832198319');
insert into Student_Contact values('201914049','01832198313');


/*Insert in Room_Information table*/
insert into Room_Information values ('501',4,0,5);
insert into Room_Information values ('502',4,0,5);
insert into Room_Information values ('503',4,0,5);
insert into Room_Information values ('504',4,0,5);
insert into Room_Information values ('505',4,0,5);
insert into Room_Information values ('506',4,0,5);
insert into Room_Information values ('507',4,0,5);
insert into Room_Information values ('508',4,0,5);
insert into Room_Information values ('509',4,0,5);
insert into Room_Information values ('510',4,0,5);


insert into Mill_Information values('Saturday','Bread,Banana,Butter','Rice, Pulse,Fish(Hilsha)','Rice, Pulse,Beef',30,80,100);
insert into Mill_Information values('Sunday','Ruti,Egg Fry,Potato Fry','Rice, Pulse,Chicken','Rice, Pulse,Fish(Rui)',30,70,60);
insert into Mill_Information values('Monday','Hotchpotch,Pickles','Rice, Pulse,Fish(Rui)','Rice, Pulse,Chicken',40,60,70);
insert into Mill_Information values('Tuesday','Parata,Egg Fry,Potato Fry','Rice, Pulse,Beef','Rice, Pulse,Egg Fry',30,100,50);
insert into Mill_Information values('Wednesday','Ruti,Egg Fry,Potato Fry','Hotchpotch,Chicken','Rice, Pulse,Fish(Hilsha)',30,60,80);
insert into Mill_Information values('Thursday','Hotchpotch,Egg Fry','Rice, Pulse,Chicken','Rice, Pulse,Fish(Lobstar)',30,70,60);
insert into Mill_Information values('Friday','Parata,Egg Fry,Potato Fry','Pilau,Roast,Salad','Rice, Pulse,Fish(Rui)',30,120,60);

insert into Stuff_Information values('101914001','101914001','Saif Uddin Kawsar','Provost','101','510','101914001');
insert into Stuff_Information values('101914002','101914002','Osman Md Amin','Deputy Provost','101','510','101914001');
insert into Stuff_Information values('101914003','101914003','Tahmina Sultana','Assistant Provost','101','510','101914002');
insert into Stuff_Information values('101914004','101914004','Abu Said','Manager','101','510','101914003');
insert into Stuff_Information values('101914005','101914005','Romij Uddin','Office Employee','101','510','101914004');
insert into Stuff_Information values('101914006','101914006','Karim Alam','Office Employee','101','510','101914004');
insert into Stuff_Information values('101914007','101914007','Siddiqur Rahman','Cleaner','101','305','101914004');
insert into Stuff_Information values('101914008','101914008','Jamil Hasan','Cleaner','306','510','101914004');
insert into Stuff_Information values('101914009','101914009','Rashi','Cook','101','510','101914004');
insert into Stuff_Information values('101914010','101914010','Gopi Bahu','Cook','101','510','101914004');
insert into Stuff_Information values('101914011','101914011','Johir Uddin','Electrician','101','305','101914004');
insert into Stuff_Information values('101914012','101914012','Fuad Ahmed','Electrician','306','510','101914004');
insert into Stuff_Information values('101914013','101914013','Idris Mia','ISP','101','305','101914004');
insert into Stuff_Information values('101914014','101914014','Omor Faruk','ISP','306','510','101914004');
insert into Stuff_Information values('101914015','101914015','Sazu','Laundry Man','101','510','101914004');
insert into Stuff_Information values('101914016','101914016','Motin','Laundry Man','101','510','101914004');
insert into Stuff_Information values('101914017','101914017','Rami Malek','Gaurd','101','510','101914004');
insert into Stuff_Information values('101914018','101914018','Ashraf Hossain','Gaurd','101','510','101914004');


insert into Stuff_Contact values('101914001','01304736901');
insert into Stuff_Contact values('101914001','01832198301');
insert into Stuff_Contact values('101914002','01404736902');
insert into Stuff_Contact values('101914003','01404736903');
insert into Stuff_Contact values('101914004','01304736904');
insert into Stuff_Contact values('101914005','01504736905');
insert into Stuff_Contact values('101914006','01604736906');
insert into Stuff_Contact values('101914007','01704736907');
insert into Stuff_Contact values('101914008','01604736908');
insert into Stuff_Contact values('101914009','01504736909');
insert into Stuff_Contact values('101914010','01704736910');
insert into Stuff_Contact values('101914011','01804736911');
insert into Stuff_Contact values('101914012','01904736912');
insert into Stuff_Contact values('101914013','01704736913');
insert into Stuff_Contact values('101914014','01904736914');
insert into Stuff_Contact values('101914015','01804736915');
insert into Stuff_Contact values('101914016','01304736916');
insert into Stuff_Contact values('101914017','01404736917');
insert into Stuff_Contact values('101914018','01904736918');

select * from Student_Information;
select * from Student_Contact;
select * from Room_Information;
select * from Mill_Information;
select * from Stuff_Information;
select * from Stuff_Contact;
select * from Response_Issue;
select * from Bills;
select * from Student_Mill;


--          Add Hall Bill Procedure Start  
create or replace procedure addbills
AS
    counter number(9,0);

Begin
   FOR counter IN (Select Hall_Bill from Bills) 
   LOOP
        --dbms_output.put_line(' Hall Bills: ' || counter.hall_bill); 
        counter.hall_bill:=counter.hall_bill+2200;
        Update Bills
        set Hall_Bill=counter.hall_bill;
   END LOOP; 
END;

BEGIN
    addbills;
END;
--          Add Hall Bill Procedure Ends




-- Procedre for room seat increase Start
create or replace procedure incre(room in Room_Information.Room_No%TYPE,c in out Room_Information.Cur_No_Seat%TYPE )
As
BEGIN
    c:=c+1;
    Update Room_Information
    set Cur_No_Seat=c
    where Room_No=room;
END;
-- Procedre for room  seat increase Ends

-- Procedre for room seat decrease Start
create or replace procedure seatdecr(room in Room_Information.Room_No%TYPE,c in out Room_Information.Cur_No_Seat%TYPE )
As
BEGIN
    c:=c-1;
    Update Room_Information
    set Cur_No_Seat=c
    where Room_No=room;
END;
-- Procedre for room  seat decrease Ends

--One complex Quey and also inner join---
select RI.S_ID,SI.Room_No,RI.Issue_Descr,RI.Issue_Cost 
from Student_Information SI inner join Response_Issue RI on SI.S_ID=RI.S_ID and RI.issue_status=1 and stuffid in(select Stuff_ID from Response_Issue where Stuff_ID='101914011')
--One complex Quey and also inner join ends---


---Sequence for making auto pass for seat applicant----
create sequence hall_pass_seq
start with 1000
increment by 1;

---Sequence for making auto pass for seat applicant----

------Trigger for insert in bill table new id----
 create trigger addtoBilltable
 after update OF S_Status on student_information
 referencing NEW AS Neww
 for each row
 Begin
    IF:Neww.S_Status='1' then
    insert into Bills(S_ID) values(:Neww.S_ID);
    end if;
End;
------Trigger for insert in bill table new id end----





