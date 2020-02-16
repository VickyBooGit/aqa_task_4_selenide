import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CardDelivery {

    private WebDriver driver;
//    @BeforeAll
//    static void setUpAll() {
//        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
//    }

    @Test
    void shouldDeliveryCardByContactData() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Петрозаводск").pressEnter();
        $("[type='tel']").sendKeys(Keys.CONTROL, "a");
        $("[type='tel']").sendKeys(Keys.DELETE);
        $("[type='tel']").setValue("20.02.2020");
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+78589658432");
        $("[class='checkbox__box']").click();
        $$("button").find(Condition.exactText("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);


    }
}
