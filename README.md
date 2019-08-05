# Expressiontree

Swagger URL for Expression Tree API  - https://expressiontree.cfapps.io/swagger-ui.html

Sample URL for evaluate (1+2) * (4 - 2).Passing value should be encoded.
https://expressiontree.cfapps.io/expressiontree/evaluate?expression=(1%2B2)%20*%20(4%20%2D%202)

App also can run using spring shell console.Below is the steps needs to follow.
  1)Import the project into eclipse as Maven project
  2)Run the project using Run As --> Spring Boot App.
  3)After starting the project use the shell console for executing the service.Below is the sample command for evaluate (1+2) * (4 - 2)
            shell:> evaluate "(1+2) * (4 - 2)"
  
  

 
