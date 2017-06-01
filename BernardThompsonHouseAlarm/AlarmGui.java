package bernard_thompson_ca1New;

//import the required packages from the Java class library
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlarmGui {
	
	//add the fields to the class beginning with the JFrame
			
			//Field to boolean check is user has already armed/disamred the system
			boolean armed;
			
			//create the JFrame
			private JFrame frame;

			//this field will hold the current display on the JLabel/screen
			private String display;

			//create a field of type Container that will store the contentPane
			private Container contentPane;

			 //the fields below will store the JPanels
			 private JPanel topPanel, midPanel, bottomPanel;

			 //this field will store the label which will be used as a screen
			 private JLabel screen;

			 //the fields below will store the JButtons for the midPanel
			 private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bc,bp;
			 
			 private JButton arm, disarm;
			 
	public AlarmGui () {
		//display welcome message on the screen
		display = "Welcome";
		
		constructAlarmGUI();
	}
	
	//method to construct the frame
	public void makeFrame(){
		// create and set up the frame
				frame = new JFrame("Alarm Control Unit");

				// calling the makeMenuBar 
				makeMenuBar();

				
				contentPane = frame.getContentPane();

				
			     contentPane.setLayout(new BorderLayout ());

				// creating the panels
				createPanels();

				// this will display information messages
				screen = new JLabel(display);
				topPanel.add(screen);

				//buttons 0-9, Clear, Arm and Disarm.
				makeButtons();

				// ensure that the frame is made visible after all components have been
				//Set the position centered
				//set the size
				//ensure it close when x is pressed
				
				frame.pack();
				frame.setVisible(true);
				frame.setSize(400,300);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
	
	public void makeButtons()
	{

		//button objects
		//adding the  buttons to their mid JPanel

		b1    = new JButton ("1");
		midPanel.add(b1);
		b2   = new JButton ("2");
		midPanel.add(b2);
		b3   = new JButton ("3");
		midPanel.add(b3);
		b4   = new JButton ("4");
		midPanel.add(b4);
		b5    = new JButton ("5");
		midPanel.add(b5);
		b6   = new JButton ("6");
		midPanel.add(b6);
		b7    = new JButton ("7");
		midPanel.add(b7);
		b8   = new JButton ("8");
		midPanel.add(b8);
		b9    = new JButton ("9");
		midPanel.add(b9);
		b0   = new JButton ("0");
		midPanel.add(b0);
		bc    = new JButton ("Clear");
		midPanel.add(bc);
		bp   = new JButton ("Panic");
		midPanel.add(bp);
		
		
		arm = new JButton ("Arm Alarm");
		bottomPanel.add(arm);
		disarm = new JButton ("Disarm Alarm");
		bottomPanel.add(disarm);
		//add the  buttons to their respective JPanels
		


	}
	
	public void createPanels() {

		// creating  JPanels and adding them to contentPane to enable a Border Layout


		// create instances of the JPanels
		topPanel = new JPanel(new FlowLayout());
		topPanel.setBackground(Color.GREEN);
		topPanel.setSize(400,400);
		topPanel.setOpaque(true);
		
		midPanel = new JPanel(new GridLayout(4,3));
		topPanel.setOpaque(true);
		
		bottomPanel = new JPanel(new FlowLayout());
		bottomPanel.setSize(400,400);
		bottomPanel.setBackground(Color.GREEN);
		bottomPanel.setOpaque(true);




		// selecting the position of each JPanel
		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(midPanel, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);

	}
	
	private void makeMenuBar()
	{
		//creating the menu bar buttons and using short keys
		final int SHORTCUT_MASK =
				Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu menu;
		JMenuItem item;
		
		menu = new JMenu("File");
		menubar.add(menu);
		
		item = new JMenuItem("Quit");
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, SHORTCUT_MASK));
			item.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING",
						        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						// yes option
						MenuBar mu = new MenuBar();
						mu.quit();
						} 
					}
					
				
			});
		menu.add(item);
		
		menu = new JMenu("Help");
		menubar.add(menu);
		
		item = new JMenuItem("Instructions");
			
			item.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					showInstructions();
				}
			});
		menu.add(item);
		
		item = new JMenuItem("About");
			
			item.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					showAbout();
				}
			});
		menu.add(item);
		
			
	}
//methods to be implemented in menuBar
	

	private void showInstructions()
	{
		JOptionPane.showMessageDialog(frame,
				"Code: 1234\nTo ARM Alarm enter code, then press ARM\nTo DISARM Alarm enter code, then press DISARM\nTo sound alarm press PANIC button"
				);
	}

	private void showAbout()
	{
		JOptionPane.showMessageDialog(frame,
				"Written by Bernard Thompson\n CA 1"
			);
	}
	
	
	public void addEventHandlers(){
		
		//creating buttons 0-9 and arm clear and disarm. Ensuring to delete screen message and add numbers as strings
		 b1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 String command = e.getActionCommand();
				 screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				 else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b3.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				 else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b4.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				 else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b5.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				 else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b6.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				 else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b7.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				 else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b8.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				 else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b9.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText("");
				 }
				 else if(screen.getText().equals("Wrong code, please enter again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System already disarmed")){
					 screen.setText("");
				 }
				 
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 b0.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
				 if(screen.getText().equals("Welcome")){
					 screen.setText(""); 
				 }
				 else if(screen.getText().equals("Wrong code, please try again")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("System Armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Panic Alarm Sounded!")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("The system has already been armed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Alarm DisArmed")){
					 screen.setText("");
				 }
				 else if (screen.getText().equals("Error, please try again")){
					 screen.setText("");
				 }
				 
				 String command = e.getActionCommand();
					screen.setText(screen.getText() + command);
				
			 }
		 });
		 
		 bp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
					{
					screen.setText("Panic Alarm Sounded!");
					topPanel.setBackground(Color.RED);
					topPanel.setOpaque(true);
					bottomPanel.setBackground(Color.RED);
					topPanel.setOpaque(true);
					


				}
			});
		 
		 bc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
					{
					screen.setText("\n");
				}
			});
			
			//arm button, if statement checks to see if the alarm has already been armed
		 
			arm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
					{
					if(armed == true){
						screen.setText("The system has already been armed");
					}
					else if( screen.getText().equals("1234")){
						screen.setText("System Armed");
						topPanel.setBackground(Color.RED);
						topPanel.setOpaque(true);
						bottomPanel.setBackground(Color.RED);
						topPanel.setOpaque(true);
						armed = true;
						
	
					}
					
					else{
						screen.setText("Wrong code, please enter again");
						topPanel.setBackground(Color.GREEN);
						topPanel.setOpaque(true);
						bottomPanel.setBackground(Color.GREEN);
						topPanel.setOpaque(true);
						
					}
					
					

				}
			});
			
					
			disarm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
					{
					if(armed == false){
						screen.setText("System already disarmed");
					}
					else if(screen.getText().equals("1234")){
						screen.setText("Alarm DisArmed");
						topPanel.setBackground(Color.GREEN);
						topPanel.setOpaque(true);
						bottomPanel.setBackground(Color.GREEN);
						topPanel.setOpaque(true);
						armed = false;
					}
					else{
						screen.setText("Error, please try again");
					}
				

				}
			});
		
	}
	
	public void constructAlarmGUI() {

		// call the make frame method
		makeFrame();
		// call the eventHandlers methid
		addEventHandlers();
		

	}
	
	
	
		
		
}
	



