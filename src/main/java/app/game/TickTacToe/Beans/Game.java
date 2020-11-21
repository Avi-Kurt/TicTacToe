package app.game.TickTacToe.Beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//Games Spring Bean Model.
public class Game implements Serializable{

	//Instance Attributes.
	private static final long serialVersionUID = -243967190523908636L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Player playerOne;
	private Player playerTwo;
	private String playerOneName;
	private String playerTwoName;
	private String winnersName;


	//Composed Constructor.
	private Game(Player playerOne, Player playerTwo) {
		setPlayerOne(playerOne);
		setPlayerTwo(playerTwo);
		setPlayerOneName(playerOne.getName());
		setPlayerTwoName(playerTwo.getName());
	}


	//Setters Methods.
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	public void setWinnersName(String winnersName) {
		this.winnersName = winnersName;
	}
	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}
	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

	//Getters Methods.
	public int getId() {
		return id;
	}
	public Player getPlayerOne() {
		return playerOne;
	}
	public Player getPlayerTwo() {
		return playerTwo;
	}


	public String getWinnersName() {
		return winnersName;
	}
	public String getPlayerOneName() {
		return playerOneName;
	}


	public String getPlayerTwoName() {
		return playerTwoName;
	}


}