import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;


import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();
//INTEGRATION TESTING
  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Tamagotchi!");
  }

  @Test
  public void tamagotchiIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("Bob");
    submit(".btn");
    assertThat(pageSource()).contains("Bob");
  }
  @Test
  public void makeSureVariablesAreWorking() {
    goTo("http://localhost:4567/");
    fill("#name").with("Bob");
    submit(".btn");
    assertThat(pageSource()).contains("Hunger Level: 10");
  }
  //
  // @Test
  // public void taskIsDisplayedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   assertThat(pageSource()).contains("Mow the lawn");
  // }
  //
  // @Test
  // public void multipleTasksAreDisplayedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   fill("#description").with("Buy groceries");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   assertThat(pageSource()).contains("Mow the lawn");
  //   assertThat(pageSource()).contains("Buy groceries");
  // }

// UNIT TESTING
  @Test
  public void tamagotchi_instantiatesCorrectly() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals("lil dragon", myPet.getName());
    assertEquals(10, (int) myPet.getFoodLevel());
    assertEquals(10, (int) myPet.getSleepLevel());
    assertEquals(10, (int) myPet.getActivityLevel());
  }

  @Test
public void isAlive_foodLevelAbove0_true() {
  Tamagotchi myPet = new Tamagotchi("lil dragon");
  assertEquals(true, myPet.isAlive());
  }
  @Test
public void decreaseLevels_decreaseAllByOne_9() {
  Tamagotchi myPet = new Tamagotchi("lil dragon");
  myPet.decreaseLevels();
  assertEquals(9, (int) myPet.getFoodLevel());
  }
  @Test
public void addFoodLevel_addOneToFood_() {
  Tamagotchi myPet = new Tamagotchi("lil dragon");
  myPet.decreaseLevels();
  myPet.addFoodLevel();
  assertEquals(11, (int) myPet.getFoodLevel());
  }
}
