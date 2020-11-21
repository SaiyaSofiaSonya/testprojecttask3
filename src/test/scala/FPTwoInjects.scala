import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef.http

import scala.concurrent.duration.DurationInt

trait FPTwoInjects extends Simulation {

  def loader(firstScenario: ScenarioBuilder): SetUp = {
    val httpProtocol = http.baseUrl("http://185.233.0.230:3000/")

  //Checking the stair with max perfomance
 /*   setUp(firstScenario.inject(constantUsersPerSec(12) during(65 minutes)).
      throttle(reachRps(12) in (5 minutes),
        holdFor (60 minutes))
        .protocols(httpProtocol),
        ).maxDuration(65 minutes)*/

    //Steps. To count max intensity by chairs
    setUp(firstScenario.inject(constantUsersPerSec(380) during(181 minutes)).
           throttle(
             reachRps(20)  in (1 minutes), holdFor (10 minutes),
             reachRps(40)  in (1 minutes), holdFor (10 minutes),
             reachRps(60)  in (1 minutes), holdFor (10 minutes),
             reachRps(80)  in (1 minutes), holdFor (10 minutes),
             reachRps(100) in (1 minutes), holdFor (10 minutes),
             reachRps(120) in (1 minutes), holdFor (10 minutes),
             reachRps(140) in (1 minutes), holdFor (10 minutes),
             reachRps(160) in (1 minutes), holdFor (10 minutes),
             reachRps(180) in (1 minutes), holdFor (10 minutes),
             reachRps(200) in (1 minutes), holdFor (10 minutes),
             reachRps(220) in (1 minutes), holdFor (10 minutes),
             reachRps(260) in (1 minutes), holdFor (10 minutes),
             reachRps(280) in (1 minutes), holdFor (10 minutes),
             reachRps(300) in (1 minutes), holdFor (10 minutes),
             reachRps(320) in (1 minutes), holdFor (10 minutes),
             reachRps(340) in (1 minutes), holdFor (10 minutes),
             reachRps(360) in (1 minutes), holdFor (10 minutes),
             reachRps(380) in (1 minutes), holdFor (11 minutes)
           ).protocols(httpProtocol),
           ).maxDuration(180 minutes) //Мааксимальное время до выполения всего скрипта?
     }
// Расчет максимального для нецелых значений
      /*
        val stepsOne = mutable.MutableList[OpenInjectionStep]()
        val stepsTwo = mutable.MutableList[OpenInjectionStep]()

        def perMinute(rate: Double): Double = rate / 60

        val durationsStage = (15 minutes);
        val stages = 15;
        val ratePerStage1 = 240;
        val ratePerStage2 = 30;

        for (s <- 1 to stages) {
          val rate = s * ratePerStage1;
          stepsOne+= (constantUsersPerSec(perMinute(rate)) during (durationsStage));
        }
    for (s <- 1 to stages) {
      val rate = s * ratePerStage2;
      stepsTwo+= (constantUsersPerSec(perMinute(rate)) during (durationsStage));
    }

        setUp(
       firstScenario.inject(stepsOne.toList).protocols(httpProtocol),
          secondScenario.inject(stepsTwo.toList).protocols(httpProtocol)
        )
*/
}
