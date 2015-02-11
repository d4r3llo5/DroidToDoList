package com.example.d4r3llo5.todolist;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class CheckList extends ActionBarActivity implements View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();

		setContentView(R.layout.activity_check_list);

		TextView list_name = (TextView)findViewById(R.id.cli_list_name);

		String name = intent.getStringExtra("name") ;
		if ( name== null )
			System.out.println("Could not find the extra.");
		else
			list_name.setText(name);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		initAllListTable();
		System.out.println("Start the thing!");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_check_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}


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
		TDLTableBorder border = new TDLTableBorder(this);
		border.setBackgroundColor(Color.CYAN);
		todoTable.addView(border);
		i = 0;
		while (i < 10) {
			CTDLTableRow item = new CTDLTableRow(this, 1000 + i * 10, this);     // The item
			TDLTableBorder borderItem = new TDLTableBorder(this);
			borderItem.setBackgroundColor(Color.CYAN);

			setListItemColumnValues(item, i);       // Set up the TableRow columns
			todoTable.addView(item);                // Add TableRow to the TableLayout
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
	private void setListItemColumnValues(CTDLTableRow item, int i)
	{
		item.setItemQuantity(i);
		item.setItemUnit("oz.");
		item.setItemName(String.format("Item #%d", i));
		item.setItemDescr("No description given for this item");
	}

	/**
	 * click listener for the "All List" list
	 * I feel kind of dirty doing this here, but not as dirty as I did having a separate class
	 * specifically for this one onclick method where I couldn't negotiate who init'd the click
	 */
	public void onClick(View view)
	{
		TableRow itemClicked = (TableRow) findViewById(view.getId());
		TextView itemName = (TextView) itemClicked.getChildAt(1);
		System.out.println("View clicked: " + view.getId());
		System.out.println("I clicked on this: " + itemName.getText());
	}
}
