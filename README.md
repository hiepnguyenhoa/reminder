<h2>reminder App</h2>
<br>
This is a small application consisting of two parts (i) fontend (ii) and backend.
<br>
<h3>Fontend app</h3> is run at <a href="localhost:9090">localhost:9090</a> which provies
 - listing reminders
 - adding a reminder
 - updating a reminder
 - filter reminders by due date and status

font-end app can run by <b>mvn spring-boot:run</b>
<br>
<h3>Backend services</h3> is run at <a href="localhost:8080/rest/reminder">localhost:8080/rest/reminder</a> which provides all services to maintain reminders.<br>
Cmd to run <b>mvn jetty:run</b>
<h4>GET - localhost:8080/rest/reminders</h4>
* params: start and end date both are optional have format <b> MM/dd/yyyy</b>, and list of status is also optional.<br>
* return: list of reminders
<br>
<h4>GET - localhost:8080/rest/reminders/{id}</h4>
* params: id of a reminder<br>
* return: a reminder object in json format if the id is valid.
<br>
<h4>POST - localhost:8080/rest/reminders</h4>
* params: being body parameter of a reminder object in json format consists of content, due date, and status fields.<br>
* return: an added reminder in json format.
<br>
<h4>PUT - localhost:8080/rest/reminders</h4>
* params: being a body paraeter in json format of a reminder needs to be updated.<br>
* return: return an empty entity <code>204</code> if success<br>
All those end-points returns a status code to let up-stream know result of calls.
<br><br>
<h2> Designation</h2>
<br>
<h3>Font-end side</h3> provides GUI which will call back-end services by using CFX client library. It will handle status code returned to navigate to correct page.
<br>
<h3>Back-end side</h3> consists of three layers (i) REST implemented as JAX-RS standard which uses Jersey as a provider, (ii) business layer runs on Spring DI, and (iii) Respository uses Spring Data framwork, JPA use Hibernate as a providers.<br>
DTO uses to tranfer data between Rest and Business layers or upper stream.<br>
To enhance ability of extension in feature, statuses of a reminder is defined as an entity which its values are defined/stored in a table. However, Status DTO is defined as an enumeration to help check type quickly since as requirement defined two status <b>Done</b> and <b>Not Done</b>.<br>
By using both DTO and Entity, we can avoid lazzy load problem in practice, and have a short life of transaction.
<br><br>
<p style="font-color:red;">
<h3>Notes:</h3>
1) Cross-site Scripting(XSS). as a demotration, I do not sanitize reminder's content.<br/>
2) Handling exception. Lower levels and util classes will throw unchecked exceptions if any, which will be handle at the top level class. <code>ExceptionMapper</code> classes will handle exceptions. The mechanisim helps code clearer, more concise, and centerlize processing errors such as logging.<br>
</p>
