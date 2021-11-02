import scala.concurrent.duration._
 
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
 
class RecordedSimulation extends Simulation {
 
   val httpProtocol = http
       .baseUrl("https://computer-database.gatling.io")
       .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
       .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
       .acceptEncodingHeader("gzip, deflate")
       .acceptLanguageHeader("en-US,en;q=0.5")
       .upgradeInsecureRequestsHeader("1")
       .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:93.0) Gecko/20100101 Firefox/93.0")
 
   val headers_0 = Map(
       "Sec-Fetch-Dest" -> "document",
       "Sec-Fetch-Mode" -> "navigate",
       "Sec-Fetch-Site" -> "none",
       "Sec-Fetch-User" -> "?1")
 
   val headers_1 = Map(
       "Sec-Fetch-Dest" -> "document",
       "Sec-Fetch-Mode" -> "navigate",
       "Sec-Fetch-Site" -> "same-origin",
       "Sec-Fetch-User" -> "?1")
 
   val headers_5 = Map(
       "Origin" -> "https://computer-database.gatling.io",
       "Sec-Fetch-Dest" -> "document",
       "Sec-Fetch-Mode" -> "navigate",
       "Sec-Fetch-Site" -> "same-origin",
       "Sec-Fetch-User" -> "?1")
 
 
 
   val scn = scenario("RecordedSimulation")
       .exec(http("request_0")
           .get("/computers")
           .headers(headers_0))
       .pause(62)
       // tag_search
       .exec(http("request_1")
           .get("/computers?f=macbook")
           .headers(headers_1))
       .pause(28)
       // tag_select_computer
       .exec(http("request_2")
           .get("/computers/273")
           .headers(headers_1))
       .pause(38)
       // tag_create_computer
       .exec(http("request_3")
           .get("/computers")
           .headers(headers_1))
       .pause(2)
       .exec(http("request_4")
           .get("/computers/new")
           .headers(headers_1))
       .pause(54)
       .exec(http("request_5")
           .post("/computers")
           .headers(headers_5)
           .formParam("name", "Macbook 2")
           .formParam("introduced", "2018-01-01")
           .formParam("discontinued", "2020-02-03")
           .formParam("company", "1"))
 
   setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
