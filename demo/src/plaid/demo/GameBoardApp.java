package plaid.demo;


import javax.swing.JFrame;

public class GameBoardApp extends JFrame{

	private static final long serialVersionUID = 3701846206299130963L;
	
	private static final int COLS = 25;
	private static final int ROWS = 25;
	private static final int CELLSIZE = 20;

	private GameBoardPanel ui;

	  private GameBoardApp() {
	    ui = new GameBoardPanel(
	    		new BoardGameGrid<PlaidCellProxy>(COLS, ROWS, new PlaidCellProxyFactory()),
	    		CELLSIZE);     
	    add ("Center", ui);   
	  }

	  static public void main (String argv[]) {     
		GameBoardApp a = new GameBoardApp();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    a.setResizable(false);   
		a.pack();
	    a.setVisible(true);
	  } 
}
