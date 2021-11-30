package pokemon;

import pokemon.controllers.CapturasController;
import pokemon.controllers.PerfilController;
import pokemon.controllers.SigninController;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {

  public static void configure() {
    DebugScreen.enableDebugScreen();
    Spark.staticFiles.location("public");

    HandlebarsTemplateEngine engineTemplate = new HandlebarsTemplateEngine();
    CapturasController capturasController = new CapturasController();
    SigninController signinController = new SigninController();
    PerfilController perfilController = new PerfilController();

    Spark.get("/capturas", capturasController::index, engineTemplate);
    Spark.get("/perfil", perfilController::index, engineTemplate);
    Spark.get("/signin", signinController::index, engineTemplate);
    Spark.post("/session", signinController::post, engineTemplate);
  }

}
