import SongApplication.Album;
import SongApplication.Song;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Listenify word!");

        Album album = new Album("New Hindi song","Arijit singh");
        album.addNewSongToAlbum("Tum hi ho",3.5);
        album.addNewSongToAlbum("what jhumka",4.2);
        album.addNewSongToAlbum("kesariya",5.2);
        album.addNewSongToAlbum("shayad",6.0);


        Album album1 = new Album("Old Hindi songs","Kishore kumar");
        album1.addNewSongToAlbum("neele neele amber prr", 5.6);
        album1.addNewSongToAlbum("Mere Mehboob Qayamat",3.4);
        album1.addNewSongToAlbum("ek chatur naar",6.2);
        album1.addNewSongToAlbum("Mere sapnon Ki Rani",3.4);

        List<Song> playList = new ArrayList<>();

        album.addSongToPlayList(1,playList);
        album.addSongToPlayList(4,playList);

        album1.addSongToPlayList("Mere Mehboob Qayamat",playList);
        album1.addSongToPlayList("neele neele amber prr",playList);

        printManu();
        startSongs(playList);

    }
    public static void startSongs(List<Song>playList){

        int index = 0;
        System.out.println("Now playing "+playList.get(index).toString());

        Scanner sc = new Scanner(System.in);

        boolean continuePlayList  = true;

        while (continuePlayList) {

            System.out.println("Enter your choice ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (index == playList.size()-1) {
                        index++;

                    }else{
                        index=0;
                    }
                    System.out.println("Now Playing " + playList.get(index).toString());
                    break;

                case 2:
                    if(index==0){
                        index=0;
                    }else{
                        index--;
                    }
                    System.out.println("Now Playing " + playList.get(index).toString());
                    break;

                case 3:
                    System.out.println("Now Playing " + playList.get(index).toString());
                    break;

                case 4:
                    printPlayList(playList);
                    break;

                case 5:
                    printManu();
                    break;

                case 6:
                    playList.remove(index);
                    //It will go to next index
                    if(index==playList.size()){
                        index=0;
                    }
                    break;

                case 7:
                    Collections.shuffle(playList);
                    break;

                case 8:
                    continuePlayList = false;
                    break;

            }

        }
    }
    public static void printPlayList(List<Song> playList){
        for (Song song:playList){
            System.out.println(song.toString());
        }
    }

    public static void printManu(){
        System.out.println("These are the options you can choose from");
        System.out.println("1. Goto and play next song");
        System.out.println("2. Goto the previous song");
        System.out.println("3. Repeat the same song");
        System.out.println("4. Show all songs of playList");
        System.out.println("5. print the manu");
        System.out.println("6. Delete the current song");
        System.out.println("7. Shuffle the playlist");
        System.out.println("8. Exit the playList");
    }
}