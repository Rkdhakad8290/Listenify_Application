package SongApplication;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String albumName;

    private List<Song> songList;

    private String artistName;

    public Album(String albumName,String artistName){
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public Album(String albumName, List<Song> songList, String artistName) {
        this.albumName = albumName;
        this.songList = songList;
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }


    public boolean findSong(String enteredTitle){

        // you need to check if the song is present in this album or not
        for(Song song : songList){

            if(song.getName().equals(enteredTitle))
                return true;
        }
        return false;
    }
    public String addNewSongToAlbum(String title,double duration){
        //Adding to the songList

        //Step 1. check if its already present

        if(findSong(title)){
            return "Song is already present in the songList";
        }
        //If I find out the song, I say song is already present in
        //songList
        Song newSong = new Song(title,duration);
        songList.add(newSong);
        return "New song with title "+title+" has been added to the songList";

    }

    public String addSongToPlayList(int songNo,List<Song>playList){

        int index  = songNo-1;

        if (index>=0 && index<songList.size()){
            Song song = songList.get(index);
            playList.add(song);
            return "Song has been added to the playList";
        }else{
            return "song No is out of range";
        }
    }
    public String addSongToPlayList(String title,List<Song>playList){

        for(Song song:songList){

            if(song.getName().equals(title)){
                playList.add(song);
                return "Song added to playList successfuly";

            }
        }
        return "Song could not be found in Album";
    }
}
