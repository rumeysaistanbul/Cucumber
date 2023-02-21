package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features" ,
        glue ="//src/test/java/stepdefinitions" , //src/test/java/stepdefinitions yandakini kabul etmezse bunu deneyebilirisn .stepdefinitions ı babası olarak belirliyor ve runer bu satede buradaki tüm kodları çalıştırıyor
        tags = "@wip",
        dryRun = false
)
public class Runner {}


