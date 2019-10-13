PROBLEM STATEMENT:
Suppose in a junction point three roads meet, for the traffics on the three roads, three signals P, Q and R are there. Only one signal 
can be turned on at a time to allow the traffic to pass. Following three functions are suggested in order to study the performance of 
the traffic control:
(a)	Each signal when turned on allows passing equal number of traffic, say, N in succession.
(b)	Different signals allow different number of traffics during their turn, say, signals, P, Q and R allow Q1, Q2 and Q3 number of 
traffics, respectively.
(c)	Only that signal will be turned on where maximum numbers of traffics are waiting till the numbers of traffics are at par with the 
other remaining queues. If all the queues contain the same number of traffic, signal P will be turned on. 

PROJECT BRIEF
The system works as mentioned below, but for a junction with ‘4’ roads. Vehicles are entered manually and each lane is allocated time on 
the basis of the algorithm chosen in which ‘m’ number of vehicles can be freed, like a typical traffic signal. Also property can be 
assigned to the queue manually.
In case of an emergency vehicle, the program will search for the lane with the nearest emergency vehicle and dequeue the whole lane as 
soon as the emergency vehicle is detected so that the emergency can be helped. Until, all emergencies are taken care of, the signal will 
not resume the normal state. 
The traffic lanes are represented by queues. Linear queue data structure is used for this purpose.  Input for each lane would be given 
sequentially. After all the lanes are initialized, first a check will be performed for any emergency vehicles in all lanes. The 
emergency vehicles will be allowed to exit the lanes based on their proximity to the lane exit. First, it will detect the foremost 
emergency vehicle in all lanes and would allow the nearest vehicle to exit first. All lanes would be stopped after the first emergency 
vehicle exits, then it would detect the foremost emergency vehicle again in all the lanes. This process would continue till all the 
emergency vehicles clear out of all the lanes. 
 
  After all the emergency vehicles exit all the lanes, we check all the lanes based on what algorithm is used. If the number of vehicles in any lane follows below the minimum threshold limit (here if the ratio is >= 4); that lane will be cleared and therefore skipped in the round robin scheduling. 
 
  After the lanes are checked for threshold, the round robin scheduling (Modified) will be executed. Round robin scheduling algorithm 
  will take all lanes as an input. The algorithm will allow vehicles in a lane to be cleared till a certain specified time 
  (that is taken as input), after that the lane would be stopped and the vehicles in the next lane would be allowed to clear for the 
  mentioned specific time (Time Limit). This process will continue till all the vehicles from all the lanes would be cleared and all 
  the lanes are empty.  
  Priority Scheduling gives better performance, since the emergency can be taken care of with priorities and we can also include functionality for dequeuing a specific queue out of sequence. Priority Scheduling was taken into consideration during the course of the project but due to some conflicts with the timers, the class was scraped off from the final project.

