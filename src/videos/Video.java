package videos;

import java.util.ArrayList;
import java.util.List;

public class Video {

    private String url;
    private String title;
    private List<String> tags = new ArrayList<>();

    public Video(String url, String title, List<String> tags) { //constructor video

        this.url = url;
        this.title = title;
        this.tags = tags;
    }

    public String getTitle() {
        return "["+title+"]";
    }
}
