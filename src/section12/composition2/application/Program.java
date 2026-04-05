package section12.composition2.application;

import section12.composition2.entities.Comment;
import section12.composition2.entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
    Instancie manualmente (hard code) os objetos mostrados abaixo e mostre-os
    na tela do terminal, conforme exemplo.

    Traveling to New Zealand
    12 Likes - 21/06/2018 13:05:44
    I'm going to visit this wonderful country!
    Comments:
    Have a nice trip
    Wow that's awesome!

    Good night guys
    5 Likes - 28/07/2018 23:14:19
    See you tomorrow
    Comments:
    Good night
    May the Force be with you
*/

public class Program {
    public static void main(String[] args) throws ParseException {

        // Post1
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date moment = sdf.parse("21/06/2018 13:05:44");
        String title = "Treveling to new Zealand";
        String content = "Im goint to visit this wonderful country!";

        Post post = new Post(moment, title, content, 12);
        post.addComment(new Comment("Have a nice trip"));
        post.addComment(new Comment("Wow that's awesome!"));

        Date moment2 = sdf.parse("28/07/2018 23:14:19");
        String title2 = "Good night guys";
        String content2 = "See you tomorrow";

        Post post2 = new Post(moment2, title2, content2, 5);
        post2.addComment(new Comment("Good night"));
        post2.addComment(new Comment("May the Force be with you"));

        System.out.println(post);
        System.out.println(post2);
    }
}
