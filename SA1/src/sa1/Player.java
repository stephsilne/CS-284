package sa1;
/**
 * 
 * @author Stephaan Silne
 * @class CS 284: Data Structures
 * @assignment Special Assignment 1
 * @date 04/01/2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 */
import java.util.*;

public class Player {

	private static class Node<F> {
		private F data;
		private Node<F> next;
		
		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Node(F data) {
			super();
			this.data = data;
		}
	}
	
	private Node<Song> currentSong;	//The currently playing / first song in the queue
	private Node<Song> lastSong;	//The last song in the queue
	private int playQueueSize;		//The total amount of songs in the play queue
	private int totalRunTime;		//The amount of time the player has played; intended to only go up

	public Player() {
		currentSong = null;
		lastSong = null;
		playQueueSize = 0;
		totalRunTime = 0;
	}
	
	public Player(Playlist plist) {
		if (plist.getSize() == 0) {
			throw new IllegalArgumentException("Player: needs a full playlist.");
		}
		lastSong = new Node <Song>(plist.getAt(0));
		currentSong = lastSong;
		playQueueSize ++;
		int i = 1;
		while (i <= plist.getSize()-1) {
			lastSong.next = new Node<Song>(plist.getAt(i));
			lastSong = lastSong.next;
			playQueueSize ++;
			i++;
		}
		totalRunTime = currentSong.data.getRunTime();
	}
	
	public int getTotalRuntime() {
		return totalRunTime;
	}
	;
	public int getPlayQueueSize() {
		return playQueueSize;
	}
	
	public Song getCurrentSong() {
		if (currentSong == null) {
			throw new IllegalArgumentException("getCurrentSong: no songs currently playing");
		}
		return currentSong.data;
	}

	public ArrayList<Song> getAllSongs(){
		if (playQueueSize == 0) {
			throw new IllegalArgumentException("getAllSongs: no songs in the play queue");
		}
		ArrayList<Song> arr = new ArrayList<Song>();
		Node<Song> current = currentSong;
		while(current != null) {
			arr.add(current.data);
			current = current.next;
		}
		return arr;
	}
	
	public int getRemainingRunTime() {
		if (playQueueSize == 0) {
			throw new IllegalArgumentException("getAllSongs: no songs in the play queue");
		}
		
		if (currentSong == lastSong) {
			return 0;
		}
		int rrtime = 0;
		Node <Song> current = currentSong;
		current = current.next;
		while (current != null) {
			rrtime = rrtime + current.data.getRunTime();
			current = current.next;
		}
		return rrtime;
	}
	
	public void playNextSong() {
		if (currentSong == null) {
			throw new IllegalArgumentException("playNextSong: player is not playing anything");
		}
		else if (currentSong.next != null){
		currentSong = currentSong.next;
		totalRunTime = totalRunTime + currentSong.data.getRunTime();
		playQueueSize--;
		}
	}
	
	public void clearQueue() {
		while (currentSong != null) {
			currentSong = currentSong.next;
			playQueueSize--;
		}
	}
	
	public void addSong(Song song) {
		if (currentSong == null) {
			lastSong = new Node<Song>(song);
			currentSong = lastSong;
		}
		else {
		lastSong.next = new Node<Song>(song);
		lastSong = lastSong.next;
		}
		playQueueSize++;
	}
}
