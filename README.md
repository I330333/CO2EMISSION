# CO2EMISSION

Requirements to execute the Project:

Installation:

Eclipse or IntelliJ to download the project from git
Maven for Windows or Mac to update the maven dependency locally
Postman or any web browser preferably Chrome to test the rest end points
 
Application was created in Spring boot with rest end points to get the co2 emission based on the given vehicle types.

The vehicle type and other information was stored in H2 data base. 

Once the project is downloaded from Git and update for maven is done, the execution of project will give the local host with port number according to your system. 

You can find the Schema for the table CO2emission, in the following URL. Here the port number may vary according to your system. 

http://localhost:8080/h2-console/login.jsp?jsessionid=086126cfa68028ca3795773855051232


When you execute the table by selecting the table schema, you will get the details of co2emission with vehicle type and its details as below.


Rest end point used to get the details of vehicle type.
http://localhost:8080/vehicletype

The following is the rest end point for getting CO2emission.
http://localhost:8080/Co2emission/api/v1/getEmission/{vehicletype}/{traveldistance}/{unitofmeasure}

If the vehicle type is outside the given data there will be an failure in the execution.

Unit of measure should be either M (meter) or KM (Kilo Meter).There is no default behavior here. Either pass KM or M. If anything, other than this will have request failure. Also you can pass m or km or Km. 

The travel distance also should be greater than 0.
 


 Some sample to check the APP with browser.
 
With postman
 
The Test are added for the following test cases.
1.	Test case for the vehicle type availability in the table.
2.	Test case for the unit of measure to be km or m.
3.	Test case for travel distance to be more than 0.
4.	Test case for successful execution of both km and m. 
