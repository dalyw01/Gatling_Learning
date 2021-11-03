Good overall explanation without having to register for anything -
https://www.youtube.com/watch?v=5MYuQBQZ8Ys

I had to install Java from here - https://www.oracle.com/java/technologies/downloads/#jdk17-mac

Download Gatling ZIP -
https://gatling.io/open-source/

Register and go here for more on the prerequisites -
https://academy.gatling.io/courses/take/Run-your-first-tests-with-Gatling/lessons/15869639-a3-course-prerequisites 


Verify Java is installed
wdaly@WDALY-FVFFC4FWQ05N ~ % javac -version
javac 17.0.1

Download from here - https://gatling.io/open-source/
Go into folder - cd gatling-charts-highcharts-bundle-3.6.1 
Go into /bin - cd bin

Run the command for a quick example script - ./gatling.sh
wdaly@WDALY-FVFFC4FWQ05N bin % ./gatling.sh
GATLING_HOME is set to /Users/wdaly/Desktop/gatling-charts-highcharts-bundle-3.6.1
Java HotSpot(TM) 64-Bit Server VM warning: Option UseBiasedLocking was deprecated in version 15.0 and will likely be removed in a future release.
Choose a simulation number:
     [0] computerdatabase.BasicSimulation
     [1] computerdatabase.advanced.AdvancedSimulationStep01
     [2] computerdatabase.advanced.AdvancedSimulationStep02
     [3] computerdatabase.advanced.AdvancedSimulationStep03
     [4] computerdatabase.advanced.AdvancedSimulationStep04
     [5] computerdatabase.advanced.AdvancedSimulationStep05
0
Select run description (optional)
test
11:40:03.583 [ERROR] i.g.h.u.SslContextsFactory - OpenSSL is enabled in the Gatling configuration but it's not available on your architecture.
Simulation computerdatabase.BasicSimulation started...
. . .
Etc . . .
Simulation computerdatabase.BasicSimulation completed in 24 seconds
Parsing log file(s)...
Parsing log file(s) done
Generating reports...

================================================================================
---- Global Information --------------------------------------------------------
> request count                                         13 (OK=13     KO=0     )
> min response time                                    127 (OK=127    KO=-     )
> max response time                                    264 (OK=264    KO=-     )
> mean response time                                   142 (OK=142    KO=-     )
> std deviation                                         35 (OK=35     KO=-     )
> response time 50th percentile                        132 (OK=132    KO=-     )
> response time 75th percentile                        134 (OK=134    KO=-     )
> response time 95th percentile                        188 (OK=188    KO=-     )
> response time 99th percentile                        249 (OK=249    KO=-     )
> mean requests/sec                                  0.542 (OK=0.542  KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                            13 (100%)
> 800 ms < t < 1200 ms                                   0 (  0%)
> t > 1200 ms                                            0 (  0%)
> failed                                                 0 (  0%)
================================================================================

To view the results in their html output, navigate to something like the following - file:///Users/wdaly/Desktop/gatling-charts-highcharts-bundle-3.6.1/results/basicsimulation-20211101114003566/index.html

Run this command to launch the recorder - ​​./recorder.sh

B3 in lessons shows how to RECORD but also how to get a HAR file

This is the site we used - https://computer-database.gatling.io/computers 

https://gatling.io/docs/gatling/reference/current/session/feeder/ 

