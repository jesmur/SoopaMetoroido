//Player Vs Player Program
//Author: Jessica Murray
//A GUI text based game in which a user plays a dice roll game against randomly generated monsters.
//The player rolls for their stats, which affects the speed and progression of the game. 

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GameApp {
	
	// initialize new game
	private Game soopaMetoroido = new Game();
	
	// load in icons for UI
	// Credits for themes and images to Super Metroid by Nintendo
	private Icon zeroSuit = new ImageIcon(getClass().getResource("img/zerosuit.png"));
	private Icon powerSuit = new ImageIcon(getClass().getResource("img/powersuit.png"));
	private Icon variaSuit = new ImageIcon(getClass().getResource("img/variasuit.png"));
	private Icon gravitySuit = new ImageIcon(getClass().getResource("img/gravitysuit.png"));
	private Icon zeroSuitBattle = new ImageIcon(getClass().getResource("img/zero_battle.png"));
	private Icon powerSuitBattle = new ImageIcon(getClass().getResource("img/power_battle.png"));
	private Icon variaSuitBattle = new ImageIcon(getClass().getResource("img/varia_battle.png"));
	private Icon gravitySuitBattle = new ImageIcon(getClass().getResource("img/gravity_battle.png"));
	private Icon metroid = new ImageIcon(getClass().getResource("img/metroid.png"));
	private Icon arachnus = new ImageIcon(getClass().getResource("img/arachnus.png"));
	private Icon sidehopper = new ImageIcon(getClass().getResource("img/sidehopper.png"));
	private Icon spacePirate = new ImageIcon(getClass().getResource("img/spacepirate.png"));
	private Icon ridley = new ImageIcon(getClass().getResource("img/ridley.png"));
	
	// global variable to keep track of hit points
	private int currentPlayerHP;
	private int currentAlienHP;

	// GUI elements
	private JFrame frame;
	private JTextField textFieldNameEntry;
	private JTextField textFieldHPRoll;
	private JTextField textFieldAttackRoll;
	private JTextField textFieldDefenceRoll;
	private JTextField textFieldSpeedRoll;
	private JRadioButton rdbtnPowerSuit;
	private final ButtonGroup buttonGroupSuit = new ButtonGroup();
	private final ButtonGroup buttonGroupWeapon = new ButtonGroup();
	private JTextArea textAreaWeaponDesc;
	private JTextArea textAreaCombatLog = new JTextArea();
	private JTextField textFieldPlayerHP;
	private JTextField textFieldAlienHP;
	private JButton btnReturnToUpgrade = new JButton("Upgrade Station");
	private JButton btnNextAlien = new JButton("Next Alien");
	private JButton btnRollStats = new JButton("Roll Stats");

	private JLabel lblCurrentCreditNumber = new JLabel("");
	private JLabel lblAlienBattlePic = new JLabel("");
	private JLabel lblSuitImage = new JLabel("");		
	private JLabel lblHunterBattlePic = new JLabel("");
	private final int animationDelay = 400; // 400 millisecond delay
	private Timer timer = new Timer(animationDelay, new TimerHandler());



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				GameApp window = new GameApp();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	private GameApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Monospaced", Font.BOLD, 13));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GameApp.class.getResource("/img/icon.png")));
		frame.setBounds(100, 100, 666, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelSplashPage = new JPanel();
		panelSplashPage.setBorder(null);
		panelSplashPage.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panelSplashPage, "name_16204071182081");
		panelSplashPage.setLayout(null);
		
		JPanel panelHero = new JPanel();
		panelHero.setBorder(null);
		panelHero.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panelHero, "name_16208462033069");
		panelHero.setLayout(null);
		
		JPanel panelUpgradeShop = new JPanel();
		panelUpgradeShop.setBackground(Color.BLACK);
		frame.getContentPane().add(panelUpgradeShop, "name_16210166572101");
		panelUpgradeShop.setLayout(null);
		
		JPanel panelBattle = new JPanel();
		panelBattle.setBackground(Color.BLACK);
		frame.getContentPane().add(panelBattle, "name_16211576370871");
		panelBattle.setLayout(null);
		
		lblHunterBattlePic.setIcon(new ImageIcon(GameApp.class.getResource("/img/zero_battle.PNG")));
		lblHunterBattlePic.setBackground(Color.BLACK);
		lblHunterBattlePic.setBounds(24, 48, 150, 204);
		panelBattle.add(lblHunterBattlePic);
		
		lblAlienBattlePic.setBounds(472, 48, 150, 204);
		panelBattle.add(lblAlienBattlePic);
		
		JLabel lblCombatLog = new JLabel("Combat Log");
		lblCombatLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombatLog.setFont(new Font("Monospaced", Font.BOLD, 26));
		lblCombatLog.setForeground(new Color(0, 128, 0));
		lblCombatLog.setBounds(229, 0, 186, 35);
		panelBattle.add(lblCombatLog);
		
		JLabel lblPlayerName = new JLabel("");
		lblPlayerName.setForeground(new Color(210, 105, 30));
		lblPlayerName.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblPlayerName.setBounds(24, 263, 150, 19);
		panelBattle.add(lblPlayerName);
		
		JLabel lblAlienName = new JLabel("");
		lblAlienName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAlienName.setForeground(new Color(210, 105, 30));
		lblAlienName.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblAlienName.setBounds(472, 263, 150, 19);
		panelBattle.add(lblAlienName);
		
		textFieldPlayerHP = new JTextField();
		textFieldPlayerHP.setEditable(false);
		textFieldPlayerHP.setBounds(24, 283, 86, 20);
		panelBattle.add(textFieldPlayerHP);
		textFieldPlayerHP.setColumns(10);
		
		textFieldAlienHP = new JTextField();
		textFieldAlienHP.setEditable(false);
		textFieldAlienHP.setBounds(536, 283, 86, 20);
		panelBattle.add(textFieldAlienHP);
		textFieldAlienHP.setColumns(10);
		
		btnReturnToUpgrade.setForeground(new Color(255, 204, 51));
		btnReturnToUpgrade.setBackground(Color.DARK_GRAY);
		btnReturnToUpgrade.addActionListener(arg0 -> {
			panelBattle.setVisible(false);
			panelUpgradeShop.setVisible(true);
			refreshCredits();
		});
		btnReturnToUpgrade.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnReturnToUpgrade.setBounds(141, 308, 150, 35);
		panelBattle.add(btnReturnToUpgrade);
		
		btnNextAlien.addActionListener(arg0 -> {
			// button to proceed to next fight
			btnReturnToUpgrade.setEnabled(false);
			btnNextAlien.setEnabled(false);
			soopaMetoroido.determineAlien();
			setAlienPic();
			lblAlienName.setText(soopaMetoroido.randomAlien.getName() + " HP");
			lblPlayerName.setText(soopaMetoroido.spaceHunter.getName() + " HP");
			textAreaCombatLog.setText(null);
			currentPlayerHP = soopaMetoroido.spaceHunter.getHitPoints();
			currentAlienHP = soopaMetoroido.randomAlien.getHitPoints();
			textFieldPlayerHP.setText(currentPlayerHP + "/" + soopaMetoroido.spaceHunter.getHitPoints());
			textFieldAlienHP.setText(currentAlienHP + "/" + soopaMetoroido.randomAlien.getHitPoints());

			timer.start(); // starts the battle
		});
		btnNextAlien.setEnabled(false);
		btnNextAlien.setBackground(Color.DARK_GRAY);
		btnNextAlien.setForeground(new Color(255, 204, 51));
		btnNextAlien.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnNextAlien.setBounds(363, 308, 150, 35);
		panelBattle.add(btnNextAlien);
		
		JScrollPane scrollPaneCombatLog = new JScrollPane();
		scrollPaneCombatLog.setFocusable(false);
		scrollPaneCombatLog.setViewportBorder(new LineBorder(Color.DARK_GRAY));
		scrollPaneCombatLog.setForeground(Color.BLACK);
		scrollPaneCombatLog.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPaneCombatLog.setBackground(Color.DARK_GRAY);
		scrollPaneCombatLog.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCombatLog.setAutoscrolls(true);
		scrollPaneCombatLog.setBounds(190, 48, 272, 216);
		panelBattle.add(scrollPaneCombatLog);
		scrollPaneCombatLog.setViewportView(textAreaCombatLog);
		textAreaCombatLog.setBorder(new LineBorder(new Color(218, 165, 32)));
		textAreaCombatLog.setMargin(new Insets(4, 4, 4, 4));
		textAreaCombatLog.setFont(new Font("Monospaced", Font.BOLD, 12));
		textAreaCombatLog.setForeground(new Color(255, 255, 255));
		textAreaCombatLog.setBackground(new Color(0, 0, 0));
		textAreaCombatLog.setWrapStyleWord(true);
		textAreaCombatLog.setLineWrap(true);
		textAreaCombatLog.setEditable(false);
		
		panelSplashPage.setVisible(true);
		panelHero.setVisible(false);
		panelUpgradeShop.setVisible(false);
		panelBattle.setVisible(false);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setFocusPainted(false);
		btnStartGame.addActionListener(arg0 -> {
			panelSplashPage.setVisible(false);
			panelHero.setVisible(true);
		});
		btnStartGame.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnStartGame.setBackground(Color.DARK_GRAY);
		btnStartGame.setForeground(new Color(204, 0, 0));
		btnStartGame.setBounds(267, 307, 125, 36);
		panelSplashPage.add(btnStartGame);
		
		JLabel lblSoopa = new JLabel("S00PA");
		lblSoopa.setForeground(new Color(204, 0, 0));
		lblSoopa.setBackground(new Color(255, 0, 0));
		lblSoopa.setFont(new Font("Wide Latin", Font.PLAIN, 35));
		lblSoopa.setBounds(214, 27, 250, 47);
		panelSplashPage.add(lblSoopa);
		
		JLabel lblMetoroido = new JLabel("METOROIDO");
		lblMetoroido.setForeground(new Color(204, 0, 0));
		lblMetoroido.setFont(new Font("Wide Latin", Font.BOLD, 40));
		lblMetoroido.setBounds(73, 57, 513, 59);
		panelSplashPage.add(lblMetoroido);
		
		JLabel lblBackgroundImg = new JLabel("");
		lblBackgroundImg.setIcon(new ImageIcon(GameApp.class.getResource("/img/background.jpg")));
		lblBackgroundImg.setBounds(-34, 0, 684, 354);
		panelSplashPage.add(lblBackgroundImg);
		
		JLabel labelNoSuitSamusImg = new JLabel("");
		labelNoSuitSamusImg.setIcon(new ImageIcon(GameApp.class.getResource("/img/nosuitsamus.PNG")));
		labelNoSuitSamusImg.setBounds(498, 11, 146, 343);
		panelHero.add(labelNoSuitSamusImg);
		
		JLabel lblWhatIsYourName = new JLabel("What is your name, Space Hunter?");
		lblWhatIsYourName.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblWhatIsYourName.setForeground(new Color(210, 105, 30));
		lblWhatIsYourName.setBounds(21, 22, 370, 22);
		panelHero.add(lblWhatIsYourName);
		
		textFieldNameEntry = new JTextField();
		textFieldNameEntry.setFont(new Font("Monospaced", Font.BOLD, 12));
		textFieldNameEntry.setBackground(new Color(255, 255, 255));
		textFieldNameEntry.setBounds(31, 58, 225, 20);
		panelHero.add(textFieldNameEntry);
		textFieldNameEntry.setColumns(10);
		
		JLabel lblRollForStats = new JLabel("You must roll for your base stats");
		lblRollForStats.setForeground(new Color(210, 105, 30));
		lblRollForStats.setBackground(new Color(255, 255, 255));
		lblRollForStats.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblRollForStats.setBounds(21, 89, 370, 30);
		panelHero.add(lblRollForStats);
		
		textFieldHPRoll = new JTextField();
		textFieldHPRoll.setFont(new Font("Monospaced", Font.BOLD, 15));
		textFieldHPRoll.setForeground(new Color(0, 0, 0));
		textFieldHPRoll.setEditable(false);
		textFieldHPRoll.setBackground(new Color(153, 153, 153));
		textFieldHPRoll.setBounds(21, 134, 77, 20);
		panelHero.add(textFieldHPRoll);
		textFieldHPRoll.setColumns(10);
		
		textFieldAttackRoll = new JTextField();
		textFieldAttackRoll.setFont(new Font("Monospaced", Font.BOLD, 15));
		textFieldAttackRoll.setEditable(false);
		textFieldAttackRoll.setBackground(new Color(153, 153, 153));
		textFieldAttackRoll.setBounds(21, 180, 77, 20);
		panelHero.add(textFieldAttackRoll);
		textFieldAttackRoll.setColumns(10);
		
		textFieldDefenceRoll = new JTextField();
		textFieldDefenceRoll.setFont(new Font("Monospaced", Font.BOLD, 15));
		textFieldDefenceRoll.setEditable(false);
		textFieldDefenceRoll.setBackground(new Color(153, 153, 153));
		textFieldDefenceRoll.setBounds(21, 225, 77, 20);
		panelHero.add(textFieldDefenceRoll);
		textFieldDefenceRoll.setColumns(10);
		
		textFieldSpeedRoll = new JTextField();
		textFieldSpeedRoll.setFont(new Font("Monospaced", Font.BOLD, 15));
		textFieldSpeedRoll.setEditable(false);
		textFieldSpeedRoll.setBackground(new Color(153, 153, 153));
		textFieldSpeedRoll.setBounds(21, 270, 77, 20);
		panelHero.add(textFieldSpeedRoll);
		textFieldSpeedRoll.setColumns(10);
		
		JLabel lblHPlabel = new JLabel("Hit Points");
		lblHPlabel.setForeground(new Color(0, 128, 0));
		lblHPlabel.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblHPlabel.setBounds(21, 120, 96, 14);
		panelHero.add(lblHPlabel);
		
		JLabel lblHPDesc = new JLabel("How many hits can be sustained before dying");
		lblHPDesc.setBackground(new Color(204, 204, 204));
		lblHPDesc.setForeground(new Color(204, 204, 204));
		lblHPDesc.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblHPDesc.setBounds(108, 136, 350, 14);
		panelHero.add(lblHPDesc);
		
		JLabel lblAttackDesc = new JLabel("How much damage is dealt per hit");
		lblAttackDesc.setBackground(new Color(204, 204, 204));
		lblAttackDesc.setForeground(new Color(204, 204, 204));
		lblAttackDesc.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblAttackDesc.setBounds(108, 182, 350, 14);
		panelHero.add(lblAttackDesc);
		
		JLabel lblDefenceDesc = new JLabel("How much damage is resisted per hit taken");
		lblDefenceDesc.setBackground(new Color(204, 204, 204));
		lblDefenceDesc.setForeground(new Color(204, 204, 204));
		lblDefenceDesc.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblDefenceDesc.setBounds(108, 227, 350, 14);
		panelHero.add(lblDefenceDesc);
		
		JLabel lblAttack = new JLabel("Attack");
		lblAttack.setForeground(new Color(0, 128, 0));
		lblAttack.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblAttack.setBounds(21, 165, 54, 14);
		panelHero.add(lblAttack);
		
		JLabel lblDefence = new JLabel("Defence");
		lblDefence.setForeground(new Color(34, 139, 34));
		lblDefence.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblDefence.setBounds(21, 211, 96, 14);
		panelHero.add(lblDefence);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setForeground(new Color(34, 139, 34));
		lblSpeed.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblSpeed.setBounds(21, 256, 96, 14);
		panelHero.add(lblSpeed);
		
		JLabel lblSpeedDesc = new JLabel("Determines who will attack first");
		lblSpeedDesc.setForeground(new Color(204, 204, 204));
		lblSpeedDesc.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblSpeedDesc.setBounds(108, 272, 350, 14);
		panelHero.add(lblSpeedDesc);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setEnabled(false);
		btnContinue.addActionListener(arg0 -> {
			// validates whether a user has entered a name and rolled stats and if so, lets the user proceed
			if (validateInput(textFieldNameEntry.getText())) {
				soopaMetoroido.spaceHunter.setName(textFieldNameEntry.getText());
				panelHero.setVisible(false);
				panelUpgradeShop.setVisible(true);
				refreshCredits();
			}
		});
		btnContinue.setForeground(new Color(255, 204, 51));
		btnContinue.setBackground(Color.DARK_GRAY);
		btnContinue.setFont(new Font("Monospaced", Font.BOLD, 15));
		btnContinue.setBounds(376, 308, 112, 23);
		panelHero.add(btnContinue);
		btnRollStats.addActionListener(arg0 -> {
			// rolls stats for player and displays to screen
			soopaMetoroido.setPlayerStats();
			textFieldHPRoll.setText(String.valueOf(soopaMetoroido.spaceHunter.getHitPoints()));
			textFieldAttackRoll.setText(String.valueOf(soopaMetoroido.spaceHunter.getAttack()));
			textFieldDefenceRoll.setText(String.valueOf(soopaMetoroido.spaceHunter.getDefence()));
			textFieldSpeedRoll.setText(String.valueOf(soopaMetoroido.spaceHunter.getSpeed()));
			// lets player continue if they have rolled stats
			btnContinue.setEnabled(true);
		});
		btnRollStats.setForeground(new Color(255, 204, 51));
		btnRollStats.setBackground(Color.DARK_GRAY);
		btnRollStats.setFont(new Font("Monospaced", Font.BOLD, 15));
		btnRollStats.setBounds(21, 308, 130, 23);
		panelHero.add(btnRollStats);
		
		JLabel lblUpgradeStation = new JLabel("Upgrade Station");
		lblUpgradeStation.setFont(new Font("Monospaced", Font.BOLD, 26));
		lblUpgradeStation.setForeground(new Color(0, 128, 0));
		lblUpgradeStation.setBounds(204, 0, 247, 30);
		panelUpgradeShop.add(lblUpgradeStation);
		
		JLabel lblSuits = new JLabel("Suit");
		lblSuits.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuits.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblSuits.setForeground(new Color(210, 105, 30));
		lblSuits.setBounds(28, 51, 158, 14);
		panelUpgradeShop.add(lblSuits);
		
		JLabel lblWeapon = new JLabel("Weapon");
		lblWeapon.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeapon.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblWeapon.setForeground(new Color(210, 105, 30));
		lblWeapon.setBounds(455, 43, 158, 30);
		panelUpgradeShop.add(lblWeapon);
		
		JLabel lblCurrentCredits = new JLabel("Current Credits");
		lblCurrentCredits.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblCurrentCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentCredits.setForeground(new Color(210, 105, 30));
		lblCurrentCredits.setBounds(235, 41, 164, 14);
		panelUpgradeShop.add(lblCurrentCredits);
		
		JTextArea textAreaSuitDesc = new JTextArea();
		textAreaSuitDesc.setEditable(false);
		textAreaSuitDesc.setWrapStyleWord(true);
		textAreaSuitDesc.setLineWrap(true);
		textAreaSuitDesc.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textAreaSuitDesc.setBackground(Color.LIGHT_GRAY);
		textAreaSuitDesc.setBounds(28, 181, 187, 93);
		textAreaSuitDesc.setText(soopaMetoroido.zeroSuit.getDesc());
		panelUpgradeShop.add(textAreaSuitDesc);
		
		textAreaWeaponDesc = new JTextArea();
		textAreaWeaponDesc.setEditable(false);
		textAreaWeaponDesc.setWrapStyleWord(true);
		textAreaWeaponDesc.setLineWrap(true);
		textAreaWeaponDesc.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textAreaWeaponDesc.setBackground(Color.LIGHT_GRAY);
		textAreaWeaponDesc.setBounds(434, 181, 179, 93);
		panelUpgradeShop.add(textAreaWeaponDesc);
		
		
		// Sets icons and descriptions for each suit and their respective radio button 
		
		JRadioButton rdbtnZeroSuit = new JRadioButton("Zero Suit");
		buttonGroupSuit.add(rdbtnZeroSuit);
		rdbtnZeroSuit.addActionListener(e -> {
			textAreaSuitDesc.setText(soopaMetoroido.zeroSuit.getDesc());
			lblSuitImage.setIcon(zeroSuit);
		});
		rdbtnZeroSuit.setSelected(true);
		rdbtnZeroSuit.setFont(new Font("Monospaced", Font.BOLD, 13));
		rdbtnZeroSuit.setForeground(new Color(255, 215, 0));
		rdbtnZeroSuit.setBackground(Color.BLACK);
		rdbtnZeroSuit.setBounds(28, 73, 158, 23);
		panelUpgradeShop.add(rdbtnZeroSuit);
		
		rdbtnPowerSuit = new JRadioButton("Power Suit");
		buttonGroupSuit.add(rdbtnPowerSuit);
		rdbtnPowerSuit.addActionListener(e -> {
			textAreaSuitDesc.setText(soopaMetoroido.powerSuit.getDesc());
			lblSuitImage.setIcon(powerSuit);
		});
		rdbtnPowerSuit.setForeground(Color.WHITE);
		rdbtnPowerSuit.setFont(new Font("Monospaced", Font.BOLD, 13));
		rdbtnPowerSuit.setBackground(Color.BLACK);
		rdbtnPowerSuit.setBounds(28, 99, 158, 23);
		panelUpgradeShop.add(rdbtnPowerSuit);
		
		JRadioButton rdbtnVariaSuit = new JRadioButton("Varia Suit");
		buttonGroupSuit.add(rdbtnVariaSuit);
		rdbtnVariaSuit.addActionListener(e -> {
			textAreaSuitDesc.setText(soopaMetoroido.variaSuit.getDesc());
			lblSuitImage.setIcon(variaSuit);
		});
		rdbtnVariaSuit.setForeground(Color.WHITE);
		rdbtnVariaSuit.setFont(new Font("Monospaced", Font.BOLD, 13));
		rdbtnVariaSuit.setBackground(Color.BLACK);
		rdbtnVariaSuit.setBounds(28, 125, 158, 23);
		panelUpgradeShop.add(rdbtnVariaSuit);
		
		JRadioButton rdbtnGravitySuit = new JRadioButton("Gravity Suit");
		buttonGroupSuit.add(rdbtnGravitySuit);
		rdbtnGravitySuit.addActionListener(e -> {
			textAreaSuitDesc.setText(soopaMetoroido.gravitySuit.getDesc());
			lblSuitImage.setIcon(gravitySuit);
		});
		rdbtnGravitySuit.setForeground(Color.WHITE);
		rdbtnGravitySuit.setFont(new Font("Monospaced", Font.BOLD, 13));
		rdbtnGravitySuit.setBackground(Color.BLACK);
		rdbtnGravitySuit.setBounds(28, 151, 158, 23);
		panelUpgradeShop.add(rdbtnGravitySuit);
		
		JRadioButton rdbtnChargeBeam = new JRadioButton("Charge Beam");
		buttonGroupWeapon.add(rdbtnChargeBeam);
		rdbtnChargeBeam.addActionListener(e -> textAreaWeaponDesc.setText(soopaMetoroido.chargeBeam.getDesc()));
		rdbtnChargeBeam.setForeground(Color.WHITE);
		rdbtnChargeBeam.setFont(new Font("Monospaced", Font.BOLD, 13));
		rdbtnChargeBeam.setBackground(Color.BLACK);
		rdbtnChargeBeam.setBounds(455, 73, 158, 23);
		panelUpgradeShop.add(rdbtnChargeBeam);
		
		JRadioButton rdbtnIceBeam = new JRadioButton("Ice Beam");
		buttonGroupWeapon.add(rdbtnIceBeam);
		rdbtnIceBeam.addActionListener(e -> textAreaWeaponDesc.setText(soopaMetoroido.iceBeam.getDesc()));
		rdbtnIceBeam.setForeground(Color.WHITE);
		rdbtnIceBeam.setFont(new Font("Monospaced", Font.BOLD, 13));
		rdbtnIceBeam.setBackground(Color.BLACK);
		rdbtnIceBeam.setBounds(455, 99, 158, 23);
		panelUpgradeShop.add(rdbtnIceBeam);
		
		JRadioButton rdbtnSpazerBeam = new JRadioButton("Spazer Beam");
		buttonGroupWeapon.add(rdbtnSpazerBeam);
		rdbtnSpazerBeam.addActionListener(e -> textAreaWeaponDesc.setText(soopaMetoroido.spazerBeam.getDesc()));
		rdbtnSpazerBeam.setForeground(Color.WHITE);
		rdbtnSpazerBeam.setFont(new Font("Monospaced", Font.BOLD, 13));
		rdbtnSpazerBeam.setBackground(Color.BLACK);
		rdbtnSpazerBeam.setBounds(455, 125, 158, 23);
		panelUpgradeShop.add(rdbtnSpazerBeam);
		
		JRadioButton rdbtnPlasmaBeam = new JRadioButton("Plasma Beam");
		buttonGroupWeapon.add(rdbtnPlasmaBeam);
		rdbtnPlasmaBeam.addActionListener(e -> textAreaWeaponDesc.setText(soopaMetoroido.plasmaBeam.getDesc()));
		rdbtnPlasmaBeam.setForeground(Color.WHITE);
		rdbtnPlasmaBeam.setFont(new Font("Monospaced", Font.BOLD, 13));
		rdbtnPlasmaBeam.setBackground(Color.BLACK);
		rdbtnPlasmaBeam.setBounds(455, 151, 158, 23);
		panelUpgradeShop.add(rdbtnPlasmaBeam);
		
		JButton btnPurchaseSuit = new JButton("Purchase Suit");
		btnPurchaseSuit.setBackground(Color.DARK_GRAY);
		btnPurchaseSuit.setForeground(new Color(255, 204, 51));
		btnPurchaseSuit.addActionListener(arg0 -> {

			// Allows player to purchase and equip suits with their credits and displays the correct credit amount

			if (rdbtnPowerSuit.isSelected()){
				if (!soopaMetoroido.powerSuit.isBought()) {
					if ((soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.powerSuit.getCost()) >= 0){
						soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.powerSuit.getCost());
						soopaMetoroido.powerSuit.setBought(true);
						soopaMetoroido.powerSuit.setDesc("PURCHASED. Basic powered armorsuit. Small bonus to defence and speed.");
						textAreaSuitDesc.setText(soopaMetoroido.powerSuit.getDesc());
						refreshCredits();
					}
				}
			}
			else if (rdbtnVariaSuit.isSelected()){
				if (!soopaMetoroido.variaSuit.isBought()){
					if ((soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.variaSuit.getCost()) >= 0){
						soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.variaSuit.getCost());
						soopaMetoroido.variaSuit.setBought(true);
						soopaMetoroido.variaSuit.setDesc("PURCHASED. Barrier suit providing moderate bonus to defence and low bonus to speed.");
						textAreaSuitDesc.setText(soopaMetoroido.variaSuit.getDesc());
						refreshCredits();
					}
				}
			}
			else if (rdbtnGravitySuit.isSelected()){
				if (!soopaMetoroido.gravitySuit.isBought()){
					if ((soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.gravitySuit.getCost()) >= 0){
						soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.gravitySuit.getCost());
						soopaMetoroido.gravitySuit.setBought(true);
						soopaMetoroido.gravitySuit.setDesc("PURCHASED. Allows you to move unhindered. Provides small bonus to defence but large bonus to speed.");
						textAreaSuitDesc.setText(soopaMetoroido.gravitySuit.getDesc());
						refreshCredits();
					}
				}
			}
		});
		
		btnPurchaseSuit.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnPurchaseSuit.setBounds(28, 285, 158, 23);
		panelUpgradeShop.add(btnPurchaseSuit);
		
		JButton btnEquipSuit = new JButton("Equip Suit");
		btnEquipSuit.setForeground(new Color(255, 204, 51));
		btnEquipSuit.setBackground(Color.DARK_GRAY);
		btnEquipSuit.addActionListener(arg0 -> {

			// changes defence and speed value per suit equipped

			if (rdbtnZeroSuit.isSelected() && soopaMetoroido.zeroSuit.isBought()){
				soopaMetoroido.spaceHunter.setCurrentDefence(soopaMetoroido.spaceHunter.getDefence() + soopaMetoroido.zeroSuit.getDefenceBonus());
				soopaMetoroido.spaceHunter.setSpeed(soopaMetoroido.spaceHunter.getSpeed() + soopaMetoroido.zeroSuit.getSpeedBonus());
				soopaMetoroido.zeroSuit.setEquipped(true);
				soopaMetoroido.powerSuit.setEquipped(false);
				soopaMetoroido.variaSuit.setEquipped(false);
				soopaMetoroido.gravitySuit.setEquipped(false);
				rdbtnZeroSuit.setForeground(new Color(255, 204, 51));
				rdbtnPowerSuit.setForeground(Color.WHITE);
				rdbtnVariaSuit.setForeground(Color.WHITE);
				rdbtnGravitySuit.setForeground(Color.WHITE);
				lblHunterBattlePic.setIcon(zeroSuitBattle);
			}
			else if (rdbtnPowerSuit.isSelected() && soopaMetoroido.powerSuit.isBought()){
				soopaMetoroido.spaceHunter.setCurrentDefence(soopaMetoroido.spaceHunter.getDefence() + soopaMetoroido.powerSuit.getDefenceBonus());
				soopaMetoroido.spaceHunter.setSpeed(soopaMetoroido.spaceHunter.getSpeed() + soopaMetoroido.powerSuit.getSpeedBonus());
				soopaMetoroido.zeroSuit.setEquipped(false);
				soopaMetoroido.powerSuit.setEquipped(true);
				soopaMetoroido.variaSuit.setEquipped(false);
				soopaMetoroido.gravitySuit.setEquipped(false);
				rdbtnZeroSuit.setForeground(Color.WHITE);
				rdbtnPowerSuit.setForeground(new Color(255, 204, 51));
				rdbtnVariaSuit.setForeground(Color.WHITE);
				rdbtnGravitySuit.setForeground(Color.WHITE);
				lblHunterBattlePic.setIcon(powerSuitBattle);
			}
			else if (rdbtnVariaSuit.isSelected() && soopaMetoroido.variaSuit.isBought()){
				soopaMetoroido.spaceHunter.setCurrentDefence(soopaMetoroido.spaceHunter.getDefence() + soopaMetoroido.variaSuit.getDefenceBonus());
				soopaMetoroido.spaceHunter.setSpeed(soopaMetoroido.spaceHunter.getSpeed() + soopaMetoroido.variaSuit.getSpeedBonus());
				soopaMetoroido.zeroSuit.setEquipped(false);
				soopaMetoroido.powerSuit.setEquipped(false);
				soopaMetoroido.variaSuit.setEquipped(true);
				soopaMetoroido.gravitySuit.setEquipped(false);
				rdbtnZeroSuit.setForeground(Color.WHITE);
				rdbtnPowerSuit.setForeground(Color.WHITE);
				rdbtnVariaSuit.setForeground(new Color(255, 204, 51));
				rdbtnGravitySuit.setForeground(Color.WHITE);
				lblHunterBattlePic.setIcon(variaSuitBattle);
			}
			else if (rdbtnGravitySuit.isSelected() && soopaMetoroido.gravitySuit.isBought()){
				soopaMetoroido.spaceHunter.setCurrentDefence(soopaMetoroido.spaceHunter.getDefence() + soopaMetoroido.gravitySuit.getDefenceBonus());
				soopaMetoroido.spaceHunter.setSpeed(soopaMetoroido.spaceHunter.getSpeed() + soopaMetoroido.gravitySuit.getSpeedBonus());
				soopaMetoroido.zeroSuit.setEquipped(false);
				soopaMetoroido.powerSuit.setEquipped(false);
				soopaMetoroido.variaSuit.setEquipped(false);
				soopaMetoroido.gravitySuit.setEquipped(true);
				rdbtnZeroSuit.setForeground(Color.WHITE);
				rdbtnPowerSuit.setForeground(Color.WHITE);
				rdbtnVariaSuit.setForeground(Color.WHITE);
				rdbtnGravitySuit.setForeground(new Color(255, 204, 51));
				lblHunterBattlePic.setIcon(gravitySuitBattle);
			}
		});
		btnEquipSuit.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnEquipSuit.setBounds(28, 319, 158, 23);
		panelUpgradeShop.add(btnEquipSuit);
		
		lblCurrentCreditNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentCreditNumber.setForeground(Color.WHITE);
		lblCurrentCreditNumber.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblCurrentCreditNumber.setBounds(273, 51, 90, 38);
		panelUpgradeShop.add(lblCurrentCreditNumber);
		
		JButton btnToHunt = new JButton("Proceed to Hunt");
		btnToHunt.setForeground(new Color(255, 204, 51));
		btnToHunt.setBackground(Color.DARK_GRAY);
		btnToHunt.addActionListener(arg0 -> {

			// Populates page labels with names and hit points and starts the battle

			panelUpgradeShop.setVisible(false);
			panelBattle.setVisible(true);
			btnReturnToUpgrade.setEnabled(false);
			btnNextAlien.setEnabled(false);
			soopaMetoroido.determineAlien();
			setAlienPic();
			lblAlienName.setText(soopaMetoroido.randomAlien.getName() + " HP");
			lblPlayerName.setText(soopaMetoroido.spaceHunter.getName() + " HP");
			textAreaCombatLog.setText(null);
			currentPlayerHP = soopaMetoroido.spaceHunter.getHitPoints();
			currentAlienHP = soopaMetoroido.randomAlien.getHitPoints();
			textFieldPlayerHP.setText(currentPlayerHP + "/" + soopaMetoroido.spaceHunter.getHitPoints());
			textFieldAlienHP.setText(currentAlienHP + "/" + soopaMetoroido.randomAlien.getHitPoints());


			timer.start();

		});
		btnToHunt.setFont(new Font("Monospaced", Font.BOLD, 15));
		btnToHunt.setBounds(235, 315, 179, 30);
		panelUpgradeShop.add(btnToHunt);
		
		lblSuitImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuitImage.setIcon(new ImageIcon(GameApp.class.getResource("/img/zerosuit.PNG")));
		lblSuitImage.setBounds(245, 90, 158, 218);
		panelUpgradeShop.add(lblSuitImage);
		
		JButton btnPurchaseWeapon = new JButton("Purchase Weapon");
		btnPurchaseWeapon.addActionListener(arg0 -> {

			// allows user to purchase weapon with credits and re-populates page with correct credit amount

			if (rdbtnChargeBeam.isSelected()){
				if (!soopaMetoroido.chargeBeam.isBought()) {
					if ((soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.chargeBeam.getCost()) >= 0){
						soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.chargeBeam.getCost());
						soopaMetoroido.chargeBeam.setBought(true);
						soopaMetoroido.chargeBeam.setDesc("PURCHASED. Allows you to hold your fire and release a stronger energy blast.");
						textAreaWeaponDesc.setText(soopaMetoroido.chargeBeam.getDesc());
						refreshCredits();
					}
				}
			}
			else if (rdbtnIceBeam.isSelected()){
				if (!soopaMetoroido.iceBeam.isBought()){
					if ((soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.iceBeam.getCost()) >= 0){
						soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.iceBeam.getCost());
						soopaMetoroido.iceBeam.setBought(true);
						soopaMetoroido.iceBeam.setDesc("PURCHASED. Freezing beam that increases damage dealt and slows enemies.");
						textAreaWeaponDesc.setText(soopaMetoroido.iceBeam.getDesc());
						refreshCredits();
					}
				}
			}
			else if (rdbtnSpazerBeam.isSelected()){
				if (!soopaMetoroido.spazerBeam.isBought()){
					if ((soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.spazerBeam.getCost()) >= 0){
						soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.spazerBeam.getCost());
						soopaMetoroido.spazerBeam.setBought(true);
						soopaMetoroido.spazerBeam.setDesc("PURCHASED. Simultaneous blast of three lasers. Has more power and width than the charge beam.");
						textAreaWeaponDesc.setText(soopaMetoroido.spazerBeam.getDesc());
						refreshCredits();
					}
				}
			}
			else if (rdbtnPlasmaBeam.isSelected()){
				if (!soopaMetoroido.plasmaBeam.isBought()){
					if ((soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.plasmaBeam.getCost()) >= 0){
						soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() - soopaMetoroido.plasmaBeam.getCost());
						soopaMetoroido.plasmaBeam.setBought(true);
						soopaMetoroido.plasmaBeam.setDesc("PURCHASED. Strongest beam available. Inflicts heavy damage to enemies.");
						textAreaWeaponDesc.setText(soopaMetoroido.plasmaBeam.getDesc());
						refreshCredits();
					}
				}
			}
		});
		btnPurchaseWeapon.setBackground(Color.DARK_GRAY);
		btnPurchaseWeapon.setForeground(new Color(255, 204, 51));
		btnPurchaseWeapon.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnPurchaseWeapon.setBounds(455, 285, 158, 23);
		panelUpgradeShop.add(btnPurchaseWeapon);
		
		JButton btnEquipWeapon = new JButton("Equip Weapon");
		btnEquipWeapon.addActionListener(arg0 -> {

			// Allows user to equip weapon by changing current attack value

			if (rdbtnChargeBeam.isSelected() && soopaMetoroido.chargeBeam.isBought()){
				soopaMetoroido.spaceHunter.setCurrentAttack(soopaMetoroido.spaceHunter.getAttack() + soopaMetoroido.chargeBeam.getAttackBonus());
				soopaMetoroido.chargeBeam.setEquipped(true);
				soopaMetoroido.iceBeam.setEquipped(false);
				soopaMetoroido.spazerBeam.setEquipped(false);
				soopaMetoroido.plasmaBeam.setEquipped(false);
				rdbtnChargeBeam.setForeground(new Color(255, 204, 51));
				rdbtnIceBeam.setForeground(Color.WHITE);
				rdbtnSpazerBeam.setForeground(Color.WHITE);
				rdbtnPlasmaBeam.setForeground(Color.WHITE);
			}
			else if (rdbtnIceBeam.isSelected() && soopaMetoroido.iceBeam.isBought()){
				soopaMetoroido.spaceHunter.setCurrentAttack(soopaMetoroido.spaceHunter.getAttack() + soopaMetoroido.iceBeam.getAttackBonus());
				soopaMetoroido.chargeBeam.setEquipped(false);
				soopaMetoroido.iceBeam.setEquipped(true);
				soopaMetoroido.spazerBeam.setEquipped(false);
				soopaMetoroido.plasmaBeam.setEquipped(false);
				rdbtnChargeBeam.setForeground(Color.WHITE);
				rdbtnIceBeam.setForeground(new Color(255, 204, 51));
				rdbtnSpazerBeam.setForeground(Color.WHITE);
				rdbtnPlasmaBeam.setForeground(Color.WHITE);
			}
			else if (rdbtnSpazerBeam.isSelected() && soopaMetoroido.spazerBeam.isBought()){
				soopaMetoroido.spaceHunter.setCurrentAttack(soopaMetoroido.spaceHunter.getAttack() + soopaMetoroido.spazerBeam.getAttackBonus());
				soopaMetoroido.chargeBeam.setEquipped(false);
				soopaMetoroido.iceBeam.setEquipped(false);
				soopaMetoroido.spazerBeam.setEquipped(true);
				soopaMetoroido.plasmaBeam.setEquipped(false);
				rdbtnChargeBeam.setForeground(Color.WHITE);
				rdbtnIceBeam.setForeground(Color.WHITE);
				rdbtnSpazerBeam.setForeground(new Color(255, 204, 51));
				rdbtnPlasmaBeam.setForeground(Color.WHITE);
			}
			else if (rdbtnPlasmaBeam.isSelected() && soopaMetoroido.plasmaBeam.isBought()){
				soopaMetoroido.spaceHunter.setCurrentAttack(soopaMetoroido.spaceHunter.getAttack() + soopaMetoroido.plasmaBeam.getAttackBonus());
				soopaMetoroido.chargeBeam.setEquipped(false);
				soopaMetoroido.iceBeam.setEquipped(false);
				soopaMetoroido.spazerBeam.setEquipped(false);
				soopaMetoroido.plasmaBeam.setEquipped(true);
				rdbtnChargeBeam.setForeground(Color.WHITE);
				rdbtnIceBeam.setForeground(Color.WHITE);
				rdbtnSpazerBeam.setForeground(Color.WHITE);
				rdbtnPlasmaBeam.setForeground(new Color(255, 204, 51));
			}
		});
		btnEquipWeapon.setBackground(Color.DARK_GRAY);
		btnEquipWeapon.setForeground(new Color(255, 204, 51));
		btnEquipWeapon.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnEquipWeapon.setBounds(455, 319, 158, 23);
		panelUpgradeShop.add(btnEquipWeapon);		
	}
	
	// returns correct alien picture to display
	private void setAlienPic(){

		switch (soopaMetoroido.randomAlien.getName()) {
			case "Metroid":
				lblAlienBattlePic.setIcon(metroid);
				break;
			case "Arachnus":
				lblAlienBattlePic.setIcon(arachnus);
				break;
			case "Space Pirate":
				lblAlienBattlePic.setIcon(spacePirate);
				break;
			case "Sidehopper":
				lblAlienBattlePic.setIcon(sidehopper);
				break;
			case "Ridley":
				lblAlienBattlePic.setIcon(ridley);
				break;
		}
	}
	
	// calculates int value of alien attack
	private int calculateAlienAttack() {
		
		if (soopaMetoroido.randomAlien.attack() - soopaMetoroido.spaceHunter.defend() <= 0) {
			return 0;
		}
		else {
			return soopaMetoroido.randomAlien.attack() - soopaMetoroido.spaceHunter.defend();
		}
	}
	
	// calculates int value of player attack
	private int calculatePlayerAttack() {
						
		if ((soopaMetoroido.spaceHunter.attack() - soopaMetoroido.randomAlien.defend()) <= 0) {
			return 0;
		}
		else {
			return soopaMetoroido.spaceHunter.attack() - soopaMetoroido.randomAlien.defend();
		}
	}
	
	// timer tick that displays player attack on alien 
	private void doPlayerAttack() {
		if (currentPlayerHP > 0) {
			int currentAttack = calculatePlayerAttack();
			textAreaCombatLog.append(soopaMetoroido.spaceHunter.getName() + " hits " + soopaMetoroido.randomAlien.getName() + " for " + currentAttack + " damage.\n");
			currentAlienHP = currentAlienHP - currentAttack;
			textFieldPlayerHP.setText(currentPlayerHP + "/" + soopaMetoroido.spaceHunter.getHitPoints());
			
			if (currentAlienHP <= 0) {
				textFieldAlienHP.setText("DEAD");
				textAreaCombatLog.append(soopaMetoroido.randomAlien.getName() + " was defeated! " + soopaMetoroido.randomAlien.getCreditDrop() + " credits obtained.\n");
				timer.stop();
				btnReturnToUpgrade.setEnabled(true);
				btnNextAlien.setEnabled(true);
				soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() + soopaMetoroido.randomAlien.getCreditDrop());
			}
		}
	}
	
	// timer tick that displays alien attack on player	
	private void doAlienAttack() {
		
		if (currentAlienHP > 0) {
			textAreaCombatLog.append(soopaMetoroido.randomAlien.getName() + " attacks for " + calculateAlienAttack() + " damage.\n");
			currentPlayerHP = currentPlayerHP - calculateAlienAttack();
			textFieldAlienHP.setText(currentAlienHP + "/" + soopaMetoroido.randomAlien.getHitPoints());
			
			if (currentPlayerHP <= 0) {
				textFieldPlayerHP.setText("DEFEAT");
				textAreaCombatLog.append("You have been defeated! 30 credits lost.\n");
				soopaMetoroido.spaceHunter.setCredits(soopaMetoroido.spaceHunter.getCredits() - 30);
				
				if (soopaMetoroido.spaceHunter.getCredits() < 0) {
					soopaMetoroido.spaceHunter.setCredits(0);
				}
				
				timer.stop();
				btnReturnToUpgrade.setEnabled(true);
			}
		}
	}
	
	
	
	// timer handles the battle evaluating which player goes first and attacking the appropriate number of times depending on the weapon
	private class TimerHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)
		{			
			boolean playerGoesNext = soopaMetoroido.spaceHunter.getSpeed() >= soopaMetoroido.randomAlien.getSpeed();
			
			if(soopaMetoroido.iceBeam.isEquipped() && playerGoesNext){
				doPlayerAttack();
				doPlayerAttack();
				doAlienAttack();
			}
			else if (soopaMetoroido.iceBeam.isEquipped()) {
				doAlienAttack();
				doPlayerAttack();
				doPlayerAttack();
			}
			else if (soopaMetoroido.spazerBeam.isEquipped() && playerGoesNext) {
				doPlayerAttack();
				doPlayerAttack();
				doPlayerAttack();
				doAlienAttack();
			}
			else if (soopaMetoroido.spazerBeam.isEquipped()) {
				doAlienAttack();
				doPlayerAttack();
				doPlayerAttack();
				doPlayerAttack();
			}
			else if (playerGoesNext){
				doPlayerAttack();
				doAlienAttack();
			}
			else{
				doAlienAttack();
				doPlayerAttack();
			}
		}
	}
	
	// refreshes the credit label when the number of credits change
	private void refreshCredits() {
		lblCurrentCreditNumber.setText(String.valueOf(soopaMetoroido.spaceHunter.getCredits()));
	}
	
	// evaluates whether there was user input	
	private boolean validateInput(String input) {
		return input != null && input.length() > 0 && !input.trim().isEmpty();
	}
}
