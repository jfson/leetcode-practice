package com.sun.leetcode.company.ab;

/**
 * Author: jfson sun
 * Create on:  2019/1/12
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc175 {
    /**
     175. Combine Two Tables
     Easy

     582

     76

     Favorite

     Share
     SQL Schema
     Table: Person

     +-------------+---------+
     | Column Name | Type    |
     +-------------+---------+
     | PersonId    | int     |
     | FirstName   | varchar |
     | LastName    | varchar |
     +-------------+---------+
     PersonId is the primary key column for this table.
     Table: Address

     +-------------+---------+
     | Column Name | Type    |
     +-------------+---------+
     | AddressId   | int     |
     | PersonId    | int     |
     | City        | varchar |
     | State       | varchar |
     +-------------+---------+
     AddressId is the primary key column for this table.


     Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

     FirstName, LastName, City, State
     为报告编写一个SQL查询，该查询为person表中的每个人提供以下信息，无论这些人是否有地址
     */

//    select FirstName, LastName, City, State from Person left outer join Address on Person.PersonId = Address.PersonId
}
