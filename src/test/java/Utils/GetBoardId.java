package Utils;

import entities.Board_response;
import io.restassured.http.ContentType;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class GetBoardId {

    public Board_response response;
    public String boardName = "BoardTest" + (int) ((Math.random())*800);

    public Board_response GetId(String domain) {

        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("key", ReadProperties.getInstance().getProperties().get("consumerKey").toString());
        postContent.put("token", ReadProperties.getInstance().getProperties().get("accessToken").toString());
        postContent.put("name", boardName);

        response = given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when().post(domain + "/1/boards").then().log().all().extract().as(Board_response.class);

        return new Board_response(response.getId(), response.getName());
    }

}
