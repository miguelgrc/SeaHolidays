package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;


public class CruiseSelection extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnCruise1;
	private JLabel lblImageCruise1;
	private JLabel lblNameCruise1;
	private JTextField txtPriceCruise1;
	private JPanel pnCruise2;
	private JLabel lblImageCruise2;
	private JLabel lblNameCruise2;
	private JTextField txtPriceCruise2;
	private JPanel pnCruise3;
	private JLabel lblImageCruise3;
	private JLabel lblNameCruise3;
	private JTextField txtPriceCruise3;
	private JPanel pnCruise4;
	private JLabel lblImageCruise4;
	private JLabel lblNameCruise4;
	private JTextField txtPriceCruise4;
	private JPanel pnCruise5;
	private JLabel lblImageCruise5;
	private JLabel lblNameCruise5;
	private JTextField txtPriceCruise5;
	private JPanel pnInfoCruise1;
	private JPanel pnInfoCruise2;
	private JPanel pnInfoCruise3;
	private JPanel pnInfoCruise4;
	private JPanel panel;
	private JPanel pnTitle;
	private JPanel pnContent;
	private JLabel lblChooseYourCruise;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDialog.setDefaultLookAndFeelDecorated(true);
					JFrame.setDefaultLookAndFeelDecorated(true);;
					
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");					
					
					CruiseSelection frame = new CruiseSelection();
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
	public CruiseSelection() {
		setTitle("EII Travel Agency");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CruiseSelection.class.getResource("/img/ship-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnContent());
		contentPane.add(getPnTitle(), BorderLayout.NORTH);
	}

	private JPanel getPnCruise1() {
		if (pnCruise1 == null) {
			pnCruise1 = new JPanel();
			GridBagLayout gbl_pnCruise1 = new GridBagLayout();
			gbl_pnCruise1.columnWidths = new int[]{154, 0};
			gbl_pnCruise1.rowHeights = new int[]{213, 213, 0};
			gbl_pnCruise1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_pnCruise1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnCruise1.setLayout(gbl_pnCruise1);
			GridBagConstraints gbc_lblImageCruise1 = new GridBagConstraints();
			gbc_lblImageCruise1.fill = GridBagConstraints.BOTH;
			gbc_lblImageCruise1.insets = new Insets(0, 0, 5, 0);
			gbc_lblImageCruise1.gridx = 0;
			gbc_lblImageCruise1.gridy = 0;
			pnCruise1.add(getLblImageCruise1(), gbc_lblImageCruise1);
			GridBagConstraints gbc_pnInfoCruise1 = new GridBagConstraints();
			gbc_pnInfoCruise1.fill = GridBagConstraints.BOTH;
			gbc_pnInfoCruise1.gridx = 0;
			gbc_pnInfoCruise1.gridy = 1;
			pnCruise1.add(getPnInfoCruise1(), gbc_pnInfoCruise1);
		}
		return pnCruise1;
	}
	private JLabel getLblImageCruise1() {
		if (lblImageCruise1 == null) {
			lblImageCruise1 = new JLabel("");
			lblImageCruise1.setIcon(scale(new ImageIcon(CruiseSelection.class.getResource("/img/CRU0001.jpg")), 170, 96));
			lblImageCruise1.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return lblImageCruise1;
	}
	private JLabel getLblNameCruise1() {
		if (lblNameCruise1 == null) {
			lblNameCruise1 = new JLabel("CRUISE NAME");
			lblNameCruise1.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return lblNameCruise1;
	}
	private JTextField getTxtPriceCruise1() {
		if (txtPriceCruise1 == null) {
			txtPriceCruise1 = new JTextField("PRICE");
			txtPriceCruise1.setBorder(null);
			txtPriceCruise1.setEditable(false);
			txtPriceCruise1.setHorizontalAlignment(SwingConstants.CENTER);
			txtPriceCruise1.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return txtPriceCruise1;
	}
	private JPanel getPnCruise2() {
		if (pnCruise2 == null) {
			pnCruise2 = new JPanel();
			GridBagLayout gbl_pnCruise2 = new GridBagLayout();
			gbl_pnCruise2.columnWidths = new int[]{154, 0};
			gbl_pnCruise2.rowHeights = new int[]{213, 213, 0};
			gbl_pnCruise2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_pnCruise2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnCruise2.setLayout(gbl_pnCruise2);
			GridBagConstraints gbc_lblImageCruise2 = new GridBagConstraints();
			gbc_lblImageCruise2.fill = GridBagConstraints.BOTH;
			gbc_lblImageCruise2.insets = new Insets(0, 0, 5, 0);
			gbc_lblImageCruise2.gridx = 0;
			gbc_lblImageCruise2.gridy = 0;
			pnCruise2.add(getLblImageCruise2(), gbc_lblImageCruise2);
			GridBagConstraints gbc_pnInfoCruise2 = new GridBagConstraints();
			gbc_pnInfoCruise2.fill = GridBagConstraints.BOTH;
			gbc_pnInfoCruise2.gridx = 0;
			gbc_pnInfoCruise2.gridy = 1;
			pnCruise2.add(getPnInfoCruise2(), gbc_pnInfoCruise2);
		}
		return pnCruise2;
	}
	private JLabel getLblImageCruise2() {
		if (lblImageCruise2 == null) {
			lblImageCruise2 = new JLabel("");
			lblImageCruise2.setIcon(new ImageIcon(CruiseSelection.class.getResource("/img/CRU0002.jpg")));
			lblImageCruise2.setAlignmentX(0.5f);
		}
		return lblImageCruise2;
	}
	private JLabel getLblNameCruise2() {
		if (lblNameCruise2 == null) {
			lblNameCruise2 = new JLabel("CRUISE NAME");
			lblNameCruise2.setAlignmentX(0.5f);
		}
		return lblNameCruise2;
	}
	private JTextField getTxtPriceCruise2() {
		if (txtPriceCruise2 == null) {
			txtPriceCruise2 = new JTextField("PRICE");
			txtPriceCruise2.setBorder(null);
			txtPriceCruise2.setEditable(false);
			txtPriceCruise2.setHorizontalAlignment(SwingConstants.CENTER);
			txtPriceCruise2.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return txtPriceCruise2;
	}
	private JPanel getPnCruise3() {
		if (pnCruise3 == null) {
			pnCruise3 = new JPanel();
			GridBagLayout gbl_pnCruise3 = new GridBagLayout();
			gbl_pnCruise3.columnWidths = new int[]{154, 0};
			gbl_pnCruise3.rowHeights = new int[]{213, 213, 0};
			gbl_pnCruise3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_pnCruise3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnCruise3.setLayout(gbl_pnCruise3);
			GridBagConstraints gbc_lblImageCruise3 = new GridBagConstraints();
			gbc_lblImageCruise3.fill = GridBagConstraints.BOTH;
			gbc_lblImageCruise3.insets = new Insets(0, 0, 5, 0);
			gbc_lblImageCruise3.gridx = 0;
			gbc_lblImageCruise3.gridy = 0;
			pnCruise3.add(getImageCruise3(), gbc_lblImageCruise3);
			GridBagConstraints gbc_pnInfoCruise3 = new GridBagConstraints();
			gbc_pnInfoCruise3.fill = GridBagConstraints.BOTH;
			gbc_pnInfoCruise3.gridx = 0;
			gbc_pnInfoCruise3.gridy = 1;
			pnCruise3.add(getPnInfoCruise3(), gbc_pnInfoCruise3);
		}
		return pnCruise3;
	}
	private JLabel getImageCruise3() {
		if (lblImageCruise3 == null) {
			lblImageCruise3 = new JLabel("");
			lblImageCruise3.setIcon(new ImageIcon(CruiseSelection.class.getResource("/img/CRU0003.jpg")));
			lblImageCruise3.setAlignmentX(0.5f);
		}
		return lblImageCruise3;
	}
	private JLabel getNameCruise3() {
		if (lblNameCruise3 == null) {
			lblNameCruise3 = new JLabel("CRUISE NAME");
			lblNameCruise3.setAlignmentX(0.5f);
		}
		return lblNameCruise3;
	}
	private JTextField getTxtPriceCruise3() {
		if (txtPriceCruise3 == null) {
			txtPriceCruise3 = new JTextField("PRICE");
			txtPriceCruise3.setBorder(null);
			txtPriceCruise3.setEditable(false);
			txtPriceCruise3.setHorizontalAlignment(SwingConstants.CENTER);
			txtPriceCruise3.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return txtPriceCruise3;
	}
	private JPanel getPnCruise4() {
		if (pnCruise4 == null) {
			pnCruise4 = new JPanel();
			GridBagLayout gbl_pnCruise4 = new GridBagLayout();
			gbl_pnCruise4.columnWidths = new int[]{154, 0};
			gbl_pnCruise4.rowHeights = new int[]{213, 213, 0};
			gbl_pnCruise4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_pnCruise4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnCruise4.setLayout(gbl_pnCruise4);
			GridBagConstraints gbc_lblImageCruise4 = new GridBagConstraints();
			gbc_lblImageCruise4.fill = GridBagConstraints.BOTH;
			gbc_lblImageCruise4.insets = new Insets(0, 0, 5, 0);
			gbc_lblImageCruise4.gridx = 0;
			gbc_lblImageCruise4.gridy = 0;
			pnCruise4.add(getImageCruise4(), gbc_lblImageCruise4);
			GridBagConstraints gbc_pnInfoCruise4 = new GridBagConstraints();
			gbc_pnInfoCruise4.fill = GridBagConstraints.BOTH;
			gbc_pnInfoCruise4.gridx = 0;
			gbc_pnInfoCruise4.gridy = 1;
			pnCruise4.add(getPnInfoCruise4(), gbc_pnInfoCruise4);
		}
		return pnCruise4;
	}
	private JLabel getImageCruise4() {
		if (lblImageCruise4 == null) {
			lblImageCruise4 = new JLabel("");
			lblImageCruise4.setIcon(new ImageIcon(CruiseSelection.class.getResource("/img/CRU0004.jpg")));
			lblImageCruise4.setAlignmentX(0.5f);
		}
		return lblImageCruise4;
	}
	private JLabel getNameCruise4() {
		if (lblNameCruise4 == null) {
			lblNameCruise4 = new JLabel("CRUISE NAME");
			lblNameCruise4.setAlignmentX(0.5f);
		}
		return lblNameCruise4;
	}
	private JTextField getTxtPriceCruise4() {
		if (txtPriceCruise4 == null) {
			txtPriceCruise4 = new JTextField("PRICE");
			txtPriceCruise4.setBorder(null);
			txtPriceCruise4.setEditable(false);
			txtPriceCruise4.setHorizontalAlignment(SwingConstants.CENTER);
			txtPriceCruise4.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return txtPriceCruise4;
	}
	private JPanel getPnCruise5() {
		if (pnCruise5 == null) {
			pnCruise5 = new JPanel();
			GridBagLayout gbl_pnCruise5 = new GridBagLayout();
			gbl_pnCruise5.columnWidths = new int[]{154, 0};
			gbl_pnCruise5.rowHeights = new int[]{213, 213, 0};
			gbl_pnCruise5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_pnCruise5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnCruise5.setLayout(gbl_pnCruise5);
			GridBagConstraints gbc_lblImageCruise5 = new GridBagConstraints();
			gbc_lblImageCruise5.fill = GridBagConstraints.BOTH;
			gbc_lblImageCruise5.insets = new Insets(0, 0, 5, 0);
			gbc_lblImageCruise5.gridx = 0;
			gbc_lblImageCruise5.gridy = 0;
			pnCruise5.add(getImageCruise5(), gbc_lblImageCruise5);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			pnCruise5.add(getPanel(), gbc_panel);
		}
		return pnCruise5;
	}
	private JLabel getImageCruise5() {
		if (lblImageCruise5 == null) {
			lblImageCruise5 = new JLabel("");
			lblImageCruise5.setIcon(new ImageIcon(CruiseSelection.class.getResource("/img/CRU0005.jpg")));
			lblImageCruise5.setAlignmentX(0.5f);
		}
		return lblImageCruise5;
	}
	private JLabel getNameCruise5() {
		if (lblNameCruise5 == null) {
			lblNameCruise5 = new JLabel("CRUISE NAME");
			lblNameCruise5.setAlignmentX(0.5f);
		}
		return lblNameCruise5;
	}
	private JTextField getTxtPriceCruise5() {
		if (txtPriceCruise5 == null) {
			txtPriceCruise5 = new JTextField("PRICE");
			txtPriceCruise5.setBorder(null);
			txtPriceCruise5.setEditable(false);
			txtPriceCruise5.setHorizontalAlignment(SwingConstants.CENTER);
			txtPriceCruise5.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return txtPriceCruise5;
	}
	private JPanel getPnInfoCruise1() {
		if (pnInfoCruise1 == null) {
			pnInfoCruise1 = new JPanel();
			pnInfoCruise1.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfoCruise1.add(getLblNameCruise1());
			pnInfoCruise1.add(getTxtPriceCruise1());
		}
		return pnInfoCruise1;
	}
	private JPanel getPnInfoCruise2() {
		if (pnInfoCruise2 == null) {
			pnInfoCruise2 = new JPanel();
			pnInfoCruise2.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfoCruise2.add(getLblNameCruise2());
			pnInfoCruise2.add(getTxtPriceCruise2());
		}
		return pnInfoCruise2;
	}
	private JPanel getPnInfoCruise3() {
		if (pnInfoCruise3 == null) {
			pnInfoCruise3 = new JPanel();
			pnInfoCruise3.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfoCruise3.add(getNameCruise3());
			pnInfoCruise3.add(getTxtPriceCruise3());
		}
		return pnInfoCruise3;
	}
	private JPanel getPnInfoCruise4() {
		if (pnInfoCruise4 == null) {
			pnInfoCruise4 = new JPanel();
			pnInfoCruise4.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfoCruise4.add(getNameCruise4());
			pnInfoCruise4.add(getTxtPriceCruise4());
		}
		return pnInfoCruise4;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(getNameCruise5());
			panel.add(getTxtPriceCruise5());
		}
		return panel;
	}
	private JPanel getPnTitle() {
		if (pnTitle == null) {
			pnTitle = new JPanel();
			pnTitle.add(getLblChooseYourCruise());
		}
		return pnTitle;
	}
	private JPanel getPnContent() {
		if (pnContent == null) {
			pnContent = new JPanel();
			pnContent.setLayout(new GridLayout(0, 5, 0, 0));
			pnContent.add(getPnCruise1());
			pnContent.add(getPnCruise2());
			pnContent.add(getPnCruise3());
			pnContent.add(getPnCruise4());
			pnContent.add(getPnCruise5());
		}
		return pnContent;
	}
	private JLabel getLblChooseYourCruise() {
		if (lblChooseYourCruise == null) {
			lblChooseYourCruise = new JLabel("CHOOSE YOUR CRUISE");
		}
		return lblChooseYourCruise;
	}
}
