package com.example.d4r3llo5.todolist;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.TableRow;

/**
 * Created by d4r3llo5 on 1/31/2015.
 */
public class TDLTableBorder extends View
{
	public TDLTableBorder(Context context) {
		super(context);
		int px;

		px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 2, getResources().getDisplayMetrics());
		TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
		layoutParams.width = TableRow.LayoutParams.MATCH_PARENT;
		layoutParams.height = px;
		this.setLayoutParams(layoutParams);
		setBackgroundColor(Color.MAGENTA);
	}
}
