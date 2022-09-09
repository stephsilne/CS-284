package sa1;
/**
 * 
 * @author Stephaan Silne
 * @class CS 284: Data Structures
 * @assignment Special Assignment 1
 * @date 04/01/2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 */
public class Playlist{
	
	private SLL<Song> songs;
	
	public Playlist(){
		songs = new SLL<Song>();
	}
	
	public Playlist(Song song){
		songs = new SLL <Song>();
		songs.addFirst(song);
	}
	
	public int getSize() {
		return songs.getSize();
	}
	
	public Song getAt(int index) {
		if (index < 0 || index > songs.getSize()-1) {
			throw new IllegalArgumentException("getAt: index out of bounds");
		}
		return songs.getAt(index);
	}
	
	public void addSong(Song song) {
		SLL <Song> newpl = new SLL<Song>();
		newpl.addFirst(song);
		for (int i = songs.getSize()-1; i >= 0; i--) {
			newpl.add(songs.getAt(i),0);
		}
		songs = newpl;
	}
	
	public int totalRunTime() {
		if(songs.getSize() == 0) {
			throw new IllegalStateException("totalRunTime: no songs in the playlist");
		}
		int totRunTime = 0;
		for (int i = 0; i < songs.getSize(); i++) {
			Song s = songs.getAt(i);
			totRunTime = totRunTime + s.getRunTime();
		}
		return totRunTime;
	}
	
	public Song longestSong() {
		if(songs.getSize() == 0) {
			throw new IllegalStateException("totalRunTime: no songs in the playlist");
		}
		Song longSong = songs.getAt(0);
		int i = 1;
		while (i < songs.getSize()) {
			if (longSong.getRunTime() > songs.getAt(i).getRunTime()) {
				i++;
			}
			else if (longSong.getRunTime() < songs.getAt(i).getRunTime()) {
				longSong = songs.getAt(i);
				i++;
			}
		}
		return longSong;
	}
	
	
	public String toString() {
		return songs.toString();
	}
}
