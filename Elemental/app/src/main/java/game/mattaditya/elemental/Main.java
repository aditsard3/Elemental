package game.mattaditya.elemental;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Main extends ActionBarActivity
{

    // Declare string array holders (arrays will be created in onCreate)
    //  BTW, these live in /app/src/main/res/values/arrays.xml
    String[] elementsymbols;
    String[] elementNames;

    // Declare elementstring for text input
    String elementstring;

    // seed the random number generator
    Random randomelement = new Random((int) System.currentTimeMillis() / 2);

    //Notice how it always starts with Gold?
    int elementnum = 78;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button get_edit_view_button = (Button) findViewById(R.id.check_answer_button);
        get_edit_view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //initialising the TextView, etc.
                TextView elementsymboldisplay = (TextView) findViewById(R.id.element_symbol);

                EditText element_name_input = (EditText) findViewById(R.id.element_name_input);
                elementstring = element_name_input.getText().toString();

                if (elementstring.toLowerCase().equals(elementNames[elementnum].toLowerCase()))
                {

                    //Good job, you got it right
                    Context context = getApplicationContext();
                    CharSequence text = "Great job!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast greatjob = Toast.makeText(context, text, duration);
                    greatjob.show();

                }
                else
                {

                    //You got it wrong, go home and study
                    Context context = getApplicationContext();
                    CharSequence text = "Nope, it was " + elementNames[elementnum] + ", " + elementsymbols[elementnum] + ".";
                    int duration = Toast.LENGTH_SHORT;

                    Toast nopesorry = Toast.makeText(context, text, duration);
                    nopesorry.show();

                }

                elementnum = randomelement.nextInt(117);

                element_name_input.setText("");

                // answer given, display the new symbol
                elementsymboldisplay.setText(elementsymbols[elementnum]);
                elementsymboldisplay.setKeyListener(null);
            }
        });

        // set up string arrays defined above
        elementsymbols = getResources().getStringArray(R.array.elementsymbols);
        elementNames = getResources().getStringArray(R.array.elementNames);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

}
