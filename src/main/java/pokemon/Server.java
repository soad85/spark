package pokemon;

import spark.Spark;

public class Server {
  public static void main(String[] args) {
    Bootstrap.init();
    Spark.port(getHerokuAssignedPort());
    Router.configure();
  }

  static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
      return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return 9000; // puerto por defecto
  }
}
