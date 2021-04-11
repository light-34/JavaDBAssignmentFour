Create Table C_Customers (
				CustomerID Number(4) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
				FNAME varchar2 (30) NOT NULL,
				LNAME varchar2 (30) NOT NULL,
				PHONE varchar2 (10),
				EMAIL varchar2 (30) NOT NULL,
				STREET varchar2 (50),
				CITY varchar2 (30),
				PROVINCE varchar2 (20),
				POST_CODE varchar2 (6));

Create Table p_products (
				ProductID Number(3) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
				PRODUCT_NAME Varchar2 (30) NOT NULL,
				LIST_PRICE Number(6,2) NOT NULL);