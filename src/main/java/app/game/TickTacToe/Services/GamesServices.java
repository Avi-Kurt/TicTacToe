package app.game.TickTacToe.Services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import app.game.TickTacToe.Beans.Player;
import app.game.TickTacToe.Repositories.PlayersRepository;

@Service
@Transactional
@Scope("prototype")
//Game's Services Layer.
public class GamesServices {

	//Injected Dependencies.
	@Autowired
	private PlayersRepository playersRepository;


	//Default Constructor.
	private GamesServices() {

	}


	//Available Services.
	//2. Create New Player Record in the DataBase.
	public String createNewPlayer(Player newPlayer) {

		//Password Validation.
		if(playersRepository.findByPassword(newPlayer.getPassword())!= null) {

			//Server Response to Client.
			return "ERROR: Password Alredy Exist in the System! <br> Please try Another Password.";

		}else {

			//Created New Player in the Database.
			playersRepository.save(newPlayer);

			//Server Response to Client.
			return "Players Wes Created Successfully!";
		}
	}

	//2. Update Total Games Record in the DataBase of Current Players.
	public void updatePlayerTotalGames(Player playerOne, Player playerTwo) {

		//Update Players Records.
		playerOne.setTotalGames( playerOne.getTotalGames()+1 );
		playerTwo.setTotalGames( playerTwo.getTotalGames()+1 );

		//Save Updated Players Records in the Database.
		playersRepository.save(playerOne);
		playersRepository.save(playerTwo);
	}

	//3. Update Winners Winning Record in the DataBase.
	public void updatePlayerTotalGames(Player winnerPlayer) {

		//Update Player Records.
		winnerPlayer.setWins( winnerPlayer.getWins()+1 );

		//Save Updated Player Records in the Database.
		playersRepository.save(winnerPlayer);
	}

	//4. Delete Existing Player Record from the DataBase.
	public String deleteExistingPlayer(Player existingPlayer) {

		//Existence Validation.
		if(playersRepository.findById(existingPlayer.getId())== null) {

			//Server Response to Client.
			return "ERROR: Current Player Doesn't Exist in the System!";

		}else {

			//Delete Existing Player from the Database.
			playersRepository.deleteById(existingPlayer.getId());

			//Server Response to Client.
			return "Players Wes Deleted Successfully!";
		}
	}

}
