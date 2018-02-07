package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.OverlayLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jvnet.substance.SubstanceLookAndFeel;

import logica.Booking;
import logica.Cabin;
import logica.Cruise;
import logica.Extras;
import logica.Ship;
import logica.TravelAgency;


public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel pnContent;
	private TravelAgency tA = new TravelAgency();
	private JPanel pnCruises;

	private JPanel pnImageAndText;
	private JScrollPane spCruise;
	private ButtonGroup btGroupCruises = new ButtonGroup();
	private JPanel pnRadioButtons;
	private JPanel pnCruisesButtons;
	private JButton btnNextCruises;
	private JPanel pnContentCruises;
	private JPanel pnContentCabin;
	private JPanel pnCabinSummary;
	private JPanel pnCabinButtons;
	private JPanel pnOptionsType;
	private JLabel lblCabinType;
	private JComboBox<Cabin> cbCabinType;
	private JComboBox<String> cbDates;
	private Cruise selectedCruise;
	private JScrollPane spOptionsExtras;
	private JSpinner spinnerPersons;
	private JLabel lblNumberOfPersons;
	private JPanel pnOptionsConfig;
	private JPanel pnCabinBanner;
	private JList<Booking> listCabins;
	private JTextField txtCabinPrice;
	private JButton btnAddCabin;
	private JButton btnRemoveCabin;
	private ArrayList<JCheckBox> extras = new ArrayList<JCheckBox>();
	private float totalCabinPrice;
	private float discountedCabinPrice;
	private DefaultListModel<Booking> listModel;
	private JScrollPane spCabinList;
	private JTextArea taConsiderations;
	private JLabel lblConsiderations;
	private JScrollPane spConsiderations;
	private JLabel lblCabinPrice;
	private JTextField txtTotalPrice;
	private JButton btnNextCabin;
	private JButton btnBackCabin;
	private JButton btnCancelCabin;
	@SuppressWarnings("rawtypes")
	private ArrayList<JComboBox> cbDatesArray = new ArrayList<JComboBox>();
	private String selectedDate;
	private JPanel pnContentData;
	private JPanel pnDataBanner;
	private JPanel pnDataButtons;
	private JPanel pnDataFields;
	private JPanel pnDataSummaryPrice;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblID;
	private JTextField txtID;
	private JPanel pnPaymentMethod;
	private JPanel pnCreditBank;
	private JPanel pnInsertAccount;
	private JRadioButton rdbtnCreditCard;
	private JRadioButton rdbtnBankAccount;
	private JTextField txtCardNumber;
	private ButtonGroup btgPayment = new ButtonGroup();
	private JLabel lblInsertAccount;
	private JLabel lblSurnames;
	private JTextField txtSurnames;
	private JLabel lblPhoneNumber;
	private JTextField txtPhoneNumber;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JTextField txtDataTotalPrice;
	private JButton btnNextData;
	private JButton btnCancelData;
	private JButton btnBackData;
	private JPanel pnTotalPrice;
	private ResourceBundle texts;
	private JPanel pnContentStart;
	private JButton btnES;
	private JButton btnEN;
	private JLabel lblStartLogo;
	private JPanel pnCruisesBanner;
	private JLabel lblCruisesBanner;
	private JLabel lblCabinBanner;
	private JLabel lblDataBanner;
	
	public static SimpleDateFormat dateFormatSlash = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat dateFormatDash = new SimpleDateFormat("dd-MM-yyyy");
	
	private int numberOfPassengers;
	private JPanel pnContentBill;
	private JPanel pnBillButtons;
	private JPanel pnBillBanner;
	private JButton btnPurchaseBill;
	private JButton btnBackBill;
	private JButton btnCancelBill;
	private JScrollPane spBillContent;
	private JTextArea taBill;
	
	private int nCabinsDE;
	private int nCabinsDI;
	private int nCabinsFE;
	private int nCabinsFI;
	private JMenuBar menuBar;
	private JMenu mnApplication;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem mntmClose;
	private JMenu mnLanguage;
	private JMenuItem mntmEnEs;
	private JCheckBox chckbxTooltips;
	private JMenuItem mntmHelp;
	private JSeparator separator_1;
	private JMenuItem mntmAbout;
	private JSeparator separator;
	private JPanel pnCabinPrice;
	private JLabel lblDisclaimer;
	private JPanel pnCabinButtonsAndDisclaimer;
	private JLabel lblBillBanner;
	private JLabel lblBillTitle;
	private JLabel lblCabinTitle;
	private JLabel lblDataTitle;
	private JLabel lblCruisesTitle;
	private JPanel pnContentShips;
	private JPanel pnShipsBanner;
	private JLabel lblShipsBanner;
	private JLabel lblShipsTitle;
	private JPanel pnShipsButtons;
	private JButton btnBackShips;
	private JPanel pnShips;
	private JScrollPane spShip;
	private JPanel pnShipImageAndText;
	private JButton btnShipsInfoCruises;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDialog.setDefaultLookAndFeelDecorated(true);
					JFrame.setDefaultLookAndFeelDecorated(true);;
					
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.DustSkin");					
					
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static ImageIcon scale(ImageIcon image, int width, int height) {

		BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image.getImage(), 0, 0, width, height, null);
		g2.dispose();

		return new ImageIcon(resizedImg);
	}
	
	

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("EII Travel Agency");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/ship-icon(NOTEXT).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 500);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnContent(), BorderLayout.CENTER);
		
		Locale.setDefault(new Locale("en"));
		localizar(new Locale(System.getProperty("user.language")));
		
		generateDiscounts();
		createPanels(pnCruises);
		createShipPanels(pnShips);
		createExtras(spOptionsExtras);
		
		chckbxTooltips.setSelected(true);
		
		loadHelp();
	}
	
	
	private void loadHelp(){
		
		//URL hsURL;
		HelpSet hs;
		
		try{
			//File file = new File("help/HelpSet.hs");	//Necessary to replace these three lines with the two below in order for this to work after exporting as jar
			//hsURL = file.toURI().toURL();				//
			//hs = new HelpSet(null, hsURL);			//
			URL in = this.getClass().getResource("/HelpSet.hs");	//For exporting as jar. We also need to add "help" as a source folder to the build path!
			hs = new HelpSet(null, in);								//
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Help not found");
			return;
		}
		
		HelpBroker hb = hs.createHelpBroker();
		
		hb.initPresentation();
		
		hb.enableHelpKey(getRootPane(), "introduction", hs);
		hb.enableHelpOnButton(mntmHelp, "introduction", hs);
		hb.enableHelp(pnContentStart, "introduction", hs);
		hb.enableHelp(pnContentShips, "ships", hs);
		hb.enableHelp(pnContentCruises, "cruises", hs);
		hb.enableHelp(pnContentCabin, "cabin", hs);
		hb.enableHelp(pnContentData, "data", hs);
		hb.enableHelp(pnContentBill, "bill", hs);
	}
	
	
	private void localizar(Locale localization){
		texts = ResourceBundle.getBundle("rcs/texts", localization);
		
		btnNextCruises.setText(texts.getString("txtBtnNextCruises"));
		lblConsiderations.setText(texts.getString("txtLblConsiderations"));
		btnAddCabin.setText(texts.getString("txtBtnAddCabin"));
		btnRemoveCabin.setText(texts.getString("txtBtnRemoveCabin"));
		lblCabinPrice.setText(texts.getString("txtLblCabinPrice"));
		btnNextCabin.setText(texts.getString("txtBtnNextCabin"));
		btnCancelCabin.setText(texts.getString("txtBtnCancelCabin"));
		btnBackCabin.setText(texts.getString("txtBtnBackCabin"));
		lblCabinType.setText(texts.getString("txtLblCabinType"));
		lblNumberOfPersons.setText(texts.getString("txtLblNumberOfPersons"));
		btnCancelData.setText(texts.getString("txtBtnCancelData"));
		btnBackData.setText(texts.getString("txtBtnBackData"));
		btnNextData.setText(texts.getString("txtBtnNextData"));
		lblName.setText(texts.getString("txtLblDataName"));
		lblSurnames.setText(texts.getString("txtLblDataSurnames"));
		lblID.setText(texts.getString("txtLblDataID"));
		lblEmail.setText(texts.getString("txtLblDataEmail"));
		rdbtnCreditCard.setText(texts.getString("txtRdbtnDataCreditCard"));
		rdbtnBankAccount.setText(texts.getString("txtRdbtnBankAccount"));
		lblInsertAccount.setText(texts.getString("txtLblDataInsertAccount"));
		lblPhoneNumber.setText(texts.getString("txtLblDataPhoneNumber"));
		lblAddress.setText(texts.getString("txtLblDataAddress"));
		
		pnTotalPrice.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), texts.getString("txtPnTitleTotalPrice"), 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnOptionsType.setBorder(new TitledBorder(null, texts.getString("txtPnTitleCabinOptions"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		spCabinList.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), texts.getString("txtPnTitleAddedCabins"), 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnPaymentMethod.setBorder(new TitledBorder(null, texts.getString("txtPnTitlePaymentMethod"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDataSummaryPrice.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), texts.getString("txtPnTitleTotalPrice"), 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnCancelBill.setText(texts.getString("txtBtnCancelBill"));
		btnBackBill.setText(texts.getString("txtBtnBackBill"));
		btnPurchaseBill.setText(texts.getString("txtBtnPurchaseBill"));
		
		mnApplication.setText(texts.getString("txtMnApplication"));
		mnOptions.setText(texts.getString("txtMnOptions"));
		mnHelp.setText(texts.getString("txtMnHelp"));
		mntmClose.setText(texts.getString("txtMntmClose"));
		mnLanguage.setText(texts.getString("txtMnLanguage"));
		mntmHelp.setText(texts.getString("txtMnHelp"));
		mntmAbout.setText(texts.getString("txtMntmAbout"));
		mntmEnEs.setText(texts.getString("txtMntmEnEs"));
		
		btnES.setToolTipText(texts.getString("txtTooltipES"));
		btnEN.setToolTipText(texts.getString("txtTooltipEN"));
		btnAddCabin.setToolTipText(texts.getString("txtTooltipAddCabin"));
		btnRemoveCabin.setToolTipText(texts.getString("txtTooltipRemoveCabin"));
		btnNextCruises.setToolTipText(texts.getString("txtTooltipNextCruises"));
		btnCancelCabin.setToolTipText(texts.getString("txtTooltipCancel"));
		btnBackCabin.setToolTipText(texts.getString("txtTooltipBackCabin"));
		btnNextCabin.setToolTipText(texts.getString("txtTooltipNextCabin"));
		btnCancelData.setToolTipText(texts.getString("txtTooltipCancel"));
		btnBackData.setToolTipText(texts.getString("txtTooltipBackData"));
		btnNextData.setToolTipText(texts.getString("txtTooltipNextData"));
		btnCancelBill.setToolTipText(texts.getString("txtTooltipCancel"));
		btnBackBill.setToolTipText(texts.getString("txtTooltipBackBill"));
		btnPurchaseBill.setToolTipText(texts.getString("txtTooltipPurchaseBill"));
		
		lblCruisesTitle.setText(texts.getString("txtCruisesTitle"));
		lblCabinTitle.setText(texts.getString("txtCabinTitle"));
		lblDataTitle.setText(texts.getString("txtDataTitle"));
		lblBillTitle.setText(texts.getString("txtBillTitle"));
		
		lblShipsTitle.setText(texts.getString("txtLblShipsTitle"));
		btnBackShips.setText(texts.getString("txtBtnBackShips"));
		btnShipsInfoCruises.setText(texts.getString("txtBtnShipsInfoCruises"));
		btnBackShips.setToolTipText(texts.getString("txtTooltipBackShips"));
		btnShipsInfoCruises.setToolTipText(texts.getString("txtTooltipShipsInfoCruises"));
		
	}
	
	
	

	private JPanel getPnContent() {
		if (pnContent == null) {
			pnContent = new JPanel();
			pnContent.setLayout(new CardLayout(0, 0));
			pnContent.add(getPnContentStart(), "pnContentStart");
			pnContent.add(getPnContentCruises(), "pnContentCruises");
			pnContent.add(getPnContentShips(), "pnContentShips");
			pnContent.add(getPnContentCabin(), "pnContentCabin");
			pnContent.add(getPnContentData(), "pnContentData");
			pnContent.add(getPnContentBill(), "pnContentBill");
		}
		return pnContent;
	}
	
	protected void createPanels(JPanel panel){
		panel.removeAll();
		for(int i=0; i<tA.getCruises().size(); i++){
			panel.add(newPanel(i));
		}
	}
	
	private JPanel newPanel(Integer index){
		pnImageAndText = new JPanel();
		pnImageAndText.setLayout(new BorderLayout(0, 0));
	
		
		spCruise = new JScrollPane();
		
		spCruise.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spCruise.setBounds(10, 35, 250, 525);
		spCruise.setBackground(new Color(1, 0, 0, 0));
		spCruise.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		spCruise.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		spCruise.getViewport().setViewPosition(new Point(0,0));
		spCruise.getVerticalScrollBar().setUnitIncrement(20);		//Making the wheel scrolling speed higher
		
		pnImageAndText.add(spCruise, BorderLayout.CENTER);
		
		
		JPanel pnText = new JPanel();
		pnText.setLayout(new BorderLayout(0, 0));
		spCruise.setViewportView(pnText);
		
		pnRadioButtons = new JPanel();
		pnRadioButtons.setLayout(new BorderLayout(0, 0));
		pnImageAndText.add(pnRadioButtons, BorderLayout.SOUTH);
		
		generateInfo(pnText, index);
		
		return pnImageAndText;
	}
	
	private void generateInfo(JPanel pn, int index){
		Cruise c = tA.getCruises().get(index);
		
		JPanel pnImage = new JPanel();
		pnImage.setLayout(new OverlayLayout(pnImage));
		pnImageAndText.add(pnImage, BorderLayout.NORTH);
		
		JLabel image = new JLabel();
		image.setIcon(scale(new ImageIcon(MainWindow.class.getResource("/img/" + c.getCodigo() + ".jpg")), 170, 96));
		image.setHorizontalAlignment(JLabel.RIGHT);
		image.setVerticalAlignment(JLabel.TOP);
		image.setAlignmentX(0.0f);
		image.setAlignmentY(0.0f);
		
		JLabel discountImage = new JLabel();
		discountImage.setIcon(scale(new ImageIcon(MainWindow.class.getResource("/img/15OFF.png")), 100, 96));
		if(c.getDiscounted() == true){
			discountImage.setHorizontalAlignment(JLabel.RIGHT);
			discountImage.setVerticalAlignment(JLabel.TOP);
			discountImage.setAlignmentX(0.0f);
			discountImage.setAlignmentY(0.0f);
			pnImage.add(discountImage);
		}
		
		pnImage.add(image);
		
		JTextPane tp = new JTextPane();
		
		tp.setContentType("text/html");	
		
		StringBuffer sb = new StringBuffer();
		sb.append("<b>" + c.getDenominacion().toUpperCase()+ "</b><br><br>");
		sb.append("<b>" + texts.getString("txtCruisesZona") + "</b><br>");
		sb.append(c.getZona()+ "<br><br>");
		sb.append("<b>" + texts.getString("txtCruisesPuertoSalida") + "</b><br>");
		sb.append(c.getPuertoSalida() + "<br><br>");
		sb.append("<b>" + texts.getString("txtCruisesItinerario") + "</b><br>");
		sb.append(c.getItinerario() + "<br><br>");
		sb.append("<b>" + texts.getString("txtCruisesDuracion") + "</b><br>");
		sb.append(c.getDuracion() + " día(s)<br><br>");
		sb.append("<b>" + texts.getString("txtCruisesAptoMenores") + "</b><br>");
		String aptoMenores = texts.getString("txtNo");
		if(c.getAptoMenores().equals("S"))
			aptoMenores = texts.getString("txtYes");
		sb.append(aptoMenores + "<br><br>");
		sb.append("<b>" + texts.getString("txtCruisesShip") + "</b><br>");
		sb.append(c.getShip().getNombre() + "<br><br>");
		sb.append("<b>" + texts.getString("txtCruisesDescripcion") + "</b><br>");
		sb.append(c.getDescripcion() + "<br><br>");
		
		tp.setText(sb.toString());
		
		tp.setCaretPosition(0); 		//To start at top on the panel if there is too much information and scroll is needed

		pn.add(tp, BorderLayout.CENTER);
		tp.setEditable(false);
		
		spCruise.setViewportView(tp);	//This line here is crucial in order for the text to wrap and not go in the same line infinitely because of the scroll pane
		
		/**
		 * The function of this block of code basically to align the text to the center.
		 */
//		StyledDocument doc = tp.getStyledDocument();
//		SimpleAttributeSet center = new SimpleAttributeSet();
//		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
//		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		cbDates = new JComboBox<String>();
		for(int i =0; i<c.getFechaSalida().length; i++)
			cbDates.addItem(c.getFechaSalida()[i]);
		pnRadioButtons.add(cbDates, BorderLayout.NORTH);
		
		cbDatesArray.add(cbDates);
		
		
		//Generate buttons:
		JRadioButton rdbtn = new JRadioButton();
		rdbtn.setText(texts.getString("txtCruisesSeleccionar"));
		rdbtn.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn.setVerticalTextPosition(JRadioButton.BOTTOM);
		rdbtn.setHorizontalTextPosition(JRadioButton.CENTER);
		btGroupCruises.add(rdbtn);
		pnRadioButtons.add(rdbtn, BorderLayout.CENTER);
		rdbtn.setName(String.valueOf(index));			//In order to be able to differentiate the radio buttons
		rdbtn.setActionCommand(rdbtn.getName());		//I need to add this for being able to get the selected button in a group with ___.getActionCommand()
		
		
		
		
		/**
		 * Clean way of setting properties for all the elements of each kind inside the same panel
		 */
		for(Component comp : pn.getComponents()){
			if(comp instanceof JTextField)
				comp.setEnabled(false);
		}
		
	}

	
	private JPanel getPnContentCruises(){
		if(pnContentCruises == null){
			pnContentCruises = new JPanel();
			pnContentCruises.setLayout(new BorderLayout(0, 0));
			pnContentCruises.add(getPnCruises(), BorderLayout.CENTER);
			pnContentCruises.add(getPnCruisesButtons(), BorderLayout.SOUTH);
			pnContentCruises.add(getPnCruisesBanner(), BorderLayout.NORTH);
		}
		return pnContentCruises;
	}
	
	
	private JPanel getPnCruises() {
		if (pnCruises == null) {
			pnCruises = new JPanel();
			pnCruises.setLayout(new GridLayout(1, 0, 0, 0));
		}
		return pnCruises;
	}
	
	
	private JPanel getPnCruisesButtons(){
		if(pnCruisesButtons == null){
			pnCruisesButtons = new JPanel();
			pnCruisesButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnCruisesButtons.add(getBtnShipsInfoCruises());
			pnCruisesButtons.add(getBtnNextCruises());
		}
		return pnCruisesButtons;
	}
	
	private void fillCabinTypes(){
		try {
			cbCabinType.removeAllItems();

			if(selectedCruise.getShip().getCabinsDE() > 0)
				cbCabinType.addItem(new Cabin(texts.getString("txtCabinDE"), selectedCruise.getShip().getPrecioDE(), 2));
			
			if(selectedCruise.getShip().getCabinsDI() > 0)
				cbCabinType.addItem(new Cabin(texts.getString("txtCabinDI"), selectedCruise.getShip().getPrecioDI(), 2));
			
			if(selectedCruise.getShip().getCabinsFE() > 0)
				cbCabinType.addItem(new Cabin(texts.getString("txtCabinFE"), selectedCruise.getShip().getPrecioFE(), 4));
			
			if(selectedCruise.getShip().getCabinsFI() > 0)
				cbCabinType.addItem(new Cabin(texts.getString("txtCabinFI"), selectedCruise.getShip().getPrecioFI(), 4));
		} catch (NullPointerException e) {
			//We get this exception when we change language from menu bar in the first screen (when cbCabinType has not been filled yet). Nothing important.
		}
		
	}
	
	private JButton getBtnNextCruises(){
		if(btnNextCruises == null){
			btnNextCruises = new JButton();
			btnNextCruises.setToolTipText("");
			btnNextCruises.setMnemonic('t');
			btnNextCruises.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {					
					try {
						String selectedButton = ((JToggleButton.ToggleButtonModel) btGroupCruises.getSelection()).getActionCommand();	//Index of the selected radioButton
						selectedCruise = tA.getCruises().get(Integer.parseInt(selectedButton));
						
						selectedDate = (String) cbDatesArray.get(Integer.parseInt(selectedButton)).getSelectedItem();
						
						fillCabinTypes();
						
						if(selectedCruise.getAptoMenores().equals("N"))
							for (int i=0; i<tA.getExtras().size(); i++)
								if(tA.getExtras().get(i).getNombre().equals("Cama supletoria"))
									extras.get(i).setEnabled(false);
						
						calculatePrice();
						
						((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentCabin");						
						
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogSelectACruise"));
					}
				}
				});
		}
		return btnNextCruises;
	}
	
	
	
	private JScrollPane getSpOptionsExtras(){
		if (spOptionsExtras == null) {
			spOptionsExtras = new JScrollPane();
			spOptionsExtras.setBorder(new TitledBorder(null, "Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			spOptionsExtras.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
		return spOptionsExtras;
	}
	
	
	protected void createExtras(JScrollPane panel){
		JPanel pnExtras = new JPanel();
		pnExtras.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		int count = 0;
		for(Extras extra : tA.getExtras()){
			JCheckBox chckbx = new JCheckBox();
			chckbx.setText(extra.getNombre() + " [" + extra.getPrecio() + "\u20ac]       ");
			
			if(extra.getNombre().equals("Cama supletoria")){
				chckbx.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0){
						calculatePrice();
						if(cbCabinType.getSelectedItem() != null && chckbx.isSelected())
							spinnerPersons.setModel(new SpinnerNumberModel((int) spinnerPersons.getValue(), 1, ((Cabin) cbCabinType.getSelectedItem()).getCapacidad() + 1, 1));
						else if(cbCabinType.getSelectedItem() != null && !chckbx.isSelected()){
							spinnerPersons.setModel(new SpinnerNumberModel(1, 1, ((Cabin) cbCabinType.getSelectedItem()).getCapacidad(), 1));
						}
					}
				});
			}
			
			pnExtras.add(chckbx, gbc);
			
			if(count%2 == 0)	//This lines are just distributing uniformly the options between 2 columns
				gbc.gridx++;
			else{
				gbc.gridy++;
				gbc.gridx--;
			}
			chckbx.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					calculatePrice();
				}
			});
			count++;
			extras.add(chckbx);
		}
		panel.add(pnExtras);
		spOptionsExtras.setViewportView(pnExtras);
	}

		
	protected void generateDiscounts(){
		Random random = new Random();
		int rng1 = random.nextInt(tA.getCruises().size());
		int rng2 = random.nextInt(tA.getCruises().size());
		
		while(rng2 == rng1)
			rng2 = random.nextInt(tA.getCruises().size());
		
		tA.getCruises().get(rng1).setDiscounted(true);
		tA.getCruises().get(rng2).setDiscounted(true);
	}
	
	
	
	
	private JPanel getPnContentCabin() {
		if (pnContentCabin == null) {
			pnContentCabin = new JPanel();
			pnContentCabin.setLayout(new BorderLayout(0, 0));
			pnContentCabin.add(getPnCabinBanner(), BorderLayout.NORTH);
			pnContentCabin.add(getPnCabinSummary(), BorderLayout.EAST);
			pnContentCabin.add(getPnOptionsConfig(), BorderLayout.CENTER);
			pnContentCabin.add(getPnCabinButtonsAndDisclaimer(), BorderLayout.SOUTH);
		}
		return pnContentCabin;
	}
	private JPanel getPnCabinSummary() {
		if (pnCabinSummary == null) {
			pnCabinSummary = new JPanel();
			GridBagLayout gbl_pnCabinSummary = new GridBagLayout();
			gbl_pnCabinSummary.columnWidths = new int[]{98, 86, 28, 0};
			gbl_pnCabinSummary.rowHeights = new int[]{25, 42, 77, 50, 23, 23, 24, 32, 0, 0, 14, 27, 18, 0};
			gbl_pnCabinSummary.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnCabinSummary.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			pnCabinSummary.setLayout(gbl_pnCabinSummary);
			GridBagConstraints gbc_lblConsiderations = new GridBagConstraints();
			gbc_lblConsiderations.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblConsiderations.gridwidth = 2;
			gbc_lblConsiderations.insets = new Insets(0, 0, 5, 5);
			gbc_lblConsiderations.gridx = 0;
			gbc_lblConsiderations.gridy = 1;
			pnCabinSummary.add(getLblConsiderations(), gbc_lblConsiderations);
			GridBagConstraints gbc_spConsiderations = new GridBagConstraints();
			gbc_spConsiderations.gridwidth = 2;
			gbc_spConsiderations.insets = new Insets(0, 0, 5, 5);
			gbc_spConsiderations.fill = GridBagConstraints.BOTH;
			gbc_spConsiderations.gridx = 0;
			gbc_spConsiderations.gridy = 2;
			pnCabinSummary.add(getSpConsiderations(), gbc_spConsiderations);
			GridBagConstraints gbc_btnAddCabin = new GridBagConstraints();
			gbc_btnAddCabin.gridwidth = 2;
			gbc_btnAddCabin.insets = new Insets(0, 0, 5, 5);
			gbc_btnAddCabin.gridx = 0;
			gbc_btnAddCabin.gridy = 4;
			pnCabinSummary.add(getBtnAddCabin(), gbc_btnAddCabin);
			GridBagConstraints gbc_btnRemoveCabin = new GridBagConstraints();
			gbc_btnRemoveCabin.gridwidth = 2;
			gbc_btnRemoveCabin.insets = new Insets(0, 0, 5, 5);
			gbc_btnRemoveCabin.gridx = 0;
			gbc_btnRemoveCabin.gridy = 5;
			pnCabinSummary.add(getBtnRemoveCabin(), gbc_btnRemoveCabin);
			GridBagConstraints gbc_lblCabinPrice = new GridBagConstraints();
			gbc_lblCabinPrice.gridwidth = 2;
			gbc_lblCabinPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblCabinPrice.gridx = 0;
			gbc_lblCabinPrice.gridy = 8;
			pnCabinSummary.add(getLblCabinPrice(), gbc_lblCabinPrice);
			GridBagConstraints gbc_pnCabinPrice = new GridBagConstraints();
			gbc_pnCabinPrice.gridwidth = 2;
			gbc_pnCabinPrice.insets = new Insets(0, 0, 5, 5);
			gbc_pnCabinPrice.fill = GridBagConstraints.BOTH;
			gbc_pnCabinPrice.gridx = 0;
			gbc_pnCabinPrice.gridy = 9;
			pnCabinSummary.add(getPnCabinPrice(), gbc_pnCabinPrice);
			GridBagConstraints gbc_pnTotalPrice = new GridBagConstraints();
			gbc_pnTotalPrice.gridwidth = 2;
			gbc_pnTotalPrice.insets = new Insets(0, 0, 5, 5);
			gbc_pnTotalPrice.fill = GridBagConstraints.BOTH;
			gbc_pnTotalPrice.gridx = 0;
			gbc_pnTotalPrice.gridy = 11;
			pnCabinSummary.add(getPnTotalPrice(), gbc_pnTotalPrice);
		}
		return pnCabinSummary;
	}
	private JPanel getPnCabinButtons() {
		if (pnCabinButtons == null) {
			pnCabinButtons = new JPanel();
			pnCabinButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnCabinButtons.add(getBtnNextCabin());
			pnCabinButtons.add(getBtnBackCabin());
			pnCabinButtons.add(getBtnCancelCabin());
		}
		return pnCabinButtons;
	}
	private JPanel getPnOptionsType() {
		if (pnOptionsType == null) {
			pnOptionsType = new JPanel();
			GridBagLayout gbl_pnOptionsType = new GridBagLayout();
			gbl_pnOptionsType.columnWidths = new int[]{136, 0, 53, 138, 127, 0};
			gbl_pnOptionsType.rowHeights = new int[]{45, 25, 17, 0, 11, 0};
			gbl_pnOptionsType.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_pnOptionsType.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnOptionsType.setLayout(gbl_pnOptionsType);
			GridBagConstraints gbc_lblCabinType = new GridBagConstraints();
			gbc_lblCabinType.anchor = GridBagConstraints.EAST;
			gbc_lblCabinType.insets = new Insets(0, 0, 5, 5);
			gbc_lblCabinType.gridx = 1;
			gbc_lblCabinType.gridy = 1;
			pnOptionsType.add(getLblCabinType(), gbc_lblCabinType);
			GridBagConstraints gbc_cbCabinType = new GridBagConstraints();
			gbc_cbCabinType.gridwidth = 2;
			gbc_cbCabinType.insets = new Insets(0, 0, 5, 5);
			gbc_cbCabinType.anchor = GridBagConstraints.NORTH;
			gbc_cbCabinType.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbCabinType.gridx = 2;
			gbc_cbCabinType.gridy = 1;
			pnOptionsType.add(getCbCabinType(), gbc_cbCabinType);
			GridBagConstraints gbc_lblNumberOfPersons = new GridBagConstraints();
			gbc_lblNumberOfPersons.anchor = GridBagConstraints.EAST;
			gbc_lblNumberOfPersons.insets = new Insets(0, 0, 5, 5);
			gbc_lblNumberOfPersons.gridx = 1;
			gbc_lblNumberOfPersons.gridy = 3;
			pnOptionsType.add(getLblNumberOfPersons(), gbc_lblNumberOfPersons);
			GridBagConstraints gbc_spinnerPersons = new GridBagConstraints();
			gbc_spinnerPersons.fill = GridBagConstraints.HORIZONTAL;
			gbc_spinnerPersons.insets = new Insets(0, 0, 5, 5);
			gbc_spinnerPersons.gridx = 2;
			gbc_spinnerPersons.gridy = 3;
			pnOptionsType.add(getSpinnerPersons(), gbc_spinnerPersons);
		}
		return pnOptionsType;
	}
	private JComboBox<Cabin> getCbCabinType() {
		if (cbCabinType == null) {
			cbCabinType = new JComboBox<Cabin>();
			cbCabinType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculatePrice();
					if (cbCabinType.getSelectedItem() != null) {
						spinnerPersons.setModel(new SpinnerNumberModel(1, 1, ((Cabin) cbCabinType.getSelectedItem()).getCapacidad(), 1));
					}
				}
			});
		}
		return cbCabinType;
	}
	private JLabel getLblCabinType() {
		if (lblCabinType == null) {
			lblCabinType = new JLabel();
			lblCabinType.setDisplayedMnemonic('t');
			lblCabinType.setLabelFor(getCbCabinType());
		}
		return lblCabinType;
	}
	private JSpinner getSpinnerPersons() {
		if (spinnerPersons == null) {
			spinnerPersons = new JSpinner();
			spinnerPersons.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					calculatePrice();
				}
			});
		}
		return spinnerPersons;
	}
	private JLabel getLblNumberOfPersons() {
		if (lblNumberOfPersons == null) {
			lblNumberOfPersons = new JLabel();
			lblNumberOfPersons.setDisplayedMnemonic('n');
			lblNumberOfPersons.setLabelFor(getSpinnerPersons());
		}
		return lblNumberOfPersons;
	}
	private JPanel getPnOptionsConfig() {
		if (pnOptionsConfig == null) {
			pnOptionsConfig = new JPanel();
			GridBagLayout gbl_pnOptionsConfig = new GridBagLayout();
			gbl_pnOptionsConfig.columnWidths = new int[]{38, 456, 48, 0};
			gbl_pnOptionsConfig.rowHeights = new int[]{112, 152, 109, 0};
			gbl_pnOptionsConfig.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnOptionsConfig.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
			pnOptionsConfig.setLayout(gbl_pnOptionsConfig);
			GridBagConstraints gbc_pnOptionsType = new GridBagConstraints();
			gbc_pnOptionsType.fill = GridBagConstraints.BOTH;
			gbc_pnOptionsType.insets = new Insets(0, 0, 5, 5);
			gbc_pnOptionsType.gridx = 1;
			gbc_pnOptionsType.gridy = 0;
			pnOptionsConfig.add(getPnOptionsType(), gbc_pnOptionsType);
			GridBagConstraints gbc_spOptionsExtras = new GridBagConstraints();
			gbc_spOptionsExtras.insets = new Insets(0, 0, 5, 5);
			gbc_spOptionsExtras.fill = GridBagConstraints.BOTH;
			gbc_spOptionsExtras.gridx = 1;
			gbc_spOptionsExtras.gridy = 1;
			pnOptionsConfig.add(getSpOptionsExtras(), gbc_spOptionsExtras);
			GridBagConstraints gbc_spCabinList = new GridBagConstraints();
			gbc_spCabinList.insets = new Insets(0, 0, 0, 5);
			gbc_spCabinList.fill = GridBagConstraints.BOTH;
			gbc_spCabinList.gridx = 1;
			gbc_spCabinList.gridy = 2;
			pnOptionsConfig.add(getSpCabinList(), gbc_spCabinList);
		}
		return pnOptionsConfig;
	}
	private JPanel getPnCabinBanner() {
		if (pnCabinBanner == null) {
			pnCabinBanner = new JPanel();
			pnCabinBanner.setLayout(new BorderLayout(0, 0));
			pnCabinBanner.add(getLblCabinBanner(), BorderLayout.WEST);
			pnCabinBanner.add(getLblCabinTitle(), BorderLayout.EAST);
		}
		return pnCabinBanner;
	}
	private JScrollPane getSpCabinList() {
		if (spCabinList == null) {
			spCabinList = new JScrollPane();
			spCabinList.setViewportView(getListCabins());
			spCabinList.getVerticalScrollBar().setUnitIncrement(20);
		}
		return spCabinList;
	}
	private JList<Booking> getListCabins() {
		if (listCabins == null) {
			listModel = new DefaultListModel<Booking>();
			listCabins = new JList<Booking>(listModel);
		}
		return listCabins;
	}
	private JTextField getTxtCabinPrice() {
		if (txtCabinPrice == null) {
			txtCabinPrice = new JTextField();
			txtCabinPrice.setFocusable(false);
			txtCabinPrice.setEditable(false);
			txtCabinPrice.setHorizontalAlignment(SwingConstants.CENTER);
			txtCabinPrice.setColumns(10);
		}
		return txtCabinPrice;
	}
	private JButton getBtnAddCabin() {
		if (btnAddCabin == null) {
			btnAddCabin = new JButton();
			btnAddCabin.setToolTipText("");
			btnAddCabin.setMnemonic('d');
			btnAddCabin.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnAddCabin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int people[] = new int[(int) spinnerPersons.getValue()];
					boolean minorsAllowed;
					if(selectedCruise.getAptoMenores().equals("S"))
						minorsAllowed = true;
					else
						minorsAllowed = false;
					JPanel pnSelectAges = new JPanel();
					ArrayList<JSpinner> spinners = new ArrayList<JSpinner>();
					
					if(((Cabin) cbCabinType.getSelectedItem()).getNombre().equals(texts.getString("txtCabinDE"))){
						if(nCabinsDE >= selectedCruise.getShip().getCabinsDE()){
							JOptionPane.showMessageDialog(pnContent, texts.getString("txtNotEnoughCabins"));
							return;
						}
						nCabinsDE++;
					}
					else if(((Cabin) cbCabinType.getSelectedItem()).getNombre().equals(texts.getString("txtCabinDI"))){
						if(nCabinsDI >= selectedCruise.getShip().getCabinsDI()){
							JOptionPane.showMessageDialog(pnContent, texts.getString("txtNotEnoughCabins"));
							return;
						}
						nCabinsDI++;
					}
					else if(((Cabin) cbCabinType.getSelectedItem()).getNombre().equals(texts.getString("txtCabinFE"))){
						if(nCabinsFE >= selectedCruise.getShip().getCabinsFE()){
							JOptionPane.showMessageDialog(pnContent, texts.getString("txtNotEnoughCabins"));
							return;
						}
						nCabinsFE++;
					}
					else if(((Cabin) cbCabinType.getSelectedItem()).getNombre().equals(texts.getString("txtCabinFI"))){
						if(nCabinsFI >= selectedCruise.getShip().getCabinsFI()){
							JOptionPane.showMessageDialog(pnContent, texts.getString("txtNotEnoughCabins"));
							return;
						}
						nCabinsFI++;
					}					
					
					for(int i=0; i<people.length; i++){
						JSpinner spinnerAge = null;
						
						if(minorsAllowed){
							spinnerAge = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
						}
						else{
							spinnerAge = new JSpinner(new SpinnerNumberModel(16, 16, 100, 1));
						}
					
						spinners.add(spinnerAge);
						pnSelectAges.add(spinnerAge);		
					}
					
					int value = JOptionPane.showConfirmDialog(pnContent, pnSelectAges, texts.getString("txtDialogSelectAges"), JOptionPane.OK_CANCEL_OPTION);
					int results[] = new int[people.length];
					
					if(value == JOptionPane.OK_OPTION){
						for(int i=0; i<people.length; i++)
							results[i] = (int) spinners.get(i).getValue();
						
						ArrayList<Extras> selectedExtras = new ArrayList<Extras>();
						for(int i=0; i<tA.getExtras().size(); i++)
							if(extras.get(i).isSelected())
								selectedExtras.add(tA.getExtras().get(i));
						
						Booking newBooking = new Booking(selectedCruise, selectedExtras, (String) cbDates.getSelectedItem(), (int) spinnerPersons.getValue(), 
								results, totalCabinPrice, discountedCabinPrice, ((Cabin) cbCabinType.getSelectedItem()).getNombre());
						listModel.addElement(newBooking);
						
						clearSelected();
						
						numberOfPassengers = numberOfPassengers + (Integer) spinnerPersons.getValue();
					
					}
				}
			});
		}
		return btnAddCabin;
	}
	
	private void clearSelected(){
		for(JCheckBox chckbx : extras)
			chckbx.setSelected(false);
		spinnerPersons.setValue(1);
		calculatePrice();
	}
	
	private void clear(){
		for(JCheckBox chckbx : extras)
			chckbx.setSelected(false);
		
		cbCabinType.removeAllItems();
		spinnerPersons.setValue(1);
		listModel.removeAllElements();
		
		totalCabinPrice = 0;
		txtCabinPrice.setText(0 + "\u20ac");
		txtTotalPrice.setText(0 + "\u20ac");
		
		for (int i=0; i < tA.getExtras().size(); i++)
			if (tA.getExtras().get(i).getNombre().equals("Cama supletoria"))
				extras.get(i).setEnabled(true);
	}
	
	private JButton getBtnRemoveCabin() {
		if (btnRemoveCabin == null) {
			btnRemoveCabin = new JButton();
			btnRemoveCabin.setToolTipText("");
			btnRemoveCabin.setMnemonic('m');
			btnRemoveCabin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(listCabins.getSelectedIndex() != -1){
						
						if(((Cabin) cbCabinType.getSelectedItem()).getNombre().equals(texts.getString("txtCabinDE")))
							nCabinsDE--;
						else if(((Cabin) cbCabinType.getSelectedItem()).getNombre().equals(texts.getString("txtCabinDI")))
							nCabinsDI++;
						else if(((Cabin) cbCabinType.getSelectedItem()).getNombre().equals(texts.getString("txtCabinFE")))
							nCabinsFE++;
						else if(((Cabin) cbCabinType.getSelectedItem()).getNombre().equals(texts.getString("txtCabinFI")))
							nCabinsFI++;
						
						numberOfPassengers = numberOfPassengers - ((Booking) listCabins.getSelectedValue()).getPeople();
						listModel.remove(listCabins.getSelectedIndex());
						
						calculatePrice();
					}
				}
			});
			btnRemoveCabin.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return btnRemoveCabin;
	}
	
	
	protected void calculatePrice(){
		if(selectedCruise == null || cbCabinType.getSelectedItem() == null)
			return;
		
		totalCabinPrice = 0;
		for(int i=0; i<extras.size(); i++)
			if(extras.get(i).isSelected())
				totalCabinPrice += tA.getExtras().get(i).getPrecio() * selectedCruise.getDuracion() * (Integer) spinnerPersons.getValue();
		
		totalCabinPrice += ((Cabin) cbCabinType.getSelectedItem()).getPrecio() * ((Cabin) cbCabinType.getSelectedItem()).getCapacidad() * selectedCruise.getDuracion();
		
		if(selectedCruise.getDiscounted())
			discountedCabinPrice = (totalCabinPrice*15)/100;
		
		txtCabinPrice.setText(totalCabinPrice - discountedCabinPrice + " \u20ac");
		
		if(!listModel.isEmpty()){
			int price = 0;
			int discPrice = 0;
			for(int i=0; i<listModel.getSize(); i++){
				price += listModel.getElementAt(i).getPrice();
				discPrice += listModel.getElementAt(i).getDiscountedPrice();
			}
		txtTotalPrice.setText(price-discPrice + " \u20ac");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private JTextArea getTaConsiderations() {
		if (taConsiderations == null) {
			taConsiderations = new JTextArea();
			taConsiderations.setLineWrap(true);
			taConsiderations.setWrapStyleWord(true);
		}
		return taConsiderations;
	}
	private JLabel getLblConsiderations() {
		if (lblConsiderations == null) {
			lblConsiderations = new JLabel();
			lblConsiderations.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblConsiderations.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblConsiderations;
	}
	private JScrollPane getSpConsiderations() {
		if (spConsiderations == null) {
			spConsiderations = new JScrollPane();
			spConsiderations.setViewportView(getTaConsiderations());
		}
		return spConsiderations;
	}
	private JLabel getLblCabinPrice() {
		if (lblCabinPrice == null) {
			lblCabinPrice = new JLabel();
		}
		return lblCabinPrice;
	}
	private JTextField getTxtTotalPrice() {
		if (txtTotalPrice == null) {
			txtTotalPrice = new JTextField();
			txtTotalPrice.setFocusable(false);
			txtTotalPrice.setEditable(false);
			txtTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
			txtTotalPrice.setColumns(10);
		}
		return txtTotalPrice;
	}
	private JPanel getPnTotalPrice() {
		if (pnTotalPrice == null) {
			pnTotalPrice = new JPanel();
			pnTotalPrice.add(getTxtTotalPrice());
		}
		return pnTotalPrice;
	}
	private JButton getBtnNextCabin() {
		if (btnNextCabin == null) {
			btnNextCabin = new JButton();
			btnNextCabin.setToolTipText("");
			btnNextCabin.setMnemonic('t');
			btnNextCabin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!listModel.isEmpty()){
						txtDataTotalPrice.setText(txtTotalPrice.getText());
						((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentData");
					}
					else
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogAddAnyCabin"));
				}
			});
		}
		return btnNextCabin;
	}
	private JButton getBtnBackCabin() {
		if (btnBackCabin == null) {
			btnBackCabin = new JButton();
			btnBackCabin.setToolTipText("");
			btnBackCabin.setMnemonic('a');
			btnBackCabin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentCruises");
					clear();
				}
			});
		}
		return btnBackCabin;
	}
	private JButton getBtnCancelCabin() {
		if (btnCancelCabin == null) {
			btnCancelCabin = new JButton();
			btnCancelCabin.setToolTipText("");
			btnCancelCabin.setMnemonic('n');
			btnCancelCabin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale(System.getProperty("user.language")));
					createPanels(pnCruises);
					createShipPanels(pnShips);
					fillCabinTypes();
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentStart");
					clear();
				}
			});
		}
		return btnCancelCabin;
	}
	private JPanel getPnContentData() {
		if (pnContentData == null) {
			pnContentData = new JPanel();
			pnContentData.setLayout(new BorderLayout(0, 0));
			pnContentData.add(getPnDataBanner(), BorderLayout.NORTH);
			pnContentData.add(getPnDataButtons(), BorderLayout.SOUTH);
			pnContentData.add(getPnDataFields(), BorderLayout.CENTER);
		}
		return pnContentData;
	}
	private JPanel getPnDataBanner() {
		if (pnDataBanner == null) {
			pnDataBanner = new JPanel();
			pnDataBanner.setLayout(new BorderLayout(0, 0));
			pnDataBanner.add(getLblDataBanner(), BorderLayout.WEST);
			pnDataBanner.add(getLblDataTitle(), BorderLayout.EAST);
		}
		return pnDataBanner;
	}
	private JPanel getPnDataButtons() {
		if (pnDataButtons == null) {
			pnDataButtons = new JPanel();
			pnDataButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnDataButtons.add(getBtnNextData());
			pnDataButtons.add(getBtnBackData());
			pnDataButtons.add(getBtnCancelData());
		}
		return pnDataButtons;
	}
	private JPanel getPnDataFields() {
		if (pnDataFields == null) {
			pnDataFields = new JPanel();
			GridBagLayout gbl_pnDataFields = new GridBagLayout();
			gbl_pnDataFields.columnWidths = new int[]{30, 80, 0, 200, 37, 63, 93, 172, 30, 0};
			gbl_pnDataFields.rowHeights = new int[]{30, 0, 30, 0, 30, 24, 30, 0, 30, 0, 0, 0};
			gbl_pnDataFields.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnDataFields.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			pnDataFields.setLayout(gbl_pnDataFields);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			pnDataFields.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.insets = new Insets(0, 0, 5, 5);
			gbc_txtName.gridx = 3;
			gbc_txtName.gridy = 1;
			pnDataFields.add(getTxtName(), gbc_txtName);
			GridBagConstraints gbc_lblSurnames = new GridBagConstraints();
			gbc_lblSurnames.anchor = GridBagConstraints.EAST;
			gbc_lblSurnames.insets = new Insets(0, 0, 5, 5);
			gbc_lblSurnames.gridx = 5;
			gbc_lblSurnames.gridy = 1;
			pnDataFields.add(getLblSurnames(), gbc_lblSurnames);
			GridBagConstraints gbc_txtSurnames = new GridBagConstraints();
			gbc_txtSurnames.gridwidth = 2;
			gbc_txtSurnames.insets = new Insets(0, 0, 5, 5);
			gbc_txtSurnames.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSurnames.gridx = 6;
			gbc_txtSurnames.gridy = 1;
			pnDataFields.add(getTxtSurnames(), gbc_txtSurnames);
			GridBagConstraints gbc_lblID = new GridBagConstraints();
			gbc_lblID.anchor = GridBagConstraints.EAST;
			gbc_lblID.insets = new Insets(0, 0, 5, 5);
			gbc_lblID.gridx = 1;
			gbc_lblID.gridy = 3;
			pnDataFields.add(getLblID(), gbc_lblID);
			GridBagConstraints gbc_txtID = new GridBagConstraints();
			gbc_txtID.insets = new Insets(0, 0, 5, 5);
			gbc_txtID.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtID.gridx = 3;
			gbc_txtID.gridy = 3;
			pnDataFields.add(getTxtID(), gbc_txtID);
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 5;
			gbc_lblEmail.gridy = 3;
			pnDataFields.add(getLblEmail(), gbc_lblEmail);
			GridBagConstraints gbc_txtEmail = new GridBagConstraints();
			gbc_txtEmail.gridwidth = 2;
			gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
			gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEmail.gridx = 6;
			gbc_txtEmail.gridy = 3;
			pnDataFields.add(getTxtEmail(), gbc_txtEmail);
			GridBagConstraints gbc_pnPaymentMethod = new GridBagConstraints();
			gbc_pnPaymentMethod.gridwidth = 5;
			gbc_pnPaymentMethod.insets = new Insets(0, 0, 5, 5);
			gbc_pnPaymentMethod.fill = GridBagConstraints.BOTH;
			gbc_pnPaymentMethod.gridx = 1;
			gbc_pnPaymentMethod.gridy = 5;
			pnDataFields.add(getPnPaymentMethod(), gbc_pnPaymentMethod);
			GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
			gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
			gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
			gbc_lblPhoneNumber.gridx = 1;
			gbc_lblPhoneNumber.gridy = 7;
			pnDataFields.add(getLblPhoneNumber(), gbc_lblPhoneNumber);
			GridBagConstraints gbc_txtPhoneNumber = new GridBagConstraints();
			gbc_txtPhoneNumber.anchor = GridBagConstraints.NORTH;
			gbc_txtPhoneNumber.insets = new Insets(0, 0, 5, 5);
			gbc_txtPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPhoneNumber.gridx = 3;
			gbc_txtPhoneNumber.gridy = 7;
			pnDataFields.add(getTxtPhoneNumber(), gbc_txtPhoneNumber);
			GridBagConstraints gbc_pnDataSummaryPrice = new GridBagConstraints();
			gbc_pnDataSummaryPrice.gridheight = 3;
			gbc_pnDataSummaryPrice.insets = new Insets(0, 0, 5, 5);
			gbc_pnDataSummaryPrice.gridx = 7;
			gbc_pnDataSummaryPrice.gridy = 7;
			pnDataFields.add(getPnDataSummaryPrice(), gbc_pnDataSummaryPrice);
			GridBagConstraints gbc_lblAddress = new GridBagConstraints();
			gbc_lblAddress.anchor = GridBagConstraints.EAST;
			gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAddress.gridx = 1;
			gbc_lblAddress.gridy = 9;
			pnDataFields.add(getLblAddress(), gbc_lblAddress);
			GridBagConstraints gbc_txtAddress = new GridBagConstraints();
			gbc_txtAddress.insets = new Insets(0, 0, 5, 5);
			gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAddress.gridx = 3;
			gbc_txtAddress.gridy = 9;
			pnDataFields.add(getTxtAddress(), gbc_txtAddress);
		}
		return pnDataFields;
	}
	private JPanel getPnDataSummaryPrice() {
		if (pnDataSummaryPrice == null) {
			pnDataSummaryPrice = new JPanel();
			pnDataSummaryPrice.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnDataSummaryPrice.add(getTxtDataTotalPrice());
		}
		return pnDataSummaryPrice;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel();
			lblName.setDisplayedMnemonic('m');
			lblName.setLabelFor(getTxtName());
		}
		return lblName;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setColumns(10);
		}
		return txtName;
	}
	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel();
			lblID.setLabelFor(getTxtID());
			lblID.setDisplayedMnemonic('d');
		}
		return lblID;
	}
	private JTextField getTxtID() {
		if (txtID == null) {
			txtID = new JTextField();
			txtID.setColumns(10);
			String hintText = getHintText(txtID);
			txtID.setText(hintText);
			txtID.setForeground(Color.LIGHT_GRAY);
			txtID.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txtID.getText().equals(hintText)){
						txtID.setText("");
						txtID.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtID.getText().isEmpty())
						generateHints(txtID);
				}
			});
		}
		return txtID;
	}
	private JPanel getPnPaymentMethod() {
		if (pnPaymentMethod == null) {
			pnPaymentMethod = new JPanel();
			pnPaymentMethod.setLayout(new BorderLayout(0, 0));
			pnPaymentMethod.add(getPnCreditBank(), BorderLayout.WEST);
			pnPaymentMethod.add(getPnInsertAccount(), BorderLayout.CENTER);
		}
		return pnPaymentMethod;
	}
	private JPanel getPnCreditBank() {
		if (pnCreditBank == null) {
			pnCreditBank = new JPanel();
			pnCreditBank.setLayout(new BoxLayout(pnCreditBank, BoxLayout.Y_AXIS));
			pnCreditBank.add(getRdbtnCreditCard());
			pnCreditBank.add(getRdbtnBankAccount());
		}
		return pnCreditBank;
	}
	private JPanel getPnInsertAccount() {
		if (pnInsertAccount == null) {
			pnInsertAccount = new JPanel();
			GridBagLayout gbl_pnInsertAccount = new GridBagLayout();
			gbl_pnInsertAccount.columnWidths = new int[]{47, 287, 10, 0};
			gbl_pnInsertAccount.rowHeights = new int[]{20, 0, 0};
			gbl_pnInsertAccount.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnInsertAccount.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnInsertAccount.setLayout(gbl_pnInsertAccount);
			GridBagConstraints gbc_lblInsertAccount = new GridBagConstraints();
			gbc_lblInsertAccount.anchor = GridBagConstraints.WEST;
			gbc_lblInsertAccount.insets = new Insets(0, 0, 5, 5);
			gbc_lblInsertAccount.gridx = 1;
			gbc_lblInsertAccount.gridy = 0;
			pnInsertAccount.add(getLblInsertAccount(), gbc_lblInsertAccount);
			GridBagConstraints gbc_txtCardNumber = new GridBagConstraints();
			gbc_txtCardNumber.insets = new Insets(0, 0, 0, 5);
			gbc_txtCardNumber.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCardNumber.anchor = GridBagConstraints.NORTH;
			gbc_txtCardNumber.gridx = 1;
			gbc_txtCardNumber.gridy = 1;
			pnInsertAccount.add(getTxtCardNumber(), gbc_txtCardNumber);
		}
		return pnInsertAccount;
	}
	private JRadioButton getRdbtnCreditCard() {
		if (rdbtnCreditCard == null) {
			rdbtnCreditCard = new JRadioButton();
			rdbtnCreditCard.setMnemonic('e');
			btgPayment.add(rdbtnCreditCard);
		}
		return rdbtnCreditCard;
	}
	private JRadioButton getRdbtnBankAccount() {
		if (rdbtnBankAccount == null) {
			rdbtnBankAccount = new JRadioButton();
			rdbtnBankAccount.setMnemonic('u');
			btgPayment.add(rdbtnBankAccount);
		}
		return rdbtnBankAccount;
	}
	private JTextField getTxtCardNumber() {
		if (txtCardNumber == null) {
			txtCardNumber = new JTextField();
			txtCardNumber.setColumns(10);
			String hintText = getHintText(txtCardNumber);
			txtCardNumber.setText(hintText);
			txtCardNumber.setForeground(Color.LIGHT_GRAY);
			txtCardNumber.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txtCardNumber.getText().equals(hintText)){
						txtCardNumber.setText("");
						txtCardNumber.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtCardNumber.getText().isEmpty())
						generateHints(txtCardNumber);
				}
			});
		}
		return txtCardNumber;
	}
	
	private String getHintText(JTextField txt){
		if(txt.equals(txtCardNumber))
			return "1234-1234-1234-1234"; 
		else if(txt.equals(txtID))
			return "12345678X"; 
		else if(txt.equals(txtEmail))
			return "user@email.com";
		else
			return "";
	}
	
	private void generateHints(JTextField txt){
		txt.setText(getHintText(txt));
		txt.setForeground(Color.LIGHT_GRAY);
	}
	
	private JLabel getLblInsertAccount() {
		if (lblInsertAccount == null) {
			lblInsertAccount = new JLabel();
			lblInsertAccount.setDisplayedMnemonic('c');
			lblInsertAccount.setLabelFor(getTxtCardNumber());
		}
		return lblInsertAccount;
	}
	private JLabel getLblSurnames() {
		if (lblSurnames == null) {
			lblSurnames = new JLabel();
			lblSurnames.setLabelFor(getTxtSurnames());
			lblSurnames.setDisplayedMnemonic('s');
		}
		return lblSurnames;
	}
	private JTextField getTxtSurnames() {
		if (txtSurnames == null) {
			txtSurnames = new JTextField();
			txtSurnames.setColumns(10);
		}
		return txtSurnames;
	}
	private JLabel getLblPhoneNumber() {
		if (lblPhoneNumber == null) {
			lblPhoneNumber = new JLabel();
			lblPhoneNumber.setLabelFor(getTxtPhoneNumber());
		}
		return lblPhoneNumber;
	}
	private JTextField getTxtPhoneNumber() {
		if (txtPhoneNumber == null) {
			txtPhoneNumber = new JTextField();
			txtPhoneNumber.setText("");
			txtPhoneNumber.setColumns(10);			
		}
		return txtPhoneNumber;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel();
			lblEmail.setLabelFor(getTxtEmail());
			lblEmail.setDisplayedMnemonic('l');
		}
		return lblEmail;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			String hintText = getHintText(txtEmail);
			txtEmail.setText(hintText);
			txtEmail.setForeground(Color.LIGHT_GRAY);
			txtEmail.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txtEmail.getText().equals(hintText)){
						txtEmail.setText("");
						txtEmail.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtEmail.getText().isEmpty())
						generateHints(txtEmail);
				}
			});
		}
		return txtEmail;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel();
			lblAddress.setLabelFor(getTxtAddress());
		}
		return lblAddress;
	}
	private JTextField getTxtAddress() {
		if (txtAddress == null) {
			txtAddress = new JTextField();
			txtAddress.setColumns(10);
		}
		return txtAddress;
	}
	private JTextField getTxtDataTotalPrice() {
		if (txtDataTotalPrice == null) {
			txtDataTotalPrice = new JTextField();
			txtDataTotalPrice.setFocusable(false);
			txtDataTotalPrice.setEditable(false);
			txtDataTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
			txtDataTotalPrice.setColumns(10);
		}
		return txtDataTotalPrice;
	}
	private JButton getBtnNextData() {
		if (btnNextData == null) {
			btnNextData = new JButton();
			btnNextData.setToolTipText("");
			btnNextData.setMnemonic('t');
			btnNextData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!checkNameField(txtName.getText()))
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogName"));
					else if(!checkSurnamesField(txtSurnames.getText()))
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogSurnames"));
					else if(!checkIDField(txtID.getText()) || txtID.getForeground() == Color.LIGHT_GRAY)
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogID"));
					else if(!checkEmailField(txtEmail.getText()) || txtEmail.getForeground() == Color.LIGHT_GRAY)
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogEmail"));
					else if(!checkCardField(txtCardNumber.getText()) || txtCardNumber.getForeground() == Color.LIGHT_GRAY)
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogCardNumber"));
					else if(!checkPhoneField(txtPhoneNumber.getText()))
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogPhoneNumber"));
					else if(txtAddress.getText().length() == 0)
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogAddress"));
					else if(!rdbtnCreditCard.isSelected() && !rdbtnBankAccount.isSelected())
						JOptionPane.showMessageDialog(pnContent, texts.getString("txtDialogPaymentMethod"));
					else{
						taBill.setText(getBill());
						((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentBill");
					}
				}
			});
		}
		return btnNextData;
	}
	private JButton getBtnCancelData() {
		if (btnCancelData == null) {
			btnCancelData = new JButton();
			btnCancelData.setToolTipText("");
			btnCancelData.setMnemonic('n');
			btnCancelData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
					clearData();
					localizar(new Locale(System.getProperty("user.language")));
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentStart");
				}
			});
			btnCancelData.setMnemonic('n');
		}
		return btnCancelData;
	}
	private JButton getBtnBackData() {
		if (btnBackData == null) {
			btnBackData = new JButton();
			btnBackData.setToolTipText("");
			btnBackData.setMnemonic('a');
			btnBackData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentCabin");
				}
			});
		}
		return btnBackData;
	}
	
	private void clearData(){
		txtName.setText("");
		txtSurnames.setText("");
		generateHints(txtID);
		generateHints(txtEmail);
		generateHints(txtCardNumber);
		txtPhoneNumber.setText("");
		txtAddress.setText("");
	}
	
	private boolean checkNameField(String input){
		if(input.matches("[a-zA-Z]+"))
			return true;
		return false;
	}
	
	private boolean checkSurnamesField(String input){
		if(input.matches("[a-zA-z]+([ '-][a-zA-Z]+)*"))
			return true;
		return false;
	}
	
	private boolean checkEmailField(String input){
		if(input.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{2,3}"))
			return true;
		return false;
	}
	
	private boolean checkPhoneField(String input){
		if(input.matches("[0-9]{9}"))
			return true;
		return false;
	}
	
	private boolean checkCardField(String input){
		if(input.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}"))
			return true;
		return false;
	}
	
	private boolean checkIDField(String input){
		if(input.matches("[0-9]{8}[a-zA-Z]{1}"))
			return true;
		return false;
	}
	
	
	protected String getBill(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(texts.getString("txtBookingProof") + " - EII TRAVEL AGENCY" + " - " + dateFormatSlash.format(Calendar.getInstance().getTime()) + "\n");
		sb.append("------------------------------------------------------------------------------\n");
		sb.append("(" + texts.getString("txtLblDataName") + " " + txtName.getText() + " " + txtSurnames.getText() + "  ·  " + 
				texts.getString("txtLblDataID") + " " + txtID.getText() + "  ·  " + texts.getString("txtLblDataPhoneNumber") + " " + txtPhoneNumber.getText() + ")\n\n");
		sb.append("** " + texts.getString("txtCruiseData") + " **\n");
		sb.append(texts.getString("txtCruise") + ": (" + selectedCruise.getDenominacion() + " / " + selectedCruise.getCodigo() + ")\n");
		sb.append(texts.getString("txtShip") + ": " + selectedCruise.getShip().getNombre() + "\n");
		sb.append(texts.getString("txtDepartureDate") + ": " + selectedDate + "\n");
		sb.append(texts.getString("txtDays") + ": " + selectedCruise.getDuracion() + "\n");
		sb.append(texts.getString("txtDeparture") + ": " + selectedCruise.getPuertoSalida() + "\n");
		sb.append(texts.getString("txtNumberOfPassengers") + ": " + numberOfPassengers + "\n");
		sb.append(texts.getString("txtCabins") + ": ");
		for(int i=0; i<listModel.size(); i++){
//			sb.append(listModel.getElementAt(i).toString() + "\n");
			sb.append(getCbCabinType().getSelectedItem() + " / ");
			for(Extras e : listModel.getElementAt(i).getExtras())
				sb.append(e.getNombre() + ", ");
			sb.append(";  ");
		}
		sb.append("\n\n");
		sb.append("**" + texts.getString("txtPaidBooking") + "**\n");
		float price = 0;
		float discPrice = 0;
		for(int i=0; i<listModel.getSize(); i++){
			price += listModel.getElementAt(i).getPrice();
			discPrice += listModel.getElementAt(i).getDiscountedPrice();
		}
		sb.append(texts.getString("txtCabins") + " + Extras: \n\t" + price + "\n");
		if(selectedCruise.getDiscounted()){
			sb.append(texts.getString("txtDiscountedOffer") + ": \n\t" + discPrice + " \u20ac\n");
			sb.append(texts.getString("txtTotalImport") + ": \n\t" + price + " - " + discPrice + "\n\n");
		}
		sb.append( "TOTAL ........................ " + (price-discPrice) + " \u20ac\n");		
		
		return sb.toString();
	}
	
	
	
	
	
	private JPanel getPnContentStart() {
		if (pnContentStart == null) {
			pnContentStart = new JPanel();
			GridBagLayout gbl_pnContentStart = new GridBagLayout();
			gbl_pnContentStart.columnWidths = new int[]{30, 93, 0, 0, 30, 0};
			gbl_pnContentStart.rowHeights = new int[]{0, 0, 30, 0};
			gbl_pnContentStart.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnContentStart.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
			pnContentStart.setLayout(gbl_pnContentStart);
			GridBagConstraints gbc_lblStartLogo = new GridBagConstraints();
			gbc_lblStartLogo.gridheight = 2;
			gbc_lblStartLogo.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartLogo.gridx = 2;
			gbc_lblStartLogo.gridy = 0;
			pnContentStart.add(getLblStartLogo(), gbc_lblStartLogo);
			GridBagConstraints gbc_btnES = new GridBagConstraints();
			gbc_btnES.insets = new Insets(0, 0, 5, 5);
			gbc_btnES.gridx = 1;
			gbc_btnES.gridy = 1;
			pnContentStart.add(getBtnES(), gbc_btnES);
			GridBagConstraints gbc_btnEN = new GridBagConstraints();
			gbc_btnEN.anchor = GridBagConstraints.SOUTH;
			gbc_btnEN.insets = new Insets(0, 0, 5, 5);
			gbc_btnEN.gridx = 3;
			gbc_btnEN.gridy = 1;
			pnContentStart.add(getBtnEN(), gbc_btnEN);
		}
		return pnContentStart;
	}
	private JButton getBtnES() {
		if (btnES == null) {
			btnES = new JButton("");
			btnES.setIcon(new ImageIcon(MainWindow.class.getResource("/img/ES_flag_s.png")));
			btnES.setBorderPainted(false);
			btnES.setToolTipText("");
			btnES.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale("es"));
					createPanels(pnCruises);
					createShipPanels(pnShips);
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentCruises");
				}
			});
		}
		return btnES;
	}
	private JButton getBtnEN() {
		if (btnEN == null) {
			btnEN = new JButton("");
			btnEN.setIcon(new ImageIcon(MainWindow.class.getResource("/img/EN_flag_s.png")));
			btnEN.setBorderPainted(false);
			btnEN.setToolTipText("");
			btnEN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale("en"));
					createPanels(pnCruises);
					createShipPanels(pnShips);
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentCruises");
				}
			});
		}
		return btnEN;
	}
	private JLabel getLblStartLogo() {
		if (lblStartLogo == null) {
			lblStartLogo = new JLabel("");
			lblStartLogo.setIcon(scale(new ImageIcon(MainWindow.class.getResource("/img/ship-icon.png")), 530, 400));
		}
		return lblStartLogo;
	}
	private JPanel getPnCruisesBanner() {
		if (pnCruisesBanner == null) {
			pnCruisesBanner = new JPanel();
			pnCruisesBanner.setLayout(new BorderLayout(0, 0));
			pnCruisesBanner.add(getLblCruisesBanner(), BorderLayout.WEST);
			pnCruisesBanner.add(getLblCruisesTitle(), BorderLayout.EAST);
		}
		return pnCruisesBanner;
	}
	private JLabel getLblCruisesBanner() {
		if (lblCruisesBanner == null) {
			lblCruisesBanner = new JLabel("");
			lblCruisesBanner.setIcon(new ImageIcon(MainWindow.class.getResource("/img/banner_short.png")));
		}
		return lblCruisesBanner;
	}
	private JLabel getLblCabinBanner() {
		if (lblCabinBanner == null) {
			lblCabinBanner = new JLabel("");
			lblCabinBanner.setIcon(new ImageIcon(MainWindow.class.getResource("/img/banner_short.png")));
		}
		return lblCabinBanner;
	}
	private JLabel getLblDataBanner() {
		if (lblDataBanner == null) {
			lblDataBanner = new JLabel("");
			lblDataBanner.setIcon(new ImageIcon(MainWindow.class.getResource("/img/banner_short.png")));
		}
		return lblDataBanner;
	}
	private JPanel getPnContentBill() {
		if (pnContentBill == null) {
			pnContentBill = new JPanel();
			pnContentBill.setLayout(new BorderLayout(0, 0));
			pnContentBill.add(getPnBillButtons(), BorderLayout.SOUTH);
			pnContentBill.add(getPnBillBanner(), BorderLayout.NORTH);
			pnContentBill.add(getSpBillContent(), BorderLayout.CENTER);
		}
		return pnContentBill;
	}
	private JPanel getPnBillButtons() {
		if (pnBillButtons == null) {
			pnBillButtons = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBillButtons.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBillButtons.add(getBtnPurchaseBill());
			pnBillButtons.add(getBtnBackBill());
			pnBillButtons.add(getBtnCancelBill());
		}
		return pnBillButtons;
	}
	private JPanel getPnBillBanner() {
		if (pnBillBanner == null) {
			pnBillBanner = new JPanel();
			pnBillBanner.setLayout(new BorderLayout(0, 0));
			pnBillBanner.add(getLblBillBanner());
			pnBillBanner.add(getLblBillTitle(), BorderLayout.EAST);
		}
		return pnBillBanner;
	}
	private JButton getBtnPurchaseBill() {
		if (btnPurchaseBill == null) {
			btnPurchaseBill = new JButton();
			btnPurchaseBill.setToolTipText("");
			btnPurchaseBill.setMnemonic('u');
			btnPurchaseBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tA.printBill(taBill.getText(), txtID.getText(), dateFormatDash.format(Calendar.getInstance().getTime()));
					clear();
					clearData();
					localizar(new Locale(System.getProperty("user.language")));
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentStart");
				}
			});
		}
		return btnPurchaseBill;
	}
	private JButton getBtnBackBill() {
		if (btnBackBill == null) {
			btnBackBill = new JButton();
			btnBackBill.setToolTipText("");
			btnBackBill.setMnemonic('a');
			btnBackBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentData");
				}
			});
		}
		return btnBackBill;
	}
	private JButton getBtnCancelBill() {
		if (btnCancelBill == null) {
			btnCancelBill = new JButton();
			btnCancelBill.setToolTipText("");
			btnCancelBill.setMnemonic('n');
			btnCancelBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale(System.getProperty("user.language")));
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentStart");
				}
			});
		}
		return btnCancelBill;
	}
	private JScrollPane getSpBillContent() {
		if (spBillContent == null) {
			spBillContent = new JScrollPane();
			spBillContent.setViewportView(getTaBill());
		}
		return spBillContent;
	}
	private JTextArea getTaBill() {
		if (taBill == null) {
			taBill = new JTextArea();
			taBill.setWrapStyleWord(true);
			taBill.setLineWrap(true);
			taBill.setEditable(false);
		}
		return taBill;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnApplication());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnApplication() {
		if (mnApplication == null) {
			mnApplication = new JMenu();
			mnApplication.setMnemonic('p');
			mnApplication.add(getSeparator());
			mnApplication.add(getMntmClose());
		}
		return mnApplication;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu();
			mnOptions.setMnemonic('o');
			mnOptions.add(getMnLanguage());
			mnOptions.add(getChckbxTooltips());
		}
		return mnOptions;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu();
			mnHelp.setMnemonic('h');
			mnHelp.add(getMntmHelp());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmClose() {
		if (mntmClose == null) {
			mntmClose = new JMenuItem();
			mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmClose;
	}
	private JMenu getMnLanguage() {
		if (mnLanguage == null) {
			mnLanguage = new JMenu();
			mnLanguage.setMnemonic('a');
			mnLanguage.add(getMntmEnEs());
		}
		return mnLanguage;
	}
	private JMenuItem getMntmEnEs() {
		if (mntmEnEs == null) {
			mntmEnEs = new JMenuItem();
			mntmEnEs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (texts.equals(ResourceBundle.getBundle("rcs/texts", Locale.getDefault()))){
						localizar(new Locale("es"));
						createPanels(pnCruises);
						createShipPanels(pnShips);
						fillCabinTypes();
					}
					else{
						localizar(new Locale("en"));
						createPanels(pnCruises);
						createShipPanels(pnShips);
						fillCabinTypes();
					}
				}
			});
		}
		return mntmEnEs;
	}
	private JCheckBox getChckbxTooltips() {
		if (chckbxTooltips == null) {
			chckbxTooltips = new JCheckBox("Tooltips");
			chckbxTooltips.setMnemonic('t');
			chckbxTooltips.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (chckbxTooltips.isSelected())
						ToolTipManager.sharedInstance().setEnabled(true);
					else if (!chckbxTooltips.isSelected())
						ToolTipManager.sharedInstance().setEnabled(false);
				}
			});
		}
		return chckbxTooltips;
	}
	private JMenuItem getMntmHelp() {
		if (mntmHelp == null) {
			mntmHelp = new JMenuItem();
			mntmHelp.setMnemonic('e');
		}
		return mntmHelp;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem();
			mntmAbout.setMnemonic('b');
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(pnContent, "<html><center>EII Travel Agency <br> Practical holidays module <br>"
							+ " \u00a9 Miguel García García · UO245504</center></html>");
				}
			});
		}
		return mntmAbout;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JPanel getPnCabinPrice() {
		if (pnCabinPrice == null) {
			pnCabinPrice = new JPanel();
			pnCabinPrice.add(getTxtCabinPrice());
		}
		return pnCabinPrice;
	}
	private JLabel getLblDisclaimer() {
		if (lblDisclaimer == null) {
			lblDisclaimer = new JLabel("          *Prices shown in each item are per night and person. Prices on the right of the window show total prices.");
		}
		return lblDisclaimer;
	}
	private JPanel getPnCabinButtonsAndDisclaimer() {
		if (pnCabinButtonsAndDisclaimer == null) {
			pnCabinButtonsAndDisclaimer = new JPanel();
			pnCabinButtonsAndDisclaimer.setLayout(new BorderLayout(0, 0));
			pnCabinButtonsAndDisclaimer.add(getPnCabinButtons(), BorderLayout.EAST);
			pnCabinButtonsAndDisclaimer.add(getLblDisclaimer(), BorderLayout.WEST);
		}
		return pnCabinButtonsAndDisclaimer;
	}
	private JLabel getLblBillBanner() {
		if (lblBillBanner == null) {
			lblBillBanner = new JLabel("");
			lblBillBanner.setIcon(new ImageIcon(MainWindow.class.getResource("/img/banner_short.png")));
		}
		return lblBillBanner;
	}
	private JLabel getLblBillTitle() {
		if (lblBillTitle == null) {
			lblBillTitle = new JLabel();
			lblBillTitle.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
		}
		return lblBillTitle;
	}
	private JLabel getLblCabinTitle() {
		if (lblCabinTitle == null) {
			lblCabinTitle = new JLabel();
			lblCabinTitle.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
		}
		return lblCabinTitle;
	}
	private JLabel getLblDataTitle() {
		if (lblDataTitle == null) {
			lblDataTitle = new JLabel();
			lblDataTitle.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
		}
		return lblDataTitle;
	}
	private JLabel getLblCruisesTitle() {
		if (lblCruisesTitle == null) {
			lblCruisesTitle = new JLabel();
			lblCruisesTitle.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
		}
		return lblCruisesTitle;
	}
	private JPanel getPnContentShips() {
		if (pnContentShips == null) {
			pnContentShips = new JPanel();
			pnContentShips.setLayout(new BorderLayout(0, 0));
			pnContentShips.add(getPnShipsBanner(), BorderLayout.NORTH);
			pnContentShips.add(getPnShipsButtons(), BorderLayout.SOUTH);
			pnContentShips.add(getPnShips(), BorderLayout.CENTER);
		}
		return pnContentShips;
	}
	private JPanel getPnShipsBanner() {
		if (pnShipsBanner == null) {
			pnShipsBanner = new JPanel();
			pnShipsBanner.setLayout(new BorderLayout(0, 0));
			pnShipsBanner.add(getLblShipsBanner(), BorderLayout.WEST);
			pnShipsBanner.add(getLblShipsTitle(), BorderLayout.EAST);
		}
		return pnShipsBanner;
	}
	private JLabel getLblShipsBanner() {
		if (lblShipsBanner == null) {
			lblShipsBanner = new JLabel("");
			lblShipsBanner.setIcon(new ImageIcon(MainWindow.class.getResource("/img/banner_short.png")));
		}
		return lblShipsBanner;
	}
	private JLabel getLblShipsTitle() {
		if (lblShipsTitle == null) {
			lblShipsTitle = new JLabel("");
			lblShipsTitle.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
		}
		return lblShipsTitle;
	}
	private JPanel getPnShipsButtons() {
		if (pnShipsButtons == null) {
			pnShipsButtons = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnShipsButtons.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnShipsButtons.add(getBtnBackShips());
		}
		return pnShipsButtons;
	}
	private JButton getBtnBackShips() {
		if (btnBackShips == null) {
			btnBackShips = new JButton();
			btnBackShips.setMnemonic('a');
			btnBackShips.setToolTipText("");
			btnBackShips.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentCruises");
				}
			});
		}
		return btnBackShips;
	}
	

	private JPanel getPnShips() {
		if (pnShips == null) {
			pnShips = new JPanel();
			pnShips.setLayout(new GridLayout(1, 0, 0, 0));
		}
		return pnShips;
	}
	
	protected void createShipPanels(JPanel panel){
		panel.removeAll();
		for(int i=0; i<tA.getShips().size(); i++){
			panel.add(newShipPanel(i));
		}
	}
	
	private JPanel newShipPanel(Integer index){
		pnShipImageAndText = new JPanel();
		pnShipImageAndText.setLayout(new BorderLayout(0, 0));
	
		
		spShip = new JScrollPane();
		
		spShip.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spShip.setBounds(10, 35, 250, 525);
		spShip.setBackground(new Color(1, 0, 0, 0));
		spShip.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		spShip.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		spShip.getViewport().setViewPosition(new Point(0,0));
		spShip.getVerticalScrollBar().setUnitIncrement(20);		//Making the wheel scrolling speed higher
		
		pnShipImageAndText.add(spShip, BorderLayout.CENTER);
		
		
		JPanel pnShipText = new JPanel();
		pnShipText.setLayout(new BorderLayout(0, 0));
		spShip.setViewportView(pnShipText);
		
		generateShipInfo(pnShipText, index);
		
		return pnShipImageAndText;
	}
	
	private void generateShipInfo(JPanel pn, int index){
		Ship s = tA.getShips().get(index);
		
		JPanel pnShipImage = new JPanel();
		pnShipImage.setLayout(new OverlayLayout(pnShipImage));
		pnShipImageAndText.add(pnShipImage, BorderLayout.NORTH);
		
		JLabel image = new JLabel();
		image.setIcon(scale(new ImageIcon(MainWindow.class.getResource("/img/" + s.getCodigo() + ".jpg")), 283, 160));
		image.setHorizontalAlignment(JLabel.RIGHT);
		image.setVerticalAlignment(JLabel.TOP);
		image.setAlignmentX(0.0f);
		image.setAlignmentY(0.0f);
		
		
		pnShipImage.add(image);
		
		JTextPane tp = new JTextPane();
		
		tp.setContentType("text/html");	
		
		StringBuffer sb = new StringBuffer();
		sb.append("<b>" + s.getNombre().toUpperCase()+ "</b><br><br>");
		sb.append("<b>" + texts.getString("txtShipsDescripcion") + "</b><br>");
		sb.append(s.getDescripcion()+ "<br><br>");
		
		tp.setText(sb.toString());
		
		tp.setCaretPosition(0); 		//To start at top on the panel if there is too much information and scroll is needed

		pn.add(tp, BorderLayout.CENTER);
		tp.setEditable(false);
		
		spShip.setViewportView(tp);	//This line here is crucial in order for the text to wrap and not go in the same line infinitely because of the scroll pane
		
		/**
		 * The function of this block of code basically to align the text to the center.
		 */
//		StyledDocument doc = tp.getStyledDocument();
//		SimpleAttributeSet center = new SimpleAttributeSet();
//		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
//		doc.setParagraphAttributes(0, doc.getLength(), center, false);
				
		
		
		/**
		 * Clean way of setting properties for all the elements of each kind inside the same panel
		 */
		for(Component comp : pn.getComponents()){
			if(comp instanceof JTextField)
				comp.setEnabled(false);
		}
		
	}

	private JButton getBtnShipsInfoCruises() {
		if (btnShipsInfoCruises == null) {
			btnShipsInfoCruises = new JButton("");
			btnShipsInfoCruises.setMnemonic('i');
			btnShipsInfoCruises.setToolTipText("");
			btnShipsInfoCruises.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) pnContent.getLayout()).show(pnContent, "pnContentShips");
				}
			});
		}
		return btnShipsInfoCruises;
	}
}