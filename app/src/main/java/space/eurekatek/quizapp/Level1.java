package space.eurekatek.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Level1 extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        // Код который скругляет углы левой картинки

        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        // Код который скругляет углы правой картинки

        img_right.setClipToOutline(true);

        // Развернуть игру на весь экран - начало

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // Развернуть игру на весь экран - конец

        // Вызов диалогового окна в начале игры

        dialog = new Dialog(this); // Создаём новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок диалогового окна
        dialog.setContentView(R.layout.previewdialog); // путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialog.setCancelable(false); // диалог нельзя закрыть кнопкой "Назад"

        // кнопка которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // обрабатываем нажатие кнопки - начало

                try {
                    // вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    // вернуться назад к выбору уровня - конец
                }catch (Exception e){

                }
                dialog.dismiss(); // закрываем диалоговое окно

                // обрабатываем нажатие кнопки - конец
            }
        });

        // кнопка которая закрывает диалоговое окно - конец

        // кнопка "продолжить" - начало

        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); // закрываем диалоговое окно
            }
        });
        // кнопка "продолжить" - конец

        dialog.show(); // показать диалоговое окно

        // кнопка "Назад" - начало
            Button btn_back = (Button)findViewById(R.id.button_back);
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // обрабатываем нажатие кнопки "назад" - начало
                    try {
                        Intent intent= new Intent(Level1.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){

                    }
                    // обрабатываем нажатие кнопки "назад" - конец
                }
            });
        // кнопка "Назад" - конец
    }
    // системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        // обрабатываем нажатие кнопки "назад" - начало
        try {
            Intent intent= new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
        // обрабатываем нажатие кнопки "назад" - конец
    }
    // системная кнопка "назад" - конец
}