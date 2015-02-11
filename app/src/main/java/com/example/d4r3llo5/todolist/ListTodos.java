package com.example.d4r3llo5.todolist;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class ListTodos extends ActionBarActivity implements View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_todos);
		// Init the table (static until learn how to create databases)
		initAllListTable();
		System.out.println("Start the thing!");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_list_todos, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		switch (id)
		{
			case R.id.action_settings:
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	// Custom On-click method for the thing
	public void onTableRowClick()
	{

	} // end of table row listener

	// Private methods

	/**
	 * Create the all items table (should pull from database when all is said and done).
	 * This finds the TableLayout view item and adds new TableRows to it,
	 * which contain a check box, a name, and a description
	 * TODO: Make the table not static
	 */
	private void initAllListTable()
	{
		int i;
		TableLayout todoTable = (TableLayout) findViewById(R.id.alt_all_todo_lists);
		i = 0;
		while (i < 10) {
			ATDLTableRow userList = new ATDLTableRow(this, 1000 + i * 10, i, this);     // The item
			TDLTableBorder borderItem = new TDLTableBorder(this);

			setListItemColumnValues(userList, i);       // Set up the TableRow columns
			todoTable.addView(userList);                // Add TableRow to the TableLayout

			borderItem.setBackgroundColor(Color.BLUE);  // Add a blue line to the text
			todoTable.addView(borderItem);
			i++;
		}
	}   /* end of initAllListTable method */

	/**
	 * set the View item Layout properties in relation to parent
	 * TableRow. This is for the ListTable TableRow column items so
	 * they match the static table header.
	 * Parameters: TableRow
	 * userList: TableRow to set the visual parameters
	 */
	private void setListItemColumnValues(ATDLTableRow userList, int i)
	{
		userList.setItemName(String.format("Item #%d", i));
//		userList.setItemDescr("No description given for this item");
		userList.setItemDescr("No description given");
	}

	/**
	 * set View item to be weighted at indicated values
	 * Params: View v, float weight, boolean centered
	 * view: View to set parameter values to
	 * weight: Set the weight
	 */
	private void setItemValueColWeight(View view, float weight)
	{
		TableRow.LayoutParams layout = new TableRow.LayoutParams();
		layout.weight = weight;
		layout.width = 0;
		view.setLayoutParams(layout);
	}

	/**
	 * click listener for the "All List" list
	 * I feel kind of dirty doing this here, but not as dirty as I did having a separate class
	 * specifically for this one onclick method where I couldn't negotiate who init'd the click
	 */
	public void onClick(View view)
	{
		ATDLTableRow itemClicked = (ATDLTableRow) findViewById(view.getId());
		TextView itemName = (TextView) itemClicked.getChildAt(1);

		Intent intent = new Intent(this, CheckList.class);

		// Give the Display List the type of list to display
		intent.putExtra("name",  itemName.getText());
		intent.putExtra("id", itemClicked.getDatabaseId());
		startActivity(intent);
	}
}
