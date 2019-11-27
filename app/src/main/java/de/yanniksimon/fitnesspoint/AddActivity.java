package de.yanniksimon.fitnesspoint;

import android.app.IntentService;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import de.yanniksimon.fitnesspoint.Helpers.HelperClass;
import de.yanniksimon.fitnesspoint.Objects.Set;

public class AddActivity extends AppCompatActivity {

    //UI
    Spinner bodyPartSpinner;
    Spinner exerciseSpinner;

    EditText weightEditText;
    EditText repsEditText;

    //Database
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //UI
        bodyPartSpinner = findViewById(R.id.body_part_spinner);
        exerciseSpinner = findViewById(R.id.exercise_spinner);

        weightEditText = findViewById(R.id.weight_edit_text);
        repsEditText = findViewById(R.id.reps_edit_text);



        setupSpinner();


        //Database
         db = FirebaseFirestore.getInstance();


    }

    private void setupSpinner() {

        //Create Lists
        ArrayList<String> bodyParts = new ArrayList<>();
        final ArrayList<String> exercises = new ArrayList<>();

        ArrayList<String> chestExercises = new ArrayList<>();
        ArrayList<String> backExercises = new ArrayList<>();
        ArrayList<String> legsExercises = new ArrayList<>();

        //Add items
        bodyParts.add("Brust");
        bodyParts.add("Rücken");
        bodyParts.add("Beine");

        exercises.add("Bankdrücken");
        exercises.add("Rudern");
        exercises.add("Kniebeuge");

        chestExercises.add("Bankdrücken");
        chestExercises.add("Kurzhantel Schägbankdrücken");
        chestExercises.add("Langhantel Schägbankdrücken");
        chestExercises.add("Kabelzug Flys UnO");
        chestExercises.add("Kabelzug Flys OnU");
        chestExercises.add("Schrägbank Kabelzug Flys");
        chestExercises.add("Schrägbank Kurzhantel Flys");


        //Create Adapter
        ArrayAdapter<String> bodyPartsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item, bodyParts);

        ArrayAdapter<String> exercisesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item, exercises);

        //Chest Adapter
        final ArrayAdapter<String> chestAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, chestExercises);

        //Set DropDown Animation
        bodyPartsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercisesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set Adapter on Spinner
        bodyPartSpinner.setAdapter(bodyPartsAdapter);
        exerciseSpinner.setAdapter(exercisesAdapter);

        bodyPartSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), bodyPartSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                switch (bodyPartSpinner.getSelectedItem().toString()){
                    case "Brust":
                        exerciseSpinner.setAdapter(chestAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void saveSet(){
        Set set = new Set(
                bodyPartSpinner.getSelectedItem().toString(),
                exerciseSpinner.getSelectedItem().toString(),
                Integer.parseInt(weightEditText.getText().toString()),
                Integer.parseInt(repsEditText.getText().toString())

        );

        DocumentReference reference = db
                .collection("users")
                .document("yannik")
                .collection("workouts")
                .document(getDate())
                .collection("sets")
                .document();

        reference.set(set).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });
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
                saveSet();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
