package Tests;

import Utils.GetBoardId;
import Utils.ReadProperties;
import entities.Board_response;
import io.restassured.http.ContentType;
import org.junit.Test;
import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class APITests {

    public String domain = "https://api.trello.com";
    public Board_response boardResponse;

    @Test
    public void createBoard(){
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("key", ReadProperties.getInstance().getProperties().get("consumerKey").toString());
        postContent.put("token", ReadProperties.getInstance().getProperties().get("accessToken").toString());
        postContent.put("name", "BoardTest4");
        given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when().post(domain+"/1/boards")
                .then().assertThat()
                .body("name", equalTo("BoardTest4"))
                .log().status();
    }

    @Test
    public void updateBoardName(){
        GetBoardId boardId = new GetBoardId();
        boardResponse = boardId.GetId(domain);
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("key", ReadProperties.getInstance().getProperties().get("consumerKey").toString());
        postContent.put("token", ReadProperties.getInstance().getProperties().get("accessToken").toString());
        postContent.put("name", boardResponse.getName());
        given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when().put(domain+"/1/boards/"+boardResponse.getId())
                .then().assertThat()
                .body("name", equalTo(boardResponse.getName()))
                .log().status();
    }

    @Test
    public void createBoardList(){
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("key", ReadProperties.getInstance().getProperties().get("consumerKey").toString());
        postContent.put("token", ReadProperties.getInstance().getProperties().get("accessToken").toString());
        postContent.put("name", "ListTest");
        given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when().post(domain+"/1/boards/5f78ada861491b805fa48406/lists")
                .then().assertThat()
                .body("name", equalTo("ListTest"))
                .log().status();
    }

    @Test
    public void getBoard(){
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("key", ReadProperties.getInstance().getProperties().get("consumerKey").toString());
        postContent.put("token", ReadProperties.getInstance().getProperties().get("accessToken").toString());
        given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when().get(domain+"/1/boards/5f78ada861491b805fa48406")
                .then().assertThat()
                .body("name", equalTo("BoardTest6"));
    }

    @Test
    public void getListOnBoards(){
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("key", ReadProperties.getInstance().getProperties().get("consumerKey").toString());
        postContent.put("token", ReadProperties.getInstance().getProperties().get("accessToken").toString());
        given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when().get(domain+"/1/boards/5f78ada861491b805fa48406/lists")
                .then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void createCardOnBoard(){
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("key", ReadProperties.getInstance().getProperties().get("consumerKey").toString());
        postContent.put("token", ReadProperties.getInstance().getProperties().get("accessToken").toString());
        postContent.put("idList", "5f78c1b6ec6afd2db9587f3f");
        postContent.put("name", "TestCard");
        given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when().post(domain+"/1/cards")
                .then().assertThat()
                .body("name", equalTo("TestCard"));
    }


}
