# 3-Semesterproject

*Read the file to end before running the program*

In order to run this code you will need the following installed: 

* Docker and Docker-comopose 
* Laravel - We suggest using it through PHP-storm
* PHP 8 
* Java - We suggst using IntelliJ but any IDE should get the job done
* Either the physical beer machine or the software simulation provided by B&R

It is expected that persons who wants to run this software has basic knowlagde of docker and docker-compose as well as Java. So guidance to how to instal docker and docker-compose and java will not be given furhter. 

The system relies on a database named beerMachine running on localhost port 3306. The docker-compose-yml file can be used to run a mySQL database where the only thing you need to add is a database with the beforementioned name. 

In order to run the frontend Laravel, Composer as well as PHP 8 needs to be installed. For that we recomend watching the following video depending on your OS:
* [Windowes](https://www.youtube.com/watch?v=NgZDw8Ravvg)
* [Linux or MAC](https://www.youtube.com/watch?v=YsqTZfeo_jk)


When everything is installed you will need to run the system in the following order
* Connect to the physical beer machines wifi or start the simulation locally
* The dockerfile using the command: **docker-compose up -d**
* The java-backend where the BeerMachineApplication class is the one you will run - When the red warnings stop comming it should be ready
* The frontend using the command: **php artisan serve** in a terminal inside PHP-storm (Be sure to **not** close this termianl as it will stop the frontend)


If you encounter any issues with port 8081, be sure that it is free to use because the backend relies on that port. If you cannot free port 8081 it can be changed under resources/application.properties but is not advised 

The frontend can be accessed through the link written in the same termianl as you wrote **php artisan serve**

If you encounter problems with the java-code where it cannot find specific classes we sugest that you try to install maven again as well as reloading maven. If that does not work try to restart your IDE and do tha above steps again. 

Depending on which beer machine you will use, you can change the host-IP in the /BeerMachineCommunication/MachineConnection class. If you use the physical machine the host-ip needs to be "192.168.0.122" (Is so by default) and if you use the software simulation the host-IP needs to be "127.0.0.1"


You can use UA Expert to see values reated to the beer machine but guidance for how to use this will not be given other then the following. 
* The URL for the OPC-UA client is **opc:tcp://192.168.0.122:4840**  for the physical machine and for the simulation **opc:tcp://127.0.0.1:4840**.
* Username: **sdu** 
* Password: **1234**

The projects backend directory needs to be opened in order to run the backend. That goes for the frontend as well where the frontend directory needs to be open in order to run the php artisan serve commando 
