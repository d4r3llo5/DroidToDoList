package com.example.d4r3llo5.todolist;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TableRow;

/**
 *
 * Custom TableRow class which will contain a information for the Todo Checklist view
 *  for the ToDo list application. All specific classes to this View contain the subheading
 *  CTDL specifying CheckListToDoLists
 *  Pertinent information is if it is in the notification pool, its name, and its description
 * Created by d4r3llo5 on 1/31/2015.
 */
public class CTDLTableRow extends TableRow
{
	/** Private View variables for the information we are sent to display **/
	private TDLTextView listQuantity;
	private TDLTextView listUnit;
	private TDLTextView listName;
	private TDLTextView listDescr;

	/*-- Start of Constructors --*/
	/**
	 * Override Constructor (default)
	 *  Does not set View id or OnClickListener
	 * @param context
	 */
	public CTDLTableRow(Context context)	{
		super(context);

		TableRow.LayoutParams layout = new TableRow.LayoutParams();
		layout.width = TableRow.LayoutParams.MATCH_PARENT;
		layout.height = TableRow.LayoutParams.WRAP_CONTENT;
		setLayoutParams(layout);
		setClickable(true);                // Set the row to be action-able
	}

	/**
	 * Override Constructor (default)
	 *  Does not set View id or OnClickListener
	 *  @param context (Context): ?? yeah
	 *  @param id (int): the id value to use for this view object
	 *  @param listener (OnClickListener): Where do we find the on-click listener
	 */
	public CTDLTableRow(Context context, int id, View.OnClickListener listener)
	{
		super(context);
		int height_padding;
		int width_padding;

		height_padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics());
		width_padding = 0;//(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics());

		// Set the layout stats
		TableRow.LayoutParams layout = new TableRow.LayoutParams();
		layout.width = TableRow.LayoutParams.MATCH_PARENT;
		layout.height = LayoutParams.MATCH_PARENT;
		setLayoutParams(layout);

		this.setId(id);
		this.setPadding(width_padding, height_padding, width_padding, height_padding);

		// Set up the SubViews
		initSubViews(context, id);
		addViewItems();

		// Set the Listener stuff
		setClickable(true);                // Set the row to be action-able
		setOnClickListener(listener);
	}
	/*-- End of Constructors --*/

	/**
	 * setItemQuantity
	 *  @param quantity (int): Number to buy
	 */
	public void setItemQuantity(int quantity)
	{
		String number = String.valueOf(quantity);
		if (listQuantity!= null) {
			listQuantity.setText(number);
		}
	}
	/**
	 * setItemUnit
	 *  @param unit (String): Unit for quantity
	 */
	public void setItemUnit(String unit)
	{
		if (listUnit != null) {
			listUnit.setText(unit);
		}
	}

	/**
	 * setItemName
	 *  @param name (String): Name of the unit
	 */
	public void setItemName(String name)
	{
		if (listName != null) {
			listName.setText(name);
		}
	}

	/**
	 * setItemDescr
	 *  @param descr (String): Description for the item
	 */
	public void setItemDescr(String descr)
	{
		if (listDescr != null) {
			listDescr.setText(descr);
		}
	}

	/**
	 * Initialize the SubItems
	 *  @param context (Context): Sure
	 *  @param id (int): The id of this object, it's children will inherit an id close to it
	 */
	private void initSubViews(Context context, int id)
	{
		listQuantity = new TDLTextView(context, id + 1, 1.0f, Gravity.CENTER, R.color.pen_pink );
		listUnit = new TDLTextView(context, id + 2, 1.0f, Gravity.CENTER, R.color.pen_pink );
		listName = new TDLTextView(context, id + 3, 3.0f, Gravity.CENTER, R.color.pen_pink );
		listDescr = new TDLTextView(context, id + 4, 5.0f, Gravity.CENTER, R.color.pen_pink );
	}

	/*
     * addViewItems: Add the Views to the TableRow
     */
	private void addViewItems()
	{
		if ( listQuantity != null )
			this.addView(listQuantity);
		if ( listUnit != null )
			this.addView(listUnit);
		if ( listName != null )
			this.addView(listName);
		if ( listDescr != null )
			this.addView(listDescr);
	}

}

