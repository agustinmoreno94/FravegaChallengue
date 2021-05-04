package pom;

import org.openqa.selenium.By;

public class FilterPage {

    private By heladerasFilter = By.xpath("//h4[@name='subcategoryAggregation'][starts-with(text(),'Heladeras (')]");
    private By verTodasCatButton = By.xpath("//a[@name='viewAllBrands']");
    private By samsungFilterCheckBox = By.xpath("//label[@for='filterItemsamsung']");
    private By aplicarButton = By.xpath("//button[@id='apply']");
    private By tablaProductos = By.xpath("//ul[@name='itemsGrid' and @class='listingDesktopstyled__SearchResultList-wzwlr8-6 fCKkuk']");
    private String heladerasSamsung = "h4";
    private String waitElement = "#__next > div.withMainLayout__LayoutWrapper-sc-1lj5zpr-1.hhFziS > div:nth-child(2) > div > div > div.generalstyles__Column-s" +
            "c-1j7wv79-5.chgPzg > section > ul.listingDesktopstyled__SearchResultList-wzwlr8-6.fCKkuk > li:nth-child(1)";
    private By Menu = By.xpath("//div[@name='breadcrumb']");

    public By getHeladerasFilter() {
        return heladerasFilter;
    }

    public By getVerTodasCatButton() {
        return verTodasCatButton;
    }

    public By getSamsungFilterCheckBox() {
        return samsungFilterCheckBox;
    }

    public By getAplicarButton() {
        return aplicarButton;
    }

    public By getTablaProductos() {
        return tablaProductos;
    }

    public String getHeladerasSamsung() {
        return heladerasSamsung;
    }

    public String getWaitElement() {
        return waitElement;
    }

    public By getMenu() {
        return Menu;
    }
}
