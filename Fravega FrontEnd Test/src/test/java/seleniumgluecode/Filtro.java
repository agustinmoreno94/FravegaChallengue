package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.util.List;
import java.util.logging.Logger;


public class Filtro extends TestBase {

    @Given("^el usuario se encuentra en la página home de Fravega$")
    public void el_usuario_se_encuentra_en_la_página_home_de_Fravega() throws Throwable {
        Assert.assertEquals(homePage.getTitleHomePage(),driver.getTitle());
    }

    @Given("^el usuario realiza una busqueda del articulo 'Heladeras'$")
    public void el_usuario_realiza_una_busqueda_del_articulo_Heladeras() throws Throwable {
        WebElement barraBusqueda = driver.findElement(homePage.getBarraSearch());
        barraBusqueda.clear();
        barraBusqueda.sendKeys(homePage.getBusqueda());
        barraBusqueda.sendKeys(Keys.ENTER);
    }

    @Given("^el usuario aplica filtro 'Heladera'$")
    public void el_usuario_aplica_filtro_Heladera() throws Throwable {
        WebElement filtroHeladeras = driver.findElement(filterPage.getHeladerasFilter());
        filtroHeladeras.click();
    }

    @When("^el usuario aplica filtro 'Samsung'$")
    public void el_usuario_aplica_filtro_Samsung() throws Throwable {
        driver.findElement(filterPage.getVerTodasCatButton()).click();
        driver.findElement(filterPage.getSamsungFilterCheckBox()).click();
        driver.findElement(filterPage.getAplicarButton()).click();

    }

    @Then("^Se debe verificar 'Samsung' en su title$")
    public void se_debe_verificar_Samsung_en_su_title() throws Throwable {
        Boolean flag = true;
        WebElement tablaProductos = driver.findElement(filterPage.getTablaProductos());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(filterPage.getWaitElement())));
        List<WebElement> heladerasSamsung = tablaProductos.findElements(By.tagName(filterPage.getHeladerasSamsung()));

        for(WebElement i : heladerasSamsung){
            String articleTitle = i.getText();
                if(!articleTitle.contains("Samsung")){
                    flag = false;
                }
        }
        Assert.assertTrue("No se encuentra 'Samsung' en el titulo de todos los articulos",flag);
    }

    @Then("^Se debe verificar la cantidad de elementos mostrados$")
    public void se_debe_verificar_la_cantidad_de_elementos_mostrados() throws Throwable {
        int cantidadArticulosEsperados = 6;

        WebElement tablaProductos = driver.findElement(filterPage.getTablaProductos());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(filterPage.getWaitElement())));
        List<WebElement> heladerasSamsung = tablaProductos.findElements(By.tagName(filterPage.getHeladerasSamsung()));

        Assert.assertEquals("No hay la misma cantidad de elementos",cantidadArticulosEsperados,heladerasSamsung.size());

    }

    @Then("^Se debe verificar que breadcrumbItem contenga el texto 'Heladeras con Frezzer'$")
    public void se_debe_verificar_que_breadcrumbItem_contenga_el_texto_Heladeras_con_Frezzer() throws Throwable {

        WebElement menu = driver.findElement(filterPage.getMenu());
        String textoMenu = menu.getText();

        Assert.assertEquals("No se encontró el texto 'Heladeras con Frezzer'","Heladeras con Frezzer",textoMenu);

    }

}
