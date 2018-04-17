package usna.swing.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import java.awt.Dimension;

/**
 * <p>Title: DialogFind</p>
 * <p>Generic find dialog</p>
 * <p>Company: USNA</p>
 * @author Antonio Flaccomio
 * @version 1.0
 */

public class FindReplaceDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelButtons = null;
	private JButton jButtonFind = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JTextField jTextFind = null;
	private final JTextComponent textComponent;
	private JCheckBox jCheckCase = null;
	private JRadioButton jRadioBackward = null;
	private JPanel jPanel1 = null;
	private JRadioButton jRadioForward = null;
	private JRadioButton jRadioFromStart = null;
	private JRadioButton jRadioFromEnd = null;
	private JButton jButtonClose = null;
	private JLabel jLabel1 = null;
	private JTextField jTextReplace = null;
	private JButton jButtonReplace = null;
	private JButton jButtonReplaceAll = null;

	public FindReplaceDialog(final Window owner, final JTextComponent textComponent) {
		super(owner);
		this.textComponent = textComponent;
		initialize();
		pack();
	}
	
	@Override
	public void setVisible(final boolean visible) {
		super.setVisible(visible);
		jButtonReplace.setEnabled(false);
	}

	/**
	 * This method initializes this
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Find/Replace");
		this.setMinimumSize(new Dimension(280, 10));
		this.setContentPane(getJContentPane());
		ButtonGroup group = new ButtonGroup();
		group.add(jRadioForward);
		group.add(jRadioBackward);
		getRootPane().setDefaultButton(jButtonFind);
	}
	
	public void enableReplace(final boolean replace) {
		jLabel1.setVisible(replace);
		jTextReplace.setVisible(replace);
		jButtonReplace.setVisible(replace);
		jButtonReplaceAll.setVisible(replace);
		this.setTitle(replace ? "Find/Replace" : "Find");
		pack();
	}

	/**
	 * This method initializes jContentPane
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setVgap(4);
			jContentPane = new JPanel();
			jContentPane.setBorder(BorderFactory.createEmptyBorder(2, 4, 0, 4));
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJPanelButtons(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel(), BorderLayout.NORTH);
			jContentPane.add(getJPanel1(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelButtons	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelButtons() {
		if (jPanelButtons == null) {
			jPanelButtons = new JPanel();
			jPanelButtons.setLayout(new FlowLayout());
			jPanelButtons.add(getJButtonFind(), null);
			jPanelButtons.add(getJButtonReplace(), null);
			jPanelButtons.add(getJButtonReplaceAll(), null);
			jPanelButtons.add(getJButtonClose(), null);
		}
		return jPanelButtons;
	}

	/**
	 * This method initializes jButtonFind	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFind() {
		if (jButtonFind == null) {
			jButtonFind = new JButton();
			jButtonFind.setText("Find");
			jButtonFind.setMargin(new Insets(2, 8, 2, 8));
			getRootPane().setDefaultButton(jButtonFind);
			jButtonFind.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					doFind();
				}
			});
		}
		return jButtonFind;
	}

	/**
	 * This method initializes jPanel	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.gridy = 1;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.insets = new Insets(4, 0, 0, 0);
			gridBagConstraints21.gridx = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.insets = new Insets(4, 0, 0, 4);
			gridBagConstraints12.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("Replace with:");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridwidth = 2;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.insets = new Insets(4, 0, 0, 0);
			gridBagConstraints11.gridy = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(6, 0, 0, 0);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.insets = new Insets(6, 0, 0, 2);
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Find:");
			jLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(getJTextFind(), gridBagConstraints1);
			jPanel.add(getJCheckCase(), gridBagConstraints11);
			jPanel.add(jLabel1, gridBagConstraints12);
			jPanel.add(getJTextReplace(), gridBagConstraints21);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextFind	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFind() {
		if (jTextFind == null) {
			jTextFind = new JTextField();
			jTextFind.setFocusAccelerator('T');
		}
		return jTextFind;
	}

	/**
	 * This method initializes jCheckCase	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckCase() {
		if (jCheckCase == null) {
			jCheckCase = new JCheckBox();
			jCheckCase.setText("Case sensitive");
			jCheckCase.setMnemonic(KeyEvent.VK_C);
		}
		return jCheckCase;
	}

	/**
	 * This method initializes jRadioBackward	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioBackward() {
		if (jRadioBackward == null) {
			jRadioBackward = new JRadioButton();
			jRadioBackward.setText("Backward");
			jRadioBackward.setMnemonic(KeyEvent.VK_B);
			jRadioBackward.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
						getJRadioForward().setSelected(false);
						getJRadioFromStart().setSelected(false);
					}
				}
			});
		}
		return jRadioBackward;
	}

	/**
	 * This method initializes jPanel1	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.insets = new Insets(0, 0, 0, 6);
			gridBagConstraints6.gridy = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints5.weighty = 10.0D;
			gridBagConstraints5.insets = new Insets(0, 0, 0, 6);
			gridBagConstraints5.gridy = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints4.gridy = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints3.weighty = 10.0D;
			gridBagConstraints3.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints3.gridy = 1;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setBorder(BorderFactory.createLineBorder(SystemColor.controlShadow, 1));
			jPanel1.add(getJRadioBackward(), gridBagConstraints3);
			jPanel1.add(getJRadioForward(), gridBagConstraints4);
			jPanel1.add(getJRadioFromStart(), gridBagConstraints6);
			jPanel1.add(getJRadioFromEnd(), gridBagConstraints5);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jRadioForward	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioForward() {
		if (jRadioForward == null) {
			jRadioForward = new JRadioButton();
			jRadioForward.setText("Forward");
			jRadioForward.setMnemonic(KeyEvent.VK_F);
			jRadioForward.setSelected(true);
			jRadioForward.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
						getJRadioBackward().setSelected(false);
						getJRadioFromEnd().setSelected(false);
					}
				}
			});
		}
		return jRadioForward;
	}

	/**
	 * This method initializes jRadioFromStart	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioFromStart() {
		if (jRadioFromStart == null) {
			jRadioFromStart = new JRadioButton();
			jRadioFromStart.setText("From start");
			jRadioFromStart.setMnemonic(KeyEvent.VK_S);
			jRadioFromStart.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
						getJRadioForward().setSelected(true);
					}
				}
			});
		}
		return jRadioFromStart;
	}

	/**
	 * This method initializes jRadioFromEnd	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioFromEnd() {
		if (jRadioFromEnd == null) {
			jRadioFromEnd = new JRadioButton();
			jRadioFromEnd.setText("From end");
			jRadioFromEnd.setMnemonic(KeyEvent.VK_E);
			jRadioFromEnd.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
						getJRadioBackward().setSelected(true);
					}
				}
			});
		}
		return jRadioFromEnd;
	}

	/**
	 * This method initializes jButtonClose	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClose() {
		if (jButtonClose == null) {
			jButtonClose = new JButton();
			jButtonClose.setText("Close");
			jButtonClose.setMargin(new Insets(2, 8, 2, 8));
			jButtonClose.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonClose;
	}

	/**
	 * This method initializes jTextReplace	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextReplace() {
		if (jTextReplace == null) {
			jTextReplace = new JTextField();
			jTextReplace.setFocusAccelerator('R');
		}
		return jTextReplace;
	}

	/**
	 * This method initializes jButtonReplace	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonReplace() {
		if (jButtonReplace == null) {
			jButtonReplace = new JButton();
			jButtonReplace.setText("Replace");
			jButtonReplace.setMargin(new Insets(2, 8, 2, 8));
			jButtonReplace.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					doReplace();
				}
			});
		}
		return jButtonReplace;
	}

	/**
	 * This method initializes jButtonReplaceAll	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonReplaceAll() {
		if (jButtonReplaceAll == null) {
			jButtonReplaceAll = new JButton();
			jButtonReplaceAll.setText("Replace all");
			jButtonReplaceAll.setMargin(new Insets(2, 8, 2, 8));
			jButtonReplaceAll.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					doReplaceAll();
				}
			});
		}
		return jButtonReplaceAll;
	}
	
	private void doFind() {
		String find = jTextFind.getText();
		String text = textComponent.getText();
		if(find.length() > 0 && text.length() > 0) {
			final boolean forward = jRadioForward.getModel().isSelected();
			if(!jCheckCase.getModel().isSelected()) {
				find = find.toLowerCase();
				text = text.toLowerCase();
			}
			final int startPos;
			if(jRadioFromStart.getModel().isSelected()) {
				startPos = 0;
				jRadioFromStart.setSelected(false);
			} else if(jRadioFromEnd.getModel().isSelected()) {
				startPos = text.length();
				jRadioFromEnd.setSelected(false);
			} else {
				if(forward) {
					startPos = textComponent.getSelectionEnd();
				} else {
					startPos = textComponent.getSelectionStart() - 1;
				}
			}
			final int ind;
			if(forward) {
				ind = text.indexOf(find, startPos);
			} else  {
				ind = text.lastIndexOf(find, startPos);
			}
			if(ind >= 0) {
				textComponent.setSelectionStart(ind);
				textComponent.setSelectionEnd(ind + find.length());
				jButtonReplace.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(FindReplaceDialog.this, "Text not found.", "Find", JOptionPane.INFORMATION_MESSAGE);
				jButtonReplace.setEnabled(false);
			}
		} else {
			jButtonReplace.setEnabled(false);
		}
	}
	
	private void doReplace() {
		textComponent.replaceSelection(jTextReplace.getText());
		jButtonReplace.setEnabled(false);
	}
	
	private void doReplaceAll() {
		final String findText = jTextFind.getText();
		if(findText.length() > 0) {
			textComponent.setText(textComponent.getText().replace(findText, jTextReplace.getText()));
			jButtonReplace.setEnabled(false);
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
