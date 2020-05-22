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

![image](https://user-images.githubusercontent.com/59384874/82643887-f8367000-9c2d-11ea-9de2-50522479e648.png)

When you execute the table by selecting the table schema, you will get the details of co2emission with vehicle type and its details as below.

![image](https://user-images.githubusercontent.com/59384874/82644265-a510ed00-9c2e-11ea-8269-309f9401aa56.png)

Rest end point used to get the details of vehicle type.
http://localhost:8080/vehicletype

![image](https://user-images.githubusercontent.com/59384874/82644438-f15c2d00-9c2e-11ea-8fde-49cc41e0e03d.png)

The following is the rest end point for getting CO2emission.
http://localhost:8080/Co2emission/api/v1/getEmission/{vehicletype}/{traveldistance}/{unitofmeasure}

Some sample to check the APP with browser.

![image](https://user-images.githubusercontent.com/59384874/82644769-7e06eb00-9c2f-11ea-98a9-2d48d0ad3c55.png)

With postman

![image](https://user-images.githubusercontent.com/59384874/82644844-9ecf4080-9c2f-11ea-9daf-1fa0b643d2b9.png)

Following are the exceptions added

If the vehicle type is outside the given data there will be an failure in the execution.

Unit of measure should be either M (meter) or KM (Kilo Meter).There is no default behavior here. Either pass KM or M. If anything, other than this will have request failure. Also you can pass m or km or Km. 

The travel distance also should be greater than 0.
  
 ![image](https://user-images.githubusercontent.com/59384874/82644634-4304b780-9c2f-11ea-88bf-dd83f1a6754a.png)

The Tests are added for the following test cases.

1.	Test case for the vehicle type availability in the table.
2.	Test case for the unit of measure to be km or m.
3.	Test case for travel distance to be more than 0.
4.	Test case for successful execution of both km and m. 
