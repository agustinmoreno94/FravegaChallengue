package pom;

import org.openqa.selenium.By;

public class HomePage {

    private String titleHomePage = "Frávega: Electrodomésticos, Tecnología y Artículos para el hogar";
    private By barraSearch = By.xpath("//input[@placeholder='Buscar productos']");
    private String busqueda = "Heladera";

    public String getTitleHomePage() {
        return titleHomePage;
    }

    public By getBarraSearch() {
        return barraSearch;
    }

    public String getBusqueda() {
        return busqueda;
    }
}
