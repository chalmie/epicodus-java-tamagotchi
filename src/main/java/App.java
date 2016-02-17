
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/display", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Tamagotchi myTamagotchi = new Tamagotchi(name);
      request.session().attribute("tamagotchi", myTamagotchi);
      Integer hungerLevel = myTamagotchi.getFoodLevel();
      Integer sleepLevel = myTamagotchi.getSleepLevel();
      Integer activityLevel = myTamagotchi.getActivityLevel();

      model.put("hungerLevel", hungerLevel);
      model.put("sleepLevel", sleepLevel);
      model.put("activityLevel", activityLevel);
      model.put("name", name);
      model.put("template", "templates/display.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/activity", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Tamagotchi tempTamagotchi = request.session().attribute("tamagotchi");

      tempTamagotchi.addActivityLevel();
      tempTamagotchi.decreaseLevels();
      Boolean isAlive = tempTamagotchi.isAlive();

      String name = tempTamagotchi.getName();
      Integer hungerLevel = tempTamagotchi.getFoodLevel();
      Integer sleepLevel = tempTamagotchi.getSleepLevel();
      Integer activityLevel = tempTamagotchi.getActivityLevel();

      model.put("isAlive", isAlive);
      model.put("hungerLevel", hungerLevel);
      model.put("sleepLevel", sleepLevel);
      model.put("activityLevel", activityLevel);
      model.put("name", name);
      model.put("template", "templates/activity.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sleep", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Tamagotchi tempTamagotchi = request.session().attribute("tamagotchi");

      tempTamagotchi.addSleepLevel();
      tempTamagotchi.decreaseLevels();
      Boolean isAlive = tempTamagotchi.isAlive();

      String name = tempTamagotchi.getName();
      Integer hungerLevel = tempTamagotchi.getFoodLevel();
      Integer sleepLevel = tempTamagotchi.getSleepLevel();
      Integer activityLevel = tempTamagotchi.getActivityLevel();

      model.put("isAlive", isAlive);
      model.put("hungerLevel", hungerLevel);
      model.put("sleepLevel", sleepLevel);
      model.put("activityLevel", activityLevel);
      model.put("name", name);
      model.put("template", "templates/sleep.vtl");


      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/food", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Tamagotchi tempTamagotchi = request.session().attribute("tamagotchi");

      tempTamagotchi.addFoodLevel();
      tempTamagotchi.decreaseLevels();
      Boolean isAlive = tempTamagotchi.isAlive();

      String name = tempTamagotchi.getName();
      Integer hungerLevel = tempTamagotchi.getFoodLevel();
      Integer sleepLevel = tempTamagotchi.getSleepLevel();
      Integer activityLevel = tempTamagotchi.getActivityLevel();

      model.put("isAlive", isAlive);
      model.put("hungerLevel", hungerLevel);
      model.put("sleepLevel", sleepLevel);
      model.put("activityLevel", activityLevel);
      model.put("name", name);
      model.put("template", "templates/food.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
