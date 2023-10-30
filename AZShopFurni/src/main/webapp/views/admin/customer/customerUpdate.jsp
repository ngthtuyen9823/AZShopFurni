<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<form action="adminUpdateCustomer" method="post">
		<label>CustomerID:</label>
		<input type="text" name="customerID" value="${customer.userID}">
		<br>
		<label>First Name:</label>
		<input type="text" name="firstName" value="${customer.firstName}">
		<br>
		<label>Last Name:</label>
		<input type="text" name="lastName" value="${customer.lastName}">
		<br>
		<label>Address:</label>
		<input type="text" name="address" value="${customer.address}">
		<br>
		<label>Gender:</label>
		<input type="number" name="gender" value="${customer.gender}">
		<br>
		<label>Phone:</label>
		<input type="text" name="phone" value="${customer.phone}">
		<br>
		<label>Dob:</label>
		<input type="date" name="dob" value="${customer.dob}">
		<br>
		<label>Cid:</label>
		<input type="text" name="cid" value="${customer.cid}">
		<br>
		<label>Avatar:</label>
		<input type="text" name="avatar" value="${customer.avatar}">
		<br>
		<label>Email:</label>
		<input type="text" name="email" value="${customer.email}">
		<br>
		<input type="submit" value="UPDATE CUSTOMER">
	</form>
