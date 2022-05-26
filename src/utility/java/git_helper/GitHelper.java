package git_helper;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GitHelper {

    private  static Gson gson;
    private  static String GITHUB_API_BASE_URL = "https://api.github.com/";
    private static   String GITHUB_API_SEARCH_ISSUES_PATH = "search/issues";
    private static String GITHUB_REPO = "appwrite/appwrite";

    private static String reportFileName = "GitTestReport"+".csv";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir")+fileSeperator+"src"+fileSeperator+"testresults" +fileSeperator+ "github_result";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;

    public static void searchOpenPullRequests(){
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(reportFileLocation));
            String line1[] = {"PR name", "created date", "author"};
            writer.writeNext(line1);

            String pullRequestsQuery = "?q=repo:" + GITHUB_REPO + "+is:open+is:pr+&sort=created&order=asc&per_page=1000";

            Map pullRequestsSearchResult = makeRESTCall(
                    GITHUB_API_BASE_URL + GITHUB_API_SEARCH_ISSUES_PATH + pullRequestsQuery, "per_page=100");

            //System.out.println("Total number or results = " + pullRequestsSearchResult.get("total_count"));
            gson.toJsonTree(pullRequestsSearchResult).getAsJsonObject().get("items").getAsJsonArray()
                    .forEach(r -> writer.writeNext(new String[]{r.getAsJsonObject().get("title").getAsString(), r.getAsJsonObject().get("created_at").getAsString(),
                            r.getAsJsonObject().get("user").getAsJsonObject().get("login").getAsString()}));

            writer.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    private static Map makeRESTCall(String restUrl, String acceptHeaderValue)
            throws ClientProtocolException, IOException {
        Request request = Request.Get(restUrl);

        if (acceptHeaderValue != null && !acceptHeaderValue.isBlank()) {
            request.addHeader("Accept", acceptHeaderValue);
        }

        Content content = request.execute().returnContent();
        String jsonString = content.asString();

        System.out.println(jsonString);

        // To print response JSON, using GSON. Any other JSON parser can be used here.
        gson = new Gson();
        Map jsonMap = gson.fromJson(jsonString, Map.class);
        return jsonMap;
    }

    private static Map makeRESTCall(String restUrl) throws ClientProtocolException, IOException {
        return makeRESTCall(restUrl, null);
    }
}
