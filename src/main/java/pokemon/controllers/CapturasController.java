package pokemon.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import pokemon.model.Captura;
import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class CapturasController {
  public ModelAndView index(Request req, Response res) {
    String filtroParametro = req.queryParams("likeNombre");

    Usuario usuario = UsuarioRepositorio.get()
        .findByUsername(req.session().attribute("usuario_logueado"));
    Map<String, Object> model = new HashMap<>();
    List<Captura> capturas = Optional.ofNullable(filtroParametro)
        .map(filtro -> usuario.filtrarPorNombre(filtro))
        .orElseGet(() -> usuario.getCapturas());

    model.put("likeNombre", filtroParametro);
    model.put("usuario", usuario);
    model.put("capturas", capturas);

    return new ModelAndView(model, "capturas.hbs");
    //return "<html> <body> Hola" + UsuarioRepositorio.get().findAny() + " </body></html>";
  }
}
