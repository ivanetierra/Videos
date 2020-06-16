package videos;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String surname;
    private String password;
    private LocalDate date;
    private List<Video> videos = new ArrayList<>();

    public User(String name, String surname, String password, LocalDate date) { //User constructor

        this.name = name;
        this.surname = surname;
        this.password = password;
        this.date = date;
    }

    public void CreateVideo() {

        String url = JOptionPane.showInputDialog("Video url:");
        String title = JOptionPane.showInputDialog("Video title");
        List<String> tags = new ArrayList<>();

        String userOption = JOptionPane.showInputDialog("1:[Add tag] 0:[Exit]");

        while (userOption.equals("0")) {

            switch (userOption) {
                case "1":
                    String tag = JOptionPane.showInputDialog("Write tag:");
                    tags.add(tag);

                    userOption = JOptionPane.showInputDialog("1:[Add another tag] 0:[Exit]");
                    break;

                default:
                    System.out.println("Wrong input");

                    userOption = JOptionPane.showInputDialog("1:[Add another tag] 0:[Exit]");
                    break;
            }
        }

        Video video1 = new Video(url, title, tags); //create video
        videos.add(video1); // at the video to the list of videos of the user

        System.out.println("Your Video: "+video1.getTitle()+" Was Added!");
    }

    public String getVideos() {

        //print for
        String text = "";
        for (Video i : videos ) {
            text += i.getTitle()+" ";
        }
        return "ALL YOUR VIDEOS: "+text;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDate() {
        return date;
    }
}

