import scala.concurrent.duration._
 
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
 
class RecordedSimulationRefactored extends Simulation {
 
   val httpProtocol = http
       .baseUrl("https://computer-database.gatling.io")
       .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
       .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
       .acceptEncodingHeader("gzip, deflate")
       .acceptLanguageHeader("en-US,en;q=0.5")
       .upgradeInsecureRequestsHeader("1")
       .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:93.0) Gecko/20100101 Firefox/93.0")
 
   val scn = scenario("RecordedSimulationRefactored")
       .exec(http("request_0")
           .get("/computers"))
       .pause(3)
       // search
       .exec(http("request_1")
           .get("/computers?f=macbook"))
       .pause(3)
       // select computer
       .exec(http("request_2")
           .get("/computers/273"))
       .pause(3)
       .exec(http("request_3")
            .get("/computers"))
       .pause(3)
        // tag create computer
       .exec(http("request_4")
        .get("/computers/new"))
       .pause(3)
       // enter form information
       .exec(http("request_5")
           .post("/computers")
           .formParam("name", "Macbook 2")
           .formParam("introduced", "2018-01-01")
           .formParam("discontinued", "2020-02-03")
           .formParam("company", "1"))
 
   setUp(scn.inject(atOnceUsers(5))).protocols(httpProtocol)
}
