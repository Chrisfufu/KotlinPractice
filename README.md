# KotlinPractice
# Author: Zuofu Li.  
## if you have anything do not understand, please let me know. thanks   
  
# Instructions if run it locally  
1. download the project.  
2. import the project in IntelliJ (or other IDE you would prefer).  
3. build the project and run the application.  

# Follow Up Question   
According to the Twelve-Factor App concepts, I learnt that the cloud-scalable application should have the application setup automation, then it is easier for beginners to learn the program and get started. For example, the application may setup in docker containers, then it is easy for beginners to docker compose up to start the application. Moreover, the application should have an automatically deployment, then every time the programmer push to master or dev branch, the application should deploy it automatically. These two are just examples. There must be more procedures that can be setup automatically.   

The application should not push any configurations or dependencies to the repository, because for each server, it needs to have an environment to run the application. This means that we could easily transfer to different operating system.   

Furthermore, the application repository should have feature-branches, as well as the dev branch, in this case, the team should split the work to different teams for the testing of the new feature before merging to the master branch. The Team may need to use different testing methods, for example, AB testing, Integration Testing, etc.   

Logs are also very important to the develop process. It helps the team to solve the bugs if there are any.    

Last thing I should say is the team should use store procedure. The application is used in a very large data process everyday, the application should store all data in an atomic store procedure, which means that if anything wrong happens in the save method, then abort the whole process.    

# Evaluation Considerations  
1.   
I don't have time to write tests for each api. But I have manually tested it. If the save method does not work, then it will return an error:  
error 500: it means that the foreign key may not be found. or you've added a null value to a non-null field.  
error 400: request body may not working.  
error 404: the most common error, the api does not exist.  

2.  
Yes. there are 2 mock data provided when start the website. 
API:  
http://localhost:8080/session/all: this api is to view all the session entity. It has userId and sessionId. 
http://localhost:8080/session/addSession: this api is to add a session. the request body should look like:  
{  
	"userId": "ABC456XYZ",  
	"sessionId":"XYZ898ABC"  
}  

http://localhost:8080/action/all: this api is to view all the action entity.  
http://localhost:8080/action/addAction: this api is to add a action. the request body should look like:  
{  
	"type": "CLICK",  
	"session":"XYZ456ABC"  
}  
the session is the foreign key, the session must exist before using this api.  

http://localhost:8080/properties/all: this api is to view all the action entity.  
http://localhost:8080/properties/addProperty: this api is to add a property. the request body should look like:  
{  
	"locationX": 52,  
	"locationY": 10,  
	"actionId": 3   
}  
the actionId is the foreign key, the actionId must exist before using this api.   
The Properties Entity has 5 fields: locationX, locationY, viewedId, pageFrom, pageTo.   

3.  
The data stored is not very efficient. That's why there are more to learn. Actually, in a correct store procedure, for now, as a new programmer to Kotlin Spring, I think it is not bad.  

4.  
The error handling is using the default of Kotlin Spring framework. The error code is mentioned in question 1.  
The Dependency Injection would also handle the errors by setting up @inject, Then for each service, we could have the custom error handling. 

5.  
Yes. It is deployable. I deployed it on Cybera server. It's for free.  
of Course, Kotlin Spring Boot can also deploy on AWS or Heroku.  
API:  

Get Method:  
http://199.116.235.221:8080/session/all  
http://199.116.235.221:8080/action/all    
http://199.116.235.221:8080/properties/all   

Post Method (for these APIs, you may want to test it with PostMan, because it needs request JSON body):  
http://199.116.235.221:8080/session/addSession  
http://199.116.235.221:8080/action/addAction  
http://199.116.235.221:8080/properties/addProperty  
