# Database (Continued)


## Lecture

* [JDBC](#jdbc)



## Labs

* Use JDBC in DAO



## JDBC


![JDBC interface and Java program](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/database-jdbc.png)


* JDBC stands for Java DataBase Connectivity
* JDBC API is DBMS indepedent
* JDBC Driver implements JDBC API for a particular DBMS


### Example: HelloJDBC.java

* Load JDBC Driver
* Make Connections
* Execute queries
* Process results
* Handle exceptions (and close connections)


### JDBC Basics


* `import java.sql.*;`
* Initialize driver
    * Class.forName("com.mysql.jdbc.Driver")
* Create connection
    * URL
        * `jdbc:mysql//[host:port]/[databbase][?user=cs3220xstu25&password=abcd]`
    * DriverManager.getConnection( URL )
    * DriverManager.getConnection( URL, user, pass )


* Create statement
    * `Statement stmt = c.createStatement();`
        * `stmt.executeQuery(String sql)`
        * `stmt.executeUpdate(String sql)`
* Get result back
    * ResultSet


### DB Query Results

* In a program, we usually want to:
    * Access each record
    * Access each attribute in a record
    * Access the name of each attribute


### JDBC ResultSet -- Row Access

Each record(cursor) is a row in the DBMS table.

You can call `next()` method to move cursor one row down:
    * Cursor starts before the first record
    * `true` if the current record is valid
    * `false` if there is no more records


### Common code for processing ResultSet

* Process each row: `while (rs.next()) { ... }`
* Check whether a result set is empty: `if (rs.next()) { ... }`


### JDBC ResultSet -- Column Access

* Access the columns of current row
* getXxx(String columnName) to get column value in Xxx type
    * e.g. `getString("first_name")`
* getXxx(int columnIndex) to get column value by the index
    * columnIndex starts from 1
    * e.g. getString(1)


### JDBC ResultSet -- Access Column Names

```java
ResultSetMetaData meta = rs.getMetaData();
```


* ResultSetMetaData
    * getColumnName( columnIndex )
        * Column name
    * getColumnLabel( columnIndex )
        * Column title for display or printout


### Handle Exceptions


```java
catch (SQLException e) {
    throw new ServletException( e ); // to have Servlet to display error stack (dev only)
} finally {
    try {
        if (c != null) c.close();
    } catch (SQLException e) {
        throw new ServletException(e);
    }
}
```


### Example: GuestBook (JDBC) -- display

* Create a "guest_book" table
* Retrieve the entries in a Servlet
* Display the entries in a JSP


### Example: GuestBook (JDBC) -- add

* Save a new guest book entries to the databbase
    * `executeQuery()` vs `executeUpdate()`
* Potential problems of handling user input
    * Special characters
    * SQL Injection Attack


### Example: SQL Injection Attack

* User input should never be trusted
* Malicious user input
    * Username: someuser
    * Password: something' OR ' 1
* Prevent SQL injection attack?
    * User prepare statement


### Prepared statements

```java
String sql = "INSERT INTO items VALUES (?, ?, ?)";

PreparedStatement pstmt = c.prepareStatement(sql);

pstmt.setString(1, "orange");
pstmt.setBigDecimal(2, 0.59);
pstmt.setInt(3, 4);

pstmt.executeUpdate();
```


### Beyond basic

* Transaction
    * ACID property of database

![Database Transaction flow](https://raw.githubusercontent.com/csula/cs3220-spring-2018/master/notes/imgs/database-transaction-flow.png)


Connection pool can define:

* Max number of connections
* Max number of idle connections
* And many other configurable parameters

