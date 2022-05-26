# SeleniumJava
Selenium java framwork 

project structure :

![image](https://user-images.githubusercontent.com/64305836/170572980-bcc4dc03-9225-45fb-900d-71b392b8159e.png)
![image](https://user-images.githubusercontent.com/64305836/170573036-e03b236c-3f97-4d99-8afb-24b4309d4b5f.png)

**Test Configration Setup :**
Support 2 browsers -> chrome and firefox

support 4 environments -> local, test, staging, prod

Primary Configuration:  Command line 

![image](https://user-images.githubusercontent.com/64305836/170577026-3a1ed674-3a7d-4220-affb-cf24ec473540.png)

-Dusername=abandonedrhinoceros@maildrop.cc

-Dpassword=P@$$W0rd

-Durl=mytheresa.com/en-de/men.html

-Dbrowser=chrome

-Denv=local


Secondery Configration : Properties File
Path ->src\utility\java\config\Configuration.properties

![image](https://user-images.githubusercontent.com/64305836/170578152-aad7b05a-b1b9-4545-bdfb-126b3ecd664d.png)
![image](https://user-images.githubusercontent.com/64305836/170578199-b9d1f561-e6fa-4997-b765-f1cc0773126a.png)


For test case execution ->
user can run the test case by going to the test class or running the testing.xml file 


Test Result reporting ->

for extent report Path - src\testresults\testreport (For TestNG results)

for CSV results path - src\testresults\github_result (For Git task)

![image](https://user-images.githubusercontent.com/64305836/170579362-ad3b5a4b-6379-4c59-834d-8ee9942147de.png)


