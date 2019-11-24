package de.yanniksimon.fitnesspoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import de.yanniksimon.fitnesspoint.Objects.Set;

public class AddActivity extends AppCompatActivity {

    Spinner bodyPartSpinner;
    Spinner exerciseSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        bodyPartSpinner = findViewById(R.id.body_part_spinner);
        exerciseSpinner = findViewById(R.id.exercise_spinner);

        setupSpinner();
    }

    private void setupSpinner(){

        //Create Lists
        ArrayList<String> bodyParts= new ArrayList<>();
        ArrayList<String> exercises = new ArrayList<>();

        //Add items
        bodyParts.add("Brust");
        bodyParts.add("Rücken");
        bodyParts.add("Beine");

        exercises.add("Bankdrücken");
        exercises.add("Rudern");
        exercises.add("Kniebeuge");

        //Create Adapter
        ArrayAdapter<String> bodyPartsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item, bodyParts);

        ArrayAdapter<String> exercisesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item, exercises);

        //Set DropDown Animation
        bodyPartsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercisesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set Adapter on Spinner
        bodyPartSpinner.setAdapter(bodyPartsAdapter);
        exerciseSpinner.setAdapter(exercisesAdapter);
    }

    private void createSet(String bodyPart, String exercise, double weight, int reps){
        Set set = new Set(bodyPart, exercise, weight, reps);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
