package Steps;

import Pages.ExamenPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class DefinicionesExamen {

    ExamenPage page = new ExamenPage();
    public static WebDriver webDriver;

    @Given("^Ingresar a la Web de MercadoLibre$")
    public void IngresarWeb(){
        page.AbrirWeb();
        page.ValidarIngreso();
    }

    @When("^Ingresar a la \"([^\"]*)\" y a su \"([^\"]*)\"$")
    public void SeIngresaAlaSubcategoria(String Categoria, String Sub)  {
        page.IngresarSubcategoria(Categoria, Sub);
    }

    @Then("^Se valida la \"([^\"]*)\" y la cantidad de resultados$")
    public void SeValidaSubtipoYCantidad(String Sub){
        page.ValidarSubYCantidad(Sub);
        page.CerrarDriver();
    }

    @When("^Se filtra por la ubicacion \"([^\"]*)\"$")
    public void SeFiltraPorUbicacion(String Ubicacion) {
        page.FiltrarUbicacion(Ubicacion);
    }

    @Then("^Se ingresa a una publicacion y se verifican los datos$")
    public void SeVerificaLosDatosDeLaPublicacion(){
        page.VerificarDatosPublicacion();
        page.CerrarDriver();
    }

}
