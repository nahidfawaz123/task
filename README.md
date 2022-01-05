# task
in README have json to using in postMan 
----------------------------------------------
post 

http://localhost:8080/users/

{
    "id":"1",
    "name":"nahed",
    "password":"123",
    "email":"asdasd",
    "userName":"nahed1"
}

----------------------------------------
put 
http://localhost:8080/users/dePost/

{   
     "password":"123",
     "userName":"nahed",
     "balance":3000
}

---------------------------------------
put
http://localhost:8080/users/withdraw/
{   
     "password":"123",
     "userName":"nahed",
     "balance":3000
}
--------------------------------------
put
http://localhost:8080/users/loanAmountUser/
{   
     "password":"123",
     "userName":"nahed",
     "loanAmount": 70000
}
-------------------------------------
put
http://localhost:8080/users/loanAmountDePost/

{   
     "password":"123",
     "userName":"nahed",
     "balance":70000
}

------------------------------------------------
delete
http://localhost:8080/users/deleteUser/
{
"password":"123",
 "userName":"nahed"
}

-------------------------------------------------