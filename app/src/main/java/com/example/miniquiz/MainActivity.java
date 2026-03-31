package com.example.miniquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    TextView tytul, pytanie, wynik;
    Button start, a, b, c, reset;

    int punkty = 0;
    int index = 0;

    ArrayList<Question> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tytul = findViewById(R.id.tytul);
        pytanie = findViewById(R.id.pytanie);
        wynik = findViewById(R.id.wynik);

        start = findViewById(R.id.start);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        reset = findViewById(R.id.reset);

        dodajPytania();

        ukryjQuiz();

        start.setOnClickListener(v -> startQuiz());

        a.setOnClickListener(v -> sprawdz(a.getText().toString()));
        b.setOnClickListener(v -> sprawdz(b.getText().toString()));
        c.setOnClickListener(v -> sprawdz(c.getText().toString()));

        reset.setOnClickListener(v -> resetQuiz());
    }

    void dodajPytania() {
        lista.add(new Question("Stolica Włoch to:", "Rzym", "Paryż", "Madryt", "Rzym"));
        lista.add(new Question("Stolica Polski to:", "Kraków", "Warszawa", "Gdańsk", "Warszawa"));
        lista.add(new Question("Stolica Hiszpanii to:", "Barcelona", "Walencja", "Madryt", "Madryt"));
        lista.add(new Question("Stolica Niemiec to:", "Frankfurt", "Berlin", "Hamburg", "Berlin"));
        lista.add(new Question("Stolica Rosji to", "Moskwa", "Petersburg", "Kazań", "Moskwa"));
        lista.add(new Question("Stolica Francji to:", "Nicea", "Paryż", "Strasburg", "Paryż"));
        lista.add(new Question("Stolica Portugali to:","Porto","Lizbona","Faro","Lizbona"));
    }

    void startQuiz() {
        Collections.shuffle(lista);
        punkty = 0;
        index = 0;
        wynik.setText("Wynik: 0");

        pokazQuiz();
        pokazPytanie();
    }

    void pokazPytanie() {
        Question q = lista.get(index);

        pytanie.setText(q.pytanie);
        a.setText(q.a);
        b.setText(q.b);
        c.setText(q.c);
    }

    void sprawdz(String odp) {
        Question q = lista.get(index);

        if (odp.equals(q.poprawna)) {
            punkty++;
        }

        index++;

        wynik.setText("Wynik: " + punkty);

        if (index == 5) {
            Toast.makeText(this, "Koniec quizu! Twój wynik: " + punkty + " / 5", Toast.LENGTH_LONG).show();
            ukryjQuiz();
            return;
        }

        pokazPytanie();
    }

    void resetQuiz() {
        punkty = 0;
        wynik.setText("Wynik: 0");
        ukryjQuiz();
    }

    void ukryjQuiz() {
        pytanie.setVisibility(View.GONE);
        a.setVisibility(View.GONE);
        b.setVisibility(View.GONE);
        c.setVisibility(View.GONE);
    }

    void pokazQuiz() {
        pytanie.setVisibility(View.VISIBLE);
        a.setVisibility(View.VISIBLE);
        b.setVisibility(View.VISIBLE);
        c.setVisibility(View.VISIBLE);
    }
}
