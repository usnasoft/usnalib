package usna.examples;

/**
 * <p>Title: UsnaCalculator</p>
 * <p>Example of use for UsnaCalcPanel</p>
 * <p>Copyright (c) 2007</p>
 * <p>Company: USNA</p>
 * @author - Antonio Flaccomio
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.SoftBevelBorder;

import usna.swing.gadget.CalculatorPanel;

public class UsnaCalculator extends JFrame implements ClipboardOwner {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private CalculatorPanel usnaCalcPanel = null;
	private JPanel buttons = null;
	private JButton bCopy = null;
	private JButton bClose = null;

	/**
	 * This is the default constructor
	 */
	public UsnaCalculator() throws Exception {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}
		initialize();
	}

	/**
	 * This method initializes this
	 * @return void
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UsnaCalendar.class.getResource("/usna/img/usna16.gif")));
		this.setContentPane(getJContentPane());
		this.setTitle("USNA Calculator");
		this.pack();
	}

	/**
	 * This method initializes jContentPane
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setBorder(BorderFactory.createEmptyBorder(4, 3, 0, 3));
			jContentPane.add(getUsnaCalcPanel(), BorderLayout.CENTER);
			jContentPane.add(getButtons(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes usnaCalcPanel	
	 * @return javax.swing.JPanel	
	 */
	private CalculatorPanel getUsnaCalcPanel() {
		if (usnaCalcPanel == null) {
			usnaCalcPanel = new CalculatorPanel();
			usnaCalcPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		}
		return usnaCalcPanel;
	}

	/**
	 * This method initializes buttons	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getButtons() {
		if (buttons == null) {
			buttons = new JPanel();
			buttons.setLayout(new FlowLayout());
			buttons.add(getBCopy(), null);
			buttons.add(getBClose(), null);
		}
		return buttons;
	}

	/**
	 * This method initializes bCopy	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCopy() {
		if (bCopy == null) {
			bCopy = new JButton();
			bCopy.setText("Copy");
			bCopy.setToolTipText("Copy display content into clipboard");
			bCopy.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					final Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
					final String cp = usnaCalcPanel.getValue().toString();
					cb.setContents(new StringSelection(cp), UsnaCalculator.this);
				}
			});
		}
		return bCopy;
	}

	/**
	 * This method initializes bClose	
	 * @return javax.swing.JButton	
	 */
	private JButton getBClose() {
		if (bClose == null) {
			bClose = new JButton();
			bClose.setText("Close");
			bClose.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return bClose;
	}
	
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		// Defined in ClipboardOwner interface
	}

	public static void main(String[] arg) throws Exception {
		UsnaCalculator cp = new UsnaCalculator();
		cp.setVisible(true);
	}
}
