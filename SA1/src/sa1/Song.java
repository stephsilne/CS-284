package sa1;
/**
 * 
 * @author Stephaan Silne
 * @class CS 284: Data Structures
 * @assignment Special Assignment 1
 * @date 04/01/2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 */
public class Song {
	
	private String name;			//Name of the song
	private String artistFirstName;	//Artist's first name
	private String artistLastName;	//Artist's last name
	private int runTime;			//Run time of the song in seconds
	
	public Song(String name, String artistFirstName, String artistLastName, int runTime) {
		if (name == null || artistFirstName == null || artistLastName == null) {
			throw new IllegalArgumentException("Song: please put in all attributes.");
		}
		else if(runTime <= 0) {
			throw new IllegalArgumentException("Song: please put an appropriate runtime.");
		}
		this.name = name;
		this.artistFirstName = artistFirstName;
		this.artistLastName = artistLastName;
		this.runTime = runTime;
	}

	public String getName() {
		return name;
	}

	public String getArtistFirstName() {
		return artistFirstName;
	}

	public String getArtistLastName() {
		return artistLastName;
	}
	
	public int getRunTime() {
		return runTime;
	}
	
	public String toString() {
		return this.name + ", by " + this.artistFirstName + " " + this.artistLastName + ", runtime " + this.runTime + " seconds.";
	}
}
