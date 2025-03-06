package t2.simulacros;


interface API {
  String obtenerDatos();
}

class ApiGitHub implements API {

  @Override
  public String obtenerDatos() {
    return "Repositorios de usuario: repo1, repo2, repo3";
  }
}


class ApiClima implements API {

  @Override
  public String obtenerDatos() {
    return "Temperatura actual: 22º";
  }
}

class ClienteAPI {
  private API api;

  public ClienteAPI (API api) {
    this.api = api;
  }

  public void setAPI(API api) {
    this.api = api;
  }

  public void mostrarDatos() {
    System.out.println("Los datos obtenidos son: " + api.obtenerDatos());
  }
}




public class mainSergioRuiz {
  public static void main(String[] args) {
    ClienteAPI clienteApi = new ClienteAPI(new ApiGitHub());
    clienteApi.mostrarDatos();
    clienteApi.setAPI(new ApiClima());
    clienteApi.mostrarDatos();
  }
}
