//Christian Wolff

//class thats job is to create new variable video game
//contains two Strings, game and console
public class VideoGame {
	private String game;
	private String console;
	public VideoGame() {
		this.setGame("none");
		this.setConsole("none");
	}
	//initiates video game given game and console
	public VideoGame(String agame, String aConsole) {
		this.setGame(agame);
		this.setConsole(aConsole);
	}
	//sets the variable console to a string given its not null otherwise it become "none"
	public void setConsole(String aConsole) {
		if(aConsole != null)
			this.console = aConsole;
		else
			this.console = "none";
	}
	//sets the variable game to a string given its not null otherwise it become "none"
	public void setGame(String aGame) {
		if(aGame != null)
			this.game = aGame;
		else
			this.game = "none";
	}
	//returns console
	public String getConsole() {
		return this.console;
	}
	//returns game
	public String getGame() {
		return this.game;
	}
	//writes a video game as a string
	public String toString() {
		return this.getGame() + "\t" + this.getConsole();
	}
}
