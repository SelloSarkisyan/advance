package com.example.advance;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerActivity extends AppCompatActivity {


    List<model> notes = model.listAll(model.class);
    RecyclerAdapter adapter;
    ConstraintLayout constLayout;
    RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        adapter = new RecyclerAdapter(notes);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        rec = findViewById(R.id.rec);
        enableSwipeToDeleteAndUndo();
        rec.setAdapter(adapter);
        rec.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(RecyclerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                Long check;
                final int position = viewHolder.getAdapterPosition();
                final model item = adapter.getData().get(position);
                check=notes.get(position).getId();
                adapter.removeItem(position);
                model notes=model.findById(model.class,check);
                notes.delete();
                Snackbar snackbar = Snackbar
                        .make(findViewById(R.id.constLayout), "Item was removed from the list.", Snackbar.LENGTH_LONG);

                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        adapter.restoreItem(item, position);
                        rec.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();

            }

        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(rec);
    }
}
