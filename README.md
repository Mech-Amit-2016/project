# project
to start this application you need to run the class DemoApplication.java class.
then you can make your queriess by api calling

this project contain three controllers in controller package--
1) Insurance policy controller(InsurancePolicyController.java)-
   this is used for creating a new policy,getting a policy by its id,getting all policy details,updating a policy and deleting a policy. the required urls can be seen in their .java file
   
2)Client Controller(ClientController.java)
  this is used for adding clients to a policy, and same operations as we can do with insurance policy controller.
  
3)Claim Controller(ClaimController.java)
  this is also used for creating,accessing,deleting,updating claims regarding policies.
  
 ![image](https://user-images.githubusercontent.com/118551644/230406956-02d055fe-11d1-49c1-a652-da254538a3f4.png)
this api (localhost:8080/addpolicy?type=Life&coverageamt=25000&premium=2500&startdate=12/12/2022&enddate=12/12/2023)
is used to add a new insurence policy.

this api(localhost:8080/addclient?name=anand&dob=08/08/1993&address=varanasi&contactno=9336993748&policyid=1) is used to add a client.
![image](https://user-images.githubusercontent.com/118551644/230408213-0c9e6b56-77b5-43fa-a53f-88977df24ba9.png)

this api(localhost:8080/addclaim?description=loss of property&claimdate=24/10/2024&claimstatus=inprogress&policyid=1&claimid=0) is used to add claim regarding your policy
![image](https://user-images.githubusercontent.com/118551644/230409248-1643f0f7-2fbd-4d41-bb80-115732e0ff9d.png)

this api(localhost:8080/findclaim?claimid=1) is used to get detailes of claim by a specific claim id.
