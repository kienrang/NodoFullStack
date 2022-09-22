create database quanlisach;
use quanlisach;

create table nhaxuatban(
	id int(8) primary key,
    ten varchar(100),
    trang_thai int(1),
    dia_chi varchar(225),
    mo_ta varchar(500)
);

create table tacgia(
	id int(8) primary key,
    ten varchar(100),
    sdt varchar(13),
    diachi varchar(225),
    mota varchar(500)
);

create table sach(
	id int(8) primary key,
    ten varchar(100),
    id_nxb int(8) ,
    id_tacgia int(8),
    chude varchar(100),
    namxuatban datetime,
    mota varchar(500),
    soluongconlai int,
    soluongdangmuon int,
    tongsach int,
    constraint fk_sach_nxb foreign key (id_nxb)references nhaxuatban(id),
    constraint fk_sach_tg foreign key (id_tacgia)references tacgia(id)
);

create table bandoc(
	id int(8) primary key,
    ten varchar(100),
    sdt varchar(13),
    diachi varchar(225),
    ngaysinh datetime,
    ngaytaotk datetime,
    hang int
);

create table muonsach(
	id int(8) primary key,
	id_bd int(8),
    id_sach int(8),
    soluong int,
    ngaymuon datetime,
    ngaytra datetime,
    trangthai int(1),
    ghichu varchar(225),
    constraint fk_muonsach_bd foreign key (id_bd)references bandoc(id),
    constraint fk_muonsach_s foreign key (id_sach)references sach(id)
);
select * from nhaxuatban;
select * from tacgia;
select * from muonsach;
select * from sach;
select * from bandoc;

insert into nhaxuatban(id, ten, trang_thai, dia_chi, mo_ta)
	values(1,'aaa', 1, 'bbb', 'cccc');



