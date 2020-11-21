package app.game.TickTacToe.Repositories;

import app.game.TickTacToe.Beans.Player;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
//Player's Repository Layer.
public interface PlayersRepository extends JpaRepository<Player, Integer>{

	//Returns Entity of Player with Current ID from Database.
	public Player findById(int playerID);
	
	//Returns Entity of Player with Current Password from Database.
	public Player findByPassword(String playersPassword);
	
	//Returns Entity of Player with Current Name AND Password from Database.
	public Player findByNameAndPassword(String playersName, String playersPassword);

}
