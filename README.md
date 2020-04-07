# KotlinPractice
# Author: Zuofu Li.  
## if you have anything do not understand, please let me know. thanks   
  
# Follow Up Question   
According to the Twelve-Factor App concepts, I learnt that the cloud-scalable application should have the application setup automation, then it is easier for beginners to learn the program and get started. For example, the application may setup in docker containers, then it is easy for beginners to docker compose up to start the application. Moreover, the application should have an automatically deployment, then every time the programmer push to master or dev branch, the application should deploy it automatically. These two are just examples. There must be more procedures that can be setup automatically.   

The application should not push any configurations or dependencies to the repository, because for each server, it needs to have an environment to run the application. This means that we could easily transfer to different operating system.   

Furthermore, the application repository should have feature-branches, as well as the dev branch, in this case, the team should split the work to different teams for the testing of the new feature before merging to the master branch. The Team may need to use different testing methods, for example, AB testing, Integration Testing, etc.   

Logs are also very important to the develop process. It helps the team to solve the bugs if there are any.    

Last thing I should say is the team should use store procedure. The application is used in a very large data process everyday, the application should store all data in an atomic store procedure, which means that if anything wrong happens in the save method, then abort the whole process.    

# Evaluation Considerations  
