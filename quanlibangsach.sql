CREATE DATABASE quanlibangsach
on primary
(name=quanlibangsachdata,
filename='K:\bangsach.mdf',
size=10mb,
maxsize=15mb,
filegrowth=20%)
log on
(name=bangsachlog,
filename='K:\bangsach.ldf',
size=3mb,
maxsize= 5mb,
filegrowth=1mb)

use quanlibangsach

--tao table 
create table bangsach(masach nvarchar(50) primary key,tensach nvarchar(50),theloai nvarchar(50),hansx nvarchar(50),giathue Money,ghichu nvarchar(50))
create table nhanvien(manv nvarchar(50) primary key,hoten nvarchar(50),gioitinh nchar(20),ngaysinh date,tienluong float,chucvu nvarchar(50),sodt nvarchar(20),diachi nvarchar(50))

create table nguoidung(mangd nvarchar(50) primary key,hoten nvarchar(50),tentaikh nvarchar(50),matkhau nvarchar(50),gioitinh nvarchar(50),sodt nvarchar(50),manv nvarchar(50) references nhanvien(manv))
create table khachhangmuon(makhm nvarchar(50)primary key,sophieu nvarchar(50),ngaythue date, manv nvarchar(50) references nhanvien(manv),mabangsach nvarchar(50) references bangsach(masach),
tenbangsach nvarchar(50),theloai nvarchar(50),tinhtrang nvarchar(50),soluong int,songaymuon int,dongia float)

create table khachhangtr(makhm nvarchar(50), manv nvarchar(50) references nhanvien(manv) ,tensach nvarchar(50),ngaythue date,sophieu nvarchar(40)
                       ,ngaytr date,tinhtrang nvarchar(40),ghichu nvarchar(50) primary key(makhm,manv),masach nvarchar(50) references bangsach(masach))

--nhap du lieu
--bang sach
insert into bangsach(masach,tensach,theloai,hansx,giathue,ghichu)
values('111',N'Tuổi Thơ',N'Thiếu Nhi',N'Văn Hùng',10000,N'không');

insert into bangsach(masach,tensach,theloai,hansx,giathue,ghichu)
values('112',N'Tìm lại bầu trời',N'Bình Yên',N'Duy Thành',20000,N'không');

insert into bangsach(masach,tensach,theloai,hansx,giathue,ghichu)
values('113',N'Nỗi Buồn Của Ai Đó',N'Tiểu Thuyết ',N'Kim Dung',30000,N'không');

insert into bangsach(masach,tensach,theloai,hansx,giathue,ghichu)
values('114',N'Phía Sau Chân Trời',N'Truyện Tranh',N'Văn Phúc',45000,N'không');

insert into bangsach(masach,tensach,theloai,hansx,giathue,ghichu)
values('115',N'Tôi Là Ai Trong Tim Em',N'Thiếu Niên',N'Văn Lợi',25000,N'Không');

--NHAN VIEN
insert into nhanvien
values('1215',N'Bình','Nam','12/1/1966',125124,N'Quản Lý','13131561313','Quang Trung'),
('121430',N'Thủy',N'Nữ','12/1/1896',12233224,'Nhân Viên','13131561313',N'Phạm Văn Đồng')


--nguoi dung
insert into nguoidung(mangd,hoten,tentaikh,matkhau,gioitinh,sodt,manv)
values('331',N'Hùng','admin','123','Nam','13135','1215');

insert into nguoidung(mangd,hoten,tentaikh,matkhau,gioitinh,sodt,manv)
values('332','Kiên','abc','34441','Nam','13135','121430');


--khachhang muon
insert into khachhangmuon(makhm,sophieu,ngaythue,manv,mabangsach,tenbangsach,theloai,tinhtrang,soluong,songaymuon,dongia) 
values('12321','1','12/1/2018','1215','111',N'hùng',N'Đồng Quê',N'Mới',11,11,1123),
('11221qq211','12','1/1/2017','121430','112',N'Bình',N'Kop',N'Cũ',12,33,13212);


insert into  khachhangtr(makhm,manv,masach,ngaythue,sophieu,ngaytr,tinhtrang,ghichu)
values('12321','1215','113','12/1/2018','12','14/4/2018',N'Mới',N'Không'),
	  ('11221qq211','121430','115','11/4/2018','11','1/11/2019',N'Cũ',N'Không');
set dateformat DMY
select *from khachhangtr







