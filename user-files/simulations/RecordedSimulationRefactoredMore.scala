import scala.concurrent.duration._
 
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
 
class RecordedSimulationRefactoredMore extends Simulation {
 
    val httpProtocol = http
        .baseUrl("https://computer-database.gatling.io")
        .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("en-US,en;q=0.5")
        .upgradeInsecureRequestsHeader("1")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:93.0) Gecko/20100101 Firefox/93.0")
 
    object Search {
        val search = exec(http("Search_Computers")
        .get("/computers"))
        .pause(3)
        .exec(http("Enter_Macbook")
        .get("/computers?f=macbook"))
        .pause(3)
    }

    object Browse {
        val browse = exec(http("Browse_Pages")
        .get("/computers/273"))
        .pause(3)
    }

    object Create {
        val create = exec(http("Create_A_New_Computer")
       .get("/computers/new"))
       .pause(3)
       .exec(http("request_5")
           .post("/computers")
           .formParam("name", "Macbook 2")
           .formParam("introduced", "2018-01-01")
           .formParam("discontinued", "2020-02-03")
           .formParam("company", "1"))
    }

    val users = scenario("Users").exec(Search.search, Browse.browse)
    val admins = scenario("Admins").exec(Search.search, Browse.browse, Create.create)

    val scn = scenario("RecordedSimulationRefactoredMore").exec(Search.search, Browse.browse, Create.create)

    setUp(
        admins.inject(atOnceUsers(5)), 
        users.inject(atOnceUsers(5))
        ).protocols(httpProtocol)
}
