package Steps;

import com.cedarsoftware.util.io.JsonWriter;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;


public class Methods {

    protected JSONArray bodyJsonArray;

    public String filtrarJsonEqual(Response resp, String value) throws ParseException {

        //Se convierte el body a string
        String body = resp.body().asString();
        //se filtra el body por name 'Lagunitas Brewing Co' a JsonArray
        JSONArray filter = JsonPath.read(body, "$.[?(@.name =='"+value+"')]");
        //se pasa JsonArray a jsonString
        String filterString = filter.toJSONString();
        //Se formatea el jsonString
        String filterFormatString = JsonWriter.formatJson(filterString);
        //se filtran los id del filtro 'Lagunitas Brewing Co'
        JSONArray filterid = JsonPath.read(filterFormatString, "$..id");
        bodyJsonArray = filterid;

        return filterFormatString;
    }

    public ArrayList<String> tomarIds(){
        //Se convierten los id del jsonArray en ArrayList
        ArrayList<String> list = new ArrayList<String>();
        if (bodyJsonArray != null) {
            int len = bodyJsonArray.size();
            for (int i=0;i<len;i++){
                list.add(bodyJsonArray.get(i).toString());
            }
        }
        return list;

    }

    /*public JSONArray concatenarJsonArray(Response resp,JSONArray jsonArrayResult){
        //Se convierte el body a string
        String body = resp.body().asString();
        //se convierte el body en jsonArray
        JSONArray filter = JsonPath.read(body, "$.*");
        jsonArrayResult.merge(filter);
        return jsonArrayResult;
    }*/


}
