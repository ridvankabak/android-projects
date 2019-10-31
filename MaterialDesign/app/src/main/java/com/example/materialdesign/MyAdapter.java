package com.example.materialdesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CardTasarimTutucu>{
    private Context context;
    private List<String> ulkelerliste;

    public MyAdapter(Context context, List<String> ulkelerliste) {
        this.context = context;
        this.ulkelerliste = ulkelerliste;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView satirCard;
        private TextView satirText;
        private ImageView satirResim;

        public CardTasarimTutucu(View view){
            super(view);
            satirCard = (CardView) view.findViewById(R.id.satirCard);
            satirText = (TextView) view.findViewById(R.id.satirYazi);
            satirResim = (ImageView) view.findViewById(R.id.satirResim);
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //Tasarımın yolunu belirliyoruz
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_tasarim,viewGroup,false);
        return new CardTasarimTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardTasarimTutucu cardTasarimTutucu, int i) {//Verilerimizi sırayla getirip ne yapmak istediğimizi yazıyoruz
        final String ulke = ulkelerliste.get(i);
        cardTasarimTutucu.satirText.setText(ulke);

        cardTasarimTutucu.satirCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Tıklanılan Ülke: "+ulke,Toast.LENGTH_SHORT).show();
            }
        });
        cardTasarimTutucu.satirResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context,"Pop tıklanıldı",Toast.LENGTH_SHORT).show();

                PopupMenu popupMenu = new PopupMenu(context,cardTasarimTutucu.satirResim); //pop up menu ne zaman çalışacağını söylüyoruz
                popupMenu.getMenuInflater().inflate(R.menu.card_menu,popupMenu.getMenu()); // tasarımını bağlıyoruz

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_sill:
                                Toast.makeText(context,ulke+" silindi",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_duzenlee:
                                Toast.makeText(context,ulke+" duzenlendi",Toast.LENGTH_SHORT).show();
                                return true;
                                default:
                                    return  false;
                        }
                    }
                });
                popupMenu.show();

            }
        });
    }

    @Override
    public int getItemCount() {//kaç tane veri olduğunu söylüyoruz
        return ulkelerliste.size();
    }
}
