import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTest extends Config {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Gromchenko");
        $("#userEmail").setValue("test@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("79031234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker").$(byValue("1")).click();
        $(".react-datepicker").$(byValue("1991")).click();
        $(".react-datepicker__day--020").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("homer.png");
        $("#currentAddress").setValue("Home Address");
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Delhi").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("Alexander Gromchenko"));
        $(".table-responsive").shouldHave(text("test@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("20 February,1991"));
        $(".table-responsive").shouldHave(text("Physics"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("homer.png"));
        $(".table-responsive").shouldHave(text("Home Address"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}
