package com.example.market;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.market.databinding.CoolmarketBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CoolmarketBinding binding = CoolmarketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentView(R.layout.coolmarket);

        binding.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "78005553535";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });
        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String []{"my@yandex.ru"});
                String mail = "Моя доставка: ";
                if(binding.fruits.isChecked()) mail += "Фрукты ";
                if(binding.zamorozki.isChecked()) mail += "Заморозки ";
                if(binding.ovoschi.isChecked()) mail += "Овощи ";
                if(binding.milk.isChecked()) mail += "Молочка ";
                if(binding.myaso.isChecked()) mail += "Мясо ";
                if(binding.sweet.isChecked()) mail += "Сладкое ";
                if(binding.dostavka.isActivated()) mail += "/nДоставка";
                if(binding.samovyvoz.isActivated()) mail += "/nСамовывоз";

                intent.putExtra(Intent.EXTRA_TEXT, mail);
                intent.putExtra(Intent.EXTRA_SUBJECT, "/nНапоминание о доставке");
                startActivity(intent);
            }
        });
    }
}