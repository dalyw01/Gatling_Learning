# Gatling Learning

This is a repo where I play around with Gatling and get a feel for the tool

## Basic Setup

Good overall explanation of Gatling [here](https://www.youtube.com/watch?v=5MYuQBQZ8Ys)

Install Java from [here](https://www.oracle.com/java/technologies/downloads/#jdk17-mac)

Download Gatling open source [ZIP](https://gatling.io/open-source/)

Information on the [prerequisites](https://academy.gatling.io/courses/take/Run-your-first-tests-with-Gatling/lessons/15869639-a3-course-prerequisites)

## How to use

Verify Java is installed successfully - `javac -version`

You should get something like - `javac 17.0.1`

Go into downloaded folder - `cd gatling-charts-highcharts-bundle-3.6.1`

Go into bin - `cd bin`

Run this command for a quick example script already in the downloaded folder - `./gatling.sh`

It should start and load a series of menus to select a Gatling test to run, select `0` -

```
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
```

Run this command to launch the recorder - `​​./recorder.sh`

B3 in lessons shows how to RECORD but also how to get a HAR file

This is the site we used to run tests against - https://computer-database.gatling.io/computers 