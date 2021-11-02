import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class Derp extends Simulation {

  val httpProtocol = http
    .baseUrl("https://reqres.in/api/users")
    .acceptHeader("*/*")
    .doNotTrackHeader("1")
    .userAgentHeader(
      "Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0"
    )
    .disableWarmUp
    .disableCaching

  val getScenario = scenario("BasicSimulation - GET")
    .exec(
      http("GET request")
        .get("/")
        .check(status.is(200))
    )

  
  setUp(
    getScenario.inject(rampUsers(20) during (2 seconds))
  ).protocols(httpProtocol)
}
