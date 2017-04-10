package blog;
/* The full (expected) functionality of a program created according to the Project Topic – “1. Blog Site”. 
In this program the user can create his own blog messages/diary blocks which may contain text and pictures 
which other uses can comment upon and receive answers, old blog messages are archived away in a separate 
catalogue when a certain time span passes as this part functions with the real-time simulation part of the program. 
Users require to register and login before being able to use any part of the program, user data is stored and 
used to sort and separate each blog owner as well as identify who posted the message or the comments. 
Functionality of the program extends to being able to show a list of blogs, show the content of a specific one, 
expand comments on it, enable conversations as well as being able to search for all sorts of criteria like user names, 
date, keywords or phrases.

By Edvardas Gervaitis ir Liudas Vasaris */
public class Main {

    public static void main(String[] args) {
        MainController ui = new MainController();
    }

}
