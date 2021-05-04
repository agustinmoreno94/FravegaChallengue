package Steps;


import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;
import com.jayway.jsonpath.*;

public class GetSteps extends Methods{

    Methods methods = new Methods();

    @Given("^Se ejecuta un metodo GET con la url \"([^\"]*)\"$")
    public void seEjecutaUnMetodoGETConLaUrl(String arg0) throws Throwable {
        given().contentType(ContentType.JSON);
    }

    @And("^Se obtiene una lista de cervecerias con \"([^\"]*)\" en su key 'name' y se filtra de la lista a los registros con key 'name' \"([^\"]*)\"$")
    public void seObtieneUnaListaDeCerveceriasConEnSuKeyNameYSeFiltraDeLaListaALosRegistrosConKeyName(String name1, String name2) throws Throwable {
        //se realiza el primer GET https://api.openbrewerydb.org/breweries/autocomplete?query"lagunitas"
        Response resp = when().get("https://api.openbrewerydb.org/breweries/autocomplete?query="+name1);
        //se toma el body formateado
        String r = resp.prettyPrint();
        Reporter.addStepLog("Filtro 'Lagunitas'");
        Reporter.addStepLog(r+"\n"+"The response code is: "+resp.statusCode());
        int code = resp.getStatusCode();
        Assert.assertEquals(code,200);

        //se utiliza el response para realizar un filtro por "Lagunitas Brewing Co"
        String filter = filtrarJsonEqual(resp,name2);
        Reporter.addStepLog("\n"+"\n"+"Filtro 'Lagunitas Brewing Co'");
        Reporter.addStepLog("\n"+filter);
    }


    @Then("^Se filtra de la lista a los registros con key 'state' \"([^\"]*)\" y Se realiza assert de los keys 'id'=\"([^\"]*)\" 'name'=\"([^\"]*)\" 'street'=\"([^\"]*)\" 'phone'=\"([^\"]*)\"$")
    public void seFiltraDeLaListaALosRegistrosConKeyStateYSeRealizaAssertDeLosKeysIdNameStreetPhone(String state, int expId, String expName, String expStreet, String expPhone) throws Throwable {
        //Se instancia un JSONArray que será el merge de todas las consultas
        JSONArray jsonArrayResult = new JSONArray();
        //se ejecuta metodo tomarids para obtener los ID de los filtros anteriores
        ArrayList<String> listId = tomarIds();
        //Se recorre la lista de IDs y se realiza una consulta por cada uno
        for(int i=0;i<listId.size();i++){
            Response resp = when().get("https://api.openbrewerydb.org/breweries/"+listId.get(i));
            JsonPath jsonPathEvaluator = resp.jsonPath();
            String stateStr = jsonPathEvaluator.get("state");
            //se evalua si el estado es California
            if(stateStr.equals(state)){
                int id = jsonPathEvaluator.get("id");
                String name = jsonPathEvaluator.get("name");
                String street = jsonPathEvaluator.get("street");
                String phone = jsonPathEvaluator.get("phone");
                int code = resp.getStatusCode();

                Reporter.addStepLog(resp.prettyPrint());

                Assert.assertEquals(code,200);
                if(code==200){

                    Assert.assertEquals(expId,id);
                    if(expId==id){
                        Reporter.addStepLog("'id' Result = Pass");
                    }else{
                        Reporter.addStepLog("'id' Fail, 'id' esperada: "+expId+" , 'id' obtenida: "+id);
                    }

                    Assert.assertEquals(expName,name);
                    if(expName.equals(name)){
                        Reporter.addStepLog("'name' Result = Pass");
                    }else{
                        Reporter.addStepLog("'id' Fail, 'id' esperada: "+expName+" , 'id' obtenida: "+name);
                    }

                    Assert.assertEquals(expStreet,street);
                    if(expStreet.equals(street)){
                        Reporter.addStepLog("'street' Result = Pass");
                    }else{
                        Reporter.addStepLog("'id' Fail, 'id' esperada: "+expStreet+" , 'id' obtenida: "+street);
                    }

                    Assert.assertEquals(expPhone,phone);
                    if(expPhone.equals(phone)){
                        Reporter.addStepLog("'phone' Result = Pass");
                    }else{
                        Reporter.addStepLog("'id' Fail, 'id' esperada: "+expPhone+" , 'id' obtenida: "+phone);
                    }

                }else{
                    Reporter.addStepLog("Código de response :"+code);
                }


            }
        }

    }
}
