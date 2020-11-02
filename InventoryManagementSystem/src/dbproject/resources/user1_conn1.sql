--drop table tblOwner;
--drop table tblProducts;
--drop table tblAccounts;
CREATE TABLE tblAccounts(Username varchar(255) Not Null,Password varchar(255)Not Null,Email varchar(255)Not Null,Name varchar(255)not null);
Delete from tblAccounts;
Select * From tblAccounts;

CREATE TABLE tblOwner(Barcode char(5) not null primary key, FactoryName varchar(25) Not Null, ZipCode char(4) not null);

INSERT INTO tblOwner VALUES ('A1-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('A1-01','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('AA-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('AA-01','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('AB-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('AB-01','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('AC-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('B1-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('B1-01','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('B1-02','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('B1-03','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('C1-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('C1-01','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('C1-02','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('C1-03','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('C1-04','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('C1-05','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('C1-06','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('S1-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('S1-01','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('S2-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('D1-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('D2-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('EE-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('EE-01','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('EE-02','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('EE-03','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('EE-04','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('EE-05','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('EE-06','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('EE-07','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('G1-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-01','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-02','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-03','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-04','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-05','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-06','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-07','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('N1-08','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('DD-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('DD-20','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('L1-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('L2-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('L3-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('L4-00','AlyFacory','1930');
INSERT INTO tblOwner VALUES ('L5-00','AlyFacory','1930');

CREATE TABLE tblProducts(Items varchar (255) PRIMARY KEY Not null,
                        Quantity varchar (255) not null,
                        Pieces_Pack varchar (800) not null,
                        Pack varchar (255) not null,
                        Barcode char(5) not null references tblOwner(Barcode),
                        Date_In date,
                        Date_Out date,
                        Expiration_Date date);
                    
INSERT INTO tblProducts VALUES('Jumbo Asado Siopao','100','10pcs','10 packs','A1-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Jumbo Bola Bola Siopao','100','10pcs','10 packs','A1-01','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Mini Asado Siopao 48','480','48pcs','10 packs','AA-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Mini Bola Bola 48','480','48pcs','10 packs','AA-01','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Mini Asado Siopao 16s','160','16pcs','10packs','AB-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Mini Bola Bola Siopao 16s','160','16pcs','10 packs','AB-01','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Mini Asado Siopao 24s','240','24pcs','10 packs','AC-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DF Pork Siomai','600','60pcs','10 packs','B1-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DF Beef Siomai','600','60pcs','10 packs','B1-01','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DF Chicken Siomai','600','60pcs','10 packs','B1-02','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DF Sharksfin Dumpilng','500','50pcs','10 packs','B1-03','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Pork Siomai','600','60pcs','10 packs','C1-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Beef Siomai','600','60pcs','10 packs','C1-01','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Chicken Siomai','600','60pcs','10 packs','C1-02','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Japanese Siomai','600','60pcs','10 packs','C1-03','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Sharksfin Dumpling','500','50pcs','10 packs','C1-04','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Wanton Dumpling','500','50pcs','10 packs','C1-05','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Gyoza Dumpling','500','50pcs','10 packs','C1-06','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Shanghai Rolls 30s','300','30pcs','10 packs','S1-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Shanghai Rolls 50s','500','50pcs','10 packs','S1-01','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Fried Lumpia 60s','600','60pcs','10 packs','S2-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Dried Noodles','50kg','5kg','10 packs','D1-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Dried Noodles1','20kg','2kg','10 packs','D2-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Chili Mushroom','4000ml','400ml','10 packs','EE-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Vinegarlic','4000ml','400ml','10 packs','EE-01','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Sweet and Sour','4000ml','400ml','10 packs','EE-02','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('MS Sweet Sauce','4000ml','400ml','10 packs','EE-03','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Chili Garlic Sauce','8000ml','800ml','10 packs','EE-04','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Siopao Sauce','10000ml','1000ml','10 packs','EE-05','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Siopao Sauce 15mL-25s','250','25s-packs','10 packs','EE-06','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Siopao Sauce 15mL-50s','500','50s-packs','10 packs','EE-07','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Gulaman Powder','10kg','1kg','10 packs','G1-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Fried Wanton','150','15pcs','10 packs','N1-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Pork and Shrimp Siomai','150','15pcs','10 packs','N1-01','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Hakaw Shrimp','150','15pcs','10 packs','N1-02','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Japanese Crabstick','120','12pcs','10 packs','N1-03','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Quail Egg Siomai','150','15pcs','10 packs','N1-04','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Sharksfin Dumplings','100','10pcs','10 packs','N1-05','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Bacon Siomai','70','7pcs','10 packs','N1-06','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Chicken Feet','10kg','1kg','10 packs','N1-07','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('DIN Spareribs Tausi','10kg','1kg','10 packs','N1-08','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Pork Siomai(White Wrapper)','600','60pcs','10 packs','DD-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Regular Pork Siomai','600','60pcs','10 packs','DD-20','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Chicken Ball','340','500g-34pcs','10 packs','L1-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Squid Ball','340','500g-34pcs','10 packs','L2-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Kikiam','200','500g-20pcs','10 packs','L3-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Orleans Strips','430','500g-43pcs','10 packs','L4-00','09/14/2017','10/14/2017','11/14/2017');
INSERT INTO tblProducts VALUES('Fish Ball','950','500g-95pcs','10 packs','L5-00','09/14/2017','10/14/2017','11/14/2017');