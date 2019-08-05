# Expressiontree

App is deployed in PCF cloud.</br>
Swagger URL for Expression Tree API  - https://expressiontree.cfapps.io/swagger-ui.html</br>

Sample URL for evaluate (1+2) * (4 - 2).Passing value should be encoded.</br>
https://expressiontree.cfapps.io/expressiontree/evaluate?expression=(1%2B2)%20*%20(4%20%2D%202) </br>

App also can run using spring shell console.Below is the steps needs to follow.</br>
  1)Import the project into eclipse as Maven project </br>
  2)Run the project using Run As --> Spring Boot App.</br>
  3)After starting the project use the shell console for executing the service.Below is the sample command for evaluate (1+2) * (4 - 2)</br>
            shell:> evaluate "(1+2) * (4 - 2)"
  
  

 
