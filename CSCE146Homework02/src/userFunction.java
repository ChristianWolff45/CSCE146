//Christian Wolff

//class thats responsibility is searching through a Linked List of type Video game
public class userFunction {
	GenLL<VideoGame> genLL = new GenLL<VideoGame>();
	public GenLL<VideoGame> search(String aGame, String aConsole, GenLL<VideoGame> gLL) {
		while(gLL != null) {
			if(aGame.equals("*") && aConsole.equals("*"))
				return gLL;
			if(aGame.equals("*"))
				return searchConsole(aConsole, gLL);
			if(aConsole.equals("*"))
				return searchGame(aGame, gLL);
			else
				return searchConsole(aConsole, searchGame(aGame, gLL));
		}
		return null;
	}
	//searches a linked list<VideoGame> returns a linked list of where the game matches aGame even if search is just a partial match
	public GenLL<VideoGame> searchGame(String aGame, GenLL<VideoGame> gLL) {
		aGame = aGame.toLowerCase();
		GenLL<VideoGame> search = new GenLL<VideoGame>();
		gLL.reset();
		String g =  gLL.getCurrent().getGame();
		while(!gLL.isEnd()) {
			for(int i=0; i<g.length()+1 - aGame.length(); i ++) {
				String subG =g.substring(i, i+aGame.length());
				subG = subG.toLowerCase();
				if(aGame.equals(subG)) {
					search.add(gLL.getCurrent());
					i = g.length()+1 - aGame.length();
				}
			}
			gLL.goNext();
			g = gLL.getCurrent().getGame();
		}
		return search;
	}

	//searches a linked list<VideoGame> returns a linked list of where the console matches aConsole even if search is just a partial match
	public GenLL<VideoGame> searchConsole(String aConsole, GenLL<VideoGame> gLL) {
		aConsole = aConsole.toLowerCase();
		GenLL<VideoGame> search = new GenLL<VideoGame>();
		gLL.reset();
		if(gLL.getCurrent() == null)
			return null;
		
		String c =  gLL.getCurrent().getConsole();
		do{
			for(int i=0; i<c.length()+1 - aConsole.length(); i ++) {
				String subC = c.substring(i, i + aConsole.length());
				subC = subC.toLowerCase();
				if(aConsole.equals(subC)) {
					search.add(gLL.getCurrent());
					i = c.length()+1 - aConsole.length();
				}
			}
			gLL.goNext();
			c = gLL.getCurrent().getConsole();
		}while(!gLL.isEnd()); 
		return search;
	}
}
