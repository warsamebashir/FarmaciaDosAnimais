CREATE TABLE Employees (
  id INT NOT NULL AUTO_INCREMENT,
  ssn VARCHAR(30) NULL,
  salary FLOAT NULL,
  previousEmployed BOOL NULL,
  startingDate DATE NULL,
  birthday DATE NULL,
  name VARCHAR(100) NULL,
  telephone VARCHAR(30) NULL,
  address VARCHAR(100) NULL,
  email VARCHAR(30) NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Product (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  shortName VARCHAR(30) NULL,
  unity VARCHAR(5) NULL,
  longName VARCHAR(60) NULL,
  priceCash FLOAT NULL,
  priceTerm FLOAT NULL,
  finalPrice FLOAT NULL,
  description VARCHAR(100) NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Companies (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  address VARCHAR(100) NULL,
  telephone VARCHAR(30) NULL,
  stateId VARCHAR(30) NULL,
  federald VARCHAR(30) NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Balance (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  date DATE NULL,
  time TIME NULL,
  sourceId INTEGER UNSIGNED NULL,
  value FLOAT NULL,
  previousBalance FLOAT NULL,
  currentBalance FLOAT NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Clients (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  telephone VARCHAR(30) NULL,
  address VARCHAR(100) NULL,
  email VARCHAR(30) NULL,
  ssn VARCHAR(30) NULL,
  stateID VARCHAR(30) NULL,
  birthday DATE NULL,
  balance FLOAT NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Seller (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Employees_id INT NOT NULL,
  payingCommission BOOL NULL,
  username VARCHAR(30) NULL,
  password_2 VARCHAR(30) NULL,
  PRIMARY KEY(id),
  INDEX Seller_FKIndex1(Employees_id),
  FOREIGN KEY(Employees_id)
    REFERENCES Employees(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE Payments (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Balance_id INTEGER UNSIGNED NOT NULL,
  type_2 INTEGER UNSIGNED NULL,
  date DATE NULL,
  time TIME NULL,
  value FLOAT NULL,
  PRIMARY KEY(id, Balance_id),
  INDEX Payments_FKIndex1(Balance_id),
  FOREIGN KEY(Balance_id)
    REFERENCES Balance(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE Supplier (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Companies_id INTEGER UNSIGNED NOT NULL,
  name VARCHAR(100) NULL,
  telephone VARCHAR(30) NULL,
  address VARCHAR(100) NULL,
  PRIMARY KEY(id),
  INDEX Supplier_FKIndex1(Companies_id),
  FOREIGN KEY(Companies_id)
    REFERENCES Companies(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE Services (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Balance_id INTEGER UNSIGNED NOT NULL,
  Clients_id INTEGER UNSIGNED NOT NULL,
  Employees_id INT NOT NULL,
  date INTEGER UNSIGNED NULL,
  time INTEGER UNSIGNED NULL,
  serviceId INTEGER UNSIGNED NULL,
  value FLOAT NULL,
  PRIMARY KEY(id, Balance_id),
  INDEX Services_FKIndex1(Balance_id),
  INDEX Services_FKIndex2(Employees_id),
  INDEX Services_FKIndex3(Clients_id),
  FOREIGN KEY(Balance_id)
    REFERENCES Balance(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Employees_id)
    REFERENCES Employees(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Clients_id)
    REFERENCES Clients(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE Sales (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Balance_id INTEGER UNSIGNED NOT NULL,
  Clients_id INTEGER UNSIGNED NOT NULL,
  Seller_id INTEGER UNSIGNED NOT NULL,
  Product_id INTEGER UNSIGNED NOT NULL,
  time TIME NULL,
  date DATE NULL,
  quantity INTEGER UNSIGNED NULL,
  unityPrice FLOAT NULL,
  typeSale INTEGER UNSIGNED NULL,
  totalSale FLOAT NULL,
  PRIMARY KEY(id, Balance_id),
  INDEX Sales_FKIndex1(Product_id),
  INDEX Sales_FKIndex2(Seller_id),
  INDEX Sales_FKIndex3(Clients_id),
  INDEX Sales_FKIndex4(Balance_id),
  FOREIGN KEY(Product_id)
    REFERENCES Product(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Seller_id)
    REFERENCES Seller(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Clients_id)
    REFERENCES Clients(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Balance_id)
    REFERENCES Balance(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE Stock (
  productId INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Sales_Balance_id INTEGER UNSIGNED NOT NULL,
  Sales_id INTEGER UNSIGNED NOT NULL,
  lastChange DATE NULL,
  quantity INTEGER UNSIGNED NULL,
  PRIMARY KEY(productId, Sales_Balance_id, Sales_id),
  INDEX Stock_FKIndex1(Sales_id, Sales_Balance_id),
  FOREIGN KEY(Sales_id, Sales_Balance_id)
    REFERENCES Sales(id, Balance_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;

CREATE TABLE Purchases (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Balance_id INTEGER UNSIGNED NOT NULL,
  Stock_productId INTEGER UNSIGNED NOT NULL,
  Stock_Sales_id INTEGER UNSIGNED NOT NULL,
  Stock_Sales_Balance_id INTEGER UNSIGNED NOT NULL,
  Product_id INTEGER UNSIGNED NOT NULL,
  Supplier_id INTEGER UNSIGNED NOT NULL,
  date DATE NULL,
  time TIME NULL,
  quantity INTEGER UNSIGNED NULL,
  value FLOAT NULL,
  PRIMARY KEY(id, Balance_id, Stock_productId, Stock_Sales_id, Stock_Sales_Balance_id),
  INDEX Purchases_FKIndex1(Supplier_id),
  INDEX Purchases_FKIndex2(Balance_id),
  INDEX Purchases_FKIndex3(Stock_productId, Stock_Sales_Balance_id, Stock_Sales_id),
  INDEX Purchases_FKIndex4(Product_id),
  FOREIGN KEY(Supplier_id)
    REFERENCES Supplier(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Balance_id)
    REFERENCES Balance(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Stock_productId, Stock_Sales_Balance_id, Stock_Sales_id)
    REFERENCES Stock(productId, Sales_Balance_id, Sales_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Product_id)
    REFERENCES Product(id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
TYPE=InnoDB;


