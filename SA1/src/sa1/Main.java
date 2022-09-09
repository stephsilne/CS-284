package sa1;

public class Main {

	public static void main(String[] args) {
		Song s = new Song (" Highway to Hell ", "AC /", "DC", 207);
		System .out. println (s);
		//--------------------------------------------------------
		Song s1 = new Song (" Highway to Hell ", "AC /", "DC", 207);
		Song s2 = new Song (" Stairway to Heaven ", "Led", " Zepplin ", 482);
		Playlist p = new Playlist ();
		p. addSong (s1 );
		p. addSong (s2 );
		System .out. println (p);
		System .out. println (p. totalRunTime ());

		//--------------------------------------------------------------
		Song s11 = new Song (" Highway to Hell ", "AC /", "DC", 207);
		Song s22 = new Song (" Stairway to Heaven ", "Led", " Zepplin ", 482);
		Playlist pp = new Playlist ();
		pp. addSong (s11 );
		pp. addSong (s22 );
		Player y = new Player (pp);
		System .out. println (y. getCurrentSong ());
		System .out. println (" Total runtime : " + y. getTotalRuntime ());
		System .out. println (" Remaining runtime : " + y. getRemainingRunTime ());
		y. playNextSong ();
		System .out. println (y. getCurrentSong ());
		System .out. println (" Total runtime : " + y. getTotalRuntime ());
		System .out. println (" Remaining runtime : " + y. getRemainingRunTime ());
		y. playNextSong ();
		// The line above does not throw an exception !
		// We just end up with a player that 's not playing anything .
	}

}
