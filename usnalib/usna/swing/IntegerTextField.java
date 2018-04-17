package usna.swing;

import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.text.*;

/**
 * <p>JIntegerTextField</p>
 * <p>formatted field for integer numbers (long) with minimum
 * and maximum values specified.<br>
 * Can also give buttons to increment and decrement the value.</p>
 * <p>Copyright (c) 2006</p>
 * <p>Company: USNA</p>
 * @version 2.0
 * @author Antonio Flaccomio
 */

public class IntegerTextField extends JFormattedTextField {

	private static final long serialVersionUID = 2L;

	/**
	 * Constructors specifying the initial value, the minimum
	 * allowed value and the maximum allowed value for the field.
	 * @param init long
	 * @param min long
	 * @param max long
	 */
	public IntegerTextField(final long init, final long min, final long max) {		
		super(new Long(init));
		/*final InternationalFormatter formatter = (InternationalFormatter) getFormatter();
		formatter.setMaximum(max);
		formatter.setMinimum(min);
		setFormatterFactory(new DefaultFormatterFactory(formatter));*/
		final DefaultFormatterFactory ff = (DefaultFormatterFactory)getFormatterFactory();
		/*final InternationalFormatter defF = (InternationalFormatter)ff.getDefaultFormatter();
		if(defF != null) {
			defF.setMaximum(new Long(max));
			defF.setMinimum(new Long(min));
		}
		final InternationalFormatter disF = (InternationalFormatter)ff.getDisplayFormatter();
		if(disF != null) {
			disF.setMaximum(new Long(max));
			disF.setMinimum(new Long(min));
		}*/
		final InternationalFormatter ediF = (InternationalFormatter)ff.getEditFormatter();
		if(ediF != null) {
			ediF.setMaximum(new Long(max));
			ediF.setMinimum(new Long(min));
		}
	}

	public IntegerTextField() {
	}

	public void setConstraits(final long min, final long max) {
		/*final InternationalFormatter formatter = (InternationalFormatter) getFormatter();
		formatter.setMaximum(new Long(max));
		formatter.setMinimum(new Long(min));
		setFormatterFactory(new DefaultFormatterFactory(formatter));*/
		final DefaultFormatterFactory ff = (DefaultFormatterFactory)getFormatterFactory();
		final InternationalFormatter ediF = (InternationalFormatter)ff.getEditFormatter();
		if(ediF != null) {
			ediF.setMaximum(new Long(max));
			ediF.setMinimum(new Long(min));
		}
	}

	public void setGroupingUsed(final boolean use) {
		((NumberFormat)((InternationalFormatter) getFormatter()).getFormat()).setGroupingUsed(use);
	}

	public int getIntValue() {
		return ((Number) getValue()).intValue();
	}

	public long getLongValue() {
		return ((Number) getValue()).longValue();
	}
	
	/**
	 * Creates and returns a JButton whose action increment the field by 1
	 * @param upIcon the icon for the button
	 * @return
	 */
	public JButton getArrowUp(final ImageIcon upIcon) {
		final JButton up = new JButton(upIcon);
		//final long max = (Long)((InternationalFormatter) getFormatter()).getMaximum();
		final DefaultFormatterFactory ff = (DefaultFormatterFactory)getFormatterFactory();
		final long max = (Long)((InternationalFormatter)ff.getEditFormatter()).getMaximum();
		up.setBorderPainted(false);
		up.setContentAreaFilled(false);
		up.setMargin(new java.awt.Insets(1, 0, 1, 0));
		up.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(getLongValue() < max) {
					IntegerTextField.this.setValue(getLongValue() + 1);
					IntegerTextField.this.fireActionPerformed();
				}
			}
		});
		return up;
	}
	
	/**
	 * Creates and returns a JButton whose action increment the field by 1. Uses default usna icon
	 * @return
	 */
	public JButton getArrowUp() {
		final ImageIcon upIcon = new ImageIcon(IntegerTableCellEditor.class.getResource("/usna/img/beck_up.gif"));
		return getArrowUp(upIcon);
	}
	
	/**
	 * Creates and returns a JButton whose action decrement the field by 1
	 * @param upIcon the icon for the button
	 * @return
	 */
	public JButton getArrowDown(final ImageIcon downIcon) {
		final JButton down = new JButton(downIcon);
		//final long min = (Long)((InternationalFormatter) getFormatter()).getMinimum();
		final DefaultFormatterFactory ff = (DefaultFormatterFactory)getFormatterFactory();
		final long min = (Long)((InternationalFormatter)ff.getEditFormatter()).getMinimum();
		down.setBorderPainted(false);
		down.setContentAreaFilled(false);
		down.setMargin(new java.awt.Insets(1, 0, 1, 0));
		down.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(getLongValue() > min) {
					IntegerTextField.this.setValue(getLongValue() - 1);
					IntegerTextField.this.fireActionPerformed();
				}
			}
		});
		return down;
	}
	
	/**
	 * Creates and returns a JButton whose action increment the field by 1. Uses default usna icon
	 * @return
	 */
	public JButton getArrowDown() {
		final ImageIcon downIcon = new ImageIcon(IntegerTableCellEditor.class.getResource("/usna/img/beck_down.gif"));
		return getArrowDown(downIcon);
	}
}