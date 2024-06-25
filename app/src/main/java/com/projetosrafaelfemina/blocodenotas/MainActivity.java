package com.projetosrafaelfemina.blocodenotas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projetosrafaelfemina.blocodenotas.Model.NotePreferences;

public class MainActivity extends AppCompatActivity {

    private NotePreferences preferences;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FloatingActionButton fbToSave = findViewById(R.id.fb_toSave);
        editAnotacao = findViewById(R.id.editNote);
        preferences = new NotePreferences(getApplicationContext());

        fbToSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String retrievedText = editAnotacao.getText().toString();

                if (retrievedText.equals("")) {
                    Toast.makeText(getApplicationContext(), "Preencha a anotação", Toast.LENGTH_SHORT).show();
                } else {
                    preferences.SaveNotes(retrievedText);
                    Toast.makeText(getApplicationContext(), "Anotação salva com sucesso!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Recuperar uma anotação
        String annotation = preferences.RecoverNotes();

        if (!annotation.equals("")) {
            editAnotacao.setText(annotation);
        }
    }
}