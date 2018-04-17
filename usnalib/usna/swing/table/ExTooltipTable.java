package usna.swing.table;

import java.util.Collections;

import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;


/**
 * <p>Title: ExTootipTable</p>
 * <p>extends ToolTipTable providing new constructors and sorting support.</p>
 * <p>Company: USNA</p>
 * @author Antonio Flaccomio
 * @version 1.0
 */
public class ExTooltipTable extends TooltipTable {
	private static final long serialVersionUID = 1L;
	
	/*public ExTooltipTable() throws IntrospectionException {
		BeanInfo info = Introspector.getBeanInfo(ExTooltipTable.class);
		PropertyDescriptor[] propertyDescriptors =
		                             info.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; ++i) {
		    PropertyDescriptor pd = propertyDescriptors[i];
		    if (pd.getName().equals("rowSorter")) {
		        pd.setValue("transient", Boolean.TRUE);
		    }
		    if (pd.getName().equals("model")) {
		        pd.setValue("transient", Boolean.TRUE);
		    }
		    if (pd.getName().equals("tableHeader")) {
		        pd.setValue("transient", Boolean.TRUE);
		    }
		}
	}*/

	/**
	 * Create a table with specified TableModel and column widths
	 * @param tm
	 * @param colSize
	 */
	public ExTooltipTable(final TableModel tm, final int ... colSize) {
		super(tm);
		for(int ind = 0; ind < colSize.length && ind < tm.getColumnCount(); ind++) {
			final int size;
			if((size = colSize[ind]) >= 0) {
				columnModel.getColumn(ind).setPreferredWidth(size);
			}
		}
	}
	
	/**
	 * Create a sortable table with specified TableModel and column widths
	 * @param tm
	 * @param colSize
	 */
	public ExTooltipTable(final TableModel tm, final boolean sort, final int ... colSize) {
		this(tm, colSize);
		setAutoCreateRowSorter(sort);
	}
	
	public void clearSort() {
		getRowSorter().setSortKeys(Collections.<RowSorter.SortKey>emptyList());
	}
	
	public void sortByColumn(final int col, final boolean ascending) {
		getRowSorter().setSortKeys(Collections.<RowSorter.SortKey>singletonList(new RowSorter.SortKey(col, ascending ? SortOrder.ASCENDING : SortOrder.DESCENDING)));
	}
	
	/*public int findFirstRow(final int col, final Object colVal) {
		for(int i = 0; i < getRowCount(); i++) {
			if(colVal.equals(getValueAt(i, col))) {
				return i;
			}
		}
		return -1;
	}*/
}