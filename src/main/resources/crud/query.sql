1> use student_crud
2> GO
Changed database context to 'student_crud'.
1> create table students(
2> id int,
3> name nvarchar(50) not null,
4> age int
5> );
6> GO
1> select * from students;
2> GO
id          name                                               age
----------- -------------------------------------------------- -----------
1> select * from students;
2> Go
id          name                                               age
----------- -------------------------------------------------- -----------
          1 ab                                                          22
          2 v kohli                                                     24
