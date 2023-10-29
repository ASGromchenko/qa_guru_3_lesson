import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTest extends Config {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").shouldBe(visible).setValue("Alexander");
        $("#lastName").shouldBe(visible).setValue("Gromchenko");
        $("#userEmail").shouldBe(visible).setValue("test@gmail.com");
        $("[for='gender-radio-1']").shouldBe(visible).click();
        $("#userNumber").shouldBe(visible).setValue("79031234567");
        $("#dateOfBirthInput").shouldBe(visible).click();
        $(".react-datepicker__month-select").shouldBe(visible).click();
        $(byValue("1")).shouldBe(visible).click();
        $(".react-datepicker__year-select").shouldBe(visible).click();
        $(byValue("1991")).shouldBe(visible).click();
        $(".react-datepicker__day--020").shouldBe(visible).click();
        $("[for='hobbies-checkbox-1'").shouldBe(visible).click();
        $("[for='hobbies-checkbox-2'").shouldBe(visible).click();
        $("[for='hobbies-checkbox-3'").shouldBe(visible).click();
        $("#uploadPicture").shouldBe(visible).uploadFile(new File("picture/homer.png"));
        $("#currentAddress").shouldBe(visible).setValue("Home Address");
        $("#react-select-3-input").shouldBe(visible).val("NCR").pressEnter();
        $("#react-select-4-input").shouldBe(visible).val("Delhi").pressEnter();
        $("#subjectsInput").shouldBe(visible).setValue("Physics").pressEnter();
        $("#submit").shouldBe(visible).pressEnter();

        $(".table-responsive").shouldHave(
                text("Alexander Gromchenko"),
                text("test@gmail.com"),
                text("Male"),
                text("7903123456"),
                text("20 February,1991"),
                text("Physics"),
                text("Sports, Reading, Music"),
                text("homer.png"),
                text("Home Address"),
                text("NCR Delhi")
        );
    }
}
