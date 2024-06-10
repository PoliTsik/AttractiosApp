package com.despol.attractions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<AttractionsModel> AttractionsModels = new ArrayList<>();

    int[] AttractionImages = {
            R.drawable.forrestubud,R.drawable.centralpark,R.drawable.stonefacesatangkorwat,
            R.drawable.buckinghampalace,R.drawable.machupicchu,R.drawable.romecolosseum,
            R.drawable.thealhambra,R.drawable.mountfuji,R.drawable.forbiddencity,
            R.drawable.grandcanyon,R.drawable.greatwallofchina,R.drawable.chateaudeversailles,
            R.drawable.praguecastle,R.drawable.petra,R.drawable.eiffeltower,
            R.drawable.borobudur,R.drawable.chichenitza,R.drawable.kilimanjaro,
            R.drawable.cristoredentor,R.drawable.gizapyramids,R.drawable.acropolis,
            R.drawable.tajmahal,R.drawable.thelouvre,R.drawable.stonehenge,
            R.drawable.statueofliberty,R.drawable.bagan,R.drawable.niagarafalls,
            R.drawable.sydneyharbour};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.mRecycleView);

        setUpAttractionModels();

        AT_recyclerview_adapter adapter= new AT_recyclerview_adapter(this,AttractionsModels,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpAttractionModels(){
        String[] AttractionsNames = getResources().getStringArray(R.array.Attractions_Name);
        String[] AttractionsCountries= getResources().getStringArray(R.array.Attractions_Country);
        String[] AttractionsCities= getResources().getStringArray(R.array.Attractions_City);

        for (int i=0; i<AttractionsNames.length; i++){
            AttractionsModels.add(new AttractionsModel(AttractionsNames[i],AttractionsCountries[i],
                    AttractionsCities[i],AttractionImages[i]
            ));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);

        intent.putExtra("Name",AttractionsModels.get(position).getAttractionName());
        intent.putExtra("Country",AttractionsModels.get(position).getAttractionCountry());
        intent.putExtra("City",AttractionsModels.get(position).getAttractionCity());
        intent.putExtra("Image",AttractionsModels.get(position).getImage());

        startActivity(intent);

    }
}