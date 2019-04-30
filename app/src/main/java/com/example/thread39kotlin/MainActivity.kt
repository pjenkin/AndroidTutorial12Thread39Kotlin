package com.example.thread39kotlin

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pnjHandler: Handler = object: Handler()
    {

        // Alt+Insert (Windows AS)
        /**
         * Subclasses must implement this to receive messages.
         */
        val something = "something"
        override fun handleMessage(msg: Message?) {
            //super.handleMessage(msg)
            val pnjText = findViewById<EditText>(R.id.pnjText)
            pnjText.setText("Clicked via Kotlin")
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun clickButton(view: View)         // returning nothing, so no type declared (not 'void')?
    {
//        val pnjText = findViewById<EditText>(R.id.pnjText)
//        pnjText.setText("Clicked via Kotlin")
            val t = Thread {
                // wait 10 seconds then call handler to get text changed, or whatever
                Thread.sleep(10_000)                // NB underscore as 10^3 separator
                // wait - could be doing long calculation or other function here
                pnjHandler.sendEmptyMessage(0)      // send empty message, to trigger handler's code
            }
            t.start()// don't forget this :-D
    }
}
