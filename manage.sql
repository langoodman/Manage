drop Database IF EXISTS manage;
Create Database IF NOT EXISTS manage DEFAULT CHARACTER SET utf8;
Use manage;

-- 管理员表
CREATE TABLE if not exists admin(
	id int auto_increment PRIMARY KEY,
	phone_number varchar(11) NOT NULL unique,
	pass_word varchar(40) NOT NULL,
	name varchar(30),
	email varchar(30),
	age int,
    --	avatar varchar(200) COMMENT '头像',
	-- status_id int default 3,
	last_time varchar(40) COMMENT '最后登陆时间',
	sign_time TIMESTAMP default current_timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 10001;
INSERT INTO admin (phone_number, pass_word,name,age,email) 
	VALUES ( '13872617881','73f50c9f17291ce93ee52e50b73f6f63','lan',18,'1090230661@qq.com');

-- 会员表
Create Table if not exists user(
    id int auto_increment PRIMARY KEY,
	card_id varchar(20) NOT NULL COMMENT '会员卡号',
    phone_number varchar(11) NOT NULL unique,
    name varchar(30) COMMENT '姓名',
	gender varchar(10) COMMENT '性别',
	status varchar(30) COMMENT '会员状态',
	pharmacy_id int NOT NULL COMMENT '所属药店id',
	integral int default 0 COMMENT '会员积分',
	sign_time TIMESTAMP default current_timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 10001;
INSERT INTO user (card_id,phone_number, name,gender,pharmacy_id) 
	VALUES ( '123456789' ,'13872617881','lan','男',10001);

-- 药店表
Create TABLE if not exists pharmacy(
	id int auto_increment PRIMARY KEY,
--	phone_number varchar(11) NOT NULL unique,
    phone_number varchar(11) NOT NULL,
	address varchar(50) NOT NULL COMMENT '药店的地址',
	name varchar(30) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 10001;
INSERT INTO pharmacy (phone_number, address,name) 
	VALUES ( '13872617881','三峡大学信息科学楼','三峡大学校医院');

-- 员工表
CREATE TABLE if not exists staff(
	id int auto_increment PRIMARY KEY,
    phone_number varchar(11) NOT NULL unique,
    pharmacy_id int NOT NULL COMMENT '所属药店id',
    name varchar(30) COMMENT '姓名',
	gender varchar(10) COMMENT '性别',
	status varchar(20) default '在职' COMMENT '员工状态',
	age int,
	address varchar(50) COMMENT '员工的家庭住址'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 10001;
INSERT INTO staff (phone_number,pharmacy_id,name,gender,age,address) 
	VALUES('13872617881',10001,'lan','男',18,'欣苑二栋');

-- 药品表
CREATE TABLE if not exists medicine(
	id int auto_increment  PRIMARY KEY,
	name varchar(30) Not NULL COMMENT '药品名称',
	number varchar(20) Not NULL COMMENT '批号',
	origin varchar(30) Not NULL COMMENT '药品产地',
	specification varchar(100) Not NULL COMMENT '药品规格',
	price double(10,2) default 0.0 COMMENT '药品价格',
	stock int default 0 COMMENT '药品库存'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 10001;
INSERT INTO medicine (name,number,origin,specification,price,stock) 
	VALUES('阿莫西林','10110201238','湖南省XXX有限公司','克',20.20,200);

-- 订单表
CREATE TABLE if not exists orders(
	id int auto_increment PRIMARY KEY,
	staff_name int NOT NULL COMMENT '员工名字',
	pharmacy_name int NOT NULL COMMENT '药店名字',
	user_card_id int COMMENT '会员卡卡号',
	should_money double(10,2) COMMENT '应收金额',
	relly_money double(10,2) COMMENT '实收金额',
	integral int default 0 COMMENT '此次消费积分积分'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 10001;
--INSERT INTO orders (staff_id,pharmacy_id,user_id,should_money,relly_money,integral)
--	VALUES(10001,10001,10001,100,100,100);

-- 药品交易表
CREATE TABLE if not exists medicine_transaction(
	id int auto_increment PRIMARY KEY,
	medicine_id int  NOT NULL COMMENT '药品id',
	orders_id int  NOT NULL COMMENT '订单id',
	count int default 0 COMMENT '数量'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 10001;
INSERT INTO medicine_transaction (medicine_id,orders_id,count) 
	VALUES(10001,10001,7);

-- 状态表


