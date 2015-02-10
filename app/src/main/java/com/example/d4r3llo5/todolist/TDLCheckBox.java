package com.example.d4r3llo5.todolist;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.TableRow;

/**
 * Created by d4r3llo5 on 2/5/2015.
 */
public class TDLCheckBox extends CheckBox
{
	/**
	 * Default constructor (does nothing fancy and
	 *  operates the same as a normal TextView
	 * @param context
	 */
	public TDLCheckBox(Context context)
	{
		super(context);
	}

	/*---- OVERRIDE Constructor ----*/
	/**
	 * Constructor to init a TextView given specific params.
	 *  @param context (Context): Context?
	 *  @param id (int): Id for the code to find this object
	 *  @param weight  (float): How much this object fills of the parent's space
	 *  @param gravity (int): Text alignment within this TextVIeiw
	 *
	 */
	public TDLCheckBox(Context context, int id, float weight, int gravity)
	{
		super(context);
		this.setId(id);
		this.setGravity(gravity);
		this.setWeight(weight);
		this.setChecked(true);
	}

	/*
	 * set View item to be weighted at indicated values
	 * @param weight (float): Set the weight
	 */
	private void setWeight(float weight)
	{
		TableRow.LayoutParams layout = new TableRow.LayoutParams();
		layout.weight = weight;
		layout.width = 0;
		this.setLayoutParams(layout);
	}
}
