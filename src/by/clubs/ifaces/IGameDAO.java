package by.clubs.ifaces;

import java.util.List;

import by.clubs.model.beans.Game;
import by.clubs.utils.TheatreExeption;

/**
 * DAO interface for Game
 * @author kalachou
 *
 */
public interface IGameDAO 
{
	/**
	 * Creates new Game
	 * @param game - game to be saved
	 * @throws TheatreExeption
	 */
	public void createGame(Game game) throws TheatreExeption;
	
	/**
	 * Updates the game
	 * @param game - game to be saved
	 * @throws TheatreExeption
	 */
	public void updateGame(Game game) throws TheatreExeption;
	
	/**
	 * Gets list of the games
	 * @param currentPage - number of the page to be displayed
	 * @return List of games for current page
	 * @throws TheatreExeption
	 */
	public List<Game> getGamesList(int currentPage) throws TheatreExeption;
}
