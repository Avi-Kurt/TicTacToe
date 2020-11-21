package app.game.TickTacToe.Services;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import app.game.TickTacToe.Beans.Player;
import app.game.TickTacToe.Repositories.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;


@Service
@Transactional
@Scope("prototype")
//Player's Services Layer.
public class PlayersServices {

	//Instance Attributes.
	private int playerID=0;

	//Injected Dependencies.
	@Autowired
	private PlayersRepository playersRepository;


	//Composed Constructor.
	public PlayersServices(int playerID) {
		this.playerID=playerID;
	}


	//Available Services.
	//1. Update Name Record in the DataBase of Current Logged Player.
	public String updatePlayerName(int playerID, String newName) {

		//Gather current Player from Database.
		Player DBplayer = playersRepository.findById(playerID);

		//Update Players Name.
		DBplayer.setName(newName);

		//Save Updated Player in the Database.
		playersRepository.save(DBplayer);

		//Server Response to Client.
		return "Players Name Wes Updated Successfully!";
	}

	//2. Update Password Record in the DataBase of Current Logged Player.
	public String updatePlayerPassword(int playerID, String newPassword) {

		//Password Validation.
		if(playersRepository.findByPassword(newPassword)!= null) {

			//Server Response to Client.
			return "ERROR: Password Alredy Exist in the System! <br> Please try Another Password.";

		}else {

			//Gather current Player from Database.
			Player DBplayer = playersRepository.findById(playerID);

			//Update Players Password.
			DBplayer.setPassword(newPassword);

			//Save Updated Player in the Database.
			playersRepository.save(DBplayer);

			//Server Response to Client.
			return "Players Password Wes Updated Successfully!";
		}
	}

}
