package sa1;
/**
 * 
 * @author Stephaan Silne
 * @class CS 284: Data Structures
 * @assignment Special Assignment 1
 * @date 04/01/2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {
	
			
		
	
	@Test
	void SongTest() {
		Song song1 = new Song("Peaches", "Justin","Bieber", 217);
		Song song2 = new Song("Yummy", "Justin","Bieber", 11);
		Song song3 = new Song("Changes", "Justin",null, 0);
	}

	@Test
	void PlaylistTest() {
		  Song song4 = new Song("Cardigan","Taylor","Swift", 304); 
		  Song song5 = new Song("Up", "Cardi","B", 189); 
		  Song song6 = new Song("Driver's License", "Olivia","Rodrigo", 199); 
		  Song song7 =new Song("Levitating", "Dua","Lipa", 211);
		  Playlist p = new Playlist(song4);
		  Playlist p1 = new Playlist();
		  p1.addSong(song6);
		  p1.addSong(song7);
		  System.out.println(p1.getSize());
		  System.out.println(p1.totalRunTime());
		  p1.addSong(song5);
		  System.out.println(p1.longestSong());
		  System.out.println(p.getAt(2));
	}
	
	@Test
	void PlayrTest() {
		  Song song13 = new Song("Positions", "Ariana","Grande", 200); 
		  Song song8 = new Song("Body","Megan Thee","Stallion", 180); 
		  Song song9 = new Song("LoveSick Girls","Black","Pink", 201); 
		  Song song10 = new Song("XS", "Rina","Sawayama", 201);
		  Song song11 = new Song("Streets", "Doja","Cat", 199);
		  Song song12 = new Song("Telepatia", "Kali","Uchis", 181);
		  Playlist m = new Playlist();
		  m.addSong(song13);
		  m.addSong(song8);
		  m.addSong(song9);
		  m.addSong(song10);
		  m.addSong(song11);
		  m.addSong(song12);
		  System.out.println(m.getAt(5));
		  System.out.println(m.getSize());
		  System.out.println(m.longestSong());
		  Player pl = new Player(m);
		  System.out.println(pl.getAllSongs());
		  System.out.println(pl.getTotalRuntime());
		  System.out.println(pl.getPlayQueueSize());
		  System.out.println(pl.getRemainingRunTime());
		  pl.playNextSong();
		  System.out.println(pl.getRemainingRunTime());
		  System.out.println(pl.getCurrentSong());
		  pl.playNextSong();
		  System.out.println(pl.getCurrentSong());
		  System.out.println(pl.getRemainingRunTime());
		  pl.clearQueue();
		  System.out.println(pl.getPlayQueueSize());
		  System.out.println(pl.getTotalRuntime());
	}
	

}
